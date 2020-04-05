package samples

/**
 * https://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/

sameTree(tree1, tree2)
1. If both trees are empty then return 1.
2. Else If both trees are non -empty
(a) Check data of the root nodes (tree1->data ==  tree2->data)
(b) Check left subtrees recursively  i.e., call sameTree(
tree1->left_subtree, tree2->left_subtree)
(c) Check right subtrees recursively  i.e., call sameTree(
tree1->right_subtree, tree2->right_subtree)
(d) If a,b and c are true then return 1.
3  Else return 0 (one is empty and other is not)

 **/

data class Node(val value: Int, var left: Node? = null, var right: Node? = null)

fun isSame(node1: Node?, node2: Node?) : Boolean {
    if(node1 == null && node2 == null) return true

    if(node1?.value == node2?.value) {
        return isSame(node1?.left, node2?.left) && isSame(node1?.right, node2?.right)
    }

    return false
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
    root2.left?.right = Node(55)

    println(isSame(root1, root2))
}