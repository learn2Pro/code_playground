/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package category.bsearch._200_300;

/**
 * 240. Search a 2D Matrix II
 */
public class _240_Solution_JAVA {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        if (M == 0) { return false; }
        int N = matrix[0].length;
        int p0 = 0, p1 = N - 1;
        while (p1 >= 0 && p0 < M) {
            if (matrix[p0][p1] == target) {
                return true;
            } else if (matrix[p0][p1] < target) {
                p0++;
            } else {
                p1--;
            }
        }
        return false;
    }
    //public boolean searchMatrix(int[][] matrix, int target) {
    //    int N = matrix.length;
    //    for (int i = 0; i < N; i++) {
    //        if (Arrays.binarySearch(matrix[i], target) >= 0) { return true; }
    //    }
    //    return false;
    //}
}