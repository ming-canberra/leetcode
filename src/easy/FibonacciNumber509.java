package easy;

import java.util.ArrayList;
import java.util.List;

public class FibonacciNumber509 {
    public static void main(String[] args) {
        FibonacciNumber509 thisClass = new FibonacciNumber509();

        System.out.println(thisClass.fib(100));
    }
    public int fib(int n) {
        if (n == 0)
            return 0;
        else if (n ==1 )
            return 1;
        else{
            return fib(n-1) + fib(n-2);
        }
    }
}