public class Rook extends Piece {
    private Colour colour;
    private boolean has_moved;

    public Rook(int x, int y, Colour colour){
        super(x,y,colour,5);
        has_moved = false;
    }

    @Override
    public boolean valid_move(ChessBoard board, int i, int j) {
        return (((i - this.getX() == 0) && (j - this.getY() != 0)) ||
                ((j - this.getY() == 0) && (i - this.getX() != 0))) &&
                (board.check_board(i,j) != null);
    }

    @Override
    public boolean move_piece_to(ChessBoard board, int i, int j) {
         return false;
    }
}
