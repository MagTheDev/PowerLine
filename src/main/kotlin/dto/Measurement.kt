package dto

import java.time.LocalDate
import java.time.LocalTime

data class Measurement(
    val type: MeasurementType,
    val date: LocalDate,
    val time: LocalTime,
    var amount: Double
)

enum class MeasurementType {
    POSITIVE,
    NEGATIVE
}

operator fun Measurement.plus(other: Measurement): Measurement {
    if (this.date != other.date) throw IllegalArgumentException("Unable to add different days together")
    when (other.type) {
        MeasurementType.NEGATIVE -> {
            this.amount -= other.amount
        }
        MeasurementType.POSITIVE -> {
            this.amount += other.amount
        }
    }
    return this
}
