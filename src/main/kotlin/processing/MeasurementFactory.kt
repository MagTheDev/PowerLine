package dev.magthe.processing

import java.io.File

class MeasurementFactory(directoryPath: String) {
    private val directory: File = File(directoryPath)


    init {
        if (!directory.exists()) {
            throw IllegalArgumentException("Directory does not exist: $directoryPath")
        }
        if (!directory.isDirectory) {
            throw IllegalArgumentException("Path is not a directory: $directoryPath")
        }
    }

    private fun listMeasurementFiles(): List<File> {
        return directory.listFiles { file -> file.isFile && file.extension == "xls" }?.toList() ?: emptyList()
    }

    fun getAllMeasurements(): List<MeasurementIterator> {
        val files = listMeasurementFiles()
        val measurements = mutableListOf<ExcelMeasurementIterator>()

        for (file in files) {
            val measurementIter = ExcelMeasurementIterator(file.absolutePath)
            measurements.add(measurementIter)
        }
        return measurements
    }
}