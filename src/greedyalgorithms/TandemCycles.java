package greedyalgorithms;

import java.util.Arrays;

public class TandemCycles {

    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        // Write your code here.
        return fastest ? getFastest(redShirtSpeeds, blueShirtSpeeds) : getSlowest(redShirtSpeeds, blueShirtSpeeds);
    }

    private int getFastest(int[] redShirtSpeeds, int[] blueShirtSpeeds){
        int i = redShirtSpeeds.length - 1;
        int j = blueShirtSpeeds.length-1;
        int k =0;
        int sum =0;
        while(k < redShirtSpeeds.length){
            if(redShirtSpeeds[i] >=blueShirtSpeeds[j])
            {
                sum +=redShirtSpeeds[i];
                i--;
            }else  if(redShirtSpeeds[i] < blueShirtSpeeds[j]){
                sum +=blueShirtSpeeds[j];
                j--;
            }
            k++;
        }
        return sum;
    }

    private int getSlowest(int[] redShirtSpeeds, int[] blueShirtSpeeds){
        int i = 0;
        int j =0;
        int k =0;
        int sum =0;
        while(k < redShirtSpeeds.length){
            if(redShirtSpeeds[i] <=blueShirtSpeeds[j])
            {
                sum +=redShirtSpeeds[i];
                i++;
            }else  if(redShirtSpeeds[i] > blueShirtSpeeds[j]){
                sum +=blueShirtSpeeds[j];
                j++;
            }
            k++;
        }
        return sum;
    }
}
