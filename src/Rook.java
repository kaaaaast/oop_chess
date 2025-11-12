public class Rook extends Piece {
    private Colour colour;
    private boolean has_moved;

    public Rook(int x, int y, Colour colour){
        super(x,y,colour,5);
        has_moved = false;
    }

    @Override
    public boolean valid_move(ChessBoard board, int i, int j) {
        if (!check_coords(i,j)){
            return false;
        }
        if (!isPathReachable(board,i,j)){
            return false;
        }
        if (!((i == this.getX() && j != this.getY()) || (j == this.getY() && i != this.getX()))) {
            return false;
        }
        Piece attacked = board.getPiece(i,j);
        if (attacked == null) {
            return true;
        }
        else return attacked.getColour() != this.getColour();
    }

    public boolean valid_capture(ChessBoard board, int x_destination, int y_destination) {
        return valid_move(board, x_destination, y_destination);
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
         this.setHas_moved();
         return true;
    }

    public void setHas_moved() {
        this.has_moved = true;
    }
}
