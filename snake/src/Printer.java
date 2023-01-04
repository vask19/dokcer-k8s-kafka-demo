import java.util.Arrays;

public class Printer {


    private Place place;
    private volatile Snake snake;

    public Printer(Place place, Snake snake) {
        this.place = place;
        this.snake = snake;
    }

    public void print(){
        for (int i =0;i< 500;i++){
            System.out.println();
        }

        System.out.println("---------------------------------");


        for (int i =0;i<place.getY();i++){
            System.out.print("|");
            for (int j = 0;j<place.getX(); j++){
                boolean print = true;

                if (Arrays.equals(snake.getHead(), new int[]{i, j})){
                    System.out.print("*");
                    print = false;
                }
                for (int[] cord : snake.getBody()){
                    if (Arrays.equals(cord, new int[]{i, j})){
                        System.out.print("*");
                        print = false;
                    }

                }
                if (print){
                    System.out.print(" ");

                }
            }
            System.out.println("|");
        }
        System.out.println("---------------------------------");



    }
}

