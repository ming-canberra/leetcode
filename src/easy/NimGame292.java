package easy;

public class NimGame292 {
    public static void main(String[] args) {
        NimGame292 thisClass = new NimGame292();

        int[] input = {1,2,3,0};
        boolean result = thisClass.canWinNim(123);
        System.out.println(result);
    }

    public boolean canWinNim(int n) {

        if (n%4 ==0){
            return false;
        }

        return true;
    }
}