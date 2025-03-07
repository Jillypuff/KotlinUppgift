package aoc3

import java.io.File
import kotlin.system.measureTimeMillis

fun checkForCorrectDesign(data: String, patterns: List<String>): Boolean {
    var subDesigns: List<String> = listOf(data)
    while (subDesigns.isNotEmpty()) {
        subDesigns = checkForPatterns(subDesigns, patterns)
        if (subDesigns.size == 1) {
            if (subDesigns[0] == "Correct") return true
        }
    }
    return false
}

fun checkForPatterns(subDesigns: List<String>, patterns: List<String>): List<String> {
    val returnList = mutableListOf<String>()
    for (design in subDesigns) {
        for (pattern in patterns) {
            if (design.startsWith(pattern)) {
                val temp: String = design.replaceFirst(pattern, "")
                if (temp.isEmpty()){
                    returnList.clear()
                    returnList.add("Correct")
                    return returnList
                }
                returnList.add(temp)
            }
        }
    }
    return returnList
}

fun checkForPatternRecursive(subDesigns: List<String>, patterns: List<String>): Boolean {
    val returnList = mutableListOf<String>()
    for (design in subDesigns) {
        for (pattern in patterns) {
            if (design.startsWith(pattern)) {
                val temp: String = design.removePrefix(pattern)
                if (temp.isEmpty()) return true
                returnList.add(temp)
            }
        }
    }
    return returnList.isNotEmpty() && checkForPatternRecursive(returnList, patterns)
}

fun checkForPatternBFS(design: String, patterns: List<String>): Boolean {
    val queue: ArrayDeque<String> = ArrayDeque(listOf(design))
    val seen: MutableSet<String> = mutableSetOf()

    while(queue.isNotEmpty()) {
        val current = queue.removeFirst()

        if (current in seen) continue
        seen.add(current)

        for (pattern in patterns) {
            if (current.startsWith(pattern)) {
                val next = current.removePrefix(pattern)
                if (next.isEmpty()) return true
                queue.add(next)
            }
        }
    }
    return false
}

fun checkForPatternDFS(design: String, patterns: List<String>): Boolean {
    val stack: ArrayDeque<String> = ArrayDeque(listOf(design))
    val seen: MutableSet<String> = mutableSetOf()

    while(stack.isNotEmpty()) {
        val current = stack.removeLast()

        if (current in seen) continue
        seen.add(current)

        for (pattern in patterns) {
            if (current.startsWith(pattern)) {
                val next = current.removePrefix(pattern)
                if (next.isEmpty()) return true
                stack.add(next)
            }
        }
    }
    return false
}

fun main() {
    val data: List<String> = File("src/aoc3/data").readLines()
    val patterns: List<String> = data[0].split(", ")
    val designs = data.drop(2)

    var correctDesigns = 0
    for (design in designs) {
        if (checkForPatternDFS(design, patterns)) correctDesigns++
    }
    println(correctDesigns)

    val bfsTime = measureTimeMillis {
        for (design in designs) {
            checkForPatternBFS(design, patterns)
        }
    }
    println("BFS Time: $bfsTime ms")

    val dfsTime = measureTimeMillis {
        for (design in designs) {
            checkForPatternDFS(design, patterns)
        }
    }
    println("DFS Time: $dfsTime ms")
}