package application.model.dice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Die {
    private final DieColor color;
    private final List<DieFace> faces;

    public Die(DieColor color) {
        this.color = color;
        faces = new ArrayList<>();

        for(int i = 0; i < color.getBrainCount(); i++){
            faces.add(DieFace.BRAIN);
        }

        for(int i = 0; i < color.getGunCount(); i++){
            faces.add(DieFace.GUN);
        }

        for(int i = 0; i < color.getPrintsCount(); i++){
            faces.add(DieFace.PRINTS);
        }
    }

    public DieFace getRandomFace(){
        return faces.get(ThreadLocalRandom.current().nextInt(faces.size()));
    }

    public DieColor getColor() {
        return color;
    }
}