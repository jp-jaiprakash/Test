package graphs;

public class CycleInGraph {

    public boolean cycleInGraph(int[][] edges) {
        // Write your code here.
        boolean[] visited = new boolean[edges.length];
        boolean[] instack = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if (visited[i])
                continue;

            boolean containsCycle = checkDFS(i, edges, visited, instack);
            if (containsCycle)
                return true;


        }
        return false;
    }

    private boolean checkDFS(int i, int[][] edges, boolean[] visited, boolean[] instack) {
        visited[i] = true;
        instack[i] = true;
        int[] pointsInEdges = edges[i];
        for (int j : pointsInEdges) {
            if (!visited[j]) {
                boolean containsCycle = checkDFS(j, edges, visited, instack);
                if (containsCycle)
                    return true;
            } else if (instack[j]) {
                return true;

            }


        }
        instack[i] = false;
        return false;
    }


}
