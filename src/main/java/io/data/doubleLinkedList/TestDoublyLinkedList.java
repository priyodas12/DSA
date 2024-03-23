package io.data.doubleLinkedList;

public class TestDoublyLinkedList {

  public static void main(String[] args) {

    DoublyLinkedList<Integer> doublyLinkedList=new DoublyLinkedList<>();

    doublyLinkedList.addEnd(100);
    doublyLinkedList.addEnd(101);
    doublyLinkedList.addEnd(102);
    doublyLinkedList.addEnd(103);
    doublyLinkedList.addEnd(104);

    doublyLinkedList.traverseForward();

    doublyLinkedList.addFirst(105);
    doublyLinkedList.addFirst(106);
    doublyLinkedList.addFirst(107);
    doublyLinkedList.addFirst(108);


    doublyLinkedList.traverseForward();

  }

}
