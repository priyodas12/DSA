package io.sort;

import java.util.Arrays;
import java.util.Random;

public class MergingOf2SortedArray {
    public static void main(String[] args) {
        int [] inputArray=new int [22];
        for(int i=0;i<inputArray.length;i++){
            int k=new Random().nextInt(100,200);
            inputArray[i]=k;
        }
        System.out.println("Before Sorting::\n"+Arrays.toString(inputArray));
        mergeSort(inputArray);
    }

    public static void mergeSort(int [] inputArray){
        if(inputArray.length<2){
            return;
        }

        int midIndex= inputArray.length/2;

        int [] sortedLeftArr=new int[midIndex];
        int [] sortedRightArr=new int[inputArray.length-midIndex];

        for(int i=0;i<midIndex;i++){
            sortedLeftArr[i]=inputArray[i];
        }

        for(int i=midIndex;i<inputArray.length;i++){
            sortedRightArr[i-midIndex]=inputArray[i];
        }

        mergeSort(sortedLeftArr);
        mergeSort(sortedRightArr);

        int [] sortedArray=merge(inputArray,sortedLeftArr,sortedRightArr);

        System.out.println("After Sorting::\n"+Arrays.toString(sortedArray));
    }

    public static int [] merge(int [] inputArray,int [] a,int [] b){
        int leftArrayLength=a.length;
        int rightArrayLength=b.length;

        //int [] temp=new int[leftArrayLength+rightArrayLength];

        int i=0,j=0,k=0;

        while(i<leftArrayLength && j<rightArrayLength){
            if(a[i]<=b[j]){
                inputArray[k]=a[i];
                i++;
            }else{
                inputArray[k]=b[j];
                j++;
            }
            k++;
        }

        /*If Array a having remaining elements*/
        while(i<leftArrayLength){
            inputArray[k]=a[i];
            i++;
            k++;
        }

        /*If Array b having remaining elements*/
        while(j<rightArrayLength){
            inputArray[k]=b[j];
            j++;
            k++;
        }
        System.out.println("After Merging::\n"+Arrays.toString(inputArray));
        return inputArray;
    }
}
