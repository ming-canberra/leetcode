package easy;

public class SortArrayByParity905 {
    public static void main(String[] args) {
        SortArrayByParity905 thisClass = new SortArrayByParity905();

        System.out.println(thisClass.sortArrayByParity(new int[]{3,1,2,4}));
    }
    public int[] sortArrayByParity(int[] a) {
        int fIndex = 0;
        int sIndex = 0;

        for (int i = 0; i < a.length; i++){
            if (a[i] % 2 == 0){
                int tmp = a[fIndex];
                a[fIndex] = a[sIndex];
                a[sIndex] = tmp;
                sIndex++;
            }
            fIndex++;

        }

        return a;
    }

    class Solution {
        public int[] sortArrayByParity(int[] nums) {
            int curIndex = -1;
            for (int i = 0; i < nums.length; i++){
                if (nums[i] % 2 == 0){
                    curIndex++;
                    swap(nums, i, curIndex);
                }
            }
            return nums;
        }
        private void swap(int[] nums, int a, int b){
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }
}