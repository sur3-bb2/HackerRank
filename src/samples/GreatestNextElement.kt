package samples

fun main(args: Array<String>){
    val array = arrayOf(2, 4, 1, 2, 1)
    val expectedOutput  = arrayOf(4, -1, 2, -1, -1)

    var maxItem = array[array.size - 1]
    var actual = mutableListOf(-1)

    for(i in array.size - 2 downTo 0) {
        if(maxItem > array[i]) actual.add(maxItem)
        else {
            actual.add(-1)
            maxItem = array[i]
        }
    }

    actual = actual.asReversed()
    println(expectedOutput.toIntArray() contentEquals  actual.toIntArray())
    actual.forEach(::println)
}