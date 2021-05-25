package application.model.dice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private final DiceColor color;
    private final List<DiceFace> faces;

    public Dice(DiceColor color) {
        this.color = color;
        faces = new ArrayList<>();

        for(int i = 0; i < color.getBrainCount(); i++){
            faces.add(DiceFace.BRAIN);
        }

        for(int i = 0; i < color.getGunCount(); i++){
            faces.add(DiceFace.GUN);
        }

        for(int i = 0; i < color.getPrintsCount(); i++){
            faces.add(DiceFace.PRINTS);
        }
    }

    public DiceFace getRandomFace(){
        return faces.get(ThreadLocalRandom.current().nextInt(faces.size()));
    }

    public DiceColor getColor() {
        return color;
    }
}