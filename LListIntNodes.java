
public class LListIntNodes {
	//Attributes
	IntNode first;
	IntNode last;
	int size;
	
	//Constructor methods
	public LListIntNodes() {
		size = 0;		
	}
	
	//ModifierMethods
	public void InsertIntNode(int x) {
		IntNode n = new IntNode(x);
		if (first == null) {
			first = n;			
		}
		else{
			last.next = n;
		}
		last = n;
		size += 1;
	}
	

}
