package ule.edi.dequeue;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ule.edi.EmptyCollectionException;

public class RingBufferDeQueueImplTest {
	RingBufferDeQueueImpl<String> cola;
	@Before
	public void setUp() throws Exception {
		cola = new RingBufferDeQueueImpl<>();
	}

	@Test
	public void testEnqueueRear() {
		cola.enqueueRear("hola");
	}
	
	@Test
	public void testEnqueueRear2() {
		cola.enqueueRear("hola");
		cola.enqueueRear("adios");
	}

	@Test
	public void testEnqueueFront() {
		cola.enqueueFront("hola");
		cola.enqueueFront("adios");
	}

	@Test(expected=EmptyCollectionException.class)
	public void testDequeueFrontException() throws EmptyCollectionException {
		cola.dequeueFront();
	}
	
	@Test
	public void testDequeueFront() throws EmptyCollectionException {
		cola.enqueueFront("hola");
		cola.enqueueFront("adios");
		cola.dequeueFront();
	}
	
	@Test
	public void testDequeueFront2() throws EmptyCollectionException {
		cola.enqueueFront("hola");
		cola.dequeueFront();
	}

	@Test(expected=EmptyCollectionException.class)
	public void testDequeueRearException() throws EmptyCollectionException {
		cola.dequeueRear();
	}
	
	@Test
	public void testDequeueRear() throws EmptyCollectionException {
		cola.enqueueRear("hola");
		cola.enqueueRear("adios");
		cola.dequeueRear();
	}
	
	@Test
	public void testDequeueRear2() throws EmptyCollectionException {
		cola.enqueueRear("hola");
		cola.dequeueRear();
	}

	@Test(expected=EmptyCollectionException.class)
	public void testPeekFrontException() throws EmptyCollectionException {
		cola.peekFront();
	}
	@Test
	public void testPeekFront() throws EmptyCollectionException {
		cola.enqueueFront("hola");
		Assert.assertEquals("hola", cola.peekFront());
	}

	@Test(expected=EmptyCollectionException.class)
	public void testPeekRearException() throws EmptyCollectionException {
		cola.peekRear();
	}
	@Test
	public void testPeekRear() throws EmptyCollectionException {
		cola.enqueueRear("hola");
		Assert.assertEquals("hola", cola.peekRear());
	}
	@Test
	public void testIsEmpty() {
		Assert.assertTrue(cola.isEmpty());
	}

}
