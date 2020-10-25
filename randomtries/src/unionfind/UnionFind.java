package unionfind;

import java.util.Scanner;

public class UnionFind {

    public static void main(String[] args) {
        try (var fin = new Scanner(System.in)) {
            var n = fin.nextInt();
            UF uf = new SimpleUF(n);
            while (fin.hasNext()) {
                int p = fin.nextInt();
                int q = fin.nextInt();
                if (!uf.connected(p, q)) {
                    uf.union(p, q);
                    System.out.println(p + " " + q);
                }
            }
            System.out.println(uf);
        }
    }
}
