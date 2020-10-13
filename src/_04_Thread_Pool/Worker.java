package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {

	ConcurrentLinkedQueue<Task> taskQueue;
	
	public Worker(ConcurrentLinkedQueue<Task> tasks) {
		taskQueue = tasks;
	}
	
	@Override
	public void run() {
		while(taskQueue.size() != 0) {
			Task t = taskQueue.remove();
			t.perform();
		}
	}


}
