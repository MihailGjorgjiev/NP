package CollectionBook.Streams.Canvas;

public class ShapeFactory {
    private static boolean checkId(String id) {
        if (id.length() != 6) return false;

        for (char c : id.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) return false;
        }
        return true;
    }

    public static IShape createShape(String line) throws InvalidIDException, InvalidDimensionException {
        String[] split = line.trim().split("\\s+");
        int type=Integer.parseInt(split[0]);
        String id=split[1];
        if(!checkId(id)){
            throw new InvalidIDException(id);
        }

        double firstDimension=Double.parseDouble(split[2]);
        if(firstDimension == 0.0){
            throw new InvalidDimensionException();
        }
        if(type ==1){
            return new Circle(id,firstDimension);
        } else if (type == 2) {
            return new Square(id,firstDimension);
        }else {
            double secondDimension=Double.parseDouble(split[3]);
            if(secondDimension == 0.0){
                throw new InvalidDimensionException();
            }
            return new Rectangle(id,firstDimension,secondDimension);
        }
    }
}
