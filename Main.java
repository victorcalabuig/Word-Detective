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
		
		
		//Create new empty linked list of words called wordList:
		LListWordNodes wordList = new LListWordNodes();
		
		
		//Delimiters to separate the words of each line:
		String delimiters = "[\\p{Space}\\p{Punct}\\p{Digit}]";
		
		//create a variable to keep track of the line number the scanner is reading:
		int lineNumber = 1;
		
		
		//For every line of the text:
		while(textReader.hasNextLine()) {
			String line = textReader.nextLine();
			String[] wordArray = line.split(delimiters);		//Transform the line into an array of words, where each position stores a word of the line.
			
			//for every word of the line:
			for (int i = 0; i < wordArray.length; i +=1 ) {
				wordList.InsertWord(wordArray[i], lineNumber);	//Use the method InsertWord to add either a new WordNode (if the word appears for the first time) or a repetition to an existing WordNode.
			}
			
			lineNumber += 1;									
		}
		
		


	}

}
