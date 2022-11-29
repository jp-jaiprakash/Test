package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumNumberOfPasses {


    // O( W * h) time | O(W * h) space - where w is
    // width of the matrix and h is the height
    public int minimumPassesOfMatrix(int[][] matrix) {
        // Write your code here.
        Queue<Integer[]> queue1 = new LinkedList<>();
        Queue<Integer[]> queue2 = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > 0)
                    queue1.add(new Integer[]{i, j});
            }
        }

        if (queue1.isEmpty())
            return -1;

        int cnt = calculatePasses(queue1, queue2, 0, matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < 0)
                    return -1;
            }
        }

        return cnt - 1;
    }

    public int calculatePasses(Queue<Integer[]> queue1, Queue<Integer[]> queue2, int cnt, int[][] matrix) {
        if (queue1.isEmpty() && queue2.isEmpty())
            return cnt;

        while (!queue1.isEmpty()) {
            Integer[] points = queue1.poll();
            markit(points[0], points[1], queue1, queue2, matrix);

        }
        cnt++;

        cnt = calculatePasses(queue2, queue1, cnt, matrix);
        return cnt;
    }

    public void markit(Integer i, Integer j, Queue<Integer[]> queue1, Queue<Integer[]> queue2, int[][] matrix) {
        if (i > 0 && matrix[i - 1][j] < 0) {
            matrix[i - 1][j] = matrix[i - 1][j] * -1;
            queue2.add(new Integer[]{i - 1, j});
        }

        if (i < matrix.length - 1 && matrix[i + 1][j] < 0) {
            queue2.add(new Integer[]{i + 1, j});
            matrix[i + 1][j] = matrix[i + 1][j] * -1;
        }

        if (j > 0 && matrix[i][j - 1] < 0) {
            queue2.add(new Integer[]{i, j - 1});
            matrix[i][j - 1] = matrix[i][j - 1] * -1;
        }

        if (j < matrix[0].length - 1 && matrix[i][j + 1] < 0) {
            queue2.add(new Integer[]{i, j + 1});
            matrix[i][j + 1] = matrix[i][j + 1] * -1;
        }


    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 0, 0, -2, -3},
                {-4, -5, -6, -2, -1},
                {0, 0, 0, 0, -1},
                {1, 2, 3, 0, 3}
        };

        MinimumNumberOfPasses m = new MinimumNumberOfPasses();
        System.out.println(m.minimumPassesOfMatrix(matrix));
    }
}
