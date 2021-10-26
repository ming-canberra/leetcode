package medium;

import java.util.*;

public class Medium334IncreasingTripletSubsequence {
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            Integer low = 0;
            Integer medium = null;
            Integer lowSecond = null;
            for (int i = 1; i < nums.length; i++){
                if (medium != null){
                    if (nums[i] > nums[medium]){
                        return true;
                    }
                    else if (nums[i] < nums[medium]){
                        if (nums[i] < nums[low]){
                            // check second low
                            if (lowSecond == null){
                                lowSecond = i;
                            }
                            else{
                                if (nums[i] < nums[lowSecond]){
                                    lowSecond = i;
                                }
                                else if (nums[i] > nums[lowSecond]){
                                    medium = i;
                                    low = lowSecond;
                                    lowSecond = null;
                                }
                            }
                        }
                        else if (nums[i] > nums[low]){
                            medium = i;
                        }
                        else{
                            if (lowSecond != null){
                                if (nums[i] > nums[lowSecond]){
                                    medium = i;
                                    low = lowSecond;
                                    lowSecond = null;
                                }
                            }
                        }
                    }
                }
                else{
                    if (nums[i] < nums[low]){
                        low = i;
                    }
                    else if (nums[i] > nums[low]){
                        medium = i;
                    }
                }
            }
            return false;
        }
    }
}