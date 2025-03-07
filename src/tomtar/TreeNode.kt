package tomtar

typealias Visitor<String> = (TreeNode<String>) -> Unit

class TreeNode<String>(val value: String) {
    val children = mutableListOf<TreeNode<String>>()

    fun add(child: TreeNode<String>) = children.add(child)

    fun findEach(visit: Visitor<String>) {
        visit(this)

        children.forEach { it.findEach(visit) }
    }

    fun search(target: String): TreeNode<String>? {
        var result: TreeNode<String>? = null

        findEach { if (it.value == target) result = it }

        return result
    }

    fun addChildToParent(parent: String, child: String) {
        val parentNode: TreeNode<String>? = search(parent)
        if (parentNode != null) {
            val newChild = TreeNode(child)
            parentNode.add(newChild)
        } else {
            println("Couldn't find parent node for child $child")
        }
    }

    fun getListOfSubordinates(target: String): List<String> {
        val parentNode = search(target) ?: return emptyList()
        val returnList = mutableListOf<String>()
        parentNode.children.forEach { it.findEach { returnList.add(it.value)}}
        return returnList
    }
}