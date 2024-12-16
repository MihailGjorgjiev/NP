package VtorKolokviumVezbi.Cluster_18;

import java.util.Map;

public class Point2D implements IdentifiablePoints {
    private long id;
    private float x;
    private float y;


    public Point2D(long id, float x, float y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public long getId() {
        return id;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public double distance(IdentifiablePoints p) {
        Point2D pt= (Point2D) p;
        double dx2 = Math.pow(x - pt.x, 2);
        double dy2 = Math.pow(y - pt.y, 2);
        return Math.sqrt(dx2 + dy2);
    }
}
