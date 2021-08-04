package easy;

import java.util.HashMap;

public class ValidMountainArray941 {
    public static void main(String[] args) {
        ValidMountainArray941 thisClass = new ValidMountainArray941();
        System.out.println(" " + thisClass.validMountainArray(new int[]{1,2,3,4}));
    }
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3){
            return false;
        }
        if (arr[0]>= arr[1]){
            return false;
        }
        if (arr[arr.length -2] <= arr[arr.length -1]){
            return false;
        }

        boolean checkIncreasing = true;
        for (int i = 1; i < arr.length - 2; i++){
            if (checkIncreasing){
                if (arr[i] < arr[i + 1]){

                }
                else if (arr[i] == arr[i + 1]){
                    return false;
                }
                else{
                    checkIncreasing = false;
                }
            }
            else{
                if (arr[i] < arr[i + 1]){
                    return false;
                }
                else if (arr[i] == arr[i + 1]){
                    return false;
                }
                else{

                }
            }
        }

        return true;
    }

    class Solution {
        public boolean validMountainArray(int[] arr) {
            int n = arr.length;
            if (n >= 3){
                if (arr[0] < arr[1] && arr[n - 2] > arr[n - 1]){
                    boolean ascending = true;
                    for (int i = 2; i <= n - 2; i++){
                        if(arr[i - 1] == arr[i]){
                            return false;
                        }
                        if (ascending){
                            if(arr[i - 1] > arr[i]){
                                ascending = false;
                            }
                        }
                        else{
                            if(arr[i - 1] < arr[i]){
                                return false;
                            }
                        }
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
    }
}