public class Bishop extends Piece {
    private Colour colour;

    public Bishop(int x, int y, Colour colour){
        super(x,y,colour,3);
    }

    @Override
    public boolean valid_move(ChessBoard board, int x_destination, int y_destination) {
        if (!check_coords(x_destination, y_destination)) {
            return false;
        }
        if (!isPathReachable(board, x_destination, y_destination)) {
            return false;
        }
        byte deltaX = (byte) (this.getX() - x_destination);
        if (!(Math.abs(this.getX() - x_destination) == Math.abs(this.getY() - y_destination) && deltaX != 0)) {
            return false;
        }
        return isThisAttacking(board, x_destination, y_destination);
    }

    public boolean valid_capture(ChessBoard board, int x_destination, int y_destination) {
        return valid_move(board, x_destination, y_destination);
    }

    @Override
    public boolean move_piece_to(ChessBoard board, int x_destination, int y_destination) {
        if (!valid_move(board,x_destination,y_destination)){
            return false;
        }
        board.setPiece(this,x_destination,y_destination);
        board.removePiece(this,this.getX(),this.getY());
        this.setX(x_destination);
        this.setY(y_destination);
        return true;
    }

}
