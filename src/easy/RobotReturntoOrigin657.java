package easy;

public class RobotReturntoOrigin657 {
    public static void main(String[] args) {
        RobotReturntoOrigin657 thisClass = new RobotReturntoOrigin657();
        System.out.println(thisClass.judgeCircle("LL"));
    }

    public boolean judgeCircle(String moves) {
        char[] content = moves.toCharArray();
        int countU = 0;
        int countD = 0;
        int countL = 0;
        int countR = 0;
        for (char c : content){
            if (c=='U'){
                countU++;
            }
            else if (c=='D'){
                countD++;
            }
            else if (c=='L'){
                countL++;
            }
            else if (c=='R'){
                countR++;
            }
        }
        return countU == countD && countL == countR;
    }


}