public class Bishop extends Piece {
    private Colour colour;

    public Bishop(int x, int y, Colour colour){
        super(x,y,colour,3);
    }

    @Override
    public boolean valid_move(ChessBoard board, int x_destination, int y_destination) {
        byte deltaX = (byte) (this.getX() - x_destination);
        return Math.abs(this.getX() - x_destination) == Math.abs(this.getY() - y_destination) && deltaX != 0;
    }

    @Override
    public boolean move_piece_to(ChessBoard board, int x_destination, int y_destination) {
        return false;
    }

}
