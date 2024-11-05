package PrvKolokviumVezbi.Risk_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Risk {
    public int processAttacksData(InputStream is) throws IOException {
        try(BufferedReader reader=new BufferedReader(new InputStreamReader(is))){
            int totalAttack=0;
            String line;
            while ((line= reader.readLine())!=null){
                String[] turns=line.split(";");
                int[] sortedAttacks= Arrays.stream(turns[0].split(" ")).mapToInt(Integer::parseInt).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
                int[] sortedDefences= Arrays.stream(turns[1].split(" ")).mapToInt(Integer::parseInt).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
                boolean isSuccessfulAttack=true;
                for (int i = 0; i < sortedAttacks.length; i++) {
                    if(sortedAttacks[i]<=sortedDefences[i]){
                        isSuccessfulAttack=false;
                        break;
                    }
                }
                if(isSuccessfulAttack){
                    totalAttack++;
                }

            }
            return totalAttack;
        }
    }
}
