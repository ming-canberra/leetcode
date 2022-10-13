package medium;

public class Medium0165CompareVersionNumbers {
    class Solution {
        public int compareVersion(String version1, String version2) {
            String[] revisions1 = version1.split("\\.");
            String[] revisions2 = version2.split("\\.");

            for (int i = 0; i < revisions1.length || i < revisions2.length; i++) {
                int rvs1 = 0;
                int rvs2 = 0;

                if (i < revisions1.length) {
                    rvs1 = Integer.valueOf(revisions1[i]);
                }

                if (i < revisions2.length) {
                    rvs2 = Integer.valueOf(revisions2[i]);
                }
                if (Integer.compare(rvs1, rvs2) != 0 ) {
                    return Integer.compare(rvs1, rvs2);
                }
            }
            return 0;
        }
    }
}