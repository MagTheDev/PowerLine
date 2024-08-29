package dev.magthe.processing

import dto.Measurement
import java.time.LocalDate

class MeasurementAggregator(private val measurementIterator: MeasurementIterator) {
    private val state = hashMapOf<LocalDate, Measurement>()

    fun processMeasurements() {



    }
}