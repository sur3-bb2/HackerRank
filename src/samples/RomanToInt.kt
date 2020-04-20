package samples

fun partRomanToInt(c: Char) = when (c) {
        'I' -> 1
        'V' -> 5
        'X' -> 10
        'L' -> 50
        'C' -> 100
        'D' -> 500
        'M' -> 1000
        else -> 0
    }

fun romanToInt(s: String): Int {
    var res = 0
    var lastNum = 100000 //max


    for (i in s.indices) {
        val c: Char = s[i]
        val num = partRomanToInt(c)
        res += num
        if (num > lastNum) {
            res -= 2 * lastNum
        }
        lastNum = num
    }
    return res
}

fun main(args: Array<String>) {

}