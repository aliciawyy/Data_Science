package tree.trie;

/**
 * 677. Map Sum Pairs
 *
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 *
 * Runtime: 11 ms, faster than 94.74% of Java online submissions for Map Sum Pairs.
 * Memory Usage: 39.1 MB, less than 25.47% of Java online submissions for Map Sum Pairs.
 */
class MapSum {

    private static final int N = 26;
    private final MapSum[] mChildren = new MapSum[N];
    private int mSum = 0;
    private Integer mValue = null;

    /** Initialize your data structure here. */
    public MapSum() {

    }

    public void insert(String key, int val) {
        var cur = insertInternal(key, val);
        if (cur.mValue != null) {
            insertInternal(key, - cur.mValue);
        }
        cur.mValue = val;
    }

    private MapSum insertInternal(String key, int val) {
        var cur = this;
        mSum += val;
        for (char c : key.toCharArray()) {
            int index = c - 'a';
            if (cur.mChildren[index] == null) {
                cur.mChildren[index] = new MapSum();
            }
            cur = cur.mChildren[index];
            cur.mSum += val;
        }
        return cur;
    }

    public int sum(String prefix) {
        var cur = this;
        for (char c : prefix.toCharArray()) {
            cur = cur.mChildren[c - 'a'];
            if (cur == null) {
                return 0;
            }
        }
        return cur.mSum;
    }

    public static void main(String[] args) {
        var mapSum = new MapSum();
        mapSum.insert("apple", 3);
        mapSum.insert("apple", 2);
        mapSum.insert("app", 2);
        System.out.println("Expected 4, actual " + mapSum.sum("ap"));
        System.out.println("Expected 4, actual " + mapSum.sum("app"));
    }
}
