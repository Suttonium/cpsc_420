import java.util.*;

/**
 * @author Austin Sutton
 * @author Chris Hurt
 * @author Matthew Otto
 * <p>
 * worked with: Jona Q, and Tyler T
 * <p>
 * This class contains methods to topologically sort a graph.
 */
public class TopSort {
    private Stack<String> stack = new Stack<>();
    private ArrayList<String> visited = new ArrayList<>();
    private long time = 0;
    private ArrayList<String> subedges;

    /**
     * This method performs a depth-first search implementation of a topological sort.
     * It sorts a given graph using a stack. It adds the contents of the stack to a
     * list in reverse order and returns that list.
     *
     * @param graph the graph to be sorted topologically
     * @return a list of vertices in the graph sorted topologically
     */
    public ArrayList<String> dfsTopSort(Graph graph) {

        ArrayList<String> vertices = graph.getVertices();

        if (isDag(graph)) {
            return null;
        }
        for (String vertex : vertices) {
            if (!visited.contains(vertex)) {
                stack.push(vertex);
                ArrayList<String> edges = graph.getEdgeList(vertex);
                for(String edge : edges) {
                    // visited.add(dfsTest(edge, graph));;
                    subedges = graph.getEdgeList(edge);
                    if (subedges.size()==0) {
                        visited.add(edge);
                    }
                    for (String sedge : subedges) {

                        if (!visited.contains(sedge)) {
                            visited.add(dfs(sedge, graph));
                        }
                    }
                }
                visited.add(vertex);
            }
        }
        Collections.reverse(visited);
        return visited;
    }

    private String dfs(String vertex, Graph graph) {
        stack.push(vertex);
        subedges = graph.getEdgeList(vertex);

        if (subedges.size() ==0) {
            visited.add(stack.pop());
            while (!stack.isEmpty()) {
                if (!visited.contains(stack.peek())) {
                    subedges = graph.getEdgeList(stack.peek());
                    for(String edge : subedges) {
                        if  (!visited.contains(edge)) {
                            return dfs(edge, graph);
                        }
                    }
                    visited.add(stack.pop());
                }
            }
            return vertex;
        } else {

            for(String edge : subedges) {
                if  (!visited.contains(edge)) {
                    return dfs(edge, graph);
                }
            }
        }
        return vertex;
    }


    private boolean isDag(Graph graph){
        ArrayList<String> vertices = graph.getVertices();
        ArrayList<String> visited = new ArrayList<>();

        for(String vertex : vertices) {
            ArrayList<String> edges = graph.getEdgeList(vertex);
            visited.add(vertex);
            for (String edge : edges) {
                if (visited.contains(edge)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Source removal implementation of topological sort.
     *
     * @param graph Graph to be topologically sorted.
     * @return List of sorted vertices.
     */
    public ArrayList<String> sourceTopSort(Graph graph) {
        long startTime = System.nanoTime();
        ArrayList<String> vertices = graph.getVertices();
        ArrayList<String> sorted = new ArrayList<>();

        Iterator<String> iterator = vertices.iterator();
        while (iterator.hasNext()) {
            String vertex = iterator.next();

            if (isSource(vertex, graph, vertices)) {
                sorted.add(vertex);
                iterator.remove();
            }
        }

        time = System.nanoTime() - startTime;
        //System.out.println(System.nanoTime() - startTime);

        // If there are vertices left, the graph is not acyclic
        if (vertices.size() != 0) {
            return null;
        } else {
            return sorted;
        }

    }

    /**
     * Determines if a given vertex is a source. Which means it has
     * no edges going into it.
     *
     * @param vertex   Vertex given to be determined if it is a source.
     * @param graph    Graph containing the vertices.
     * @param vertices List of vertices left unvisited.
     * @return True if vertex is a source, false if it is not a source.
     */
    private boolean isSource(String vertex, Graph graph, ArrayList<String> vertices) {
        boolean isSource = true;
        for (String vert : vertices) {
            ArrayList<String> list = graph.getEdgeList(vert);
            if (list.contains(vertex)) {
                isSource = false;
            }
        }
        return isSource;
    }

    public long getTime() {
        return this.time;
    }
}
