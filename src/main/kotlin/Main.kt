package dev.magthe

import dev.magthe.processing.MeasurementAggregator
import dev.magthe.processing.MeasurementFactory


fun main() {

    val factory = MeasurementFactory("exports/")
    val measurements = factory.getAllMeasurements()


    val aggr = MeasurementAggregator(measurements[0])
    aggr.addIterator(measurements[1])
    aggr.processMeasurements()
    aggr.print()
}