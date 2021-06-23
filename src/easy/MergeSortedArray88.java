package easy;

public class MergeSortedArray88 {

    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for (int i = m - 1; i >= 0; i--){
                nums1[i + n] = nums1[i];
            }
            int num1Index = n;
            int num2Index = 0;
            for (int i = 0; i < m + n; i++){
                int value;
                if(num1Index == m + n){
                    value = nums2[num2Index];
                    num2Index++;
                }
                else if(num2Index == n){
                    value = nums1[num1Index];
                    num1Index++;
                }
                else{
                    if(nums1[num1Index] <= nums2[num2Index]){
                        value = nums1[num1Index];
                        num1Index++;
                    }
                    else{
                        value = nums2[num2Index];
                        num2Index++;
                    }
                }
                nums1[i] = value;
            }
        }
    }
}