package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AsteroidCollition735 {
    public static void main(String[] args) {
        AsteroidCollition735 thisClass = new AsteroidCollition735();

        thisClass.asteroidCollision(null);
    }

    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        List<Integer> resultList = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; i++){
            if (stack.isEmpty())
            {
                if (asteroids[i] < 0){
                    resultList.add(asteroids[i]);
                }
                else{
                    stack.add(asteroids[i]);
                }
            }
            else{
                if (asteroids[i] > 0){
                    stack.add(asteroids[i]);
                }
                else{
                    int astValue = asteroids[i];

                    while(!stack.isEmpty()){

                        int topValue = stack.pop();
                        if (topValue + astValue == 0){
                            astValue = 0;
                            break;
                        }
                        else if (topValue + astValue > 0){
                            stack.push(topValue);
                            astValue = topValue;
                            break;
                        }
                        else{
                            astValue = astValue;
                        }
                    }

                    if (stack.isEmpty() && astValue < 0){
                        resultList.add(astValue);
                    }
                }
            }
        }

        if (!stack.isEmpty()){
            Stack<Integer> stackH = new Stack<Integer>();
            while (!stack.isEmpty()){
                stackH.push(stack.pop());
            }

            while (!stackH.isEmpty()){
                resultList.add(stackH.pop());
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++){
            result[i] = resultList.get(i);
        }
        return result;
    }
}