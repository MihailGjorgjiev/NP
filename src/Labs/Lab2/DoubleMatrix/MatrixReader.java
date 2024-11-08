package Labs.Lab2.DoubleMatrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MatrixReader {
    public static DoubleMatrix read(InputStream input) throws IOException, InsufficientElementsException {
        try(BufferedReader reader=new BufferedReader(new InputStreamReader(input))){

            String line= reader.readLine();
            String[] dims=line.split("\\s+");
            int m= Integer.parseInt(dims[0]);
            int n= Integer.parseInt(dims[1]);
            double[] a=new double[m*n];
            int numElems=0;
            while (true){
                String[] elems=reader.readLine().split("\\s+");
                for (int i = 0; i < elems.length && numElems<=m*n; i++,numElems++) {
                    a[numElems]= Double.parseDouble(elems[i]);
                }

                if(numElems>= m*n){
                    break;
                }
            }
            return new DoubleMatrix(a,m,n);
        }

    }
}
