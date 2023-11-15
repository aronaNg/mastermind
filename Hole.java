public class Hole extends Button {
    int row;
    int col;
    int color=0 ;

    public Hole(String type, int row, int col) {
        super(type);
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
