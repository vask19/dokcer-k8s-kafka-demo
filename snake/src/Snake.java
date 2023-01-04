import java.util.Locale;

public class Snake implements Runnable{
    private volatile String runVector = "w";
    private volatile int yHead;
    private volatile int xHead;
    private int snakeSize = 0;
    private volatile int[] head;
    private volatile int[][] body = new int[30][30];



    {
        body[0] = new int[]{11,10};
        body[1] = new int[]{12,10};
        body[2] = new int[]{13,10};
        body[3] = new int[]{14,10};
        body[4] = new int[]{15,10};
        snakeSize = 4;
    }




    public void grow(){
        snakeSize++;
    }

    public void death(){

    }




    public int[] getHead() {
        return head;
    }

    public void setHead(int y,int x) {
        yHead = y;
        xHead = x;
        head = new int[]{yHead,xHead};
    }

    public int[][] getBody() {
        return body;
    }

    public void setBody(int[][] body) {
        this.body = body;
    }

    public String getRunVector() {
        return runVector;
    }

    public void setRunVector(String runVector) {
        this.runVector = runVector;
    }

    public int getYHead() {
        return yHead;
    }

    public void setYHead(int yHead) {
        this.yHead = yHead;
    }

    public int getXHead() {
        return xHead;
    }

    public void setXHead(int xHead) {
        this.xHead = xHead;
    }

    private void changeBody(){
        for (int i =snakeSize;i>0;i--){
            body[i] = body[i-1];

            }
        body[0] = head;

        }




    private int[] changeCord(int cordY,int cordX){
        int y = cordY;
        int x = cordX;
        switch (runVector.toLowerCase(Locale.ROOT)){
            case "w":
                y--;
                break;
            case "s":
                y++;
                break;
            case "a":
                x--;
                break;
            case "d":
                x++;
                break;
        }
        return new int[]{y,x};

    }

    private void changeHead(){
        int[] newCord = changeCord(yHead,xHead);
        setHead(newCord[0],newCord[1]);
    }


    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            changeBody();

            changeHead();
            }



        }
    }

