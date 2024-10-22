package AV.AV2;

import java.util.Arrays;

public class MatrixOperations {
    public static double sum(double[][] a){
        double sum=0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                sum+=a[i][j];
            }
        }
        return sum;
    }
    public static double sumStream(double[][] a){
        return Arrays.stream(a).mapToDouble(row-> Arrays.stream(row).sum()).sum();
    }
    public static double average(double[][] a){
        if(a.length == 0){
            return 0;
        }
        double sum=0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                sum+=a[i][j];
            }
        }
        return sum/(a.length*a[0].length);
    }
    public static double averageStream(double[][] a){
        // solution 1
//        return Arrays.stream(a).flatMapToDouble(row-> Arrays.stream(row)).average().getAsDouble();
        //solution 2
        return Arrays.stream(a).mapToDouble(row-> Arrays.stream(row).average().getAsDouble()).average().getAsDouble();
    }

    public static void main(String[] args) {
        double[][] a={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        //sum = 45
        //average= 5
        System.out.println(sum(a));
        System.out.println(sumStream(a));
        System.out.println(average(a));
        System.out.println(averageStream(a));
    }
}
