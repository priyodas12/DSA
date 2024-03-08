package io.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Permutations {
    static List<List<Integer>> lists=new ArrayList<>();
    public static int sum(int k) {
        if (k > 0) {
            return k + sum(k - 1);
        } else {
            return 0;
        }
    }

    public static void permute(int [] arr, int k){

        List<List<Integer>> listList= new ArrayList<>();
        List<Integer> integerList=new ArrayList<>();
        if(k==arr.length){
            for(int i=0;i<arr.length;i++){
                integerList.add(arr[i]);
            }
            System.out.println(integerList);
            lists.add(integerList);
        }else{
            for(int i=k;i<arr.length;i++){

                int temp=arr[k];
                arr[k]=arr[i];
                arr[i]=temp;

                permute(arr,k+1);

                temp=arr[k];
                arr[k]=arr[i];
                arr[i]=temp;
            }
        }
    }
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5};
        permute(arr,1);
        System.out.println(lists);
    }
}
