package hard;

import java.util.Arrays;

public class Hard0839SimilarStringGroups {

    class Solution {
        public int numSimilarGroups(String[] strs) {
            int len = strs.length;
            boolean[][] isSimilar = new boolean[len][len];
            for (int i = 0; i < len; i++){
                for (int j = i + 1; j < len; j++){
                    isSimilar[i][j] = similarStrings(strs[i], strs[j]);
                    isSimilar[j][i] = isSimilar[i][j];
                }
            }
            int groupCount = 0;
            boolean[] seen = new boolean[len];
            for (int i = 0; i < len; i++){
                if (!seen[i]){
                    groupCount++;
                    dfs(isSimilar, i, seen);
                }
            }
            return groupCount;
        }
        private void dfs(boolean[][] isSimilar, int index, boolean[] seen){
            if (seen[index]){
                return;
            }
            seen[index] = true;
            for (int i = 0; i < seen.length; i++){
                if (isSimilar[index][i] && i != index){
                    dfs(isSimilar, i, seen);
                }
            }
        }
        private boolean similarStrings(String a, String b){
            int diffCount = 0;
            for (int i = 0; i < a.length(); i++){
                if (a.charAt(i) != b.charAt(i)){
                    diffCount++;
                }
                if (diffCount > 2){
                    return false;
                }
            }
            return diffCount == 2 || diffCount == 0;
        }
    }

    class Solution1 {
        public int numSimilarGroups(String[] strs) {
            int len = strs.length;

            int[] idxParents = new int[len];
            Arrays.fill(idxParents, -1);

            for (int i = 0; i < len - 1; i++){
                for (int j = i + 1; j < len; j++){
                    String iString = strs[i];
                    String jString = strs[j];

                    if (areSimilar(iString, jString)){
                        int iParent = findParent(idxParents, i);
                        int jParent = findParent(idxParents, j);

                        if (iParent != jParent){
                            idxParents[jParent] = iParent;
                        }
                    }
                }
            }

            int result = 0;
            for (int value : idxParents){
                if (value == -1){
                    result++;
                }
            }
            return result;
        }

        private int findParent(int[] parents, int idx){
            while(parents[idx] != -1){
                if (parents[parents[idx]] != -1){
                    parents[idx] = parents[parents[idx]];
                }
                idx = parents[idx];
            }

            return idx;
        }

        private boolean areSimilar(String a, String b){
            if (a.equals(b)){
                return true;
            }

            // chars in 2 positions are different
            int diffCounter = 0;
            for (int i = 0; i < a.length(); i++){
                if (a.charAt(i) != b.charAt(i)){
                    diffCounter++;
                }
                if (diffCounter > 2){
                    return false;
                }
            }

            return diffCounter == 2;
        }
    }
}