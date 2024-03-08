package io.algo;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Combinations {

        static List<Set<Integer>> setList=new ArrayList<>();

        /* arr[]  ---> Input Array
        data[] ---> Temporary array to store current combination
        start & end ---> Starting and Ending indexes in arr[]
        index  ---> Current index in data[]
        r ---> Size of a combination to be printed */
        static void combinationUtil(int whole_arr[], int comb_arr[], int start,
                                    int end, int index, int sizeOfCombination)
        {
            // Current combination is ready to be printed, print it
            Set<Integer> integerSet=new LinkedHashSet<>();
            if (index == sizeOfCombination)
            {
                for (int j=0; j<sizeOfCombination; j++){
                    integerSet.add(comb_arr[j]);
                }
                System.out.println(integerSet);
                setList.add(integerSet);
                return;
            }

            // replace index with all possible elements. The condition
            // "end-i+1 >= r-index" makes sure that including one element
            // at index will make a combination with remaining elements
            // at remaining positions
            for (int i=start; i<=end && end-i+1 >= sizeOfCombination-index; i++)
            {
                comb_arr[index] = whole_arr[i];
                combinationUtil(whole_arr, comb_arr, i+1, end, index+1, sizeOfCombination);
            }
        }
    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static void printCombination(int whole_arr[], int n, int sizeOfCombination)
    {
        // A temporary array to store all combination one by one
        int comb_arr[]=new int[sizeOfCombination];

        // Print all combination using temporary array 'data[]'
        combinationUtil(whole_arr, comb_arr, 0, n-1, 0, sizeOfCombination);
    }
    static void printNumberCombo(List<Set<Integer>> setList,int x){
        for (Set<Integer> integers : setList) {
            if (integers.size() == 1 && integers.stream().toList().stream().reduce(0,Integer::sum).equals(x)) {
                System.out.println(x);
            } else {
                int n = 0;
                List<Integer> list = integers.stream().toList();
                n=list.stream().reduce(0,Integer::sum);
                if (x == n) {
                    System.out.println(list);
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] arr={1,2,3,4,5};
        for(int i=1;i<=arr.length;i++){
            printCombination(arr,5,i);
        }

        System.out.println(setList);

        printNumberCombo(setList,10);


    }
}
