package PrvKolokviumVezbi.Risk_24;

import java.io.IOException;

public class RiskTester {
    public static void main(String[] args) {

        Risk risk = new Risk();

        try {
            System.out.println(risk.processAttacksData(System.in));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}