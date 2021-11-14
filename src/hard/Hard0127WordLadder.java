package hard;

import java.util.*;

public class Hard0127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = wordList.size();
        boolean[][] connected = new boolean[len][len];
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                connected[i][j] = connected(wordList.get(i), wordList.get(j));
                connected[j][i] = connected[i][j];
            }
        }

        if (beginWord.equals(endWord) || !wordList.contains(endWord)){
            return 0;
        }

        int steps = 1;
        int targetIndex = wordList.indexOf(endWord);

        Queue<Integer> queue = new LinkedList<>();

        if (wordList.contains(beginWord)){
            int startIndex = wordList.indexOf(beginWord);
            queue.add(startIndex);
        }
        else{
            for (int i = 0; i < len; i++){
                if (connected(beginWord, wordList.get(i))){
                    queue.add(i);
                }
            }
            steps++;
        }
        Set<Integer> visited = new HashSet<>();
        while(!queue.isEmpty()){

            for (int size = queue.size(); size > 0; size--){

                int top = queue.poll();

                if (!visited.contains(top)){
                    visited.add(top);
                }
                else{
                    continue;
                }

                if (endWord.equals(wordList.get(top))){
                    return steps;
                }
                for (int i = 0; i < len; i++){

                    if (connected[top][i]){
                        queue.add(i);
                    }

                }

            }

            steps++;
        }

        return 0;
    }
    // assuming a and b are different
    private boolean connected(String a, String b){
        int index = 0;
        while(a.charAt(index) == b.charAt(index)){
            index++;
        }
        index++;// jump over the dif
        while(index < a.length() && a.charAt(index) == b.charAt(index) ){
            index++;
        }
        return index == a.length();
    }
}