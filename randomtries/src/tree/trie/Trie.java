package tree.trie;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 *
 * Runtime: 28 ms
 * Memory Usage: 50 MB
 */
class Trie {
    private static final int N = 26;
    private final Trie[] mChildren = new Trie[N];
    private boolean mIsEnd = false;

    /** Initialize your data structure here. */
    public Trie() {
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie cur = this;
        for (char c: word.toCharArray()) {
            int index = c - 'a';
            if (cur.mChildren[index] == null) {
                cur.mChildren[index] = new Trie();
            }
            cur = cur.mChildren[index];
        }
        cur.mIsEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie cur = this;
        for (char c: word.toCharArray()) {
            cur = cur.mChildren[c - 'a'];
            if (cur == null) {
                return false;
            }
        }
        return cur.mIsEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie cur = this;
        for (char c: prefix.toCharArray()) {
            cur = cur.mChildren[c - 'a'];
            if (cur == null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var trie = new Trie();
        trie.insert("apple");
        System.out.println("Search app. Expected false. Actual " + trie.search("app"));
        System.out.println("StartsWith app. Expected true. Actual " + trie.startsWith("app"));
        System.out.println("StartsWith b. Expected false. Actual " + trie.startsWith("b"));
    }
}
