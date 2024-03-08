package io.data.doubleLinkedList;

public class TestDoublyLinkedList {

  public static void main(String[] args) {

    DoublyLinkedList<Integer> doublyLinkedList=new DoublyLinkedList<>();

   /* doublyLinkedList.insertFromEnd(100);
    doublyLinkedList.insertFromEnd(101);
    doublyLinkedList.insertFromEnd(102);
    doublyLinkedList.insertFromEnd(103);*/

    doublyLinkedList.insertFromStart(100);
    doublyLinkedList.insertFromStart(101);
    doublyLinkedList.insertFromStart(102);
    doublyLinkedList.insertFromStart(103);


    doublyLinkedList.traverseForward();
    doublyLinkedList.traverseBackward();
  }

}
