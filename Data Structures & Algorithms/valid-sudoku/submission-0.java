class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];

                if (val == '.') continue;

                if (!seen.add(val + " found in row " + r) ||
                   !seen.add(val + " found in col " + c) ||
                   !seen.add(val + " found in box " + (r / 3) + "-" + (c / 3))) {
                        return false;
                   }
            }
        }
        return true;
    }
}
