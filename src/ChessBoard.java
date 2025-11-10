public class ChessBoard {
    private Piece[][] board;

    public ChessBoard() {
        this.board = new Piece[8][8];
        setupBoard();
    }

    public void setupBoard() {

        // PAWNS
        for (int i = 0; i < 8; i++) {
            board[i][1] = new Pawn(i, 1, Colour.BLACK);  // black pawns setup
            board[i][6] = new Pawn(i, 6, Colour.WHITE);  // white pawns setup
        }

        // ROOKS
        board[0][0] = new Rook(0, 0, Colour.BLACK);
        board[7][0] = new Rook(7, 0, Colour.BLACK);
        board[0][7] = new Rook(0, 7, Colour.WHITE);
        board[7][7] = new Rook(7, 7, Colour.WHITE);

        // KNIGHTS
        board[1][0] = new Knight(1, 0, Colour.BLACK);
        board[6][0] = new Knight(6, 0, Colour.BLACK);
        board[1][7] = new Knight(1, 7, Colour.WHITE);
        board[6][7] = new Knight(6, 7, Colour.WHITE);

        // BISHOPS
        board[2][0] = new Bishop(2, 0, Colour.BLACK);
        board[5][0] = new Bishop(5, 0, Colour.BLACK);
        board[2][7] = new Bishop(2, 7, Colour.WHITE);
        board[5][7] = new Bishop(5, 7, Colour.WHITE);

        // QUEENS
        board[3][0] = new Queen(3, 0, Colour.BLACK);
        board[3][7] = new Queen(3, 7, Colour.WHITE);

        // KINGS
        board[4][0] = new King(4, 0, Colour.BLACK);
        board[4][7] = new King(4, 7, Colour.WHITE);
    }

    public Piece check_board(int i, int j) {
        if (i < 0 || i > 7 || j < 0 || j > 7) {
            throw new IllegalArgumentException("You are trying to check outside of the board.");
        }
        return board[i][j];
    }

    public boolean setPiece(Piece piece, int i, int j) {
        if (i < 0 || i > 7 || j < 0 || j > 7) {
            throw new IllegalArgumentException("You are setting a piece outside of the board.");
        }
        if (piece == null) {
            throw new IllegalArgumentException("You can't set a null piece.");
        }
        board[i][j] = piece;
        return true;
    }
}
