public class King extends Piece{
    private Colour colour;
    private boolean has_moved;

    public King(int x, int y, Colour colour) {
        super(x,y,colour, 0);
        has_moved = false;
    }


    @Override
    public boolean valid_move(ChessBoard board, int x_destination, int y_destination) {
        return false;
    }

    @Override
    public boolean move_piece_to(ChessBoard board, int x_destination, int y_destination) {
        return false;
    }
}
