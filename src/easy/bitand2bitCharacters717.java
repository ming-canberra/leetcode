package easy;

public class bitand2bitCharacters717 {
    public static void main(String[] args) {
        bitand2bitCharacters717 thisClass = new bitand2bitCharacters717();

        int[] s1 = {1,0,1,0,0};


        System.out.println(thisClass.isOneBitCharacter(s1));
    }
    public boolean isOneBitCharacter(int[] bits) {
        int zeroCounter = 1;
        int oneCounter = 0;
        for (int i = bits.length-2; i >=0; i--){
            if (oneCounter ==0){
                if (bits[i] == 0){
                    zeroCounter++;
                }
                else{
                    oneCounter++;
                }
            }
            else{
                if (bits[i] == 0){
                    break;
                }
                else{
                    oneCounter++;
                }
            }

            if (zeroCounter >= 2){
                return true;
            }
        }

        return (oneCounter % 2 == 0);
    }
}