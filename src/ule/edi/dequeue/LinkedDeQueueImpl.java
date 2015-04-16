package ule.edi.dequeue;

import ule.edi.EmptyCollectionException;

public class LinkedDeQueueImpl<E> implements DeQueue<E> {
	
	private class Node {
		public E obj = null;
		public Node next = null;
		public Node previous = null;
		
		public Node(E element) {
			obj = element;
		}
	}
	
	private Node list = null;
	
	private Node getLastNode() {
		Node r = list;
		while(r.next != null) {
			r = r.next;
		}
		return r;
	}
	
	private Node getFirstNode() {
		Node r = list;
		while(r.previous != null) {
			r = r.previous;
		}
		return r;
	}
	
	@Override
	public void enqueueRear(E element) {
		Node n = new Node(element);
		
		if(list == null) {
			list = n;
		} else {
			Node r = getLastNode();
			r.next = n;
			n.previous = r;
		}
	}

	@Override
	public void enqueueFront(E element) {
		Node n = new Node(element);
		
		if(list == null) {
			list = n;
		} else {
			Node r = getFirstNode();
			r.previous = n;
			n.next = r;
		}	
	}

	@Override
	public E dequeueFront() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E dequeueRear() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peekFront() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peekRear() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
