import java.util.Scanner;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		//Welcome message
		System.out.println("Welcome to Word-Detective 2.0");
		
		//Ask the user to choose a file and create a Scanner object to read that file.
		System.out.print("Enter the file name you want to read (or press ENTER if you want to write your own text right now):\n>> ");
		Scanner textReader = new Scanner(System.in);
		String userInput = textReader.nextLine();
		
		
		//Ask the user if he wants the results to be ordered alphabetically
		boolean alphabetical = false;
		System.out.println("Would you like to show the results alphabetically ordered? (type y/n)");
		String alphUser = textReader.nextLine();
		if( alphUser.equals("y") || alphUser.equals("yes")) {
			alphabetical = true;
		}
		
		
		//if userInput is NOT empty, the user specified a file so make the Scanner object read that file.
		if(!userInput.equals("")) {
			textReader = new Scanner(new File(userInput));
		}
		//if the user didn't specify a file, give instructions on how to enter text:
		else {
			System.out.println("Enter your text and when you are done, press Enter, then CTRL+Z (^Z) and then ENTER again:\n");
		}
		
				
		//Create new empty linked list of words called wordList to store the word read in the file.
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
			if(alphabetical) {
				for (int i = 0; i < wordArray.length; i +=1 ) {
					wordList.InsertWordAlphOrder(wordArray[i], lineNumber);	
				}
			}else {
				for (int i = 0; i < wordArray.length; i +=1 ) {
					wordList.InsertWord(wordArray[i], lineNumber);	//Use the method InsertWord to add either a new WordNode (if the word appears for the first time) or a repetition to an existing WordNode.
				}
			
			}
			
			lineNumber += 1;									
		}
		
		//Print out results:
		System.out.println("\nWORD\tREPS\t\tLINES");
		System.out.println("_____________________________________________");
		System.out.print(wordList.toString());


	}

}
