package net.codetreats.aoc.day13

import net.codetreats.aoc.util.Level
import net.codetreats.aoc.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day13Test {
    private lateinit var classUnderTest : Day13

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day13()
    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("", classUnderTest.run2())
    }
}
