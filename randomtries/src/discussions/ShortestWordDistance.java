package discussions;

/**
 * Runtime: 1 ms
 * Memory Usage: 39.1 MB
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int lastSeen1 = -1, lastSeen2 = -1, minDist = words.length;
        for (int i = 0; i < words.length; ++i) {
            if (word1.equals(words[i])) {
                lastSeen1 = i;
            } else if (word2.equals(words[i]))   {
                lastSeen2 = i;
            } else {
                continue;
            }
            if (lastSeen1 != -1 && lastSeen2 != -1) {
                minDist = Math.min(minDist, Math.abs(lastSeen1 - lastSeen2));
            }
        }
        return minDist;
    }
}
