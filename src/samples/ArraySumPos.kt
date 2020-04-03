package samples

// https://www.geeksforgeeks.org/find-subarray-with-given-sum/
fun main(args: Array<String>) {
    val arr = intArrayOf(15, 2, 4, 8, 9, 5, 10, 23)
    val sum = 23

    var temp = arr[0]
    var pointer = 0

    for(i in 1..arr.size) {
        while (temp > sum && pointer < i - 1) {
            temp -= arr[pointer]
            pointer++
        }

        if(temp == sum) {
            println("index from $pointer to ${i-1}")

            return
        }

        temp += arr[i]
    }
}