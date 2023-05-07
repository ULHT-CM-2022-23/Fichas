package com.github.mstavares.cm.acalculator

import org.junit.Test
import org.junit.Assert.*
import android.content.Context
import io.mockk.mockk
import org.junit.Before

class CalculatorTest {


    /*
    @Test
    fun clear() {
        Calculator.clear()
        assertEquals("0", Calculator.display)
        Calculator.addSymbol("2")
        Calculator.addSymbol("+")
        assertEquals("2+", Calculator.display)
        Calculator.clear()
        assertEquals("0", Calculator.display)
    }

    @Test
    fun addSymbol() {
        Calculator.clear()
        Calculator.addSymbol("2")
        Calculator.addSymbol("+")
        Calculator.addSymbol("8")
        assertEquals("2+8", Calculator.display)
    }
    @Test
    fun twoPlusTwoEquals() {
        Calculator.clear()
        Calculator.addSymbol("2")
        Calculator.addSymbol("+")
        Calculator.addSymbol("2")
        Calculator.equals()
        assertEquals("4.0", Calculator.display)
    }

    @Test
    fun threeTimesFourEquals() {
        Calculator.clear()
        Calculator.addSymbol("3")
        Calculator.addSymbol("*")
        Calculator.addSymbol("4")
        Calculator.equals()
        assertEquals("12.0", Calculator.display)
    }

    @Test
    fun tenMinusOneEquals() {
        Calculator.clear()
        Calculator.addSymbol("10")
        Calculator.addSymbol("-")
        Calculator.addSymbol("1")
        Calculator.equals()
        assertEquals("9.0", Calculator.display)
    }

    @Test
    fun tenDividedByFiveEquals() {
        Calculator.clear()
        Calculator.addSymbol("10")
        Calculator.addSymbol("/")
        Calculator.addSymbol("5")
        Calculator.equals()
        assertEquals("2.0", Calculator.display)
    }

    @Test
    fun allowNegativeNumbers() {
        Calculator.clear()
        Calculator.addSymbol("3")
        Calculator.addSymbol("-")
        Calculator.addSymbol("5")
        Calculator.equals()
        assertEquals("-2.0", Calculator.display)
    }

    @Test
    fun historyInsertion() {
        Calculator.clear()
        assertEquals(0, Calculator.history.size)
        Calculator.addSymbol("3")
        Calculator.addSymbol("-")
        Calculator.addSymbol("5")
        Calculator.equals()
        assertEquals(1, Calculator.history.size)
        assertEquals("3-5", Calculator.history[0].expression)
        assertEquals("-2.0", Calculator.history[0].result)
    }

    @Test
    fun backspace() {
        Calculator.clear()
        Calculator.addSymbol("7")
        Calculator.addSymbol("/")
        assertEquals("7/", Calculator.display)
        Calculator.backspace()
        assertEquals("7", Calculator.display)
    }

    @Test
    fun backspaceWithOneNumberShouldBeZero() {
        Calculator.clear()
        Calculator.addSymbol("9")
        assertEquals("9", Calculator.display)
        Calculator.backspace()
        assertEquals("0", Calculator.display)
    }
     */

}