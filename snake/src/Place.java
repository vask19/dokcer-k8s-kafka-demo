public class Place {

    private int[][] array;
    private int y;
    private int x;

    public Place(int y, int x) {
        this.y = y;
        this.x = x;
        this.array = new int[y][x];
    }

    public int[][] getArray() {
        return array;
    }

    public void setArray(int[][] array) {
        this.array = array;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
