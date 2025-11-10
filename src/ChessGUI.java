import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessGUI {

    private JFrame frame;
    private JButton[][] buttons;
    private ChessBoard board;

    private int selectedX = -1;
    private int selectedY = -1;

    public ChessGUI() {
        board = new ChessBoard();
        frame = new JFrame("Chess Test GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);

        JPanel panel = new JPanel(new GridLayout(8,8));
        buttons = new JButton[8][8];

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                JButton btn = new JButton();
                btn.setFont(new Font("Arial", Font.BOLD, 20));

                final int fx = x;
                final int fy = y;

                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        onSquareClick(fx, fy);
                    }
                });

                buttons[x][y] = btn;
                panel.add(btn);
            }
        }

        frame.add(panel);
        frame.setVisible(true);
        refreshBoard();
    }

    private void onSquareClick(int x, int y) {
        if (selectedX == -1 && selectedY == -1) {
            Piece p = board.check_board(x, y);
            if (p != null) {
                selectedX = x;
                selectedY = y;
            }
        } else {
            Piece p = board.check_board(selectedX, selectedY);
            if (p != null) {
                try {
                    p.move_piece_to(board, x, y);
                } catch (Exception ignored) {}
            }
            selectedX = -1;
            selectedY = -1;
            refreshBoard();
        }
    }

    private void refreshBoard() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Piece p = null;
                try {
                    p = board.check_board(x, y);
                } catch (Exception ignored) {}

                if (p == null) {
                    buttons[x][y].setText("");
                } else {
                    buttons[x][y].setText(pieceSymbol(p));
                }
            }
        }
    }

    private String pieceSymbol(Piece p) {
        if (p instanceof Pawn) return "P";
        if (p instanceof Rook) return "R";
        if (p instanceof Knight) return "N";
        if (p instanceof Bishop) return "B";
        if (p instanceof Queen) return "Q";
        if (p instanceof King) return "K";
        return "?";
    }

    public static void main(String[] args) {
        new ChessGUI();
    }
}
