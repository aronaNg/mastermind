public class Pawn extends Button {
    String color;

    public Pawn(String type, String color) {
        super(type);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
