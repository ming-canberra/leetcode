package medium;

import java.util.*;

public class Medium1405LongestHappyString {
    class Solution {
        public String longestDiverseString(int a, int b, int c) {
            PriorityQueue<Pair> heap = new PriorityQueue<>((aPair, bPair)-> bPair.count == aPair.count ? aPair.theChar - bPair.theChar : Integer.compare(bPair.count, aPair.count) );   // max heap

            if (a != 0){
                heap.add(new Pair('a', a));
            }
            if (b != 0){
                heap.add(new Pair('b', b));
            }
            if (c != 0){
                heap.add(new Pair('c', c));
            }

            StringBuilder sb = new StringBuilder();
            while( heap.size() > 1 ){
                Pair pairMost = heap.poll();
                Pair pairSecond = heap.poll();
                if (pairMost.count >= 3){
                    sb.append(pairMost.theChar);
                    sb.append(pairMost.theChar);

                    pairMost.count = pairMost.count - 2;
                    if (pairMost.count < pairSecond.count){
                        sb.append(pairSecond.theChar);
                        sb.append(pairSecond.theChar);
                        pairSecond.count = pairSecond.count - 2;
                    }
                    else{
                        sb.append(pairSecond.theChar);
                        pairSecond.count = pairSecond.count - 1;
                    }

                    heap.add(pairMost);
                    if (pairSecond.count != 0){
                        heap.add(pairSecond);
                    }

                }
                else{
                    for (int i = 0; i < pairMost.count && i < 2; i++){
                        sb.append(pairMost.theChar);
                    }
                    for (int i = 0; i < pairSecond.count && i < 2; i++){
                        sb.append(pairSecond.theChar);
                    }
                }
            }
            if (!heap.isEmpty()){
                Pair top = heap.poll();
                for (int i = 0; i < top.count && i < 2; i++){
                    sb.append(top.theChar);
                }
            }

            return sb.toString();
        }


        class Pair{
            char theChar;
            int count;

            Pair(char inputchar, int inputCount){
                theChar = inputchar;
                count = inputCount;
            }
        }
    }
}