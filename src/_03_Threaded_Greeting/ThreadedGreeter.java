package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable {

	int num;

	public ThreadedGreeter(int num) {
		this.num = num;
	}

	public void run() {
		System.out.println("Hello from thread number: " + num);

		if (num <= 49) {
			ThreadedGreeter t = new ThreadedGreeter(num + 1);
			t.run();
		}

	}
}
