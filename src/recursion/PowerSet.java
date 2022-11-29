package recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static List<List<Integer>> powerset(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        for (Integer i : array) {
            List<List<Integer>> temp = new ArrayList<>(answer);
            for (List<Integer> lst : answer) {
                List<Integer> l = new ArrayList<>(lst);
                l.add(i);
                temp.add(l);
            }
            answer = temp;
        }
        return answer;
    }

    public static List<List<Integer>> powersetII(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        for (Integer j : array) {
            int len = answer.size();
            for (int i = 0; i < len; i++) {
                List<Integer> currentSubset = new ArrayList<>(answer.get(i));
                currentSubset.add(j);
                answer.add(currentSubset);
            }
        }
        return answer;
    }

    public static List<List<Integer>> powersetRecursion(List<Integer> array) {
        // Write your code here.

        return powersetRecursion(array, array.size() - 1);
    }

    public static List<List<Integer>> powersetRecursion(List<Integer> array, int idx) {
        // Write your code here.
        if (idx < 0) {
            List<List<Integer>> emptySet = new ArrayList<>();
            emptySet.add(array);
            return emptySet;
        }
        int element = array.get(idx);
        List<List<Integer>> subsets = powersetRecursion(array, idx - 1);
        int length = subsets.size();

        for (int i = 0; i < length; i++) {
            List<Integer> currentSubset = new ArrayList<>(subsets.get(i));
            currentSubset.add(element);
            subsets.add(currentSubset);
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        System.out.println(powersetII(lst));
    }
}
