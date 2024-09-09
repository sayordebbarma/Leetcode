/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }

        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {1, 0, -1, 0};
        int x = 0, y = 0, dir = 0;
        ListNode curr = head;

        for (int i = 0; i < m * n && curr != null; i++) {
            matrix[x][y] = curr.val;
            curr = curr.next;

            int nextX = x + dirX[dir];
            int nextY = y + dirY[dir];

            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || matrix[nextX][nextY] != -1) {
                dir = (dir + 1) % 4;
                nextX = x + dirX[dir];
                nextY = y + dirY[dir];
            }

            x = nextX;
            y = nextY;
        }

        return matrix;
    }
}
