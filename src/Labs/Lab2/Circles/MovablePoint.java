package Labs.Lab2.Circles;

public class MovablePoint implements Movable {
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() throws ObjectCanNotBeMovedException {
        if(y+ySpeed>MovablesCollection.getHeight()){
            throw new ObjectCanNotBeMovedException(String.format("Point (%d,%d) is out of bounds",x,y+ySpeed));
        }
        y += ySpeed;
    }

    @Override
    public void moveDown() throws ObjectCanNotBeMovedException {
        if(y-ySpeed<0){
            throw new ObjectCanNotBeMovedException(String.format("Point (%d,%d) is out of bounds",x,y-ySpeed));
        }
        y -= ySpeed;
    }

    @Override
    public void moveLeft() throws ObjectCanNotBeMovedException {
        if(x-xSpeed<0){
            throw new ObjectCanNotBeMovedException(String.format("Point (%d,%d) is out of bounds",x-xSpeed,y));
        }
        x -= xSpeed;
    }

    @Override
    public void moveRight() throws ObjectCanNotBeMovedException {
        if(x+xSpeed>MovablesCollection.getWidth()){
            throw new ObjectCanNotBeMovedException(String.format("Point (%d,%d) is out of bounds",x+xSpeed,y));
        }
        x += xSpeed;
    }

    @Override
    public int getCurrentXPosition() {
        return x;
    }

    @Override
    public int getCurrentYPosition() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("Movable point with coordinates (%d,%d)",x,y);
    }
}
