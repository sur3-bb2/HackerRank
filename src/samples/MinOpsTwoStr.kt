package samples

fun minOps(a: String, b: String) : Int {
    var i = a.length - 1
    var j = b.length - 1

    var ops = 0

    while(i >= 0) {
        if(a[i] != b[j]){
            ops++
        } else {
            j--
        }

        i--
    }

    return ops
}

fun main(args: Array<String>) {
    val a = "EACBD"
    val b = "EABCD"

    println(minOps(a, b))
}