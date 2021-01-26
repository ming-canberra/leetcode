package easy;

public class MonotonicArray896 {
    public static void main(String[] args) {
        MonotonicArray896 thisClass = new MonotonicArray896();
        System.out.println(" " + thisClass.isMonotonic(new int[]{1,2,2,3}));
    }
    public boolean isMonotonic(int[] A) {
        Boolean alwaysIncreasing = null;
        for (int i = 0; i < A.length -1; i++)
        {
            if (A[i] < A[i+1]){
                if (alwaysIncreasing == null){
                    alwaysIncreasing = true;
                }
                else if (!alwaysIncreasing){
                    return false;
                }
            }
            else if (A[i] > A[i+1]){
                if (alwaysIncreasing == null){
                    alwaysIncreasing = false;
                }
                else if (alwaysIncreasing){
                    return false;
                }
            }
        }

        return true;
    }
}