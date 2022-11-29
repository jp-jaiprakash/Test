package sorting;

public class ThreeNumberSorted {

    public int[] threeNumberSort(int[] array, int[] order) {
        // Write your code here.
        int startIdx = 0, endIdx = array.length - 1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == order[0]) {
                //swap with startIdx
                // increement startidx
                int temp = array[startIdx];
                array[startIdx] = array[i];
                array[i] = temp;
                startIdx++;
            }
        }

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == order[2]) {
                int temp = array[endIdx];
                array[endIdx] = array[i];
                array[i] = temp;
                endIdx--;
            }
        }

        return array;
    }
}
