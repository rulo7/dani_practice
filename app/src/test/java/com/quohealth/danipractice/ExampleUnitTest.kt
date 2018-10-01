package com.quohealth.danipractice

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun main() {
        val x = listOf("I1", "I2", "I3")

        System.out.println("x=$x tipos")

        var string1 = "Ho la"
        string1 = string1.replace(" ", "")

        System.out.println("Cadena remplazada = $string1")


        val items = mutableListOf(1, 2, 3, 4, 10)
        items[1] = 1
        items[items.size - 1] = 2
        val filteredItems = items.filter { it % 2 == 0 }

        System.out.println("x=$items")

        var answer = "Test. ,replace"
        println(answer)
        answer = answer.replace("[^A-Za-z0-9 ]", "")
        println(answer)
        val re = Regex("[^A-Za-z0-9 ]")
        answer = re.replace(answer, "")
        println(answer)


        assertTrue(true)
    }

    @Test
    fun test() {
        val items = mutableListOf(1, 2, 3, 4, 10)
        for(i in items){
            println(i)
        }
        assertTrue(true)
    }

    @Test
    fun test2() {
        /*for (i in 1..7) {
            println(i)
        }
        for (i in 6 downTo 0 step 2) {
            println(i)
        }*/
        val array = arrayOf("a", "b", "c")
        for (i in array.indices) {
            println(array[i])
        }

        for ((index, value) in array.withIndex()) {
            println("the element at $index is $value")
        }

        assertTrue(true)
    }

    @Test
    fun test3() {
        class Customer(name: String) {
            //val customerKey = name.toUpperCase()
            val customerKey = "123"
            val numero = 1
            init {
                println("$numero")
            }
        }
        Customer("Dani")

        assertTrue(true)
    }

}