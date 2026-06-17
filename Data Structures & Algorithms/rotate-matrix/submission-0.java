class Solution {
    public void rotate(int[][] matrix) {
        // process row wise
        int n = matrix.length;
        for (int p = 0; p < n/2; p++) {
            for (int q = p; q<n-p-1; q++) {
                // temp becomes top
                // top becomes left
                // left becomes bottom
                // bottom becomes right
                // right becomes temp
                int top = matrix[p][q];
                int right = matrix[q][n-1-p];
                int bottom = matrix[n-1-p][n-1-q];
                int left = matrix[n-1-q][p];
                int temp = top;
                matrix[p][q] = left;
                matrix[n-1-q][p] = bottom;
                matrix[n-1-p][n-1-q] = right;
                matrix[q][n-1-p] = temp;
            }
        }
    }
}
