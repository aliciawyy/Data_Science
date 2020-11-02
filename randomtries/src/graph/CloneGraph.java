package graph;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Leet Code. 133. Clone Graph
 */
public class CloneGraph {
    private HashMap<Node, Node> mCache = new HashMap<>();

    /**
     * Runtime: 25 ms, faster than 92.00% of Java online submissions for Clone Graph.
     * Memory Usage: 39.4 MB, less than 32.53% of Java online submissions for Clone Graph.
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (mCache.containsKey(node)) {
            return mCache.get(node);
        }
        Node newNode = new Node(node.val, new ArrayList<>());
        mCache.put(node, newNode);
        for (Node neighbor: node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;
    }
}
