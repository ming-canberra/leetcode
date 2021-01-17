package easy;

public class SqrtX69 {
    public static void main(String[] args) {
        SqrtX69 thisClass = new SqrtX69();


        System.out.println(Integer.MAX_VALUE +

                " " +
                thisClass.mySqrt(2147395599)
        );
    }
    public int mySqrt(int x) {

        if (x==0){
            return 0;
        }
        long starting = 1;
        long ending = x;
        while(true){

            long mid = starting + (ending - starting) / 2;
            long square = mid*mid;

            if (mid*mid == x){
                return (int)mid;
            }
            else if (mid*mid > x){
                ending = mid;
            }
            else{
                if ((mid +1 )*(mid+1) > x){
                    return (int)mid;
                }
                else{
                    starting = mid;
                }
            }
        }
    }
}