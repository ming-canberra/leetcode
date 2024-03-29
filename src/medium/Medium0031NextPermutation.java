package medium;

public class Medium0031NextPermutation {
    public static void main(String[] args) {
        Medium0031NextPermutation thisClass = new Medium0031NextPermutation();
    }
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length == 1){
            return;
        }
        int l = length - 2;
        while (l != -1)
        {
            if (nums[l] < nums[l + 1]){

                int indexX = length - 1;
                while(nums[indexX] <= nums[l]){
                    indexX--;
                }
                // swap
                swap(nums, l, indexX);
                reorder(nums, l + 1, length - 1);
                return;
            }
            l--;
        }
        reorder(nums, 0, length - 1);
    }
    private void swap(int[]nums, int l, int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
    // inclusive
    private void reorder(int[]nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    class Solution {
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            for (int i = n - 2; i >= 0; i--){
                //index found
                if (nums[i] < nums[i + 1]){
                    int tmp = nums[i];
                    for (int j = n - 1; j > i; j--){
                        if (tmp < nums[j]){
                            nums[i] = nums[j];
                            nums[j] = tmp;
                            reverse(nums, i + 1, n - 1);
                            return;
                        }
                    }
                }
            }
            reverse(nums, 0, n - 1);
        }
        private void reverse(int[] nums, int left, int right){
            while(left < right){
                int leftValue = nums[left];
                nums[left] = nums[right];
                nums[right] = leftValue;
                left++;
                right--;
            }
        }
    }

    class Solution1 {
        public void nextPermutation(int[] nums) {
            int len = nums.length;
            if (len == 1){
                return;
            }

            for (int i = len - 2; i >= 0; i--){
                int leftValue = nums[i];
                int rightValue = nums[i + 1];

                if (leftValue - rightValue < 0){
                    for (int tIdx = len - 1; tIdx > i; tIdx--){
                        if (leftValue - nums[tIdx] < 0){
                            swap(nums, i, tIdx);
                            revers(nums, i + 1);
                            return;
                        }
                    }
                }
            }
            revers(nums, 0);
        }

        private void swap(int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        private void revers(int[] nums, int start){
            int left = start;
            int right = nums.length - 1;
            while(left < right){
                swap(nums, left, right);
                left++;
                right--;
            }
        }
    }
}