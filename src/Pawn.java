public class Pawn extends Piece {

    private boolean has_moved;
    private boolean is_promoted;

    public Pawn(int x, int y, Colour colour) {
        super(x,y,colour,1);
        has_moved = false;
        is_promoted = false;
    }

    public boolean valid_move(ChessBoard board, int i, int j) {
        if (!check_coords(i, j)) {
            return false;
        }

        int dx = i - this.getX();
        int dy = j - this.getY();

        int direction = (this.getColour() == Colour.WHITE) ? -1 : 1;

        if (dx == 0 && dy == direction) {
            return board.getPiece(i, j) == null;
        }

        if (!has_moved && dx == 0 && dy == 2 * direction) {
            int midY = this.getY() + direction;
            return board.getPiece(i, midY) == null && board.getPiece(i, j) == null;
        }

        if (Math.abs(dx) == 1 && dy == direction) {
            return board.getPiece(i, j) != null &&
                    board.getPiece(i, j).getColour() != this.getColour();
        }

        return false;
    }


    @Override
    public boolean move_piece_to(ChessBoard board, int i, int j){
        if (!valid_move(board,i,j)) {
            return false;
        }
        else {
            board.setPiece(this,i,j);
            board.removePiece(this,this.getX(),this.getY());
            this.setX(i);
            this.setY(j);
            this.set_hasMoved();
            return true;
        }
    }

    @Override
    public boolean valid_capture(ChessBoard board, int i, int j) {
        return false;
    }

    public boolean capture_piece(ChessBoard board, int i, int j){
        return false;
    }

    public void set_hasMoved() {
        this.has_moved = true;
    }

    public void promote(PromotionPiece choice) {
        is_promoted = false;
    }

}
