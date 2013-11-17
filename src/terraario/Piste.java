package terraario;

public class Piste {

    private int x;
    private int y;

    public Piste(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double etaisyys(Piste toinen) {
        int xd = x - toinen.x;
        int yd = y - toinen.y;

        return Math.sqrt((xd * xd) + (yd * yd));
    }
}
