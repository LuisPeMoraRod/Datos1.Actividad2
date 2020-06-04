package com;

public class DoublyLinkedList<T extends Comparable<T>> {
	private Node<T> first = null;
	public Node<T> last = null;
	private int size;

	public Node<T> getFirst() {
		return this.first;
	}
	public int getSize() {
		return this.size;
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

	public T getValue(int index){

        Node<T> current = this.first;
        int reference = 0;

        while(current != null){

            if(reference == index){

                return current.getValue();
            }

            else if(index>getSize()-1){
                System.out.println("Index out of limits");
                return null;
            }

            else{
                reference++;
                current = current.getNext();
            }

        }
        return null;

    }
	  
	
	public void modifyValue(T e, int index){

        Node<T> current = this.first;
        int reference = 0;

        while(current != null){

            if(reference == index){

                current.setValue(e);
                return;
            }

            else if(index>getSize()-1){
                return;
            }

            else{
                reference++;
                current = current.getNext();
            }

        }
        return;

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