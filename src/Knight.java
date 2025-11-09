public class Knight extends Piece {

    private Colour colour;


    public Knight(int x, int y, Colour colour){
        super(x,y,colour,3);
    }

    @Override
    public boolean valid_move(ChessBoard board, int i, int j) {
        return ((Math.abs(i - this.getX()) == 2 && Math.abs(j - this.getY()) == 1) ||
               (Math.abs(i - this.getX()) == 1 && Math.abs(j - this.getY()) == 2)) &&
               (board.check_board(i,j) != null);
    }

    @Override
    public boolean move_piece_to(ChessBoard board, int i, int j) {
        return false;
    }

    @Override
    public boolean valid_capture(ChessBoard board, int i, int j) {
        return false;
    }
}
