package practice;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    public static void main(String[] args) {

        List<Integer> solution = new ArrayList<>();
        int input[][] = new int[4][4];

        int k=1;
        for(int i=0; i<4;i++){
            for(int j = 0; j<4; j++){
                input[i][j] = k;
                k++;
            }
        }

        int startColum = 0;
        int startRow =0;
        int endColumn = input[startRow].length-1;
        int endRow = input.length -1;

        while(startRow <= endRow && startColum <=endColumn){
            for(int i = startColum; i<= endColumn; i++){
                solution.add(input[startRow][i]);
            }

            if(input.length == 1)
                break;

            if(startRow== endRow)
                break;

            for(int i = startRow+1; i<= endRow;i++){
                solution.add(input[i][endColumn]);
            }

            for(int i = endColumn-1; i>=startColum; i--){
                solution.add(input[endRow][i]);
            }
            endColumn--;

            if(startColum > endColumn)
                break;

            for(int i=endRow-1; i> startRow;i--){
                solution.add(input[i][startColum]);
            }

            startRow++;
            endRow--;
        }

        System.out.println(solution);

    }
}
