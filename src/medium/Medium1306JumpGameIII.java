package medium;

public class Medium1306JumpGameIII {
    class Solution {
        Boolean result = null;
        public boolean canReach(int[] arr, int start) {
            dfs(arr, new boolean[arr.length], start);
            if (result != null){
                return result;
            }
            return false;
        }
        private void dfs(int[] arr, boolean[] visited, int index){
            if (result != null){
                return;
            }
            if (index < 0 || index > arr.length - 1){
                return;
            }
            if (visited[index]){
                return;
            }
            if (arr[index] == 0){
                result = true;
                return;
            }
            visited[index] = true;
            dfs(arr, visited, index + arr[index]);
            dfs(arr, visited, index - arr[index]);
        }
    }
}