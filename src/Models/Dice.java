package Models;

import java.util.Random;

public class Dice {
    private int numSides;
    private int currentSide;

    public Dice(int numSides){
        this.numSides = numSides;
        roll();
    }

    private void roll(){
        Random rand = new Random();
        this.currentSide = rand.nextInt(this.numSides)+1;
    }

    public int getCurrentSide(){
        return this.currentSide;
    }

    public int rollTheDice(){
        roll();
        return getCurrentSide();
    }
}
