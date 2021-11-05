package medium;

import java.util.*;

public class Medium1366RankTeamsbyVotes {
    class Solution {
        public String rankTeams(String[] votes) {
            if (votes.length == 1){
                return votes[0];
            }
            int len = votes[0].length();
            int[][] ranking = new int[len][26];  // 0th row to represnet
            for (int i = 0; i < votes.length; i++){
                String curString = votes[i];
                for (int j = 0; j < len; j++){
                    ranking[j][ curString.charAt(j) - 'A' ]++;
                }
            }
            List<Pair> collection = new ArrayList<>();
            for (char curChar : votes[0].toCharArray()){
                List<Integer> count = new ArrayList<>();

                for (int i = 0; i < len; i++){
                    count.add(ranking[i][curChar - 'A']);

                }
                Pair pa = new Pair(curChar, count);
                collection.add(pa);
            }
            Collections.sort(collection, new MyComp());
            StringBuilder sb = new StringBuilder();
            for ( Pair pair : collection){
                sb.append(pair.cha);
            }
            return sb.toString();
        }
        class MyComp implements Comparator<Pair>{
            @Override
            public int compare(Pair a, Pair b){
                Character aChar = a.cha;
                Character bChar = b.cha;
                int len = a.countList.size();
                for (int i = 0; i < len; i++){
                    if (a.countList.get(i) != b.countList.get(i)){
                        return b.countList.get(i) - a.countList.get(i);
                    }
                    else{
                        continue;
                    }
                }
                return aChar - bChar;
            }
        }
        class Pair{
            Character cha = null;
            List<Integer> countList = null;
            public Pair(Character c, List<Integer> list){
                cha = c;
                countList = list;
            }
        }
    }
}