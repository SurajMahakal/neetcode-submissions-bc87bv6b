class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        int row = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (matrix[mid][0] <= target && matrix[mid][matrix[mid].length - 1] >= target) {
              row = mid;
              break;  
            } else if (matrix[mid][0] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (row == -1) return false;

        int[] targetRow = matrix[row];
        int l = 0;
        int r = targetRow.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (targetRow[mid] == target) {
                return true;
            } else if (targetRow[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
}
