/**
 * @author Austin Sutton
 * @author Chris Hurt
 *
 * This class generates random DAGs.
 */

import java.util.*;

public class DAGGen {
    private static String[] alphabet = new String[]{
            "a", "b", "c", "d", "e", "f", "g",
            "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u",
            "v", "w", "x", "y", "z"
    };


    public DAGGen() {
    }

    /**
     * Creates a random directed-acyclic graph.
     * Inspiration taken from https://stackoverflow.com/questions/12790337/generating-a-random-dag
     * Highly simplified.
     * @param ranks how tall the graph should be
     * @param nodes how fat the graph should be
     * @param edgePercentage percent chance of an edge being drawn, higher percent = more dense graph
     * @return
     */
    public static Graph randomDAG(int ranks, int nodes, int edgePercentage) {
        Random rand = new Random();
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        // Create adjacency list for random DAG
        for(int i = 0; i < ranks; i++) {
            ArrayList<String> list = new ArrayList<>();
            for(int j = i+1; j < nodes; j++) {
                if(rand.nextInt(100) < edgePercentage) {
                    list.add(alphabet[j]);
                }
            }
            map.put(alphabet[i], list);
        }

        // Convert to adjacency matrix so a Graph object can be created.
        String[][] array = new String[nodes][nodes];
        for(int i = 0; i < nodes; i++) {
            array[i][0] = alphabet[i];
        }
        int i = 0;
        for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            int j = 0;

            String key = entry.getKey();
            array[i][j] = key;

            ArrayList<String> values = entry.getValue();
            j++;
            for(String value : values) {
                array[i][j] = value;
                j++;
            }

            i++;
        }

        // return Graph object
        return new Graph(array);
    }

}
