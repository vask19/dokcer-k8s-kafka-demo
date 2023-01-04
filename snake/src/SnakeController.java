import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class SnakeController implements Runnable{
    private volatile Snake snake;

    public SnakeController(Snake snake) {
        this.snake = snake;
    }

    private final Scanner scanner = new Scanner(System.in);


    @Override
    public void run() {
        while (true){
            var guess = scanner.nextLine();
            String vector = snake.getRunVector();
            if (guess.equals("w") && !vector.equals("s")){
                snake.setRunVector("w");
            }
            else if (guess.equals("s") && !vector.equals("w")){
                snake.setRunVector("s");
            }
            else if (guess.equals("a") && !vector.equals("d")){
                snake.setRunVector("a");
            }
            else if (guess.equals("d") && !vector.equals("a")){
                snake.setRunVector("d");
            }
            else {
                snake.grow();
            }
        }

    }
}
