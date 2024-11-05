package PrvKolokviumVezbi.LoadedCoin_18;

import java.util.Random;

public class LoadedCoin extends Coin {
    private int probability;

    public LoadedCoin(int probability) {
        this.probability = probability;
    }

    @Override
    public SIDE flip() {
        Random random=new Random();
        int chance= random.nextInt(101);
        if(chance<probability){
            return SIDE.HEAD;
        }else {
            return SIDE.TAIL;
        }
    }
}
