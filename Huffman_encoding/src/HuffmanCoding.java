import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * @author Austin Sutton
 * @author Chris Hurt
 * @author Matt Otto
 */
public class HuffmanCoding {
    private PriorityQueue<Node> pq;
    public HashMap<String, String> char_bit;
    private InternalNode root;

    public HuffmanCoding() {
        pq = new PriorityQueue<>();
        char_bit = new HashMap<>();
    }

    /**
     * Makes a priority queue out of the given hashmap
     *
     * @param character_map Given hashmap
     */
    public void makeQueue(HashMap<String, Integer> character_map) {
        for (Entry<String, Integer> entry : character_map.entrySet()) {
            Leaf storing = new Leaf();
            storing.setCharacter(entry.getKey());
            storing.weight = entry.getValue();
            pq.add(storing);
        }
    }

    /**
     * Makes a binary tree out of Priority queue while there is more than one node in the queue:
     * 1. Remove the two nodes of highest priority from the queue
     * 2. Create a new internal node with these two nodes as children and the probability
     * equal to the sum of the two nodes' probabilities.
     * 3. Add the new node to the queue
     */
    public void makeTree() {
        Node left = null;
        Node right = null;
        while (pq.size() > 1) {
            left = pq.remove();
            right = pq.remove();
            int weight = left.getWeight() + right.getWeight();
            InternalNode internal_node = new InternalNode(weight, left, right);
            internal_node.setString(left.getCharacter(), right.getCharacter());
            pq.add(internal_node);
        }
        if (left != null) {
            root = new InternalNode((left.getWeight() + right.getWeight()), left, right);
            root.setString(left.getCharacter(), right.getCharacter());
        }

        makeHashMap();

    }

    /**
     * Makes a hashmap of characters and their bit codes.
     */
    public void makeHashMap() {
        pre_help(root);
        //System.out.println(char_bit);
    }

    /**
     * Begins a traversal of a tree.
     *
     * @param root Root node of a tree.
     */
    private void pre_help(Node root) {
        if (root != null) {
            pre_help_left(root.getLeft(), "");
            pre_help_right(root.getRight(), "");
        }

    }

    /**
     * Helper to construct a bit code on the left side of a tree.
     * Adds "0" to the bit code.
     * @param root Root node of a tree
     * @param bit_code Currently constructed bit code
     */
    private void pre_help_left(Node root, String bit_code) {
        if (root != null) {
            if (root.getLeft() == null && root.getRight() == null) {
                char_bit.put(root.getCharacter(), root.getCode());
            }
            bit_code += "0";
            root.addBit(bit_code);
            pre_help_left(root.getLeft(), bit_code);
            pre_help_right(root.getRight(), bit_code);
        }
    }

    /**
     * Helper to construct a bit code on the right side of a tree.
     * Adds "1" to the bit code.
     * @param root Root node of a tree
     * @param bit_code Currently constructed bit code
     */
    private void pre_help_right(Node root, String bit_code) {
        if (root != null) {
            if (root.getLeft() == null && root.getRight() == null) {
                char_bit.put(root.getCharacter(), root.getCode());
            }
            bit_code += "1";
            root.addBit(bit_code);
            pre_help_left(root.getLeft(), bit_code);
            pre_help_right(root.getRight(), bit_code);
        }
    }

    /**
     * Prints the priority queue in order.
     */
    public void printQueue() {
        int length = pq.size();
        for (int i = 0; i < length; i++) {
            Node node = pq.remove();
            System.out.print("Character: " + node.getCharacter());
            System.out.println(" | Count: " + node.getWeight());
        }
    }
}
