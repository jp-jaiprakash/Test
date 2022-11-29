package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> answer = new ArrayList<>();
         getPermutationUsingRecursion(array, new ArrayList<>(), answer);
         return answer;
    }

    static void getPermutationUsingRecursion(List<Integer> array, List<Integer> currentPermutation, List<List<Integer>> answer){
        if(array.size()==0 && currentPermutation.size() > 0)
        {
            answer.add(currentPermutation);
            return;
        }

        for(int i=0; i< array.size(); i++){
            List<Integer> newArray = new ArrayList<>(array);
            newArray.remove(i);

            List<Integer> newPermutation = new ArrayList<>(currentPermutation);
            newPermutation.add(array.get(i));
            getPermutationUsingRecursion(newArray, newPermutation, answer);

        };



    }
    public static List<List<Integer>> getPermutationsII(List<Integer> array) {
        // Write your code here.
        getPermutationsII(array, 0);
        return new ArrayList<List<Integer>>();
    }

    public static void getPermutationsII(List<Integer> array,  int leftPtr) {
        // Write your code here.
        if(leftPtr == array.size()-1){
            System.out.println(array);
        }else {


            for (int i = leftPtr; i < array.size(); i++) {
                swapElement(array, leftPtr, i);
                getPermutationsII(array, leftPtr + 1);
                swapElement(array, leftPtr,  i);
            }
            System.out.println();
        }
    }

    private static void swapElement(List<Integer> array, int lftIdx, int rightIdx) {

        int swappedElement = array.get(lftIdx);
        array.set(lftIdx, array.get(rightIdx));
        array.set(rightIdx, swappedElement);

    }

    public static void main(String[] args) {

        List<Integer> lst1 = new ArrayList<>();
        lst1.add(4);
        lst1.add(5);
        lst1.add(6);

//        List<Integer> lst2 = new ArrayList<>();
//        lst2.add(3);
//        lst2.add(4);
//
//        List<Integer> lst3 = new ArrayList<>();
//        lst3.add(5);
//
////                lst2.addAll(lst1);
////        System.out.println(lst2);
//
//        List<List<Integer>> temp = new ArrayList<>();
//        temp.add(lst1);
//        temp.add(lst2);

//        temp.stream()
//                        .map(x-> {
//                            x.addAll(lst3);
//                            return x;
//                        }).collect(Collectors.toList());
//        System.out.println(temp);
getPermutationsII(lst1);
    }

}
