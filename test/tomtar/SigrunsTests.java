package tomtar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SigrunsTests {

    TreeNode<String> tree = Tomtar.populateTree();

    List<String> uTomten = Arrays.asList("Tröger", "Trötter", "Blyger", "Dammråttan", "Skumtomten", "Glader",
            "Butter", "Rådjuret", "Nyckelpigan", "Haren", "Räven", "Gråsuggan", "Myran", "Bladlusen");
    List<String> uGlader = Arrays.asList("Tröger", "Trötter", "Blyger", "Dammråttan", "Skumtomten");
    List<String> uButter = Arrays.asList("Rådjuret", "Nyckelpigan", "Haren", "Räven", "Gråsuggan", "Myran",
            "Bladlusen");
    List<String> uTrötter = Arrays.asList("Dammråttan", "Skumtomten");
    List<String> uSkumtomten = Arrays.asList("Dammråttan");
    List<String> uRäven = Arrays.asList("Gråsuggan", "Myran", "Bladlusen");
    List<String> uMyran = Arrays.asList("Bladlusen");


    @Test
    final void getUnderlingsBladlusenTest(){
        List<String> underlings = tree.getListOfSubordinates("Bladlusen");
        assertEquals(underlings.size(), 0);
    }

    @Test
    final void getUnderlingsTrögerTest(){
        List<String> underlings = tree.getListOfSubordinates("Tröger");
        assertEquals(underlings.size(), 0);
    }

    @Test
    final void getUnderlingsBlygerTest(){
        List<String> underlings = tree.getListOfSubordinates("Blyger");
        assertEquals(underlings.size(), 0);
    }

    @Test
    final void getUnderlingsDammråttanTest(){
        List<String> underlings = tree.getListOfSubordinates("Dammråttan");
        assertEquals(underlings.size(), 0);
    }

    @Test
    final void getUnderlingsGråsugganTest(){
        List<String> underlings = tree.getListOfSubordinates("Gråsuggan");
        assertEquals(underlings.size(), 0);
    }

    @Test
    final void getUnderlingsHarenTest(){
        List<String> underlings = tree.getListOfSubordinates("Haren");
        assertEquals(underlings.size(), 0);
    }

    @Test
    final void getUnderlingsNyckelpiganTest(){
        List<String> underlings = tree.getListOfSubordinates("Nyckelpigan");
        assertEquals(underlings.size(), 0);
    }

    @Test
    final void getUnderlingsRådjuretTest(){
        List<String> underlings = tree.getListOfSubordinates("Rådjuret");
        assertEquals(underlings.size(), 0);
    }

    @Test
    final void getUnderlingsMyranTest(){
        List<String> underlings = tree.getListOfSubordinates("Myran");
        assertEquals(underlings.size(), uMyran.size());
        assertFalse(underlings.retainAll(uMyran));
    }

    @Test
    final void getUnderlingsRävenTest(){
        List<String> underlings = tree.getListOfSubordinates("Räven");
        assertEquals(underlings.size(), uRäven.size());
        assertFalse(underlings.retainAll(uRäven));
    }

    @Test
    final void getUnderlingsSkumtomtenTest(){
        List<String> underlings = tree.getListOfSubordinates("Skumtomten");
        assertEquals(underlings.size(), uSkumtomten.size());
        assertFalse(underlings.retainAll(uSkumtomten));
    }

    @Test
    final void getUnderlingsTrötterTest(){
        List<String> underlings = tree.getListOfSubordinates("Trötter");
        assertEquals(underlings.size(), uTrötter.size());
        assertFalse(underlings.retainAll(uTrötter));
    }


    @Test
    final void getUnderlingsButterTest(){
        List<String> underlings = tree.getListOfSubordinates("Butter");
        assertEquals(underlings.size(), uButter.size());
        assertFalse(underlings.retainAll(uButter));
    }

    @Test
    final void getUnderlingsGladerTest(){
        List<String> underlings = tree.getListOfSubordinates("Glader");
        assertEquals(underlings.size(), uGlader.size());
        assertFalse(underlings.retainAll(uGlader));
    }

    @Test
    final void getUnderlingsTomtenTest(){
        List<String> underlings = tree.getListOfSubordinates("Tomten");
        assertEquals(underlings.size(), uTomten.size());
        assertFalse(underlings.retainAll(uTomten));
    }

}