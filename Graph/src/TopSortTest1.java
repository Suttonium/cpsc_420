import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;


public class TopSortTest1 {



    @Test
    public void testDFS1() {
        String[] [] graphin = {{"c1", "c3"},{"c2","c3"},
                {"c3", "c4", "c5"},
                {"c4", "c5"}, {"c5"}};
        Graph g = new Graph(graphin );
        TopSort t = new TopSort( );
        ArrayList<String> actual = t.dfsTopSort(g);
        ArrayList<String> expected = new ArrayList<String> (Arrays.asList("c2", "c1", "c3", "c4", "c5"));
        assertEquals("dfs should be c2, c1, c3, c4, c5", expected, actual);
    }

    @Test
    public void testDFS2() {
        String[] [] graphin = {{"c1", "c3"},
                {"c3", "c4", "c5"},
                {"c4", "c5"}, {"c5"}};
        Graph g = new Graph(graphin );
        TopSort t = new TopSort( );
        ArrayList<String> actual = t.dfsTopSort(g);
        ArrayList<String> expected = new ArrayList<String> (Arrays.asList("c1", "c3", "c4", "c5"));
        assertEquals("dfs should be c1, c3, c4, c5", expected, actual);
    }

    @Test
    public void testDFS3() {
        String[] [] graphin = {{"c1", "c3"},
                {"c3", "c4", "c5"},
                {"c4", "c1", "c5"}, {"c5"}};
        Graph g = new Graph(graphin );
        TopSort t = new TopSort( );
        ArrayList<String> actual = t.dfsTopSort(g);
        ArrayList<String> expected = null;
        assertEquals("dfs should be null; graph has a cycle", expected, actual);
    }

    @Test
    public void testDFS4() {
        String[] [] graphin = {{"c1", "c3"},{"c2","c3"},
                {"c3", "c4", "c5"},
                {"c4", "c5"}, {"c5"}, {"c6", "c7"}, {"c7"}};
        Graph g = new Graph(graphin );
        TopSort t = new TopSort( );
        ArrayList<String> actual = t.dfsTopSort(g);
        ArrayList<String> expected = new ArrayList<String> (Arrays.asList("c6", "c7", "c2", "c1", "c3", "c4", "c5"));
        assertEquals("dfs should be c6, c7, c2, c1, c3, c4, c5", expected, actual);
    }

    @Test
    public void testSource1() {
        String[] [] graphin = {{"c1", "c3"},{"c2","c3"},
                {"c3", "c4", "c5"},
                {"c4", "c5"}, {"c5"}};
        Graph g = new Graph(graphin );
        TopSort t = new TopSort( );
        ArrayList<String> actual = t.sourceTopSort(g);
        ArrayList<String> expected = new ArrayList<String> (Arrays.asList("c1", "c2", "c3", "c4", "c5"));
        assertEquals("source should be c1, c2, c3, c4, c5", expected, actual);
    }

    @Test
    public void testSource2() {
        String[] [] graphin = {{"c1", "c3"},
                {"c3", "c4", "c5"},
                {"c4", "c5"}, {"c5"}};
        Graph g = new Graph(graphin );
        TopSort t = new TopSort( );
        ArrayList<String> actual = t.sourceTopSort(g);
        ArrayList<String> expected = new ArrayList<String> (Arrays.asList("c1", "c3", "c4", "c5"));
        assertEquals("source should be c1, c3, c4, c5", expected, actual);
    }

    @Test
    public void testSource3() {
        String[] [] graphin = {{"c1", "c3"},
                {"c3", "c4", "c5"},
                {"c4", "c1", "c5"}, {"c5"}};
        Graph g = new Graph(graphin );
        TopSort t = new TopSort( );
        ArrayList<String> actual = t.sourceTopSort(g);
        ArrayList<String> expected = null;
        assertEquals("source should be null; graph has a cycle", expected, actual);
    }

    @Test
    public void testSource4() {
        String[] [] graphin = {{"c1", "c3"},{"c2","c3"},
                {"c3", "c4", "c5"},
                {"c4", "c5"}, {"c5"}, {"c6", "c7"}, {"c7"}};
        Graph g = new Graph(graphin );
        TopSort t = new TopSort( );
        ArrayList<String> actual = t.sourceTopSort(g);
        ArrayList<String> expected = new ArrayList<String> (Arrays.asList( "c1", "c2","c3", "c4", "c5", "c6", "c7"));
        assertEquals("source should be c1, c2, c3, c4, c5, c6, c7", expected, actual);
    }

}