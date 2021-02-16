package easy;

public class TwoSumIIInputArrayIsSorted167 {
    public static void main(String[] args) {
        TwoSumIIInputArrayIsSorted167 thisClass = new TwoSumIIInputArrayIsSorted167();
        int[]result = thisClass.twoSum(new int[]{2,7,11,15}, 9);
        for (int i : result){
            System.out.println(i);
        }
    }
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length -1;

        while(numbers[l] + numbers[r] != target){

            if (numbers[l] + numbers[r] > target){
                r--;
            }
            else if (numbers[l] + numbers[r] < target){
                l++;
            }
        }

        return new int[]{l+1, r+1};
    }
}