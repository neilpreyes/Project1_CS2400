package CS_2400.Project_1;

public final class LinkedBag<T> implements BagInterface<T> {
    private Node firstNode;
    private int numEntries;

    public LinkedBag(){
        //set default values for variables
        firstNode = null;
        numEntries = 0;
    }//end default constructor

    public boolean isEmpty(){
        //compares number of entries to 0
        return numEntries == 0;
    }//end isEmpty

    public int getCurrentSize(){
        return numEntries;
    }//end getCurrentSize

    /**
     * @param newEntry New object to be added to bag
     * @return True = boolean that returns true if addition to bag is successful and false if not
     */
    public boolean add(T newEntry){
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numEntries++;
        return true;
    }//end add

    /**
     * @return An array that contains the contents of this bag
     */
    public T[] toArray(){
        //The case is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numEntries];
        int index = 0;
        Node currentNode = firstNode;
        
        //A while loop that inputs bag objects into an array
        while ((index < numEntries) && (currentNode !=  null)){
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        }

        return result;
    }//end toArray

    /**
     * @param entry = The entry that needs to check its frequency in a bag
     * @return The number of frequencies the entry is in a bag
     */
    public int getFrequencyOf(T entry){
        int frequency = 0;
        int count = 0;
        Node currentNode = firstNode;

        while ((count < numEntries) && (currentNode != null)){
            if(entry.equals(currentNode.data)){
                frequency++;
            }
            count++;
            currentNode = currentNode.next;
        }

        return frequency;
    }//end getFrequencyOf

    /**
     * @param entry The entry that needs to check if an object is in a bag
     * @return boolean that returns true if bag contains object and false if not
     */
    public boolean contains(T entry){
        boolean contain = false;
        Node currentNode = firstNode;

        //checks if it already contains in bag and checks if the following bag object is available or not
        while(!contain && (currentNode != null)){
            if(entry.equals(currentNode.data)){
                contain = true;
            }else{//goes to next bag object
                currentNode = currentNode.next;
            }
        }
        
        return contain;
    }//end contains

    /**
     * @param entry The entry that needs to check the reference of an object in a bag
     * @return reference node
     */
    private Node getReferenceTo(T entry){
        boolean match = false;
        Node currentNode = firstNode;

        while(!match && (currentNode != null)){
            if(entry.equals(currentNode.data)){
                match = true;
            }else{//searches next bag object
                currentNode = currentNode.next;
            }
        }

        return currentNode;
    }//end getReferenceTo

    /**
     * clears bag
     */
    public void clear(){
        while(!isEmpty()){
            remove();
        }
    }//end clear

    /**
     * @return Returns removed entry or null if not available
     */
    public T remove(){
        T result = null;
        if (firstNode != null){
            result = firstNode.data;
            firstNode = firstNode.next;//remove first node from chain
            numEntries--;
        }

        return result;
    }//end remove

    /**
     * @param entry The entry that needs to be removed from the bag
     * @return Return true if removal of entry is successful and false if not
     */
    public boolean remove(T entry){
        boolean result = false;
        Node nodeR = getReferenceTo(entry);

        if (nodeR != null){
            nodeR.data = firstNode.data;
            firstNode = firstNode.next;
            numEntries--;
            result = true;
        }

        return result;
    }//end remove

    private class Node{

        private T data; // Entry in bag
        private Node next; // Link to next node

        private Node(T dataVar){
            this(dataVar, null);
        } // end constructor

        private Node(T dataVar, Node nextNode){
            data = dataVar;
            next = nextNode;
        } // end constructor
    } // end Node

    @Override
    public BagInterface<T> union(BagInterface<T> bag2){
        BagInterface < T > result = new LinkedBag<>();
        T[] bag2arr = bag2.toArray();

        for (T elem : bag2arr) {
            result.add(elem);
        }

        T[] bag1arr = this.toArray();
        for (T elem : bag1arr) {
            result.add(elem);
        }

   return result;

    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> bag2){
        BagInterface < T > result = new LinkedBag<>();
        BagInterface < T > finalResult = new LinkedBag < >();
        T[] bag1arr = this.toArray();

        for (T elem : bag1arr) {
            result.add(elem);
        }

        T[] bag2arr = bag2.toArray();
        for (T elem : bag2arr) {
            if(result.contains(elem)){
                finalResult.add(elem);
            }
        }

        return finalResult;
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> bag2){
        BagInterface<T> result = new LinkedBag<>();
        T[] myObjects = this.toArray();

        for(int index = 0; index < myObjects.length; ++index)
        {
            result.add(myObjects[index]);
        }
        T[] otherObjects = bag2.toArray();
        for(int index = 0; index < otherObjects.length; ++index)
        {
            if(result.contains(otherObjects[index]))
            {
                result.remove(otherObjects[index]);
            }
        }

        return result;
    }
}