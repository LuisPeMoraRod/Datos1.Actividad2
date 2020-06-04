package com;

public class InsertionSort<T extends Comparable<T>> {
	DoublyLinkedList<Integer> list;
	Node<Integer> first;

	public InsertionSort(DoublyLinkedList<Integer> list) {
		this.list = list;
		this.first = list.getFirst();
	}

	// function to insert a new node in sorted way in
	// a sorted doubly linked list
	public Node<T> sortedInsert(Node<T> head_ref, Node<T> newNode) {
		Node<T> current;

		// if list is empty
		if (head_ref == null)
			head_ref = newNode;

		// if the node is to be inserted at the beginning
		// of the doubly linked list
		else if ((int) (head_ref.getValue()) >= (int) (newNode.getValue())) {
			newNode.setNext(head_ref);
			newNode.getNext().setPrev(newNode);
			head_ref = newNode;
		}

		else {
			current = head_ref;

			// locate the node after which the new node
			// is to be inserted
			while (current.getNext() != null && (int) (current.getNext().getValue()) < (int) (newNode.getValue()))
				current = current.getNext();

			// Make the appropriate links /

			newNode.setNext(current.getNext());

			// if the new node is not inserted
			// at the end of the list
			if (current.getNext() != null)
				newNode.getNext().setPrev(newNode);

			current.setNext(newNode);
			newNode.setPrev(current);
		}
		return head_ref;
	}

	// function to sort a doubly linked list using insertion sort
	public Node<T> execute(Node<T> head_ref) {
		// Initialize 'sorted' - a sorted doubly linked list
		Node<T> sorted = null;

		// Traverse the given doubly linked list and
		// insert every node to 'sorted'
		Node<T> current = head_ref;
		while (current != null) {

			// Store next for next iteration
			Node<T> next = current.getNext();

			// removing all the links so as to create 'current'
			// as a new node for insertion
			current.setPrev(null);
			current.setNext(null);

			// insert current in 'sorted' doubly linked list
			sorted = sortedInsert(sorted, current);

			// Update current
			current = next;
		}

		// Update head_ref to point to sorted doubly linked list
		head_ref = sorted;

		return head_ref;
	}

}
