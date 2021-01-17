package easy;

public class ReverseStringII541 {
    public static void main(String[] args) {
        ReverseStringII541 thisClass = new ReverseStringII541();
        System.out.println(thisClass.reverseStr("abcdefg", 2));
    }
    public String reverseStr(String s, int k) {

        int numberOuterLoops = s.length()/(2*k);
        for (int j = 0; j < numberOuterLoops; j++) {

            s = revertString( s, j*2*k, j*2*k + k );
        }
        int leftOver = s.length()%(2*k);

        if (leftOver > 0) {
            s = revertString(s, numberOuterLoops*2*k, numberOuterLoops*2*k + (leftOver>k?k:leftOver) );
        }
        return s;
    }

    private String revertString(String s, int startingIndex, int endingIndexPlusOne){

        char[] chars = s.toCharArray();
        while(endingIndexPlusOne - 1 > startingIndex){
            char temp = chars[startingIndex];
            chars[startingIndex] = chars[endingIndexPlusOne -1];
            chars[endingIndexPlusOne -1] = temp;
            startingIndex ++;
            endingIndexPlusOne -- ;
        }


        String toReturn  = new String(chars);
        return toReturn;
    }

}