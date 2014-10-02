package TEST;
/* Labb 2 i DD1352 Algoritmer, datastrukturer och komplexitet    */
/* Se labbanvisning under kurswebben https://www.kth.se/social/course/DD1352 */
/* Ursprunglig författare: Viggo Kann KTH viggo@nada.kth.se      */
import java.util.LinkedList;
import java.util.List;

class ClosestWords {
    LinkedList<String> closestWords = null;

    int closestDistance = 1000;

    static int[][] M;
    String lastWord;

    private int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    /**
     *
     * @param w1    Felaktigt ord
     * @param w2    Ordlistans ord
     * @return      Distans mellan ord
     */
    int dynDistance(String w1, String w2){
        int numberSameChars = compareWords(lastWord,w2);


        for (int i = 1; i <= w1.length(); i++) {
            for (int j = numberSameChars; j <= w2.length(); j++) {
                M[i][j] = minimum(M[i-1][j] + 1,
                        M[i][j-1] + 1,
                        M[i-1][j-1] + ((w1.charAt(i-1) == w2.charAt(j-1)) ? 0 : 1));
            }
        }

        lastWord = w2;
        return M[w1.length()][w2.length()];
    }


    int compareWords(String w1, String w2){
        if (w1 == null || w2 == null){
            return 1;
        }

        int counter = 1;
        int minwordocount = Math.min(w1.length(),w2.length());

            for (int i = 0; i < minwordocount; i++) {
                if (w1.charAt(i) == w2.charAt(i)) {
                    counter++;
                }else break;
            }
        return counter;
    }

    public ClosestWords(String w, List<String> wordList) {

        M = new int[50][50];
        for (int i = 0; i < 50; i++)
            M[i][0] = i;
        for (int j = 1; j < 50; j++)
            M[0][j] = j;

        lastWord = null;
        int wlen = w.length();

        for (String s : wordList) {
            if(s.length() <= (wlen + closestDistance)) {
                int dist = dynDistance(w, s);

                if (dist < closestDistance || closestDistance == 1000) {
                    closestDistance = dist;
                    closestWords = new LinkedList<String>();
                    closestWords.add(s);
                }
                else if (dist == closestDistance)
                    closestWords.add(s);
            }
        }
    }

    int getMinDistance() {
        return closestDistance;
    }

    List<String> getClosestWords() {
        return closestWords;
    }
}
