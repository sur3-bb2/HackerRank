package samples

import java.util.*


fun printLevelOrder(root: Node) {
    val queue = ArrayDeque<Node>()

    queue.offer(root)

    while(!queue.isEmpty()) {
        val temp = queue.poll()
        println(temp?.value)

        temp?.left?.run { queue.offer(this) }
        temp?.right?.run { queue.offer(this) }
    }

}

fun main(args: Array<String>) {
    val root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left?.left = Node(4)
    root.left?.right = Node(5)

    println("Level order traversal of binary tree is - ")
    printLevelOrder(root)
}