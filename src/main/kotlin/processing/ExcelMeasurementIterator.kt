package dev.magthe.processing

import dev.magthe.DataObjects.Measurement
import dev.magthe.DataObjects.MeasurementType
import dev.magthe.iterutils.PeekingIterator
import dev.magthe.iterutils.peeking
import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.DataRow
import org.jetbrains.kotlinx.dataframe.api.convert
import org.jetbrains.kotlinx.dataframe.api.drop
import org.jetbrains.kotlinx.dataframe.api.toDouble
import org.jetbrains.kotlinx.dataframe.io.readExcel
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class ExcelMeasurementIterator(private val file: String) : MeasurementIterator {
    private val measurementsIter: PeekingIterator<DataRow<Any?>>
    private val measurementType: MeasurementType
    private val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    private val timeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")

    init {
        val dataFrame = DataFrame.readExcel(file, sheetName = "Nameraná hodinová práca", columns = "B:D").drop(9).convert("D").toDouble()
        measurementsIter = dataFrame.iterator().peeking()

        measurementType = if (file.contains("spotreba")) {
            MeasurementType.NEGATIVE
        } else {
            MeasurementType.POSITIVE
        }
    }

    override fun hasNext(): Boolean {
        val row = measurementsIter.peek()
        val hasNext = row["B"].toString() != "null"
        return hasNext
    }

    override fun next(): Measurement {
        val row = measurementsIter.next()

        val rawDate = row["B"].toString()
        val date = LocalDate.parse(rawDate, dateFormatter)

        val rawTime = row["C"].toString()
        val time = LocalTime.parse(rawTime, timeFormatter)

        val amount = row["D"] as Double

        return Measurement(measurementType, date, time, amount)

    }

}