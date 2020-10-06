package _02_Advanced_Robot_Race;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.

	static boolean notAtTop = true;
	static int winningNumber;

	public static void main(String[] args) {
		
		Robot[] robots = new Robot[5];
		
		for (int i = 0; i < robots.length; i++) {
			robots[i] = new Robot();
		}
		for (int i = 0; i < robots.length; i++) {
			robots[i].show();
			robots[i].setX(i * 155 + 150);
			robots[i].setY(550);
		}
		Thread t1 = new Thread(()-> move(robots[0], 1));
		Thread t2 = new Thread(()-> move(robots[1], 2));
		Thread t3 = new Thread(()-> move(robots[2], 3));
		Thread t4 = new Thread(()-> move(robots[3], 4));
		Thread t5 = new Thread(()-> move(robots[4], 5));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		JOptionPane.showMessageDialog(null, "The winner is Robot " + (winningNumber + 1) + "! Let's have a party!");
	}

	static public void move(Robot r, int name) {
		Random ran = new Random();
		while (notAtTop == true) {
			int random = ran.nextInt(51);
			r.move(random);
			if (r.getY() < 60) {
				notAtTop = false;
				winningNumber = name;
			}
		}
	}
}
