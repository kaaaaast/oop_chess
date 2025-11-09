public class Knight extends Piece {

    private Colour colour;

    public Knight(int x, int y, Colour colour){
        super(x,y,colour,3);
    }

    @Override
    public boolean valid_move(int x_destination, int y_destination) {
        return (Math.abs(x_destination - this.getX()) == 2 && Math.abs(y_destination - this.getY()) == 1) ||
               (Math.abs(x_destination - this.getX()) == 1 && Math.abs(y_destination - this.getY()) == 2);
    }

    @Override
    public boolean move_piece_to(int x_destination, int y_destination) {
        return false;
    }

    @Override
    public boolean valid_capture(int x_destination, int y_destination) {
        return false;
    }
}
