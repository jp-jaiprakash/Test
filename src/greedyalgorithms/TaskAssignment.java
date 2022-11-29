package greedyalgorithms;

import java.util.*;

public class TaskAssignment {

    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        // Write your code here.
        Map<Integer, List<Integer>> mapOfIndices = new HashMap<>();
        int p=0;
        for(int i: tasks){
            List<Integer> indices;
            if(mapOfIndices.containsKey(i)){
                 indices = mapOfIndices.get(i);

            }else {
                indices = new ArrayList<>();

            }
            indices.add(p);
            mapOfIndices.put(i, indices);
            p++;
        }
        Collections.sort(tasks);
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        int i=0, j= tasks.size()-1;
        while(i<j){
            ArrayList<Integer> subList = new ArrayList<>();
            subList.add(getOriginalIndex(mapOfIndices, tasks.get(i)));
            subList.add(getOriginalIndex(mapOfIndices,tasks.get(j)));
            i++;
            j--;
            answer.add(subList);
        }
        return answer;
    }

    private int getOriginalIndex(Map<Integer, List<Integer>> mapOfIndices, int number){
        List<Integer> lst = mapOfIndices.get(number);
        int answer = lst.get(lst.size()-1);
        lst.remove(lst.size()-1);
        mapOfIndices.put(number, lst);
        return answer;
    }
}
