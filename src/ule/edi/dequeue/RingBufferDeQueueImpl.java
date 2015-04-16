package ule.edi.dequeue;

import java.util.Arrays;

import ule.edi.EmptyCollectionException;

public class RingBufferDeQueueImpl<E> implements DeQueue<E> {
	private final int RESERVATION_SIZE = 5;
	private E[] array = (E[]) new Object[RESERVATION_SIZE];
	private int arraySize = 0;
	private int rear = 0;
	
	private void reserveMemory() {
		if(arraySize <= rear) {
			// no se pueden crear arrays de objetos sin tipo de ahi esto
			
			array = Arrays.copyOf(array, arraySize + RESERVATION_SIZE);
			arraySize += RESERVATION_SIZE;
			for(int i=rear; i<arraySize; i++) {
				array[i] = null;
			}
		}
	}
	
	@Override
	public void enqueueRear(E element) {
		reserveMemory();
		array[rear] = element;
		rear++;
	}

	@Override
	public void enqueueFront(E element) {
		reserveMemory();
		System.arraycopy(array, 0, array, 1, rear);
		array[0] = element;
		rear++;
	}

	@Override
	public E dequeueFront() throws EmptyCollectionException {
		if(isEmpty()) {
			throw new EmptyCollectionException("Ringbuffer DeQueue is Empty");
		}
		
		E obj = array[0];
		array[0] = null;
		rear--;
		System.arraycopy(array, 1, array, 0, rear);
		return obj;
	}

	@Override
	public E dequeueRear() throws EmptyCollectionException {
		if(isEmpty()) {
			throw new EmptyCollectionException("Ringbuffer DeQueue is Empty");
		}
		
		E obj = array[rear-1];
		array[rear-1] = null;
		rear--;
		return obj;
	}

	@Override
	public E peekFront() throws EmptyCollectionException {
		if(isEmpty()) {
			throw new EmptyCollectionException("Ringbuffer DeQueue is Empty");
		}
		return array[0];
	}

	@Override
	public E peekRear() throws EmptyCollectionException {
		if(isEmpty()) {
			throw new EmptyCollectionException("Ringbuffer DeQueue is Empty");
		}
		return array[rear - 1];
	}

	@Override
	public boolean isEmpty() {
		return rear == 0;
	}

}
