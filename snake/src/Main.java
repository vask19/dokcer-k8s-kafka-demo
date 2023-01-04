public class Main {
    public static void main(String[] args) throws InterruptedException {
        Place place = new Place(10,30);
        Snake snake = new Snake();
        snake.setHead(10,10);
        Printer printer = new Printer(place,snake);
        printer.print();

        Thread snakeControllerThread = new Thread(new SnakeController(snake));
        Thread snakeThread = new Thread(snake);
        snakeThread.start();
        snakeControllerThread.start();
        while (true){
            Thread.sleep(1000);
            printer.print();
        }
    }
}
