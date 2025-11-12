public class King extends Piece{
    private Colour colour;
    private boolean has_moved;

    public King(int x, int y, Colour colour) {
        super(x,y,colour, 0);
        has_moved = false;
    }

    @Override
    public boolean isPathReachable(ChessBoard board, int x_destination, int y_destination) {
        if (!super.isPathReachable(board, x_destination, y_destination)) {
            return false;
        }
        return !would_be_check(board, x_destination, y_destination);
    }

    public boolean valid_capture (ChessBoard board, int x_destination, int y_destination) {
        return valid_move(board, x_destination, y_destination);
    }

    public boolean would_be_check (ChessBoard board, int x_destination, int y_destination) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.getPiece(i,j) != null && board.getPiece(i,j).getColour() != board.getPiece(x_destination,y_destination).getColour()) {
                    Piece potentialAttacker = board.getPiece(i,j);
                    if (potentialAttacker.valid_capture(board,x_destination,y_destination)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean valid_move (ChessBoard board, int x_destination, int y_destination) {
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
