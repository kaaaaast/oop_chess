public class Pawn extends Piece {

    private boolean has_moved;
    private boolean is_promoted;

    public Pawn(int x, int y, Colour colour, boolean has_moved) {
        super(x,y,colour,1);
        this.has_moved = false;
        this.is_promoted = false;
    }

    @Override
    public boolean valid_move(int i, int j) {
        if (has_moved) {
            if (j != this.getY() + 1 && j != this.getY() + 2){
                throw new IllegalArgumentException("Pawn can either move 1 square or 2 squares as its first move.");
            }
        }
        else {
            if (j != this.getY() + 1 && i != this.getX()){
                throw new IllegalArgumentException("Pawn can only move 1 square forward.");
            }
        }
        return true;
    }

    @Override
    public boolean move_piece_to(int i, int j){
        this.setX(i);
        this.setY(j);
        if (j == 8){
            this.is_promoted = true;
        }
        if (!has_moved){
            has_moved = true;
        }
        return true;
    }

    @Override
    public boolean valid_capture(int i, int j) {
        if (i != this.getX() - 1 && i != this.getX() + 1 && j != this.getY() + 1) {
            return false;
        }
        return true;
    }

    public void promote(PromotionPiece choice) {
        is_promoted = false;
    }

}
