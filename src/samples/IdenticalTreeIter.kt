package samples

import java.util.*

/**
 * https://www.geeksforgeeks.org/iterative-function-check-two-trees-identical/

Iterative function to check if two trees are identical
Two trees are identical when they have same data and arrangement of data is also same.
To identify if two trees are identical, we need to traverse both trees simultaneously, and while traversing
we need to compare data and children of the trees.

We have discussed recursive solution here. In this article iterative solution is discussed.
The idea is to use level order traversal. We traverse both trees simultaneously and compare the
data whenever we dequeue and item from queue. Below is the implementation of the idea.

 **/


fun isSameIte(node1: Node?, node2: Node?) : Boolean {
    if(node1 == null && node2 == null) return true

    if(node1 == null || node2 == null) return true

    val queue = ArrayDeque<Node>()

    queue.offer(node1)
    queue.offer(node2)

    while(!queue.isEmpty()) {
        val left = queue.poll()
        val right = queue.poll()

        if(left ?.value != right?.value) return false

        if(left?.left != null && right?.left != null) {
            queue.offer(left?.left)
            queue.offer(right?.left)
        } else if(left?.left != null || right?.left != null) {
            return false
        }

        if(left?.right != null && right?.right != null) {
            queue.offer(left?.right)
            queue.offer(right?.right)
        } else if(left?.right != null || right?.right != null) {
            return false
        }
    }

    return true
}

fun main(args: Array<String>) {
    var root1 = Node(1)
    root1.left = Node(2)
    root1.right = Node(3)
    root1.left?.left = Node(4)
    root1.left?.right = Node(5)

    var root2 = Node(1)
    root2.left = Node(2)
    root2.right = Node(3)
    root2.left?.left = Node(4)
    root2.left?.right = Node(5)

    println(isSameIte(root1, root2))
}