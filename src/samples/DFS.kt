package samples

import java.util.*

//data class SNode(val value: Int, var left: SNode? = null, var right: SNode? = null, var visited: Boolean = false)
data class SNode(val value: Int, var left: SNode? = null, var right: SNode? = null)


fun preOrderRecur(root: SNode?) {
    if(root == null) return

    println(root.value)
    preOrderRecur(root.left)
    preOrderRecur(root.right)
}

fun preOrder(root: SNode) {
    val stack = ArrayDeque<SNode>()

    stack.push(root)

    while(!stack.isEmpty()) {
        val temp = stack.pop()

        println(temp.value)

        if(temp?.right != null) {
            stack.push(temp?.right)
        }

        if(temp?.left != null) {
            stack.push(temp?.left)
        }
    }
}

fun main(args: Array<String>) {
    val root = SNode(1)
    root.left = SNode(2)
    root.right = SNode(3)
    root.left?.left = SNode(4)
    root.left?.right = SNode(5)

    println("Level order traversal of binary tree is - ")
    preOrderRecur(root)
    preOrder(root)
}