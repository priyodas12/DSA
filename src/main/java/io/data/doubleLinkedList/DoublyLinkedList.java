package io.data.doubleLinkedList;

public class DoublyLinkedList<T extends Comparable<T>> {

  private Node<T> head;
  private Node<T> tail;

  /**Find out the tail node and insert elements after tail node*/
  public void insertFromEnd(T data){

    Node<T> newNode=new Node<T>(data);

    //if the element in linked list
    if(tail==null && head==null){
      //both of the first item in the linked list
      System.out.println("\nInserting first element: "+data);
      tail=newNode;
      head=newNode;
    }else{
      assert tail != null;
      System.out.println("\nAdding new node: "+newNode.getData()+" , Behind Current tail node: "+tail.getData());
      /**current tail node's next node will be the new node*/
      tail.setNextNode(newNode);
      /**bind new node's previous node as current tail node*/
      newNode.setPreviousNode(tail);
      /**now new tail will be the new node*/
      tail=newNode;
    }
  }

  public void traverseForward() {
    Node<T> current = head;
    System.out.println("\nTraversal in forward direction:");
    System.out.print("null");
    while (current != null) {
      System.out.print(" <=> "+ current.getData() + " <=> ");
      current = current.getNextNode();
    }
    System.out.print("null\n");
  }

  public void traverseBackward() {
    Node<T> current = tail;
    System.out.println("\nTraversal in backward direction:");
    System.out.print("null");
    while (current != null) {
      System.out.print(" <=> "+ current.getData() + " <=> ");
      current = current.getPreviousNode();
    }
    System.out.print("null\n");
  }
}
