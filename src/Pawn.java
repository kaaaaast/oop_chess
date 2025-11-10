public class Pawn extends Piece {

    private boolean has_moved;
    private boolean is_promoted;

    public Pawn(int x, int y, Colour colour) {
        super(x,y,colour,1);
        has_moved = false;
        is_promoted = false;
    }

    @Override
    public boolean valid_move(ChessBoard board, int i, int j) {
        if (!has_moved) {
            if ((j != this.getY() + 1 && j != this.getY() + 2)){
                throw new IllegalArgumentException("Pawn can either move 1 square or 2 squares, as its first move.");
            }
        }
        else {
            if (j != this.getY() + 1 && i != this.getX()){
                throw new IllegalArgumentException("Pawn can only move 1 square forward.");
            }
            if (board.check_board(i,j) != null) {
                throw new IllegalArgumentException("Destination square is occupied");
            }
        }
        return true;
    }

    @Override
    public boolean move_piece_to(ChessBoard board, int i, int j){

        if (!(valid_move(board,i,j))){
            return false;
        }

        this.setX(i);
        this.setY(j);
        board.setPiece(this,i+1,j);

        if (j == 8){
            is_promoted = true;
        }
        if (!has_moved){
            has_moved = true;
        }
        return true;
    }

    public boolean valid_capture(ChessBoard board, int i, int j) {
        if (i != this.getX() - 1 && i != this.getX() + 1 && j != this.getY() + 1) {
            return false;
        }
        else return board.check_board(i + 1, j + 1) != null || (board.check_board(i + 1, j - 1) != null);
    }

    public boolean capture_piece(ChessBoard board, int i, int j){
        if (!(valid_capture(board,i,j))){
            return false;
        }
        return true;
    }

    public void promote(PromotionPiece choice) {
        is_promoted = false;
    }

}
