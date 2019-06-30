import java.util.Scanner;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		//Welcome message
		System.out.println("Welcome to Word-Detective 2.0");
		
		//Ask the user to choose a file and create a Scanner object to read that file.
		System.out.print("Enter the file name you want to read:\n>> ");
		Scanner keyboard = new Scanner(System.in);
		String fileName = keyboard.nextLine();
		Scanner textReader = new Scanner(new File(fileName));
		
		
		//Print the text of the file that the user chose
		while(textReader.hasNextLine()) {
			System.out.println(textReader.nextLine());
		}

	}

}
