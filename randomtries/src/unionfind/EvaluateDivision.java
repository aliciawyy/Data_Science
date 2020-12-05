package unionfind;

import java.util.*;

/**
 * LeetCode 399. Evaluate Division
 * 0.0 < values[i] <= 20.0
 *
 * Runtime: 1 ms, faster than 86.93% of Java online submissions for Evaluate Division.
 * Memory Usage: 37.8 MB, less than 6.23% of Java online submissions for Evaluate Division.
 */
public class EvaluateDivision {
    private final HashMap<String, Integer> mIndexMap = new HashMap<>();
    private int[] mParent;
    private int[] mSize;
    private double[][] mValue;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashSet<String> allCodes = new HashSet<>();
        for (List<String> equation: equations) {
            allCodes.addAll(equation);
        }
        init(allCodes);
        for (int i = 0; i < values.length; ++i) {
            List<String> equation = equations.get(i);
            union(mIndexMap.get(equation.get(0)), mIndexMap.get(equation.get(1)), values[i]);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); ++i) {
            List<String> equation = queries.get(i);
            String a = equation.get(0), b = equation.get(1);
            if (!mIndexMap.containsKey(a) || !mIndexMap.containsKey(b)) {
                result[i] = -1;
            } else {
                result[i] = query(mIndexMap.get(a), mIndexMap.get(b));
            }
        }
        return result;
    }

    private void init(Set<String> allCodes) {
        mIndexMap.clear();
        int n = 0;
        for (String code: allCodes) {
            mIndexMap.put(code, n++);
        }
        mParent = new int[n];
        mValue = new double[n][n];
        for (int i = 0; i < n; ++i) {
            mParent[i] = i;
            Arrays.fill(mValue[i], 0.);
            mValue[i][i] = 1.0;
        }
        mSize = new int[n];
        Arrays.fill(mSize, 1);
    }

    private void union(int p, int q, double value) {
        int rootP = root(p);
        int rootQ = root(q);
        if (mSize[rootP] > mSize[rootQ]) {
            mParent[rootQ] = rootP;
            mValue[rootP][rootQ] = mValue[rootP][p] * value * mValue[q][rootQ];
            mValue[rootQ][rootP] = 1. / mValue[rootP][rootQ];
            // Attach the smaller tree to big tree
            mSize[rootP] += mSize[rootQ];
        } else {
            mParent[rootP] = rootQ;
            mValue[rootQ][rootP] = mValue[rootQ][q] / value * mValue[p][rootP];
            mValue[rootP][rootQ] = 1. / mValue[rootQ][rootP];
            mSize[rootQ] += mSize[rootP];
        }
    }

    private double query(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        if (rootP != rootQ) {
            return -1.0;
        } else {
            return mValue[rootP][q] / mValue[rootP][p];
        }
    }

    private int root(int p) {
        int q = p;
        double factor = 1.;
        while (q != mParent[q]) {
            factor *= mValue[q][mParent[q]];
            q = mParent[q];
        }
        mValue[p][q] = factor;
        mValue[q][p] = 1. / factor;
        mParent[p] = q;
        return q;
    }

    public static void main(String[] args) {
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"));
        double[] values = {2., 3.};
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "a"));
        EvaluateDivision evaluateDivision = new EvaluateDivision();
        double[] result = evaluateDivision.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(result));
    }
}
