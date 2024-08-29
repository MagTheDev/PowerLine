package dev.magthe.processing

import dev.magthe.DataObjects.Measurement
import java.time.LocalDate

class MeasurementAggregator(private val measurementIterator: MeasurementIterator) {
    private val state = hashMapOf<LocalDate, Measurement>()

    fun processMeasurements() {



    }
}