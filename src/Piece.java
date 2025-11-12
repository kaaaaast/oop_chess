public abstract class Piece {

    private int x;
    private int y;
    private Colour colour;
    private int piece_value;

    public Piece(int x, int y, Colour colour, int piece_value){
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new IllegalArgumentException("Both coordinates must be between 1 and 8");
        }
        this.x = x;
        this.y = y;
        this.colour = colour;
        this.piece_value = piece_value;
    }

    public abstract boolean valid_move     (ChessBoard board, int x_destination, int y_destination);
    public abstract boolean move_piece_to  (ChessBoard board, int x_destination, int y_destination);
    public abstract boolean valid_capture  (ChessBoard board, int x_destination, int y_destination);



    public boolean check_coords(int x, int y) {
        return x >= 0 && x <= 7 && y >= 0 && y <= 7;
    }

    public boolean isPathReachable(ChessBoard board, int x, int y) {

        int xStepping = this.getX();
        int yStepping = this.getY();
        int dx = Integer.compare(x, xStepping);
        int dy = Integer.compare(y, yStepping);

        while (true) {

            xStepping += dx;
            yStepping += dy;

            if (xStepping == x && yStepping == y) {
                break;
            }
            if (board.getPiece(xStepping, yStepping) != null) {
                return false;
            }
        }
        return true;
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

