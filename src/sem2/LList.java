package sem2;

/**
 * LList.java
 * A class that implements the ADT list by using a chain of nodes,
 * with the node implemented as an inner class with setters and getters.
 * @author Frank M. Carrano
 * @version 2.0
 */
public class LList<T> implements ListInterface<T> {
	private Node firstNode; 
	private int  length;  	

	public LList() {
		clear();
	} 

	public final void clear() {
		firstNode = null;
		length = 0;
	} 
        
        public Node getNode(T entry){
            
            patient p = (patient)entry;
            Node node = null;
            Node compareNode = firstNode;
            
            for(int i=1; i<=length;i++){
                if(p.ic.equals(((patient)compareNode.data).ic)){
                    node = compareNode;
                    return node;
                }
                compareNode = compareNode.next;
            }
            
            return node;
            
        }
        
        public int getPosition(T entry){
            
            patient p = (patient)entry;
            int q = 0;
            Node compareNode = firstNode;
            
            for(int i=1; i<=length;i++){
                if(p.ic.equals(((patient)compareNode.data).ic)){
                    q = i;
                    return q;
                }
                compareNode = compareNode.next;
            }
            
            return q;
            
        }
        
        public boolean sort(T newEntry, int serious){
            serious = 1;
            
            int number = getPosition(newEntry);
            
            remove(number);
            
            patient newPatient = (patient)newEntry;
            newPatient.setSerious(serious);
            
            Node newNode = new Node((T)newPatient);
            
            if(isEmpty()){
                firstNode = newNode;
            }
            else{
                patient firstPatient = (patient)firstNode.data;
                    
                    if(serious == 3){
                        Node lastNode = getNodeAt(length);
			lastNode.setNext(newNode);
                    }
                    else {
                        
                        if(newPatient.serious < firstPatient.serious){
                            newNode.next = firstNode;
                            firstNode = newNode;
                        }
                        else if(newPatient.serious >= firstPatient.serious && length == 1){
                            firstNode.next = newNode;
                        }
                        else{
                            Node compareNode = firstNode.next;
                            Node nodeBefore = firstNode;
                            
                            patient comparePatient;
                                
                            while(compareNode!=null){
                                
                                comparePatient = (patient)compareNode.data;
                                
                                if(newPatient.serious < comparePatient.serious){
                                    nodeBefore.next = newNode;
                                    newNode.next = compareNode;
                                    length++;
                                    return true;
                                }
                            
                                compareNode = compareNode.next;
                                nodeBefore = nodeBefore.next;
                                    
                            }
                            
                            nodeBefore.next = newNode;
                        }
                                      
                    }
                    
                    
            }
            length++;
            return true;
        }
  
	public boolean add(T newEntry) { 	      
		
                patient newPatient = (patient)newEntry;
                Node newNode = new Node((T)newPatient);

		if (isEmpty()){
			firstNode = newNode;
                }
                
                
		else {                         
                    
                    patient firstPatient = (patient)firstNode.data;
                    
                    int serious = newPatient.serious;
                    
                    if(serious == 3){
                        Node lastNode = getNodeAt(length);
			lastNode.setNext(newNode);
                    }
                    else {
                        
                        if(newPatient.serious < firstPatient.serious){
                            newNode.next = firstNode;
                            firstNode = newNode;
                        }
                        else if(newPatient.serious >= firstPatient.serious && length == 1){
                            firstNode.next = newNode;
                        }
                        else{
                            Node compareNode = firstNode.next;
                            Node nodeBefore = firstNode;
                            
                            patient comparePatient;
                                
                            while(compareNode!=null){
                                
                                comparePatient = (patient)compareNode.data;
                                
                                if(newPatient.serious < comparePatient.serious){
                                    nodeBefore.next = newNode;
                                    newNode.next = compareNode;
                                    length++;
                                    return true;
                                }
                            
                                compareNode = compareNode.next;
                                nodeBefore = nodeBefore.next;
                                    
                            }
                            
                            nodeBefore.next = newNode;
                        }
                                      
                    }      
		}
		
		length++;
		return true;
	}  

