package net.codetreats.aoc

import net.codetreats.aoc.util.Logger
import java.io.File

abstract class Day<T : Any>(val dayOfMonth: Int) {
    protected abstract val logger: Logger

    fun run() {
        runPart(1) {
            run1(useDummy)
        }
        runPart(2) {
            run2(useDummy)
        }
    }

    fun run1(dummy: Boolean) = run1(convert1(read(1, dummy)))

    fun run2(dummy: Boolean) = run2(convert2(read(2, dummy)))

    fun runPart(nr: Int, action: () -> String) {
        logger.system("#".repeat(20))
        logger.system("Starting part " + nr)
        logger.system("#".repeat(20))
        logger.system()
        var start = System.currentTimeMillis()
        logger.system("Result: " + action.invoke())
        var end = System.currentTimeMillis()
        logger.system()
        logger.system("Part " + nr + " took " + (end - start) + " millis")
    }

    private fun read(part: Int, dummy: Boolean): List<String> {
        val dir = "src/main/resources/day" + dayOfMonth.toString().padStart(2, '0')
        val filename = if (dummy) {
            "dummy"
        } else {
            "input"
        }
        val file = if (File(dir, "$filename$part.txt").exists()) {
            File(dir, "$filename$part.txt")
        } else {
            File(dir, "$filename.txt")
        }

        logger.debug("Read " + file.absolutePath)
        if (!file.exists()) {
            throw IllegalArgumentException("Input ${file.absolutePath} not exists")
        }
        return file.readLines()
    }


    open fun convert1(input: List<String>): T = convert(input)
    open fun convert2(input: List<String>): T = convert(input)
    abstract fun convert(input: List<String>): T
    abstract fun run1(data: T): String

    abstract fun run2(data: T): String

    open val useDummy = false
}