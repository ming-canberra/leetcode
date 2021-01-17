package easy;

public class ClimbingStairs70 {
    public static void main(String[] args) {
        ClimbingStairs70 thisClass = new ClimbingStairs70();

        System.out.println(thisClass.climbStairs(45));
    }
    public int climbStairs(int n) {
        int[]steps = new int[n];
        for (int i = 0;i<n; i++){
            if (i ==0){
                steps[0] = 1;
                continue;
            }
            if (i ==1){
                steps[1] = 2;
                continue;
            }
            steps[i] = steps[i -1] + steps[i-2];
        }
        return steps[n-1];
    }

}