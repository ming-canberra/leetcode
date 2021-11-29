package medium;

public class Medium0984StringWithoutAAAorBBB {
    class Solution {
        public String strWithout3a3b(int a, int b) {
            Pair aPair = new Pair('a', a);
            Pair bPair = new Pair('b', b);
            return buildString(aPair, bPair);
        }
        private String buildString(Pair pair1, Pair pair2){
            if (pair1.number < pair2.number){
                return buildString(pair2, pair1);
            }
            // make sure pair1's number is always greater or equal to pair2's number
            StringBuilder sb = new StringBuilder();
            while(pair1.number > 0){
                if (pair1.number >= 2){
                    sb.append(pair1.curChar);
                    sb.append(pair1.curChar);
                    pair1.number = pair1.number - 2;
                    //add 1 pair2 or 2 or 0
                    if (pair2.number > 0){
                        if (pair1.number < pair2.number){
                            if (pair2.number - pair1.number == 2){
                                sb.append(pair2.curChar);
                                sb.append(pair2.curChar);
                                pair2.number = pair2.number - 2;

                            }
                            else if (pair2.number - pair1.number == 1){
                                sb.append(pair2.curChar);
                                pair2.number = pair2.number - 1;
                            }
                        }
                        else{
                            sb.append(pair2.curChar);
                            pair2.number = pair2.number - 1;
                        }
                    }
                }
                else{
                    for (int i = 0; i < pair1.number; i++){
                        sb.append(pair1.curChar);
                        pair1.number--;
                    }
                    for (int i = 0; i < pair2.number; i++){
                        sb.append(pair2.curChar);
                        pair2.number--;
                    }
                }
            }

            return sb.toString();
        }
        class Pair{
            char curChar;
            int number;
            public Pair(char c, int n){
                curChar = c;
                number = n;
            }
        }
    }
}