package net.codetreats.aoc.day02

import net.codetreats.aoc.util.Level
import net.codetreats.aoc.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day02Test {
    private lateinit var classUnderTest : Day02

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day02()
    }

    @Test
    fun testPart01() {
        assertEquals("2776", classUnderTest.run1(false))
    }

    @Test
    fun testPart01_dummyData() {
        assertEquals("8", classUnderTest.run1(true))
    }

    @Test
    fun testPart02() {
        assertEquals("68638", classUnderTest.run2(false))
    }

    @Test
    fun testPart02_dummyData() {
        assertEquals("2286", classUnderTest.run2(true))
    }
}
