package samples

fun fibbasic(i: Int) : Int {
    if(i <= 1) {
        return i
    }

    return fibbasic(i - 1) + fibbasic(i - 2)
}

fun fibDynamic(i : Int) : Int {
    val ar = mutableListOf(0, 1)

    for(n in 2..i){
        ar.add(ar[n-1]+ar[n-2])
    }

    return ar.last()
}

fun fibSpace(i : Int) : Int {
    var a = 0
    var b = 1
    var c = 0

    for(n in 2..i){
        c = a + b
        a = b
        b = c
    }

    return c
}


fun main(args: Array<String>) {
    val i = 9

    println(fibbasic(i))
    println(fibDynamic(i))
    println(fibSpace(i))
}