package tomtar;


import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class TomtarTest {

    TreeNode<String> tree = Tomtar.populateTree();

    @Test
    void searchTest() {
        assertNotNull(tree.search("Nyckelpigan"));
        assertEquals("Haren", Objects.requireNonNull(tree.search("Haren")).getValue());
        assertNull(tree.search("Steve"));
    }

    @Test
    void getListOfSubordinatesTest() {
        List<String> correctList = List.of("Gråsuggan", "Myran", "Bladlusen");
        List<String> actualList = tree.getListOfSubordinates("Räven");
        assertIterableEquals(correctList, actualList);
    }

}
