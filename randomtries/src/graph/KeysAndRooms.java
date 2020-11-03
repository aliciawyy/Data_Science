package graph;

import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.List;

/**
 * 841. Keys and Rooms
 */
public class KeysAndRooms {

    /**
     * Runtime: 2 ms, faster than 46.65% of Java online submissions for Keys and Rooms.
     * Memory Usage: 39 MB, less than 11.15% of Java online submissions for Keys and Rooms.
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        final int n = rooms.size();
        if (n == 0) {
            return true;
        }
        var isRoomOpen = new BitSet(n);
        ArrayDeque<Integer> keys = new ArrayDeque<>(n);
        keys.add(0);
        while (!keys.isEmpty()) {
            var key = keys.poll();
            isRoomOpen.set(key);
            for (var newKey: rooms.get(key)) {
                if (!isRoomOpen.get(newKey)) {
                    keys.add(newKey);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (!isRoomOpen.get(i)) {
                return false;
            }
        }
        return true;
    }
}
