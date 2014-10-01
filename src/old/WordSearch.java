import java.util.ArrayList;
class WordSearch {

    private int[][] m;
    private int pointer;
    private String word;
    private int minimumCost; // Innehåller den nuvarande minimala edit distance mellan två ord
    private ArrayList<String> minimalWords; // Innehåller en lista på de ord som har den minimala edit distance

    public WordSearch(String s) {
        pointer = 0;
        word = s;
        minimumCost = 100;
        minimalWords = new ArrayList<String>();
        m = new int[50][50];
    }

    public void run() {
        search();
    }

    private void search() {
        int[] newRow = new int[word.length()];
        
        for (int i = 0; i <= word.length(); i++) {
            newRow[i] = i;
        }


        deepSearch();

    }


    private void deepSearch() {
    }
}
