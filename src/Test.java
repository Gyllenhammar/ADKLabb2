package src;

/**
 * Created by antongyllenhammar on 14-09-29.
 */
public class Test {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addWord("Anton");
        trie.addWord("Atnon");
        trie.addWord("Antton");
        trie.addWord("Adtonn");
        trie.addWord("Antdon");
        trie.addWord("Annton");

        System.out.println(trie.getWords("an"));

    }
}
