package CollectionBook.Streams.Canvas;

public abstract class Shape implements IShape{
    private String id;

    public Shape(String id) {
        this.id = id;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }
}

