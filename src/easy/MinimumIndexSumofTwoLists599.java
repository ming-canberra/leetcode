package easy;

import java.util.ArrayList;
import java.util.HashMap;

public class MinimumIndexSumofTwoLists599 {
    public static void main(String[] args) {
        MinimumIndexSumofTwoLists599 thisClass = new MinimumIndexSumofTwoLists599();

        String[] s1 = {"S","TEXP","BK","KFC"};
        String[]s2 = {"KFC","BK","S"};
        thisClass.findRestaurant(s1, s2);
    }
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> hash1 = new HashMap<String, Integer>();
        HashMap<String, Integer> hash2 = new HashMap<String, Integer>();

        int biggerLength = Math.max(list1.length, list2.length);

        ArrayList<String> toReturnList = new ArrayList();

        int leastListIndexSum = -1;
        for (int i = 0;i < biggerLength;i++){

            if (leastListIndexSum == -1 || (leastListIndexSum != -1 && leastListIndexSum >= i) ){
                if (i < list1.length){
                    hash1.put(list1[i], i);
                }
                if (i < list2.length){
                    hash2.put(list2[i], i);
                }
                if (i < list1.length){
                    if (hash2.containsKey(list1[i])){
                        if (leastListIndexSum == -1){
                            leastListIndexSum = i + hash2.get(list1[i]);
                            toReturnList.add(list1[i]);
                        }
                        else {
                            int currentIndexSum = i + hash2.get(list1[i]);
                            if (currentIndexSum< leastListIndexSum){
                                toReturnList.clear();
                                toReturnList.add(list1[i]);
                                leastListIndexSum = currentIndexSum;
                            }
                            else if (currentIndexSum == leastListIndexSum){
                                if (!toReturnList.contains(list1[i])){
                                    toReturnList.add(list1[i]);
                                }
                            }
                        }
                    }
                }
                if (i < list2.length){
                    if (hash1.containsKey(list2[i])){
                        if (leastListIndexSum == -1){
                            leastListIndexSum = i + hash1.get(list2[i]);
                            toReturnList.add(list2[i]);
                        }
                        else {
                            int currentIndexSum = i + hash1.get(list2[i]);
                            if (currentIndexSum< leastListIndexSum){
                                toReturnList.clear();
                                toReturnList.add(list2[i]);
                                leastListIndexSum = currentIndexSum;
                            }
                            else if (currentIndexSum == leastListIndexSum){
                                if (!toReturnList.contains(list2[i])){
                                    toReturnList.add(list2[i]);
                                }
                            }
                        }
                    }
                }
            }
        }

        return toReturnList.toArray(new String[toReturnList.size()]);
    }
}