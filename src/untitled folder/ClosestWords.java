/* Labb 2 i DD1352 Algoritmer, datastrukturer och komplexitet    */
/* Se labbanvisning under kurswebben https://www.kth.se/social/course/DD1352 */
/* Ursprunglig författare: Viggo Kann KTH viggo@nada.kth.se      */
import java.util.LinkedList;
import java.util.List;

public class ClosestWords {
  LinkedList<String> closestWords = null;

  int closestDistance = 1000;

  
  private int minimum(int a, int b, int c) {
      return Math.min(Math.min(a, b), c);
  }
  
  int dynDistance(String w1, String w2){
    int[][] M = new int[w1.length() + 1][w2.length() + 1];

    for (int i = 0; i <= w1.length(); i++) 
        M[i][0] = i;
    for (int j = 1; j <= w2.length(); j++) 
        M[0][j] = j;

    for (int i = 1; i <= w1.length(); i++) {
        for (int j = 1; j <= w2.length(); j++) {
            M[i][j] = minimum(M[i-1][j] + 1,
                              M[i][j-1] + 1,
                              M[i-1][j-1] + ((w1.charAt(i-1) == w2.charAt(j-1)) ? 0 : 1));
        }
    }

    return M[w1.length()][w2.length()];
  }

  public ClosestWords(String w, List<String> wordList) {
      int wlen = w.length();
    for (String s : wordList) {
      if(s.length() < (wlen + closestDistance)) {
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
