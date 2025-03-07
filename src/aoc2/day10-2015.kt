package aoc2

// https://adventofcode.com/2015/day/10#part2

fun fortyLoops(data: String): StringBuilder {
    var transformString:StringBuilder = StringBuilder()
    transformString.append(data)
    repeat(50) {
        transformString = getNewString(transformString)
    }
    return transformString
}

fun getNewString(data: StringBuilder): StringBuilder {
    val newString = StringBuilder()
    var counter = 0
    var currentChar: Char = data[0]

    for (j in data){
        when (currentChar) {
            j -> counter++
            else -> {
                newString.append(counter).append(currentChar)
                counter = 1
                currentChar = j
            }
        }
    }
    newString.append(counter).append(currentChar)

    return newString
}

fun main() {
    val data = "1321131112"
    println(fortyLoops(data).length)
}