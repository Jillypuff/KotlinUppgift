@file:JvmName("Tomtar")
package tomtar

fun populateTree(): TreeNode<String> {
    val tomten = TreeNode("Tomten")

    val glader = TreeNode("Glader")
    val butter = TreeNode("Butter")

    val tröger = TreeNode("Tröger")
    val trötter = TreeNode("Trötter")
    val blyger = TreeNode("Blyger")

    val rådjuret = TreeNode("Rådjuret")
    val nyckelpigan = TreeNode("Nyckelpigan")
    val haren = TreeNode("Haren")
    val räven = TreeNode("Räven")

    val skumtomten = TreeNode("Skumtomten")

    val dammråttan = TreeNode("Dammråttan")

    val gråsuggan = TreeNode("Gråsuggan")
    val myran = TreeNode("Myran")

    val bladlusen = TreeNode("Bladlusen")

    tomten.add(glader)
    tomten.add(butter)

    glader.add(tröger)
    glader.add(trötter)
    glader.add(blyger)

    butter.add(rådjuret)
    butter.add(nyckelpigan)
    butter.add(haren)
    butter.add(räven)

    trötter.add(skumtomten)

    skumtomten.add(dammråttan)

    räven.add(gråsuggan)
    räven.add(myran)

    myran.add(bladlusen)

    return tomten
}

fun main() {
    val tree = populateTree()

    val targetNode = "Tomten"
    val subordinates = mutableListOf<String>()
    tree.search(targetNode)?.let { it.children.forEach { it.findEach { subordinates.add(it.value) } } }
    subordinates.forEach { println(it)}

//    var subordinates2 = listOf<String>()
//    subordinates2 = tree.getListOfSubordinates(targetNode)
//    subordinates.forEach { println(it)}
}
