import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class QueueTest {

	@Test
	void testQueue() {
		Queue<String> q = new Queue<String>();
		assertEquals(0, q.getSize());	//test 1
		assertThrows(NoSuchElementException.class, ()-> {q.getFront();});	//test 2
		q.enqueue("A");
		assertNotEquals("B", q.getFront());	//test 3
	}

	@Test
	void testQueueTArray() {
		Integer[] arr = {1,2,3,4,5,6};
		Queue<Integer> q = new Queue<Integer>(arr);
		assertEquals(1, q.getFront());	//test 1
		arr = null;
		Queue<Integer> q2 = new Queue<Integer>(arr);
		assertThrows(NoSuchElementException.class, ()-> {q2.getFront();});	//test 2
		assertNotEquals(1, q2.getSize());	//test 3
	}

	@Test
	void testQueueQueueOfT() {
		Integer[] arr = {1,2,3,4,5,6};
		Queue<Integer> q = new Queue<Integer>(arr);
		Queue<Integer> q2 = new Queue<Integer>(q);
		assertEquals(1, q2.getFront());	//test 1
		
		Queue<Integer> q3 = new Queue<Integer>(new Queue<Integer>());
		assertNotEquals(1, q3.getSize());	//test 2
		
		q3.enqueue(1);
		assertFalse(q3.getSize() == 0);		//test 3
		
	}

	@Test
	void testGetFront() {
		Queue<String> q = new Queue<String>();
		assertEquals(0, q.getSize());	//test 1
		assertThrows(NoSuchElementException.class, ()-> {q.getFront();});	//test 2
		q.enqueue("A");
		assertNotEquals("B", q.getFront());	//test 3
	}

	@Test
	void testGetSize() {
		Integer[] arr = {1,2,3,4,5,6};
		Queue<Integer> q = new Queue<Integer>(arr);
		assertEquals(6, q.getSize());	//test 1
		
		Queue<Integer> q3 = new Queue<Integer>(new Queue<Integer>());
		assertNotEquals(1, q3.getSize());	//test 2
		
		q3.enqueue(1);
		assertFalse(q3.getSize() == 0);		//test 3
	}

	@Test
	void testIsEmpty() {
		Queue<Integer> q = new Queue<Integer>();
		assertTrue(q.isEmpty());	//test 1
		q.enqueue(1);
		assertFalse(q.isEmpty());	//test 2
		q.dequeue();
		assertEquals(true, q.isEmpty());	//test 3
	}

	@Test
	void testEnqueue() {
		Queue<Integer> q = new Queue<Integer>();
		assertTrue(q.isEmpty());	//test 1
		q.enqueue(1);
		assertEquals(1, q.getFront());	//test 2
		q.enqueue(2);
		assertNotEquals(2, q.getFront());	//test 3
		
	}

	@Test
	void testDequeue() {
		Queue<Integer> q = new Queue<Integer>();
		assertThrows(NoSuchElementException.class, ()->{q.dequeue();});		//test 1
		q.enqueue(1);
		assertFalse(q.isEmpty());	//test 2
		q.dequeue();
		assertEquals(true, q.isEmpty());	//test 3
	}

	@Test
	void testToString() {
		Integer[] arr = {1,2,3,4,5,6};
		Queue<Integer> q = new Queue<Integer>(arr);
		assertEquals("1 2 3 4 5 6 \n", q.toString());	//test 1
		q.dequeue();
		assertNotEquals("1 2 3 4 5 6 \n", q.toString());	//test 2
		q.enqueue(6);
		assertTrue("2 3 4 5 6 6 \n".equals(q.toString()));	//test 2
	}

	@Test
	void testEqualsObject() {
		Integer[] arr = {1,2,3,4,5,6};
		Queue<Integer> q = new Queue<Integer>(arr);
		Queue<Integer> q2 = new Queue<Integer>(arr);
		assertTrue(q.equals(q2));	//test 1
		q2.dequeue();
		assertFalse(q.equals(q2));	//test 2
		Queue<Integer> q3 = new Queue<Integer>(q);
		assertEquals(true, q3.equals(q3));	//test 3
	}

	@Test
	void testReverseQueue() {
		Integer[] arr = {1,2,3,4,5,6};
		Queue<Integer> q = new Queue<Integer>(arr);
		assertEquals("6 5 4 3 2 1 ", q.reverseQueue());	//test 1
		q.enqueue(7);
		q.dequeue();
		assertNotEquals("6 5 4 3 2 1 ", q.reverseQueue());	//test 2
		q = new Queue<Integer>();
		assertTrue(q.reverseQueue().equals(""));	//test 3
	}

	@Test
	void testIsSorted() {
		Integer[] arr = {1,2,3,4,5,6};
		Queue<Integer> q = new Queue<Integer>(arr);
		assertTrue(q.isSorted());		//test 1
		q.enqueue(1);
		assertFalse(q.isSorted());		//test 2
		
		q = new Queue<Integer>();
		assertEquals(true, q.isSorted());	//test 3
	}

	@Test
	void testLinearSearch() {
		Integer[] arr = {1,2,3,4,5,6};
		Queue<Integer> q = new Queue<Integer>(arr);
		assertTrue(q.linearSearch(6));	//test 1
		assertFalse(q.linearSearch(9));	//test 2
		q = new Queue<Integer>();
		assertEquals(false, q.linearSearch(9));	//test 3
	}

	@Test
	void testBinarySearch() {
		Integer[] arr = {6,1,2,3,4,5,6};
		Queue<Integer> q = new Queue<Integer>(arr);
		assertThrows(IllegalStateException.class, ()->{q.binarySearch(1);});		//test 1
		q.dequeue();
		assertTrue(q.binarySearch(4));				//test 2
		assertFalse(q.binarySearch(0));			//test 3
		
	}

}
