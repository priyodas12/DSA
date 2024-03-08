package io.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSortAlgo {
    public static void main(String[] args) {
        int [] inputArray=new int [10];
        for(int i=0;i<inputArray.length;i++){
            int k=new Random().nextInt(10,30);
            inputArray[i]=k;
        }
        System.out.println("Before Sorting::\n"+ Arrays.toString(inputArray));
        quickSort(inputArray,0, inputArray.length-1);
        System.out.println("After Sorting::\n"+ Arrays.toString(inputArray));
    }

    public static void quickSort(int [] array,int lowIndex,int highIndex){
        if(lowIndex>=highIndex){
            return;
        }
        int pivot=array[highIndex];

        int leftPointer=lowIndex;
        int rightPointer=highIndex;

        while(leftPointer < rightPointer){
            while(array[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            while(array[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            swap(array,leftPointer,rightPointer);
            //System.out.println("After Swap *::\n"+ Arrays.toString(array));
        }
        swap(array,leftPointer,highIndex);
        System.out.println("After Swap **::\n"+ Arrays.toString(array));

        quickSort(array,lowIndex,leftPointer-1);
        quickSort(array,leftPointer+1,highIndex);
    }

    private static void swap(int [] array,int index1,int index2){
       int temp=array[index1];
       array[index1]=array[index2];
       array[index2]=temp;
    }

}
