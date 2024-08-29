package dev.magthe.processing

import dto.Measurement
import dto.plus
import java.time.LocalDate

class MeasurementAggregator(measurementIterator: MeasurementIterator) {
    private val state = hashMapOf<LocalDate, Measurement>()
    private var measurementIterator = measurementIterator

    fun processMeasurements() {
        measurementIterator.forEach {
            var measurement = state[it.date]
            if (measurement == null) {
                state[it.date] = it
                measurement = it
            }
            measurement + it
        }
    }

    fun addIterator(other: MeasurementIterator) {
        measurementIterator = iteratorToMeasurementIterator((measurementIterator.asSequence() + other.asSequence()).iterator())
    }

    private fun iteratorToMeasurementIterator(iterator: Iterator<Measurement>): MeasurementIterator {
        return object : MeasurementIterator {
            override fun hasNext(): Boolean {
                return iterator.hasNext()
            }

            override fun next(): Measurement {
                return iterator.next()
            }

        }
    }

    fun print() {
        state.values.forEach {
            println("[${it.date}]           Δ ${it.amount}kWh")
        }
    }
}