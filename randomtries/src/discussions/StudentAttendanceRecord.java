package discussions;


public class StudentAttendanceRecord {
    private static final char ABSENT = 'A';
    private static final char LATE = 'L';

    /**
     * 551. Student Attendance Record I
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Student Attendance Record I.
     * Memory Usage: 37.4 MB, less than 18.02% of Java online submissions for Student Attendance Record I.
     */
    public boolean checkRecordI(String s) {
        int numAbsent = 0, numLate = 0;
        for (char state: s.toCharArray()) {
            if (state == ABSENT) {
                if (numAbsent == 1) {
                    return false;
                }
                ++numAbsent;
                numLate = 0;
            } else if (state == LATE) {
                if (numLate == 2) {
                    return false;
                }
                ++numLate;
            } else {
                numLate = 0;
            }
        }
        return true;
    }

    private static final int MAX = 1_000_000_007;

    /**
     * 552. Student Attendance Record II
     * Runtime: 88 ms, faster than 47.74% of Java online submissions for Student Attendance Record II.
     * Memory Usage: 38.6 MB, less than 65.23% of Java online submissions for Student Attendance Record II.
     */
    public int checkRecordII(int n) {
        /**
         * Type:
         * 0/ No absence and does not ends with L
         * 1/ One absence and does not ends with L
         * 2/ No absence and ends with L
         * 3/ One absence and ends with L
         * 4/ No absence and ends with LL
         * 5/ One absence and ends with LL
         */
        int[] numPerType = new int[6];
        numPerType[0] = 1;

        for (int i = 0; i < n; ++i) {
            int temp0 = numPerType[0], temp1 = numPerType[1];
            numPerType[0] = add(temp0 /*+'P'*/ + numPerType[2] /*+'P'*/, numPerType[4] /*+'P'*/);
            numPerType[1] =
                    add(temp0 /*+'A'*/, temp1 /*+'P'*/, numPerType[2] /*+'A'*/, numPerType[3] /*+'P'*/, numPerType[4] /*+'A'*/, numPerType[5] /*+'P'*/);
            numPerType[4] = numPerType[2] /*+'L'*/;
            numPerType[5] = numPerType[3] /*+'L'*/;
            numPerType[2] = temp0 /*+'L'*/;
            numPerType[3] = temp1 /*+'L'*/;
        }
        return add(numPerType);
    }

    private int add(int... arr) {
        int res = 0;
        for (int num: arr) {
            res = (res + num) % MAX;
        }
        return res;
    }
}
