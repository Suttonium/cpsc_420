/**
 * @author Austin Sutton
 * @author Chris Hurt
 * * @author Matt Otto
 */
public class InternalNode extends Node {

    private Node left;
    private Node right;
    private String chars;

    /**
     * Makes a new internal node with a weight of value
     *
     * @param value the weight of the new Node
     * @param left  the Left subtree
     * @param right the Right subtree
     */
    InternalNode(int value, Node left, Node right) {
        this.weight = value;
        this.left = left;
        this.right = right;
    }

    /**
     * adds value to the code for both the right and left subtree
     *
     * @param s the code being added to
     */
    public void addBit(String s) {

    }

    @Override
    public String getCharacter() {
        return chars;
    }

    @Override
    public String getCode() {
        return null;
    }

    void setString(String left, String right) {
        this.chars = left + right;
    }

    @Override
    public Node getLeft() {
        return left;
    }

    @Override
    public Node getRight() {
        return right;
    }
}
