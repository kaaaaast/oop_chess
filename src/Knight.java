public class Knight extends Piece {

    private Colour colour;


    public Knight(int x, int y, Colour colour){
        super(x,y,colour,3);
    }

    @Override
    public boolean valid_move(ChessBoard board, int i, int j) {

        if (!check_coords(i,j)){
            return false;
        }

        if (!((Math.abs(i - this.getX()) == 2 && Math.abs(j - this.getY()) == 1) ||
               (Math.abs(i - this.getX()) == 1 && Math.abs(j - this.getY()) == 2))) {
            return false;
        }

        return isThisAttacking(board, i, j);

    }

    @Override
    public boolean move_piece_to(ChessBoard board, int i, int j) {
        if (!valid_move(board,i,j)){
            return false;
        }
        board.setPiece(this,i,j);
        board.removePiece(this,this.getX(),this.getY());
        this.setX(i);
        this.setY(j);
        return true;
    }

    @Override
    public boolean valid_capture(ChessBoard board, int x_destination, int y_destination) {
        return valid_move(board, x_destination, y_destination);
    }

}
