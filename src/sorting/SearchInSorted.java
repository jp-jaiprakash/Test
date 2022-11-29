package sorting;

public class SearchInSorted {

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        // Write your code here.
        int left =0;
        int right= matrix[0].length-1;
        while(right >=0 && left < matrix[0].length){
            if(matrix[left][right] == target){
                return new int[]{left,right};
            }else if(matrix[left][right] > target){
                right = right -1;
            }else{
                left = left + 1;
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,4,7,12,15,1000},
                {2,5,19,31,32,1001},
                {3,8,24,33,35,1002},
                {40,41,42,44,45,1003}
        };
        int [] answer = searchInSortedMatrix(matrix, 44);
        System.out.println(answer[0]+ ","+answer[1]);
    }
}
