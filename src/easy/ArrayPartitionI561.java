package easy;

public class ArrayPartitionI561 {
    public static void main(String[] args) {
        ArrayPartitionI561 thisClass = new ArrayPartitionI561();

        System.out.println(thisClass.arrangeCoins(1804289383));
    }
    //do binary search
    public int arrangeCoins(int n) {

        long lowerLimit = 0;
        long higherLimit = n;

        while (lowerLimit<higherLimit){

            long mid = lowerLimit + (higherLimit-lowerLimit)/2;

            long numberOfCoinsFullRows = mid * (mid+1)/2;
            if (numberOfCoinsFullRows == n){
                return (int)mid;
            }
            else if (numberOfCoinsFullRows > n){

                higherLimit = mid;
            }
            else{
                if (higherLimit - lowerLimit == 1){
                    if (higherLimit * (higherLimit +1) /2 == n){
                        return (int)higherLimit;
                    }
                    else{
                        return (int)lowerLimit;
                    }
                }
                lowerLimit = mid;
            }
        }

        return (int)lowerLimit;
    }
}