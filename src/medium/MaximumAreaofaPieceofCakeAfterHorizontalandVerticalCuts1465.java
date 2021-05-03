package medium;

import java.util.*;

public class MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCuts1465 {
    private Object HashSet;

    public static void main(String[] args) {
        MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCuts1465 thisClass = new MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCuts1465();
    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int aLast = h - horizontalCuts[horizontalCuts.length - 1];
        int bLast = w - verticalCuts[verticalCuts.length - 1];

        int maxA = horizontalCuts[0];
        for (int i = 1; i < horizontalCuts.length; i++){
            maxA = Math.max(maxA, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        maxA = Math.max(maxA, aLast);

        int maxB = verticalCuts[0];
        for (int i = 1; i < verticalCuts.length; i++){
            maxB = Math.max(maxB, verticalCuts[i] - verticalCuts[i - 1]);
        }
        maxB = Math.max(maxB, bLast);

        long result = (long)maxA * (long)maxB;
        return (int)(result % (long)(1000000000 + 7));
    }
}