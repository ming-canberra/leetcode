package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder950 {
    public static void main(String[] args) {
        RevealCardsInIncreasingOrder950 thisClass = new RevealCardsInIncreasingOrder950();
        System.out.println(" " + thisClass.deckRevealedIncreasing(new int[]{17,13,11,2,3,5,7}));
    }
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> q = new LinkedList<Integer>();
        Arrays.sort(deck);
        for (int i = deck.length - 1; i>=0; i -- ){
            if (!q.isEmpty()){
                Integer tmp = q.poll();
                q.add(tmp);
            }
            q.add(deck[i]);
        }

        int[] ans = new int[deck.length];

        for (int i = ans.length -1; i>=0;i--){
            ans[i] = q.poll();
        }

        return ans;
    }
}