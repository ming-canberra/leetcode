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
        HashSet<String> snakePositions = new HashSet<>();
        int[][] food;
        int[] head;
        int width;
        int height;
        int foodIndex = 0;
        public SnakeGame(int width, int height, int[][] food) {
            this.food = food;
            this.width = width;
            this.height = height;
            snakePositions.add(0 + "," + 0);
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
                    snakePositions.add(head[0] + "," + head[1]);
                    foodIndex++;
                    return foodIndex;
                }
            }
            int[] top = snake.poll();
            snakePositions.remove(top[0] + "," + top[1]);
            // hit herself
            if (snakePositions.contains(head[0] + "," + head[1])){
                return -1;
            }
            else{
                // keep moving
                snake.add(new int[]{head[0], head[1]});
                snakePositions.add(head[0] + "," + head[1]);
                return foodIndex;
            }
        }
    }

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
}