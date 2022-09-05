package arrays;

public class SpiralTraverseII {
    public static void main(String[] args) {
        int input[][] = new int[4][3];

        int k=1;
        for(int i=0; i<4;i++){
            for(int j = 0; j<3; j++){
                input[i][j] = k;
                k++;
            }
        }

        int top =0, down = input.length-1, left = 0, right = input[0].length-1;
        int direction=0;

        while (top <= down && left <=right){

            if(direction == 0){
                // now we want to traverse from left to right.
                for(int i = left; i<=right; i++){
                    System.out.print(input[top][i] + " ");
                }
                top++;
            }else if(direction == 1){
                // traverse from top to bottom
                for(int i = top; i<= down; i++){
                    System.out.print(input[i][right] + " ");
                }
                right--;
            }else if(direction == 2){
                // traverse from right to left
                for(int i = right; i>= left; i--){
                    System.out.print(input[down][i] + " ");
                }
                down--;
            }
            else if(direction == 3){
                // traverse from down to top
                for(int i = down; i>= top; i--){
                    System.out.print(input[i][left] + " ");
                }
                left++;
            }
            direction = direction+1;
            direction = direction % 4;
        }
    }
}