  public boolean add(int newPosition, T newEntry) { 	                                                 
		boolean isSuccessful = true;

		if ((newPosition >= 1) && (newPosition <= length+1)) {	
			Node newNode = new Node(newEntry); 

			if (isEmpty() || (newPosition == 1))	{     // case 1: add to beginning of list
				newNode.setNext(firstNode);							
				firstNode = newNode;
			}
			else {								                      // case 2: list is not empty and newPosition > 1
				Node nodeBefore = getNodeAt(newPosition - 1);
				Node nodeAfter = nodeBefore.getNext();
				newNode.setNext(nodeAfter);
				nodeBefore.setNext(newNode);
			} 
		
			length++;
		}
		else
			isSuccessful = false;
			
		return isSuccessful;
	} 

	public T remove(int givenPosition) {
	  T result = null;                 
	  
	  if ((givenPosition >= 1) && (givenPosition <= length)) {
	    if (givenPosition == 1) {      // case 1: remove first entry
	      result = firstNode.getData();     // save entry to be removed 
	      firstNode = firstNode.getNext();
	    }
	    else {                         // case 2: givenPosition > 1
	      Node nodeBefore = getNodeAt(givenPosition - 1);
	      Node nodeToRemove = nodeBefore.getNext();
	      Node nodeAfter = nodeToRemove.getNext();
	      nodeBefore.setNext(nodeAfter); // disconnect the node to be removed
	      result = nodeToRemove.getData();  // save entry to be removed
	    } 
	    
	    length--;
	  } 
	  
	  return result;   
	} 

	public boolean replace(int givenPosition, T newEntry) {
		boolean isSuccessful = true;

    if ((givenPosition >= 1) && (givenPosition <= length)) {   
    	Node desiredNode = getNodeAt(givenPosition);
			desiredNode.setData(newEntry);
    }    
		else
			isSuccessful = false;
			
		return isSuccessful;
  } 

  public T getEntry(int givenPosition) {
  	T result = null;  
      
		if ((givenPosition >= 1) && (givenPosition <= length)) {
			result = getNodeAt(givenPosition).getData();
   	} 
      
    return result;
  } 

	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		
		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNext();
		} 
		
		return found;
	} 

  public int getLength() {
     return length;
  } 

  public boolean isEmpty() {
  	boolean result;
 		
   	if (length == 0)  
   		result = true;
   	else 
   		result = false;
    	
   	return result;
  } 
	
  public boolean isFull() {
     return false;
  } 

  public String toString() {
  	String outputStr = "";
	  Node currentNode = firstNode;
		while (currentNode != null) {
			outputStr += ((patient)currentNode.getData()) + "\n";
		  currentNode = currentNode.getNext();
		} 
		return outputStr;
  }

  private void displayChain(Node nodeOne) { 
		if (nodeOne != null) {
			System.out.print(nodeOne.getData() + " ");
			displayChain(nodeOne.getNext());
		} 
	} 

	/** Task: Returns a reference to the node at a given position.
	 *  Precondition: List is not empty; 1 <= givenPosition <= length. */
	private Node getNodeAt(int givenPosition) {
		Node currentNode = firstNode;
		
    // traverse the list to locate the desired node
		for (int counter = 1; counter < givenPosition; counter++)
			currentNode = currentNode.getNext();
		
		return currentNode;
	} 

    @Override
    public boolean add(int newPosition, patient newEntry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	private class Node {
	  private T    data; 
	  private Node next; 

		private Node(T data) {
			this.data = data;
			this.next = null;	
		} 
		
		private Node(T data, Node next) {
			this.data = data;
			this.next = next;	
		} 
		
		private T getData() {
			return data;
		} 
		
		private void setData(T data) {
			this.data = data;
		} 
		
		private Node getNext() {
			return next;
		} 
		
		private void setNext(Node next) {
			this.next = next;
		} 
	} 
} 
