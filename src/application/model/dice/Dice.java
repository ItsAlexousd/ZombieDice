package application.model.dice;

public class Dice {
    private final DiceColor color;
    private final DiceFace face;

    public Dice(DiceColor color, DiceFace face) {
        this.color = color;
        this.face = face;
    }

    public DiceColor getColor() {
        return color;
    }

    public DiceFace getFace() {
        return face;
    }
}