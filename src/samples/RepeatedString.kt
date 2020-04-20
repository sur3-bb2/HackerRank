package samples

import java.util.*
import kotlin.math.floor

/**
 * https://www.hackerrank.com/challenges/repeated-string/problem
 *
 * Lilah has a string, , of lowercase English letters that she repeated infinitely many times.

     Given an integer, , find and print the number of letter a's in the first  letters of Lilah's infinite string.

For example, if the string  and , the substring we consider is , the first  characters of her infinite string. There are  occurrences of a in the substring.
 *
 *Sample Input 0

aba
10
Sample Output 0

7
Explanation 0
The first  letters of the infinite string are abaabaabaa. Because there are  a's, we print  on a new line.

Sample Input 1

a
1000000000000
Sample Output 1

1000000000000
 *
 *
 *
 */
// Complete the repeatedString function below.
fun repeatedString(s: String, n: Long): Long {
    if(s.length >= n) return s.slice(0 until n.toInt()).count { it == 'a' }.toLong()

    val noOfAs = s.count { it == 'a' }.toLong()

    val totalAs = floor((n / s.length).toDouble()) * noOfAs

    val remaining = (n % s.length).toInt()

    if(remaining == 0) return totalAs.toLong()

    return (totalAs + s.slice(0 until remaining).count { it == 'a' }).toLong()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val n = scan.nextLine().trim().toLong()

    val result = repeatedString(s, n)

    println(result)
}
