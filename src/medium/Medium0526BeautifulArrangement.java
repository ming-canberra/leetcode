package medium;

public class Medium0526BeautifulArrangement {
    class Solution {
        int counter = 0;
        public int countArrangement(int n) {
            boolean[] used = new boolean[n + 1];
            backtrack(n, 0, used);
            return counter;
        }
        private void backtrack(int n, int current, boolean[] used){
            if ( current == n){
                counter++;
                return;
            }
            for (int i = 1; i < used.length; i++){
                if (!used[i]){
                    if( (current + 1) % i == 0 || i % (current + 1) == 0 ) {
                        used[i] = true;
                        backtrack(n, current + 1, used);
                        used[i] = false;
                    }
                }
            }
        }
    }
}