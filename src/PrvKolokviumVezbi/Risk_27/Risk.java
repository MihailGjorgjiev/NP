package PrvKolokviumVezbi.Risk_27;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Risk {

    public void processAttacksData(InputStream is) throws IOException {
        List<Integer> attackerSurvivors = new ArrayList<>();
        List<Integer> defenderSurvivors = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int totalAttackersSurvived = 0;
                String[] turns = line.split(";");
                int[] attacker = Arrays.stream(turns[0].split(" ")).mapToInt(Integer::parseInt).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
                int[] defender = Arrays.stream(turns[1].split(" ")).mapToInt(Integer::parseInt).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();

                for (int i = 0; i < attacker.length; i++) {
                    if (attacker[i] > defender[i]) {
                        totalAttackersSurvived++;
                    }
                }
                attackerSurvivors.add(totalAttackersSurvived);
                defenderSurvivors.add(attacker.length - totalAttackersSurvived);
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int i = 0; i < attackerSurvivors.size(); i++) {
                writer.write(String.format("%d %d\n", attackerSurvivors.get(i), defenderSurvivors.get(i)));
            }
        }
    }
}
