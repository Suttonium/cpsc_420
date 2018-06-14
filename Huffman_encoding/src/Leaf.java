/**
 * @author Austin Sutton
 * @author Chris Hurt
 * * @author Matt Otto
 * <p>
 * Leaf has 2 instance variables, the symbol being encoded, and its "bit" encoding, represented here as a String.
 * In the Wikipedia Example, one Leaf would have A as its symbol, and "10" as its code
 */
public class Leaf extends Node {

    private String character;
    private String code = "";

    Leaf() {

    }

    /**
     * Calls Node subclass to add a bit to the sequence as the Huffman Tree is being built
     *
     * @param s the code being added to
     */
    public void addBit(String s) {
        this.code += s;
    }

    void setCharacter(String s) {
        this.character = s;
    }

    public String getCharacter() {
        return this.character;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public Node getLeft() {
        return null;
    }

    @Override
    public Node getRight() {
        return null;
    }

}
