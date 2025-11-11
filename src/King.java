public class King extends Piece{
    private Colour colour;
    private boolean has_moved;

    public King(int x, int y, Colour colour) {
        super(x,y,colour, 0);
        has_moved = false;
    }

    @Override
    public boolean isPathReachable(ChessBoard board, int x_destination, int y_destination) {
        super.isPathReachable(board, x_destination,y_destination);
        //implement illegal stepping in checks
        return false;
    }

    @Override
    public boolean valid_move(ChessBoard board, int x_destination, int y_destination) {
        if (!valid_move(board,x_destination,y_destination)){
            return false;
        }
        if (!isPathReachable(board,x_destination,y_destination)){
            return false;
        }
        if (Math.abs(x_destination - this.getX()) > 1 || Math.abs(y_destination - this.getY()) > 1) {
            return false;
        }
        return true;
    }

    @Override
    public boolean move_piece_to(ChessBoard board, int x_destination, int y_destination) {
        return false;
    }
}
