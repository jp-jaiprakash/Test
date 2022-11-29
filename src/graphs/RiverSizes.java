package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RiverSizes {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
                };

        System.out.println(riverSizesCorrect(matrix));
    }

    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        List<Integer> answer = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = 0;
                    cnt = calculate(i, j, matrix, cnt);
                    cnt++;
                    answer.add(cnt);
                    cnt = 0;
                }
            }
        }
        return answer;
    }

    public static int calculate(int i, int j, int[][] matrix, int cnt) {
        if (i < 0 || i > matrix[0].length || j < 0 || j >= matrix[0].length || matrix[i][j] == 0) {
            return cnt;
        }
        if (i >= 0 && j < matrix[0].length && matrix[i][j] == 1) {
            cnt++;
            calculate(i + 1, j, matrix, cnt);
            calculate(i, j + 1, matrix, cnt);
            calculate(i, j - 1, matrix, cnt);
            calculate(i - 1, j, matrix, cnt);
        }
        return cnt;

    }

    public static List<Integer> riverSizesCorrect(int[][] matrix) {
        List<Integer> sizes = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visited[i][j])
                    continue;

                traverseNode(i, j, matrix, visited, sizes);
            }
        }
        return sizes;
    }

    private static void traverseNode(int i, int j, int[][] matrix, boolean[][] visited, List<Integer> sizes) {

        int currentRiverSize = 0;
        Stack<Integer[]> nodesToExplore = new Stack<>();

        nodesToExplore.push(new Integer[]{i, j});

        while (!nodesToExplore.empty()) {
            Integer[] currentNode = nodesToExplore.pop();
            i = currentNode[0];
            j = currentNode[1];

            if (visited[i][j])
                continue;

            visited[i][j] = true;

            if (matrix[i][j] == 0)
                continue;

            currentRiverSize++;
            List<Integer[]> unVisitedNeighbours = getUnvisitedNeighbors(i, j, matrix, visited);

            for (Integer[] neighbor : unVisitedNeighbours) {
                nodesToExplore.add(neighbor);
            }


        }
        if (currentRiverSize > 0)
            sizes.add(currentRiverSize);
    }

    private static List<Integer[]> getUnvisitedNeighbors(int i, int j, int[][] matrix, boolean[][] visited) {
        List<Integer[]> unVisitedNeighbors = new ArrayList<>();
        if (i > 0 && !visited[i - 1][j])
            unVisitedNeighbors.add(new Integer[]{i - 1, j});

        if (j > 0 && !visited[i][j - 1])
            unVisitedNeighbors.add(new Integer[]{i, j - 1});

        if (j < matrix[0].length - 1 && !visited[i][j + 1])
            unVisitedNeighbors.add(new Integer[]{i, j + 1});

        if (i < matrix.length - 1 && !visited[i + 1][j])
            unVisitedNeighbors.add(new Integer[]{i + 1, j});

        return unVisitedNeighbors;
    }
}
