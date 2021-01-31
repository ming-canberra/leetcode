package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContainsDuplicateII219 {
    public static void main(String[] args) {
        ContainsDuplicateII219 thisClass = new ContainsDuplicateII219();
        System.out.println(" " + thisClass.containsNearbyDuplicate(new int[]{1,0,1,1},1));
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length;i++){
            if (map.containsKey(nums[i])){
                int index = map.get(nums[i]);
                if (i-index <=k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
/*        HashMap<Integer, Integer> rValueIndexMap = new HashMap<Integer, Integer>();
        int l =0, r = nums.length - 1;
        boolean tickTock = false;
        lValueIndexMap.put(nums[0],0);
        while(l < r){
            if (tickTock){
                if (lValueIndexMap.containsKey(nums[l])){
                    if (Math.abs(lValueIndexMap.get(nums[l]) -l  )<=k)
                        return true;
                }
                lValueIndexMap.put(nums[l], l);
                if (rValueIndexMap.containsKey(nums[l])){
                    if (Math.abs(rValueIndexMap.get(nums[l]) -l  )<=k)
                        return true;
                }

                l++;
                tickTock = false;
            }
            else{
                if (rValueIndexMap.containsKey(nums[r])){
                    if (Math.abs(rValueIndexMap.get(nums[r]) -r  )<=k)
                        return true;
                }
                rValueIndexMap.put(nums[r], r);
                if (lValueIndexMap.containsKey(nums[r])){
                    if (Math.abs(lValueIndexMap.get(nums[r]) - r  )<=k)
                        return true;
                }
                r--;
                tickTock = true;
            }
        }*/
    }


}