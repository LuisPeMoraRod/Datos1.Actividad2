package com;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SortingAlgoritmsTest {
	DoublyLinkedList<Integer> list1; // List to be sorted
	Node<Integer> start1;// first node of the list to be sorted

	DoublyLinkedList<Integer> list2; // List to be sorted
	Node<Integer> start2;// first node of the list to be sorted

	DoublyLinkedList<Integer> list3; // List to be sorted
	Node<Integer> start3;// first node of the list to be sorted

	BubbleSort<Integer> bubbleSort;
	InsertionSort<Integer> insertionSort;
	DoublyLinkedList<Integer> expected;

	@Before
	public void unsortedLists() {
		list1 = createList();
		start1 = list1.getFirst();

		list2 = createList();
		start2 = list2.getFirst();

		list3 = createList();
		start3 = list3.getFirst();
		// Creates expected sorted list
		expected = new DoublyLinkedList<Integer>();
		expected.addLast(0);
		expected.addLast(3);
		expected.addLast(5);
		expected.addLast(8);
		expected.addLast(8);
		expected.addLast(9);
		expected.addLast(10);
		expected.addLast(12);
		expected.addLast(98);

	}

	@Test
	public void testBubleSort() {
		Node<Integer> bubbleSortedList;
		bubbleSort = new BubbleSort<Integer>(list1);
		bubbleSortedList = bubbleSort.execute(start1);
		boolean areEqual1 = expected.comparesLists(bubbleSortedList); // Compares the
		// expected list with the bubble sorted list
		assertTrue(areEqual1);
		
	}

	@Test
	public void testInsertionSort() {
		Node<Integer> insertionSortedList;
		insertionSort = new InsertionSort<Integer>(list2);
		insertionSortedList = insertionSort.execute(start2);
		boolean areEqual2 = expected.comparesLists(insertionSortedList);// Compares the
		// expected list with the insertion sorted list
		assertTrue(areEqual2);
	}
	
	
	public DoublyLinkedList<Integer> createList() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.addLast(9);//
		list.addLast(3);//
		list.addLast(5);//
		list.addLast(10);//
		list.addLast(12);//
		list.addLast(8);//
		list.addLast(8);//
		list.addLast(98);
		list.addLast(0);//
		return list;
	}

}
