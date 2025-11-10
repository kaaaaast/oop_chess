public class Queen extends Piece {
    private Colour colour;

    public Queen(int x, int y, Colour colour) {
        super(x,y,colour,9);
    }


    @Override
    public boolean valid_move(ChessBoard board, int x_destination, int y_destination) {
        int deltaX = this.getX() - x_destination;
        int deltaY = this.getY() - y_destination;

        boolean rookMovement = rookMovement(deltaX,deltaY);
        boolean bishopMovement = bishopMovement(deltaX,deltaY);

        return rookMovement || bishopMovement;
    }

    public boolean rookMovement(int x, int y) {
        return (x == 0 && y != 0) || (y == 0 && x != 0);
    }

    public boolean bishopMovement(int x, int y) {
        return Math.abs(x) == Math.abs(y) && x != 0;
    }
    @Override
    public boolean move_piece_to(ChessBoard board, int x_destination, int y_destination) {
        return false;
    }
}
