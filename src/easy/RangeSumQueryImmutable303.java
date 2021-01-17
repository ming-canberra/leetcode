package easy;

import java.util.HashMap;

public class RangeSumQueryImmutable303 {
    public static void main(String[] args) {
        RangeSumQueryImmutable303 thisClass = new RangeSumQueryImmutable303();

        int[] input = {1,2,3,0};
        int result = thisClass.sumRange(1,1);
        System.out.println(result);
    }


    public RangeSumQueryImmutable303(){}


    int _indexToSum[];
    public RangeSumQueryImmutable303(int[] nums) {

        _indexToSum = new int[nums.length];
        int tempSum = 0;
        for (int i = 0 ; i < nums.length; i++){
            tempSum += nums[i];
            _indexToSum[i]= tempSum;
        }


    }

    public int sumRange(int i, int j) {
        if (i ==0)
            return _indexToSum[j];
        else
            return _indexToSum[j] - _indexToSum[i-1];
    }
}