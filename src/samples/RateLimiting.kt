package samples

/**
 * Sliding window problem
 *
 * rate limiting API
 *
 * The below representation will make it clear how the window slides over the array.

This is the initial phase where we have calculated the initial window sum starting from index 0 .
At this stage the window sum is 6. Now, we set the maximum_sum as current_window i.e 6.




Now, we slide our window by a unit index. Therefore, now it discards 5 from the window and adds 0 to the window.
Hence, we will get our new window sum by subtracting 5 and then adding 0 to it. So, our window sum now becomes 1.
Now, we will compare this window sum with the maximum_sum. As it is smaller we wont the change the maximum_sum.


Similarly, now once again we slide our window by a unit index and obtain the new window sum to be 2.
Again we check if this current window sum is greater than the maximum_sum till now. Once, again it is smaller
so we don’t change the maximum_sum.

Therefore, for the above array our maximum_sum is 6.


https://www.geeksforgeeks.org/window-sliding-technique/
 
 *
 *
 */
fun slidingWindow(input: List<Int>, x: Int, n: Int) : Int {
    //val i = input.groupBy { it }

    var current = input.first()
    val grouped = mutableListOf<Int>()
    var count = 0

    for(item in input) {
        if(item == current) {
            count++
        } else {
            grouped.add(count)
            current = item
            count = 1
        }
    }

    grouped.add(count)

    var maxSum = 0

    for (i in 0 until n) {
        maxSum += grouped[i]
    }

    var rejected = if(maxSum > 0) (maxSum - x) else 0
    var currentWindow = maxSum

    for (i in n until grouped.size) {
        currentWindow = currentWindow + grouped[i] - grouped[i-n]
        rejected += (currentWindow - x)
    }

    return rejected
}

fun bruteForce(input: List<Int>, x: Int, n: Int) : Int {
    var current = 0
    var rejected = 0
    var index = 0

    //[1, 1, 1, 1, 2, 2, 2, 3, 3, 3], X = 5, N = 2. Output = 3
    //[1, 2, 2, 2, 2, 3, 3, 3, 3]

    while(index < input.size) {
        var temp = 0

        while(index < input.size && input[index++] <= current + n) { //current was 1 , loop until 1+2(n) = 3
            temp++            // 7
        }

        current += n //current = 0, 0 + 2 - 1 = 1
        rejected += (temp - x) // 7-5 = 2
        if(index < input.size && rejected > 0) index -= (rejected + 2) //shoud be 4, index = 7 ==> 7-2-1 = 4
        else if(index < input.size) index -= temp
    }

    return rejected
}

fun main(args: Array<String>) {
    val input1 = arrayOf(1, 1, 1, 1, 2, 2, 2, 3, 3, 3)
    val x1 = 5
    val n1 = 2

    val input2 = arrayOf(1, 1, 1, 1, 2, 2, 2)
    val x2 = 5
    val n2 = 2

    val input3 = arrayOf(1, 2, 2, 2, 2, 3, 3, 3, 3)
    val x3 = 5
    val n3 = 2

    //1, 4, 2, 10, 2, 3, 1, 0, 20
    val input4 = arrayOf(
        1,
        2,
        2,
        2,
        2,
        3,
        3,
        4,
        4,
        4,
        4,
        4,
        4,
        4,
        4,
        4,
        4,
        5,
        5,
        6,
        6,
        6,
        7,
        9,
        9,
        9,
        9,
        9,
        9,
        9,
        9,
        9,
        9,
        9,
        9,
        9,
        9,
        9,
        9,
        9,
        9,
        9,
        9
    )
    val x4 = 15
    val n4 = 4

    println(bruteForce(input1.toList(), x1, n1))
    println(slidingWindow(input1.toList(), x1, n1))

    println(bruteForce(input2.toList(), x2, n2))
    println(slidingWindow(input2.toList(), x2, n2))

    println(bruteForce(input3.toList(), x3, n3))
    println(slidingWindow(input3.toList(), x3, n3))

    println(bruteForce(input4.toList(), x4, n4))
    println(slidingWindow(input4.toList(), x4, n4))
}