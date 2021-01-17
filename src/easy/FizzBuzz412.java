package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FizzBuzz412 {
    public static void main(String[] args) {
        FizzBuzz412 thisClass = new FizzBuzz412();

        System.out.println(thisClass.fizzBuzz(123));
    }
    public List<String> fizzBuzz(int n) {
        List<String> toReturn = new ArrayList<String>();

        for (int i =1; i < n+1; i++){
            if (i % 3 ==0 && i % 5 ==0){
                toReturn.add("FizzBuzz");
            }
            else if (i % 3 == 0){
                toReturn.add("Fizz");
            }
            else if (i % 5 == 0){
                toReturn.add("Buzz");
            }
            else{
                toReturn.add(new Integer(i).toString());
            }

        }

        return toReturn;
    }
}