package monitor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fifo {
	Lock lock;
	Condition condNotFull, condNotEmpty;
	int head;
	int tail;
	int numElems;
	int bufferSize;
	float [] buffer;
	
	public Fifo (int bufferSize) {
		lock = new ReentrantLock();
		condNotFull = lock.newCondition();
		condNotEmpty = lock.newCondition();
		
		head = 0;
		tail = 0;
		numElems = 0;
		this.bufferSize = bufferSize;
		buffer = new float[bufferSize];
	}
	
	public void put (float element) throws InterruptedException {
		lock.lock();
		
		try {
			while (numElems == bufferSize) condNotFull.await();
			
			System.out.println("Putting " + element + " → Head= " + head + ", tail= " + tail
					+ ", nElems= " + numElems);
			buffer[head] = element;
			head = (head+1) % bufferSize;
			numElems++;
			
			if (numElems == 1) condNotEmpty.signal();
		} finally {
			lock.unlock();
		}
	}
	
	public float get () throws InterruptedException {
		lock.lock();
		
		try {		
			float element = 0;
			
			while(numElems == 0) condNotEmpty.await();
			
			element = buffer[tail];
			System.out.println("Getting " + element + " → Head= " + head + ", tail= " + tail
					+ ", nElems= " + numElems);
			tail = (tail+1) % bufferSize;
			numElems--;
			
			if (numElems == (bufferSize-1)) condNotFull.signalAll();
			
			return element;
		} finally {
			lock.unlock();
		}
	}
}
