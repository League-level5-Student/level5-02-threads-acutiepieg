package _01_Olympic_Rings;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.

	public static void main(String[] args) {
		Robot r1 = new Robot();
		Robot r2 = new Robot();
		Robot r3 = new Robot();
		Robot r4 = new Robot();
		Robot r5 = new Robot();
		
		r1.moveTo(250, 500);
		r2.moveTo(500, 500);
		r3.moveTo(750, 500);
		r4.moveTo(370, 625);
		r5.moveTo(620, 625);
		
		Thread t1 = new Thread(()-> drawRing(r1));
		Thread t2 = new Thread(()-> drawRing(r2));
		Thread t3 = new Thread(()-> drawRing(r3));
		Thread t4 = new Thread(()-> drawRing(r4));
		Thread t5 = new Thread(()-> drawRing(r5));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

	public static void drawRing(Robot r) {
		for (int i = 0; i < 360; i++) {
			r.setAngle(i);
			r.penDown();
			r.move(2);
		}
	}
}
