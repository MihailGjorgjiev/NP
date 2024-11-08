package Labs.Lab2.Circles;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MovablesCollection {
    private static int X_LIMIT;
    private static int Y_LIMIT;
    private Movable[] movables;

    static {
        X_LIMIT = 0;
        Y_LIMIT = 0;
    }

    public static boolean inRange(int lower, int current, int upper) {
        return lower <= current && current <= upper;
    }

    public MovablesCollection(int x_MAX, int y_MAX) {
        if (x_MAX > 0) {
            X_LIMIT = x_MAX;
        }
        if (y_MAX > 0) {
            Y_LIMIT = y_MAX;
        }
        movables = new Movable[0];
    }

    public static void setxMax(int xMax) {
        if (xMax > 0) {
            X_LIMIT = xMax;
        }
    }
    public static int getHeight(){
        return Y_LIMIT;
    }
    public static int getWidth(){
        return X_LIMIT;
    }
    public static void setyMax(int yMax) {
        if (yMax > 0) {
            Y_LIMIT = yMax;
        }
    }

    public void addMovableObject(Movable m) throws MovableObjectNotFittableException {
        if (m instanceof MovableCircle) {
            MovableCircle mc = (MovableCircle) m;
            int left = mc.getCurrentXPosition() - mc.getRadius();
            int right = mc.getCurrentXPosition() + mc.getRadius();
            int up = mc.getCurrentYPosition() + mc.getRadius();
            int down = mc.getCurrentYPosition() - mc.getRadius();
            if (inRange(0, left, X_LIMIT) && inRange(0, right, X_LIMIT) &&
                    inRange(0, up, Y_LIMIT) && inRange(0, down, Y_LIMIT)) {
                movables = Arrays.copyOf(movables, movables.length + 1);
                movables[movables.length - 1] = m;
                return;
            } else {
                String errMessage= Arrays.stream(mc.toString().split("\\s+")).filter(s->!s.equals("coordinates")).collect(Collectors.joining(" "));
                throw new MovableObjectNotFittableException(errMessage+" can not be fitted into the collection");
            }
        }
        if (inRange(0, m.getCurrentXPosition(), X_LIMIT) && inRange(0, m.getCurrentYPosition(), Y_LIMIT)) {
            movables = Arrays.copyOf(movables, movables.length + 1);
            movables[movables.length - 1] = m;

        } else {
            throw new MovableObjectNotFittableException(m+" can not be fitted into the collection");
        }
    }

    public void moveObjectsFromTypeWithDirection(TYPE type, DIRECTION direction) {
        Movable[] filteredMovables;
        if(type == TYPE.POINT){
            filteredMovables= Arrays.stream(movables).filter(m->m instanceof MovablePoint).toArray(Movable[]::new);
        }else {
            filteredMovables= Arrays.stream(movables).filter(m->m instanceof MovableCircle).toArray(Movable[]::new);
        }
        for(Movable movable:filteredMovables){
            try {
            if(direction == DIRECTION.UP) movable.moveUp();
            else if (direction == DIRECTION.DOWN) movable.moveDown();
            else if (direction == DIRECTION.LEFT) movable.moveLeft();
            else if(direction==DIRECTION.RIGHT) movable.moveRight();
            }catch (ObjectCanNotBeMovedException e){
                System.out.println(e.getMessage());
            }
        }
//        for (Movable movable : movables) {
//            if (type==TYPE.POINT && direction==DIRECTION.LEFT){
//                System.out.println();
//            }
//            if (type == TYPE.CIRCLE) {
//                if (movable instanceof MovableCircle) {
//                    MovableCircle mc = (MovableCircle) movable;
//                    switch (direction) {
//                        case UP:
//                            mc.moveUp();
//                            break;
//                        case DOWN:
//                            mc.moveDown();
//                            break;
//                        case LEFT:
//                            mc.moveLeft();
//                            break;
//                        case RIGHT:
//                            mc.moveRight();
//                            break;
//                    }
//                }
//            }else {
//                if (movable instanceof MovablePoint) {
//                    MovablePoint mp = (MovablePoint) movable;
//                    switch (direction) {
//                        case UP:
//                            mp.moveUp();
//                            break;
//                        case DOWN:
//                            mp.moveDown();
//                            break;
//                        case LEFT:
//                            mp.moveLeft();
//                            break;
//                        case RIGHT:
//                            mp.moveRight();
//                            break;
//                    }
//                }
//            }
//        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Collection of movable objects with size ").append(movables.length).append(":").append("\n");

        for (Movable movable : movables) {
            sb.append(movable).append("\n");
        }

        return sb.toString();
    }
}
