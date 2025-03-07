package aoc1

// https://adventofcode.com/2015/day/2#part2

import java.io.File

fun calculateSurfaceArea(x: Int, y: Int) = 2 * x * y
fun calculateAllSurfaceAreas(numbers: List<Int>) =
    calculateSurfaceArea(numbers[0], numbers[1]) +
            calculateSurfaceArea(numbers[1], numbers[2]) +
            calculateSurfaceArea(numbers[2], numbers[0])

fun calculateSmallestArea(x: Int, y: Int) = x * y

fun calculateRibbonNeeded(numbers: List<Int>) = numbers[0] + numbers [0] + numbers[1] + numbers[1]

fun calculateRibbonBow(numbers: List<Int>) = numbers[0] * numbers[1] * numbers[2]

fun main() {
    val data: List<String> = File("src/aoc1/data").readLines()
    var totalSquareFeet = 0
    var totalFeetRibbon = 0
    for (line in data) {
        val numbers = line.split("x").map { it.toInt() }.sorted()
        totalSquareFeet += calculateSmallestArea(numbers[0], numbers[1])
        totalSquareFeet += calculateAllSurfaceAreas(numbers)
        totalFeetRibbon += calculateRibbonNeeded(numbers)
        totalFeetRibbon += calculateRibbonBow(numbers)
    }

    println(totalSquareFeet)
    println(totalFeetRibbon)
}