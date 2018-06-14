import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Austin Sutton
 * @author Chris Hurt
 * This class is an implementation of a graph data structure.
 * The vertices in the graph are strings.
 */
public class Graph {
    private ArrayList<String> vertices_in_graph;
    private HashMap<String, ArrayList<String>> adjacency_list;

    /**
     * Constructor for the graph structure given a
     * 2D adjacency matrix of Strings. Converts the
     * matrix to an adjacency list.
     *
     * @param graph_in adjacency matrix of strings
     */
    public Graph(String[][] graph_in) {
        vertices_in_graph = new ArrayList<>();
        adjacency_list = new HashMap<>();

        for (int i = 0; i < graph_in.length; i++) {
            if (graph_in[i][0] != null) {
                vertices_in_graph.add(graph_in[i][0]);
                ArrayList<String> temp = new ArrayList<>();
                for (int j = 1; j < graph_in[i].length; j++) {
                    if (graph_in[i][j] != null) {
                        temp.add(graph_in[i][j]);
                    }
                }
                adjacency_list.put(vertices_in_graph.get(i), temp);
            }
        }
    }

    /**
     * Gets the edge list for a given vertex.
     *
     * @param key Vertex provided for edge list.
     * @return The edge list for the given vertex.
     */
    public ArrayList<String> getEdgeList(String key) {
        return adjacency_list.get(key);
    }

    /**
     * Gets a list of vertices for this graph.
     *
     * @return list of vertices for this graph
     */
    public ArrayList<String> getVertices() {
        return vertices_in_graph;
    }

    /**
     * Builds a string of this graph.
     *
     * @return String presentation of this graph in the form:
     * vertex_1: edge_1, edge_2
     * vertex_2: edge_1
     * vertex_3
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<String, ArrayList<String>> entry : adjacency_list.entrySet()) {
            ArrayList<String> vertices = entry.getValue();

            //cant believe this works thanks IntelliJ
            s.append(entry.getKey()).append(":").append(" ");

            for (String vertex : vertices) {
                s.append(vertex).append(", ");
            }
            s.deleteCharAt(s.length() - 2);
            s.append('\n');
        }
        return s.toString();
    }
}


