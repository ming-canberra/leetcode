package easy;

public class BinaryNumberwithAlternatingBits693 {
    public static void main(String[] args) {
        BinaryNumberwithAlternatingBits693 thisClass = new BinaryNumberwithAlternatingBits693();
        System.out.println(thisClass.hasAlternatingBits(5));

        System.out.println(Integer.toBinaryString(20));
    }
    public boolean hasAlternatingBits(int n) {
        Boolean expectingZero = (n%2 == 0);

        while(n > 0){

            if (n%2 == 1){
                if (expectingZero){
                    return false;
                }
                expectingZero = true;
            }
            else{
                if (!expectingZero){
                    return false;
                }
                expectingZero = false;
            }

            n = n/2;
        }

        return true;
    }
}