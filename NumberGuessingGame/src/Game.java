import java.util.Random;
import java.util.Scanner;

public class Game {
	int computer;
	public Game() {
		Random r = new Random();
		computer = r.nextInt(100);
		System.out.println("Guess the number from 1 to 100");
		
	}
	public int computerNo() {
		return computer;
		
	}
	
	
	static void isCorrectNumber(int i, int j) {
		if (i==j) {
			System.out.print("Yes! You guessed the correct number.");
		}
		else if(i>j) {
			System.out.print("Your number is bigger than Computer number");
		}
		else {
			System.out.print("Your number is smaller than Computer number");
		}
	}
	
	public static void main(String args[]) {
		int user = 0;
		int computer = 0;
		int itteration = 0;
		
		Game g = new Game();
		
		do {
			user = takeUserInput();
			computer = g.computerNo();
			isCorrectNumber(user, computer);
			itteration++;
		}
		while (user!= computer);
		System.out.println(" You guessed this number in "+itteration+" itterations.");
	}
	private static int takeUserInput() {
		// TODO Auto-generated method stub
		int user;
		System.out.print("Please enter your number: ");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		user = sc.nextInt();
		
		
		return user;
		
	}
}
