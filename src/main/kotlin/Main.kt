package dev.magthe

import dev.magthe.DataObjects.MeasurementType
import dev.magthe.processing.MeasurementFactory


fun main() {
//    var df = DataFrame.readExcel("exports/export_spotreba.xls", columns = "B:D", sheetName = "Nameraná hodinová práca")
//    df = df.drop(9)
//    df = df.convert("D").toDouble()
//    df.print(rowsLimit = 800)

    val factory = MeasurementFactory("exports/")
    val measurements = factory.getAllMeasurements()

    for (measurement in measurements) {
        measurement.forEach {
            println("[${it.date}]")
            print("[${if(it.type == MeasurementType.NEGATIVE) "-" else  "+"}]")
            print(" ${it.amount}\n")
        }
    }
    // TODO: Make a measurement aggregator, that will process all the measurements of the day,
    //      and produce a delta measurement that will be able to be processed into a report
}