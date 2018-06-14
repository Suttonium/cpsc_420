import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Austin Sutton
 * @author Chris Hurt
 * * @author Matt Otto
 * <p>
 */
public class Huffman {

    private static double totalChars = 0;
    private static int diffChars = 0;
    private static int maxCodeLength = 0;
    private static double avgCodeLength = 0;
    private static double fileLength = 0;
    private static int byteFileLength = 0;
    private static double totalReduction = 0;
    private static HashMap<String, Integer> character_map = new HashMap<>();


    public static void main(String[] args) {
        huffmanEncode("wiki.txt");
        HuffmanCoding hf1 = new HuffmanCoding();
        hf1.makeQueue(character_map);
        hf1.makeTree();
        hf1.makeHashMap();
        translate("wiki.txt", hf1);
        printResults(character_map, hf1.char_bit, "wiki");
        clearVariables();

        huffmanEncode("website.txt");
        HuffmanCoding hf2 = new HuffmanCoding();
        hf2.makeQueue(character_map);
        hf2.makeTree();
        hf2.makeHashMap();
        translate("website.txt", hf2);
        printResults(character_map, hf2.char_bit, "website");
        clearVariables();

        huffmanEncode("alice2.txt");
        HuffmanCoding hf3 = new HuffmanCoding();
        hf3.makeQueue(character_map);
        hf3.makeTree();
        hf3.makeHashMap();
        translate("alice2.txt", hf3);
        printResults(character_map, hf3.char_bit, "book");
        clearVariables();

        huffmanEncode("huffman.txt");
        HuffmanCoding hf4 = new HuffmanCoding();
        hf4.makeQueue(character_map);
        hf4.makeTree();
        hf4.makeHashMap();
        translate("huffman.txt", hf4);
        printResults(character_map, hf4.char_bit, "huffman");
        clearVariables();
    }

    /**
     * Resets field variables.
     */
    private static void clearVariables() {
        totalChars = 0;
        diffChars = 0;
        maxCodeLength = 0;
        fileLength = 0;
        avgCodeLength = 0;
        byteFileLength = 0;
        totalReduction = 0;
        character_map.clear();
    }

    /**
     * inspired from https://stackoverflow.com/questions/811851/how-do-i-read-input-character-by-character-in-java
     *
     * @param filename file to be read
     */
    private static void huffmanEncode(String filename) {
        try {
            BufferedReader buffered_reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename),
                    "UTF-8"));
            int end_of_file_question_mark;
            while ((end_of_file_question_mark = buffered_reader.read()) != -1) {
                Character current_char = (char) end_of_file_question_mark;
                String current_value = current_char.toString();
                if (!character_map.containsKey(current_value)) {
                    character_map.put(current_value, 1);
                } else {
                    Integer current_frequency = character_map.get(current_value);
                    current_frequency++;
                    character_map.put(current_value, current_frequency);
                }
                totalChars++;
            }
            buffered_reader.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    /**
     * Reads the file and prints the encoded version to a new file.
     * @param filename File to be encoded
     * @param hf HuffmanCoding object which provides access to the character bit codes
     */
    private static void translate(String filename, HuffmanCoding hf) {
        File outputFile = new File(filename + "_encoded.txt");
        try {
            PrintWriter pw = new PrintWriter(outputFile);
            BufferedReader buffered_reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename),
                    "UTF-8"));
            int end_of_file_question_mark;
            while ((end_of_file_question_mark = buffered_reader.read()) != -1) {
                Character current_char = (char) end_of_file_question_mark;
                String current_value = current_char.toString();
                pw.print(hf.char_bit.get(current_value));
            }
            buffered_reader.close();
            pw.close();
        } catch (Exception err) {
            System.out.println(err.toString());
        }
    }

    /**
     * Prints the report of the encoding process.
     */
    private static void printResults(HashMap<String, Integer> freq_map, HashMap<String, String> bit_map, String filename) {
        System.out.println("///////////////////////////////////////////////////////////");
        System.out.println("Summary:");
        System.out.println("Name TotalChars DiffChars MaxCodeLength AveCodeLength FileLen ByteFileLen HuffmanReduction");

        diffChars = character_map.size();

        maxCodeLength = findMaxCodeLen(bit_map);

        fileLength = calculateFileLength(freq_map, bit_map);

        avgCodeLength = fileLength / totalChars;
        avgCodeLength = Math.round(avgCodeLength * 100.0) / 100.0;

        byteFileLength = (int) totalChars * 8;

        totalReduction = (fileLength / byteFileLength) * 100;
        totalReduction = Math.round(totalReduction * 100.0) / 100.0;

        System.out.print(String.format("%-8s %6d %9d %13d", filename, (int)totalChars, diffChars, maxCodeLength));
        System.out.print(String.format("%14.2f %7d %11d %15.2f", avgCodeLength, (int)fileLength, byteFileLength, totalReduction));
        System.out.println("%");

        System.out.println();
        System.out.println("Long Report:");
        System.out.println("Char Freq Code");
        for (Map.Entry<String, Integer> entry : character_map.entrySet()) {
            System.out.println(String.format("%-4s %-4d %-4s", entry.getKey()+":", entry.getValue(), bit_map.get(entry.getKey())));
        }
        System.out.println("///////////////////////////////////////////////////////////\n");
    }

    /**
     * Finds the max code length of all of the characters.
     * @param map Hashmap of all characters and bit codes
     * @return Integer of the max length bit code
     */
    private static int findMaxCodeLen(HashMap<String, String> map) {
        int max_length = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().length() > max_length) {
                max_length = entry.getValue().length();
            }
        }
        return max_length;
    }

    /**
     * Calculates the file length by multiplying each character's occurence by
     * its respective bit code length.
     * @param freq_map Hashmap of characters and their occurrence
     * @param bit_map Hashmap of characters and their bit codes
     * @return Double of the file length
     */
    private static double calculateFileLength(HashMap<String, Integer> freq_map, HashMap<String, String> bit_map) {
        for (Map.Entry<String, Integer> entry : freq_map.entrySet()) {
            Integer current_freq = entry.getValue();
            Integer current_bit_length = bit_map.get(entry.getKey()).length();
            fileLength += current_freq * current_bit_length;
        }
        return fileLength;
    }
}
