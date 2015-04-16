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
	
	private Node front = null;
	private Node rear = null;
	
	@Override
	public void enqueueRear(E element) {
		Node n = new Node(element);
		
		if(front == null && rear == null) {
			front = n;
			rear = n;
		} else {
			rear.next = n;
			n.previous = rear;
			rear = n;
		}
	}

	@Override
	public void enqueueFront(E element) {
		Node n = new Node(element);
		
		if(front == null && rear == null) {
			front = n;
			rear = n;
		} else {
			front.previous = n;
			n.next = front;
			front = n;
		}
	}

	@Override
	public E dequeueFront() throws EmptyCollectionException {
		Node r = front;
		
		if(front == rear) {
			rear = front = null;
		} else {
			front = front.next;
			front.previous = null;
		}
		return r.obj;
	}

	@Override
	public E dequeueRear() throws EmptyCollectionException {
		Node r = front;
		
		if(front == rear) {
			rear = front = null;
		} else {
			rear = rear.previous;
			rear.next = null;
		}
		return r.obj;
	}

	@Override
	public E peekFront() throws EmptyCollectionException {
		if(front == null) {
			throw new EmptyCollectionException("Linked DeQueue is Empty");
		}
		return front.obj;
	}

	@Override
	public E peekRear() throws EmptyCollectionException {
		if(rear == null) {
			throw new EmptyCollectionException("Linked DeQueue is Empty");
		}
		return rear.obj;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
