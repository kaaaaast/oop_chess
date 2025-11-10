public class ChessBoard {
    private Piece[][] board;

    public ChessBoard(){
        this.board = new Piece[8][8];
        setupBoard();
    }

    public void setupBoard() {

        // PAWNS

        for (int i = 0; i < board.length; i++) {
            board[i][1] = new Pawn(i,1,Colour.BLACK);
            board[i][6] = new Pawn(i,6,Colour.WHITE);
        }

        // KNIGHTS

        board[0][1] = new Knight(0,1,Colour.BLACK);
        board[0][6] = new Knight(0,6,Colour.BLACK);
        board[7][1] = new Knight(1,6,Colour.WHITE);
        board[7][6] = new Knight(7,6,Colour.WHITE);

        // ROOKS

        board[0][0] = new Rook(0,0,Colour.BLACK);
        board[0][7] = new Rook(0,7,Colour.BLACK);
        board[7][0] = new Rook(7,0,Colour.WHITE);
        board[7][7] = new Rook(7,7,Colour.WHITE);

        // BISHOPS

        board[0][2] = new Bishop(0,2,Colour.BLACK);
        board[0][5] = new Bishop(0,5,Colour.BLACK);
        board[7][2] = new Bishop(7,2,Colour.WHITE);
        board[7][6] = new Bishop(7,6,Colour.WHITE);

        // QUEENS

        board[7][3] = new Queen(7,3,Colour.WHITE);
        board[0][3] = new Queen(0,3,Colour.BLACK);

        // KINGS

        board[7][4] = new King(7,4,Colour.WHITE);
        board[0][4] = new King(0,4,Colour.BLACK);
    }

    public Piece check_board(int i, int j) {
        if (i < 1 || i > 8 || j < 1 || j > 8) {
            throw new IllegalArgumentException("You are trying to check outside of the board.");
        }
        return board[i][j];
    }

    public boolean setPiece(Piece piece, int i, int j){
        if (i < 1 || i > 8 || j < 1 || j > 8){
            throw new IllegalArgumentException("You are setting a piece outside of the board.");
        }
        if (piece == null) {
            throw new IllegalArgumentException("You can't set a null piece.");
        }
        board[i][j] = piece;
        return true;
    }
}
