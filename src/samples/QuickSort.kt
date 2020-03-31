package samples

fun getPivot(input: Array<Int>, low: Int, high: Int): Int {
    val pivot = input[high]

    var i = low - 1 // index of smaller element

    for (j in low until high) { // If current element is smaller than or equal to pivot
        if (input[j] <= pivot) {
            i++
            // swap arr[i] and arr[j]
            val temp = input[i]
            input[i] = input[j]
            input[j] = temp
        }
    }

    // swap arr[i+1] and arr[high] (or pivot)
    val temp = input[i + 1]

    input[i + 1] = input[high]
    input[high] = temp

    return i + 1
}

fun Array<Int>.quickSort1(low: Int, high: Int) {
    if (low > high) return

    val pivot = getPivot(this, low, high)

    this.quickSort1(low, pivot - 1)

    this.quickSort1(pivot + 1, high)
}

fun main() {
    val input = arrayOf(10, 7, 8, 9, 1, 5)

    input.quickSort1(0, input.size - 1)

    input.forEach(::print)
}