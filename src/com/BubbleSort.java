package com;

public class BubbleSort<T extends Comparable<T>> {
	DoublyLinkedList<Integer> list;
	Node<Integer> first;
	public BubbleSort(DoublyLinkedList<Integer> list) {
		this.list=list;
		this.first = list.getFirst();
		
	}
	
	public Node<T> execute(Node<T> start) {
		int swapped;
		Node<T> ptr1;
		Node<T> lptr = null;

		if (start == null)
			return null;

		do {
			swapped = 0;
			ptr1 = start;

			while (ptr1.getNext() != lptr) {
				if ((int) (ptr1.getValue()) > (int) (ptr1.getNext().getValue())) {
					T t = ptr1.getValue();
					ptr1.setValue(ptr1.getNext().getValue());
					ptr1.getNext().setValue(t);
					swapped = 1;
				}
				ptr1 = ptr1.getNext();
			}
			lptr = ptr1;
		} while (swapped != 0);
		return start;
	}

}
