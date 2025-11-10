public abstract class Piece {

    private int x;
    private int y;
    private Colour colour;
    private int piece_value;

    public Piece(int x, int y, Colour colour, int piece_value){
        if (x < 1 || x > 8 || y < 1 || y > 8) {
            throw new IllegalArgumentException("Both coordinates must be between 1 and 8");
        }
        this.x = x;
        this.y = y;
        this.colour = colour;
        this.piece_value = piece_value;
    }

    public abstract boolean valid_move     (ChessBoard board, int x_destination, int y_destination);
    public abstract boolean move_piece_to  (ChessBoard board, int x_destination, int y_destination);

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public Colour getColour() {
        return colour;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
}

