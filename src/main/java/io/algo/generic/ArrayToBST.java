package io.algo.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToBST {
    public static void main(String[] args) {
        Node n1=new Node(new int []{-1,0,12,13,24,35,46,57,58,59,62});
        //n1.bTreeTraversal(n1);
        //System.out.println("\nSearch Status :"+n1.search_node(n1,new Node(62)));
        //n1.bTreeToArray(n1);
        Arrays.asList(n1.bTreeToArray(n1)).stream().forEach(System.out::println);
    }
}

class Node{
    int value;
    private Node leftNode;
    private Node rightNode;

    public Node(int value){
        this.value=value;
    }

    public Node(int [] values){
        int length=values.length;
        switch(length){
            case 1:
                this.value=values[0];
                return;
            case 2:
                int min=Math.min(values[0],values[1]);
                int max=Math.min(values[0],values[1]);
                this.value=max;
                this.leftNode=new Node(min);
            default:
                int median=values.length/2;
                int [] leftArray= Arrays.copyOfRange(values,0,median);
                int [] rightArray= Arrays.copyOfRange(values,median+1,values.length);
                this.value=values[median];
                if(leftArray.length>0){
                    this.leftNode=new Node(leftArray);
                }
                if(rightArray.length>0){
                    this.rightNode=new Node(rightArray);
                }
        }

    }

    void bTreeTraversal(Node node) {
        if(node != null) {
            bTreeTraversal(node.leftNode);
            System.out.print(node.value + " ");
            bTreeTraversal(node.rightNode);
        }
    }

    Integer [] bTreeToArray(Node node){
        List<Integer> integerList=new ArrayList<>();
        if(node != null) {
            bTreeToArray(node.leftNode);
            integerList.add(node.value);
            bTreeToArray(node.rightNode);
        }
        Integer [] arr=integerList.toArray(new Integer[integerList.size()]);
        return arr;
    }

    boolean search_node(Node wholeNode,Node searchingNode){
        if(wholeNode.rightNode==null && wholeNode.leftNode==null){
            return wholeNode.value==searchingNode.value;
        }else if(wholeNode.value==searchingNode.value){
            return true;
        }
        else if(wholeNode.rightNode != null && searchingNode.value>wholeNode.value){
            return search_node(wholeNode.rightNode,searchingNode);
        }else{
            return search_node(wholeNode.leftNode,searchingNode);
        }
    }
}