/**
 * @author Austin Sutton
 * @author Chris Hurt
 * * @author Matt Otto
 * <p>
 * Abstract Class with 2 subclasses: Leaf and InternalNode
 */
public abstract class Node implements Comparable<Node> {
    int weight;

    Node() {

    }

    /**
     * Creates a new Node with a weight of value
     *
     * @param value weight of the new node
     */
    public Node(int value) {
        this.weight = value;
    }

    /**
     * Calls Node subclass to add a bit to the sequence as the Huffman Tree is being built
     *
     * @param s the code being added to
     */
    public abstract void addBit(String s);

    /**
     * Returns the difference between the weight of this Node and the weight of the node in the parameter
     *
     * @param other the other node being compared
     * @return Returns the difference between the weight of this Node and the weight of the node in the parameter
     */
    public int compareTo(Node other) {
        return this.weight - other.weight;
    }

    Integer getWeight() {
        return this.weight;
    }

    public abstract String getCharacter();
    public abstract String getCode();
    public abstract Node getLeft();
    public abstract Node getRight();
}
