package models;

public class    Board {
    int[][] board;
    int[] colCount;

    public Board() {
        board = new int[6][7];
        colCount = new int[7];
    }

    public void printBoard() {
        for (int i=0; i<6; i++) {
            for (int j=0; j<7; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public int move(int col, int player) {
        if (col < 0 || col > 6)
            return -1;

        if (colCount[col] >= 6) {
            System.out.println("Column already filled!!");
            return -1;
        }
        int insertedRow = 0;
        for (int r=5; r>=0; r--) {
            if (board[r][col] == 0) {
                board[r][col] = player;
                colCount[col]++;
                insertedRow = r;
                break;
            }
        }
        return insertedRow;
    }

    public int checkWinner(int row, int col, int player) {
        int right = col+1;
        int left = col-1;
        int validCols = 0;
        while (right < 7 && board[row][right] == player) {
            right++;
            validCols++;
        }
        while (left >= 0 && board[row][left] == player) {
            left--;
            validCols++;
        }
        if (validCols >= 3)
            return 1;

        int top = row-1;
        int down = row+1;
        int validRows = 0;
        while (top >= 0 && board[top][col] == player) {
            top--;
            validRows++;
        }
        while (down < 6 && board[down][col] == player) {
            down++;
            validRows++;
        }
        if (validRows >= 3)
            return 1;

        right = col+1;
        left = col-1;
        top = row-1;
        down = row+1;
        int validDiag = 0;
        while (right < 7 && top >= 0 && board[top][right] == player) {
            right++;
            top--;
            validDiag++;
        }
        while (left >= 0 && down < 6 && board[down][left] == player) {
            left--;
            down++;
            validDiag++;
        }
        if (validDiag >= 3)
            return 1;

        right = col+1;
        left = col-1;
        top = row-1;
        down = row+1;
        validDiag = 0;
        while (top >= 0 && left >= 0 && board[top][left] == player) {
            top--;
            left--;
            validDiag++;
        }
        while (right < 7 && down < 6 && board[down][right] == player) {
            right++;
            down++;
            validDiag++;
        }
        if (validDiag >= 3)
            return 1;
        return -1;
    }
}
