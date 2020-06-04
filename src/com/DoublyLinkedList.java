package com;

public class DoublyLinkedList<T extends Comparable<T>> {
	private Node<T> first = null;
	public Node<T> last = null;
	private int size;

	public Node<T> getFirst() {
		return this.first;
	}

	public void addLast(T value) {
		if (this.first == null) {
			this.first = this.last = new Node<>(value);
			size++;
			return;

		}
		Node<T> newElement = new Node<>(value);
		this.last.setNext(newElement);
		newElement.setPrev(last);
		this.last = newElement;
		size++;
	}

	public int find(T e) {
		Node<T> temp = this.first;
		int index = 0;
		while (temp != null) {
			if (temp.getValue().compareTo(e) == 0) {
				return index;
			}
			index++;
			temp = temp.getNext();
		}
		return -1;
	}
	
	
	  
	// Function to print nodes in a given linked list  
	public void printList( Node<T> start)  
	{  
		Node<T> temp = start;  
	    System.out.println();  
	    while (temp != null)  
	    {  
	        System.out.print( temp.getValue() + " ");  
	        temp = temp.getNext();  
	    }  
	}  
	  
	

	/**
	 * Checks if every element of another list matches with the ones owned by the list
	 * @param listToCompare : Node<T>
	 * @return boolean
	 */
	public boolean comparesLists(Node<T> listToCompare) {
		Node<T> pointer = this.first;
		Node<T> pointer2 = listToCompare;
		for (int i = 0; i < size; i++) {
			if (!pointer.getValue().equals(pointer2.getValue())) {
				return false;
			}
			pointer = pointer.getNext();
			pointer2 = pointer2.getNext();
		}
		return true;
	}

}