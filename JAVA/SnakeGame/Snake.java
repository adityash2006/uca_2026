// package JAVA.SnakeGame;
 
import java.util.*;
public class Snake {

    public static void main(String[] args) {
        
    }
}

class SnakeGame {
    
    
    class Coordinate {
        int x;
        int y;
        
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Coordinate that) {
            return this.x == that.x && this.y == that.y;
        }
    }
        
    private Deque<Coordinate> snakeTracker;
    private Set<Coordinate> usedCoordinates;
    private int width;
    private int height;
    private int food[][];
    private int foodIndex;
    

    public SnakeGame(int width, int height, int[][] food) {
        this.snakeTracker = new ArrayDeque<>();
        this.width = width;
        this.height = height;
        this.food = food;
        this.foodIndex = 0;
        this.usedCoordinates = new HashSet<>();

        // starting Index for the snake
        Coordinate start = new Coordinate(0 , 0);
        snakeTracker.addFirst(start);
        usedCoordinates.add(start);
    }
    
    public int move(String direction) {
        Coordinate headCoordinates = snakeTracker.peekFirst();
        Coordinate newCoordinates = moveSnake(direction, headCoordinates);

        if (isCoordinatesInvalid(newCoordinates)) {
            return -1;
        }
        
        boolean isFoodEaten = (foodIndex < food.length) && 
                    (newCoordinates.x == food[foodIndex][0] && newCoordinates.y == food[foodIndex][1]);
        
        // when the food is not eaten
        if (!isFoodEaten) {
            Coordinate tail = snakeTracker.removeLast();
            usedCoordinates.remove(tail);
        }
        
        // If the collision has happened
        if(usedCoordinates.contains(newCoordinates)) {
            return -1;
        }
        
        // Add the new Box where snake has moved.
        snakeTracker.addFirst(newCoordinates);
        usedCoordinates.add(newCoordinates);
        
        if (isFoodEaten) {
            foodIndex++;
        }
        
        return snakeTracker.size() - 1;
        
    }

    private Coordinate moveSnake(String direction , Coordinate current) {
        if (direction.equals("U") {
            return new Coordinate(current.x-- , current.y);
        } else if (direction.equals("D") {
            return new Coordinate(current.x++ , current.y);
        } else if (direction.equals("L") {
            return new Coordinate(current.x , current.y--);
        } else if (direction.equals("R") {
            return new Coordinate(current.x , current.y++);
        }

        throw new IllegalArgumentException("Direction Not supported");
    }

    private boolean isCoordinatesInvalid(Coordinate coordinate) {
        if (coordinate.x < 0 || coordinate.y < 0 || coordinate.x >= height || coordinate.y >= width) {
            return true;
        }
        return false;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction); {
    

GRID APPROACH 
class Snake {

    int width;
    int height;

    int[][] food;
    int foodIndex = 0;
    int score = 0;

    Deque<int[]> snake = new LinkedList<>();
    boolean[][] occupied;

    public Snake(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;

        occupied = new boolean[height][width];

        snake.addFirst(new int[]{0, 0});
        occupied[0][0] = true;
    }

    public int move(String direction) {

        int[] head = snake.peekFirst();

        int newRow = head[0];
        int newCol = head[1];

        switch (direction) {
            case "R":
                newCol++;
                break;
            case "L":
                newCol--;
                break;
            case "U":
                newRow--;
                break;
            case "D":
                newRow++;
                break;
        }

        // boundary
        if (newRow < 0 || newRow >= height ||
            newCol < 0 || newCol >= width) {
            return -1;
        }

        // food
        boolean eating = foodIndex < food.length &&
                         food[foodIndex][0] == newRow &&
                         food[foodIndex][1] == newCol;

        // tail
        int[] tail = snake.peekLast();

        // collision with body
        if (occupied[newRow][newCol]) {

            boolean isTail =
                newRow == tail[0] &&
                newCol == tail[1];

            if (!(isTail && !eating)) {
                return -1;
            }
        }

        // if no food, remove tail
        if (!eating) {
            snake.removeLast();
            occupied[tail[0]][tail[1]] = false;
        } else {
            score++;
            foodIndex++;
        }

        // add new head
        snake.addFirst(new int[]{newRow, newCol});
        occupied[newRow][newCol] = true;

        return score;
    }
}
}


