package medium;

import java.util.*;

public class DesignSnakeGame353 {
    class SnakeGame {

        /** Initialize your data structure here.
         @param width - screen width
         @param height - screen height
         @param food - A list of food positions
         E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */

        Queue<int[]> snake = new LinkedList<int[]>();
        HashSet<Integer> snakePositions = new HashSet<>();
        int[][] food;
        int[] head;
        int width;
        int height;
        int foodIndex = 0;
        public SnakeGame(int width, int height, int[][] food) {
            this.food = food;
            this.width = width;
            this.height = height;
            snakePositions.add(0 * width + 0);
            snake.add(new int[] {0, 0});
            head = new int[] {0, 0};
        }

        /** Moves the snake.
         @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         @return The game's score after the move. Return -1 if game over.
         Game over when snake crosses the screen boundary or bites its body. */
        public int move(String direction) {
            int[] curFood = null;
            if (foodIndex < food.length){
                curFood = food[foodIndex];
            }

            if(direction.equals("U")){
                head[0] -= 1;
            }
            else if(direction.equals("D")){
                head[0] += 1;
            }
            else if(direction.equals("L")){
                head[1] -= 1;
            }
            else if(direction.equals("R")){
                head[1] += 1;
            }
            // hit the wall
            if (head[0] < 0 || head[0] >= height || head[1] < 0 || head[1] >= width){
                return -1;
            }
            // hit the food
            if (curFood != null){
                if (head[0] == curFood[0] && head[1] == curFood[1]){
                    snake.add(new int[]{head[0], head[1]});
                    snakePositions.add(head[0] * width + head[1]);
                    foodIndex++;
                    return foodIndex;
                }
            }
            int[] top = snake.poll();
            snakePositions.remove(top[0] * width + top[1]);
            // hit herself
            if (snakePositions.contains(head[0] * width + head[1])){
                return -1;
            }
            else{
                // keep moving
                snake.add(new int[]{head[0], head[1]});
                snakePositions.add(head[0] * width + head[1]);
                return foodIndex;
            }
        }
    }

    class SnakeGame2 {

        /** Initialize your data structure here.
         @param width - screen width
         @param height - screen height
         @param food - A list of food positions
         E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */

        private int[] headPos = new int[]{0, 0};
        private Queue<int[]> bodyQ = new LinkedList<>();
        private Set<Integer> bodyS = new HashSet<>();
        private int foodIndex = 0;
        private int foodCount;
        private int score = 0;
        private int w;
        private int h;
        private int[][] foods;
        public SnakeGame2(int width, int height, int[][] food) {
            w = width;
            h = height;
            foods = food;
            foodCount = food.length;
        }

        /** Moves the snake.
         @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         @return The game's score after the move. Return -1 if game over.
         Game over when snake crosses the screen boundary or bites its body. */
        public int move(String direction) {
            int prevR = headPos[0];
            int prevC = headPos[1];
            if (direction.equals("U")){
                headPos[0] += -1;
            }
            else if (direction.equals("L")){
                headPos[1] += -1;
            }
            else if (direction.equals("R")){
                headPos[1] += 1;
            }
            else if (direction.equals("D")){
                headPos[0] += 1;
            }
            //goes out of bound
            if (headPos[0] < 0 || headPos[0] >= h || headPos[1] < 0 || headPos[1] >= w){
                return -1;
            }
            //foodie
            if(foodIndex < foodCount){
                int[] food = foods[foodIndex];
                if (food[0] == headPos[0] && food[1] == headPos[1]){
                    bodyQ.add(new int[]{prevR, prevC});
                    bodyS.add(prevR * w + prevC);
                    foodIndex++;
                    score++;
                    return score;
                }
            }
            if (!bodyQ.isEmpty()){
                int[] top = bodyQ.poll();
                bodyS.remove(top[0] * w + top[1]);
                //collision
                if (bodyS.contains(headPos[0] * w + headPos[1] )){
                    return -1;
                }
                bodyQ.add(new int[]{prevR, prevC});
                bodyS.add(prevR * w + prevC);
            }
            return score;
        }
    }


}