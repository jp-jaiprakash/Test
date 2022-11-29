package greedyalgorithms;

import java.util.ArrayList;
import java.util.Collections;

public class ClassPhotos {

    public boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        if(redShirtHeights.get(redShirtHeights.size()-1) > blueShirtHeights.get(blueShirtHeights.size()-1))
            return checkHeights(blueShirtHeights, redShirtHeights);

        // Write your code here.
        return checkHeights( redShirtHeights, blueShirtHeights);
    }

    public boolean checkHeights(ArrayList<Integer> frontRow, ArrayList<Integer> backRow){
        for(int i = frontRow.size() -1; i>=0 ; i--){
            if(backRow.get(i) <= frontRow.get(i))
                return false;
        }
        return true;
    }
}
