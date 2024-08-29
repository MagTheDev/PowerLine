package dto

import java.time.LocalDate
import java.time.LocalTime

data class Measurement(
    val type: MeasurementType,
    val date: LocalDate,
    val time: LocalTime,
    val amount: Double
)

enum class MeasurementType {
    POSITIVE,
    NEGATIVE
}