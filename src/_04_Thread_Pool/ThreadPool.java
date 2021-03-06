package _04_Thread_Pool;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {

	ArrayList<Thread> threads;
	ConcurrentLinkedQueue<Task> taskQueue;

	public ThreadPool(int n) {
		threads = new ArrayList<Thread>();
		taskQueue = new ConcurrentLinkedQueue<Task>();
		for (int i = 0; i < n; i++) {
			threads.add(new Thread(new Worker(taskQueue)));
		}
		
	}

	public void start() {
		for (int i = 0; i < threads.size(); i++) {
			threads.get(i).start();
			try {
				threads.get(i).join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void addTask(Task task) {
		taskQueue.add(task);
	}

}
