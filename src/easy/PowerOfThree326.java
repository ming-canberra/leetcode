package easy;

public class PowerOfThree326 {
    public static void main(String[] args) {
        PowerOfThree326 thisClass = new PowerOfThree326();

        int[] input = {1,2,3,0};
        boolean result = thisClass.isPowerOfThree(123);
        System.out.println(result);
    }

    public boolean isPowerOfThree(int n) {

        if (n<=0){
            return false;
        }
        if (n==1){
            return true;
        }
        while(n >3){
            if (n%3 != 0){
                return false;
            }
            else{
                n = n/3;
            }
        }
        return n==3;

    }
}