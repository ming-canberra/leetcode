package medium;

public class NumberOfProvinces547 {
    public static void main(String[] args) {
        NumberOfProvinces547 thisClass = new NumberOfProvinces547();

    }

    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        boolean[] visited = new boolean[length];
        int count = 0;
        for (int i = 0; i < length; i++){
            if (!visited[i]){
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] graph, boolean[] visited, int i){

        visited[i] = true;

        for (int j = 0; j < visited.length; j++){
            if (graph[i][j] == 1)
            {
                if (!visited[j])
                {
                    dfs(graph, visited, j);
                }
            }
        }
    }
}