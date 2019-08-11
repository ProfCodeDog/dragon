package com.dragon.common.algorithm.chess.horse;

import java.util.LinkedList;

public class Horse {


    public static void main(String[] args) {
        int[] A = {6, 0, 8, 2, 1, 5};
        System.out.println(maxWidthRamp(A));
        int[]   B = {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
        System.out.println(maxWidthRamp(B));
        int[]   C = {4,3,2,1};
        System.out.println(maxWidthRamp(C));
    }

    public static int maxWidthRamp(int[] A) {
        int len = A.length - 1;
        for (int i = len; i > 0; i--) {
            int count = A.length - i;
            for (int j = 0; j < count; j++) {
                if (A[j] <= A[j + i]) {
                    return i;
                }
            }
        }
        return 0;
    }

    public static void horse() {
        int beginI = 6;
        int beginJ = 2;
        long start = System.currentTimeMillis();
        next(beginI, beginJ);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(selectShots.size());
        StringBuilder sb = new StringBuilder();
        for (int[] s : selectShots) {
            sb.append("[").append(s[0]).append(",").append(s[1]).append("]").append(" ");
        }
        System.out.println(sb.toString());
        check();
    }

    static void check() {
        boolean[][] spotsTemp = new boolean[SIZE][SIZE];
        for (int[] s : selectShots) {
            if (spotsTemp[s[0]][s[1]]) {
                throw new RuntimeException("shot 重复,i: " + s[0] + "   j:" + s[1]);
            }
            spotsTemp[s[0]][s[1]] = true;
        }
    }

    public static boolean next(int i, int j) {
        if (i < 0 || i >= SIZE || j < 0 || j >= SIZE || spots[i][j]) {
            return false;
        }

        int[] s = {i, j};
        selectShots.add(s);
        spots[i][j] = true;

        if (selectShots.size() == COUNT) {
            return true;
        }

        for (int m = -2; m <= 2; m++) {
            if (m == 0) {
                continue;
            }
            for (int n = -2; n <= 2; n++) {
                if (n == 0) {
                    continue;
                }
                if ((Math.abs(m) + Math.abs(n)) == 3) {
                    int iNext = i + m;
                    if (iNext > -1 && iNext < SIZE) {
                        int jNext = j + n;
                        if (jNext > -1 && jNext < SIZE) {
                            if (!spots[iNext][jNext]) {
                                if (next(iNext, jNext)) {
                                    return true;
                                }
                            }
                        }
                    }
                }

            }
        }

        if (selectShots.size() == COUNT) {
            return true;
        }
        int[] ss = selectShots.removeLast();
        spots[ss[0]][ss[1]] = false;
        return false;
    }

    private static final int SIZE = 8;
    private static final int COUNT = SIZE * SIZE;
    private static boolean[][] spots = new boolean[SIZE][SIZE];
    private static LinkedList<int[]> selectShots = new LinkedList<>();
}
