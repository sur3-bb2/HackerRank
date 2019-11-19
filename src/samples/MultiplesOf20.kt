package samples

data class MultiplierCount(val pair: Pair<Int, Int>) {
    private var multiplier1: Int = 0
    private var multiplier2: Int = 0

    fun count(it: Int) {
        when(it){
            pair.first -> multiplier1++
            pair.second -> multiplier2++
        }
    }

    fun result() {
        if(multiplier1 == 0 || multiplier2 == 0) return

        println("found ${pair.first} : ${pair.second} : ${if(multiplier1 > multiplier2) multiplier1 else multiplier2} times")
    }
}

fun main() {
    val numbers = arrayOf(1, 20, 10, 2, 4, 5, 3)

    getMultiples(numbers, 20)
}

fun Int.getMultipliers(): Map<Int, List<MultiplierCount>> {
    if(this <= 1) return emptyMap()

    var mutableMap : MutableMap<Int, List<MultiplierCount>> = mutableMapOf()
    var multipliers : MutableList<MultiplierCount> = mutableListOf()
    var loops = 0

    for(i in 1 until this.div(2)) {
        if(this.rem(i) == 0) {
            val multiplierCount = MultiplierCount(i to this.div(i))

            mutableMap[i] = listOf(multiplierCount)
            mutableMap[this.div(i)] = listOf(multiplierCount)
            multipliers.add(multiplierCount)
        }

        loops++
    }

    mutableMap[this] = multipliers

    println("Int.getMultipliers() : total loops $loops")

    return mutableMap
}

fun getMultiples(numbers: Array<Int>, multipleOf: Int) {
    val multipliers = multipleOf.getMultipliers()

    numbers.forEach {
        if(multipliers.containsKey(it)) {
            multipliers[it]?.first()?.count(it)
        }
    }

    multipliers[multipleOf]?.forEach {
        it.result()
    }
}