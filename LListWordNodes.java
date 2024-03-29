import java.lang.Object;

public class LListWordNodes {
	//Attributes
	WordNode first;
	WordNode last;
	int size;
	
	
	//Constructor method
	public LListWordNodes() {
		size = 0;
	}
	
	//Modifier method:
	public void InsertWord(String w, int line) {
		//1.Check if the word exists already or if this appearance is the first one.
		WordNode reference = first;
		boolean wordExists = false;
		while ( reference != null ) {
			if ( reference.word.equals(w) ) {
				wordExists = true;
				break;
			}else {
				reference = reference.next;
			}	
		}
		
		
		//2. If the word already EXISTS, simply insert a new IntNode with line number to the corresponding WordNode's LListIntNodes.
		if (wordExists) {
			reference.appearences.InsertIntNode(line);
		}
		
		
		//3. If the word does NOT exist in the linked list:
		else {
			WordNode n = new WordNode(w);		//1)Create new WordNode  
			if (first == null) {				//2)Insert it in the linked list of WordNodes.
				first = n;
			}
			else {
				last.next = n;
			}
			last = n;
			size += 1;
			n.appearences.InsertIntNode(line);	//3)Insert IntNode with line number into the WordNode's LListIntNodes.
		}
		
	}
	
	
	
	public void InsertWordAlphOrder(String w, int line) {
		
		//1.Check if the word exists already or if this appearance is the first one.
		WordNode reference = first;
		boolean wordExists = false;
		while ( reference != null ) {
			if ( reference.word.equals(w) ) {
				wordExists = true;
				break;
			}else {
				reference = reference.next;
			}	
		}
		
		//2. If the word already EXISTS, simply insert a new IntNode with line number to the corresponding WordNode's LListIntNodes.
		if (wordExists) {
			reference.appearences.InsertIntNode(line);
		}
		
		//3. If the word does NOT exist in the linked list:
		else {
			WordNode newNode = new WordNode(w);		//1)Create new WordNode
			reference = first;
			if (reference == null) {				//2)If it is the first word of the list, insert it and insert the corresponding IntNode
				first = newNode;
				last = newNode;
				size += 1;
				newNode.appearences.InsertIntNode(line);
			}else {
				if(first.word.compareTo(w) > 0) {
					newNode.next = first;
					first = newNode;
					newNode.appearences.InsertIntNode(line);
				}else {
					WordNode refAhead = first.next;		//This variable will always point to the WordNode that is ahead of the WordNode pointed to by the variable reference.
					while( refAhead != null && refAhead.word.toLowerCase().compareTo(w.toLowerCase()) < 0) {
						refAhead = refAhead.next;
						reference = reference.next;
					}
					newNode.next = reference.next;
					reference.next = newNode;
					newNode.appearences.InsertIntNode(line);

				}
				
				
				
				
				
				size += 1;
				
			}
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Method to convert the word linked list's attributes into string:
	public String toString() {
		WordNode reference = first;
		String result = "";
		
		//for every WordNode of the linked list of words:
		for( int i = 0; i < size; i += 1) {
			result += reference.word + "\t(" + reference.appearences.size + ")\t:\t";
			
			//for every IntNode of the word's IntNode linked list:
			IntNode ref = reference.appearences.first;
			for( int z = 0; z < reference.appearences.size; z += 1 ) {
				result += ref.number + "\t";
				ref = ref.next;
			}
			result += "\n";
			reference = reference.next;
		}
		return result;
	}
	
	
}
