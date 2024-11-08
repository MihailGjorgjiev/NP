package Labs.Lab2.Circles;

public class MovableCircle implements Movable {
    private int radius;
    private MovablePoint movablePoint;

    public MovableCircle(int radius, MovablePoint movablePoint) {
        this.radius = radius;
        this.movablePoint = movablePoint;
    }

    @Override
    public void moveUp() throws ObjectCanNotBeMovedException {
        movablePoint.moveUp();
    }

    @Override
    public void moveDown() throws ObjectCanNotBeMovedException {
        movablePoint.moveDown();
    }

    @Override
    public void moveLeft() throws ObjectCanNotBeMovedException {
        movablePoint.moveLeft();
    }

    @Override
    public void moveRight() throws ObjectCanNotBeMovedException {
        movablePoint.moveRight();
    }

    @Override
    public int getCurrentXPosition() {
        return movablePoint.getCurrentXPosition();
    }

    @Override
    public int getCurrentYPosition() {
        return movablePoint.getCurrentYPosition();
    }

    public int getRadius(){
        return radius;
    }

    @Override
    public String toString() {
        return String.format("Movable circle with center coordinates (%d,%d) and radius %d",getCurrentXPosition(),getCurrentYPosition(),radius);
    }
}
