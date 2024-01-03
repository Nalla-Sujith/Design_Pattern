package Tic_Tac_Toe;

public class Board {
    int size;
    PlayingPiece arr[][];

    Board(int size) {
        this.size = size;
        arr = new PlayingPiece[size][size];
    }

    void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[i][j] == null)
                    System.out.print("  |");
                else
                    System.out.print(arr[i][j].ptype.toString() + " |");
            }
            System.out.println();
        }
    }

    boolean addPiece(int x, int y, PlayingPiece piece) {
        if (arr[x][y] != null)
            return false;
        arr[x][y] = piece;
        return true;
    }

    boolean isGameCompleted(int x, int y, PlayingPiece piece) {

        boolean rowcheck = true, colcheck = true, diagonalcheck = true, antidiagonalcheck = true;
        // row check
        for (int i = 0; i < size; i++) {
            if (arr[x][i] == null || arr[x][i].ptype != piece.ptype) {
                rowcheck = false;
                break;
            }
        }

        // column check
        for (int i = 0; i < size; i++) {
            if (arr[i][y] == null || arr[i][y].ptype != piece.ptype) {
                colcheck = false;
                break;
            }
        }

        // left top to right bottom diagonal check
        int i = 0, j = 0;
        while (i < size && j < size) {
            if (arr[i][j] == null || arr[i][j].ptype != piece.ptype) {
                diagonalcheck = false;
                break;
            }
            i++;
            j++;
        }

        // right top to left bottom anti-diagonal check
        i = 0;
        j = size - 1;
        while (i < size && j < size) {
            if (arr[i][j] == null || arr[i][j].ptype != piece.ptype) {
                antidiagonalcheck = false;
                break;
            }
            i++;
            j--;
        }

        return rowcheck || colcheck || diagonalcheck || antidiagonalcheck;
    }

    boolean isBoardFilled() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[i][j] == null)
                    return false;
            }
        }
        return true;
    }
}
