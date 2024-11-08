package Labs.Lab2.DoubleMatrix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class DoubleMatrix {
    private double[][] matrix;

    public DoubleMatrix(double[] a, int m, int n) throws InsufficientElementsException {
        if (a.length < m * n) {
            throw new InsufficientElementsException();
        }
        if(a.length>m*n){
            a=Arrays.copyOfRange(a,a.length-m*n,a.length);
        }
        matrix = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = a[n * i + j];
            }
        }
    }

    public String getDimensions() {
        if (matrix.length == 0) {
            return "[0 x 0]";
        }
        return String.format("[%d x %d]", matrix.length, matrix[0].length);
    }

    public int rows() {
        return matrix.length;
    }

    public int columns() {
        if (matrix.length == 0) {
            return 0;
        }
        return matrix[0].length;
    }

    public double maxElementAtRow(int row) throws InvalidRowNumberException {
        if(row<=0){
            throw new InvalidRowNumberException();
        }
        if (matrix.length <= row - 1) {
            throw new InvalidRowNumberException();
        }
        return Arrays.stream(matrix[row - 1]).max().orElse(0);
    }

    public double maxElementAtColumn(int column) throws InvalidColumnNumberException {
        if(column<=0){
            throw new InvalidColumnNumberException();
        }
        if (matrix.length == 0) {
            throw new InvalidColumnNumberException();
        }
        if (matrix[0].length <= column - 1) {
            throw new InvalidColumnNumberException();
        }
        return Arrays.stream(matrix).mapToDouble(row -> row[column - 1]).max().orElse(0);
    }

    public double sum() {
        return Arrays.stream(matrix).mapToDouble(row -> Arrays.stream(row).sum()).sum();
    }

    public double[] toSortedArray() {
        return Arrays.stream(matrix).flatMapToDouble(Arrays::stream).boxed().sorted(Comparator.reverseOrder()).mapToDouble(Double::doubleValue).toArray();
    }

    @Override
    public String toString() {
        StringBuilder matrixBuilder = new StringBuilder();
        for (double[] row : matrix) {
            StringBuilder rowBuilder = new StringBuilder();
            for (double cell : row) {
                rowBuilder.append(String.format("%.2f", cell)).append("\t");
            }
            if (rowBuilder.length() != 0) {
                rowBuilder.deleteCharAt(rowBuilder.length() - 1);
            }
            matrixBuilder.append(rowBuilder.toString()).append("\n");
        }
        matrixBuilder.deleteCharAt(matrixBuilder.length()-1);
        return matrixBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleMatrix that = (DoubleMatrix) o;
        return Objects.deepEquals(matrix, that.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(matrix);
    }
}
