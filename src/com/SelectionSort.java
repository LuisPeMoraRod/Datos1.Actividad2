package com;

public class SelectionSort<T extends Comparable<T>> {

	private DoublyLinkedList<T> list;
	private int listSize;

	public SelectionSort(DoublyLinkedList<T> list) {

		this.list = list;
		this.listSize = list.getSize();

	}

	public int getMinIndex(int start) {

		int indexOfMin = start;

		for (int index = start + 1; index <= listSize - 1; index++) {
			if (list.getValue(index).compareTo(list.getValue(indexOfMin)) < 0) {
				indexOfMin = index;
			}
		}

		return indexOfMin;
	}

	public void execute() {

		T minElement;
		T element;
		int minIndex;

		for (int currentIndex = 0; currentIndex <= listSize - 1; currentIndex++) {

			minIndex = getMinIndex(currentIndex);
			minElement = list.getValue(minIndex);
			element = list.getValue(currentIndex);

			list.modifyValue(minElement, currentIndex);
			list.modifyValue(element, minIndex);

		}
	}

	public Node<T> getSortedList() {
		return this.list.getFirst();
	}

}
