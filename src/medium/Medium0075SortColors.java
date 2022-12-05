package medium;

public class Medium0075SortColors {
    public static void main(String[] args) {
        Medium0075SortColors thisClass = new Medium0075SortColors();
        thisClass.sortColors(new int[]{2,0,2,1,1,0});
    }
    public void sortColors(int[] nums) {
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                c0++;
            }
            else if (nums[i] == 1){
                c1++;
            }
            else{
                c2++;
            }
        }
        for (int i =0 ; i <=c0 -1;i++){
            nums[i] = 0;
        }
        for (int i =c0; i <=c0 -1 + c1;i++){
            nums[i] = 1;
        }
        for (int i =c0+c1; i <=c0 -1 + c1 + c2;i++){
            nums[i] = 2;
        }
    }

    class Solution {
        public void sortColors(int[] nums) {
            int n = nums.length;
            //0 red
            int rIndex = -1;
            for (int i = 0; i < n; i++){
                if (nums[i] == 0){
                    rIndex++;
                    swap(nums, i, rIndex);
                }
            }
            //2 blue
            int bIndex = n;
            for (int i = n - 1; i >= 0; i--){
                if (nums[i] == 2){
                    bIndex--;
                    swap(nums, i, bIndex);
                }
            }
        }
        private void swap(int[] nums, int a, int b){
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }

    class Solution1 {
        public void sortColors(int[] nums) {
            int redIdx = -1;
            int blueIdx = nums.length;
            int idx = 0;
            while(idx < blueIdx) {
                if (nums[idx] == 0) {
                    redIdx++;
                    swap(redIdx, idx, nums);
                    idx++;
                }
                else if (nums[idx] == 2) {
                    blueIdx--;
                    swap(blueIdx, idx, nums);
                }
                else {
                    idx++;
                }
            }
        }
        private void swap(int first, int second, int[] nums) {
            int tmp = nums[first];
            nums[first] = nums[second];
            nums[second] = tmp;
        }
    }
}