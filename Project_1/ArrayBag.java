package CS_2400.Project_1;

public class ArrayBag<T> implements BagInterface<T>{
	private final T[] bag;
	public static final int DEFAULT_CAPACITY = 25;
	private int numberOfEntries;
	
	public ArrayBag(){
		this(DEFAULT_CAPACITY);
	}//end default constructor
	
	/*Creates an empty bag having a given initial capacity.
	 @param capacity the integer capacity desired*/
	public ArrayBag(int capacity) {
		numberOfEntries = 0;
		//the cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[])new Object[capacity]; //unchecked cast
		bag = tempBag;
	}//end constructor
	
	/*Adds a new entry to this bag
	 * @param newEntry the object to be added as a new entry
	 * @return true if the addition is successful or false if not*/
	public boolean add(T newEntry) {
		boolean result = true;
		if(isFull()) {
			result = false;
		}else {
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
		}
		return result;
	}//end add
	
	/**Retrieves all entries that are in this bag
	 @return a newly allocated array of all the entries in the bag*/
	public T[] toArray() {
		//the cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		for(int index = 0; index < numberOfEntries; index++) {
			result[index] = bag[index];
		}
		return result;
	}//end toArray
	
	/**Sees whetehr this bag is full
	@return true if the bad is full or false if not*/
	public boolean isFull() {
		return numberOfEntries == bag.length;
	}//end isFull

	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}
}//end ArrayBag

