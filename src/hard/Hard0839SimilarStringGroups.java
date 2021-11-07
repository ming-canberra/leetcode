package hard;

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
}