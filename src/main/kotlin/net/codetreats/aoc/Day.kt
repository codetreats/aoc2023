package net.codetreats.aoc

import net.codetreats.aoc.util.Logger
import java.io.File

abstract class Day<T : Any>(val dayOfMonth: Int) {
    protected abstract val logger: Logger

    protected lateinit var input : T

    fun init() {
        init(useDummy)
    }

    fun init(dummy:Boolean) {
        val dir = "src/main/resources/day" + dayOfMonth.toString().padStart(2, '0')
        if (dummy) {
            initInput(read(dir, "dummy.txt"))
        } else {
            initInput(read(dir, "input.txt"))
        }
    }

    fun read(dir: String, file: String): List<String> {
        val file = File(dir, file)
        logger.debug("Read " + file.absolutePath)
        if (!file.exists()) {
            return throw IllegalArgumentException("Input ${file.absolutePath} not exists")
        }
        return file.readLines()
    }

    private fun initInput(input: List<String>) {
        this.input = convert(input)
    }


    fun run() {
        init()
        runPart(1) { run1() }
        if (reset) {
            init()
        }
        runPart(2) { run2() }
    }

    fun runPart(nr: Int, action: ()->String) {
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

    abstract fun convert(input: List<String>): T

    abstract fun run1(): String

    abstract fun run2(): String

    open val useDummy = false

    open val reset = true

}