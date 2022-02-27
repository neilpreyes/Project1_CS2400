package CS_2400.Project_1;

import java.io.InputStreamReader;
import java.util.*;

public class ResizeableArrayBag<T> implements BagInterface<T> {
    private T[] objectArray;
    private static final int DEFAULT_CAPACITY = 4;
    private int bagCapacity;
    private int numObjects;

    public ResizeableArrayBag(){
        this(DEFAULT_CAPACITY);
    }

    public ResizeableArrayBag(int capacity){
        bagCapacity = capacity;
        numObjects = 0;
        
        @SuppressWarnings("unchecked")
        T[] temporaryBag = (T[]) new Object[capacity];
        objectArray = temporaryBag;
    }

    public ResizeableArrayBag(ResizeableArrayBag newBag){
        @SuppressWarnings("unchecked")
        T[] temporaryBag = (T[]) new Object[newBag.getCapacity()];
        bagCapacity = newBag.getCapacity();
        objectArray = temporaryBag;

        numObjects = newBag.numObjects;
        for(int i = 0; i < newBag.numObjects; ++i){
            @SuppressWarnings("unchecked")
            T movingObject = (T) newBag.objectArray[i];
            objectArray[i] = movingObject;
        }
    }

    public int getCurrentSize(){
        return numObjects;
    }

    public int getCapacity(){
        return bagCapacity;
    }

    public void resize(int newCapacity){
        if(bagCapacity > newCapacity){
            return;
        }else{
            objectArray = Arrays.copyOf(objectArray, newCapacity);
            bagCapacity = newCapacity;
        }
    }


    public boolean isEmpty() {
        return numObjects == 0;
    }

    public boolean isFull(){
        if(bagCapacity == numObjects){
            return true;
        }
        return false;
    }

    public boolean add(T newEntry) {
        if(isFull()){
            resize(2*bagCapacity);
            objectArray[numObjects] = newEntry;
            numObjects++;
            return true;
        }else{
            objectArray[numObjects] = newEntry;
            numObjects++;
            if(isFull()){
                return true;
            }
            else{
                return false;
            }
        }
    }


    public T remove() {
        // TODO Auto-generated method stub
        return null;
    }

    
    public boolean remove(T anEntry) {
        int i = 0;

        while(i < numObjects){

            if(objectArray[i].equals(anEntry)){
                if(i < numObjects){
                    objectArray[i] = objectArray[numObjects-1];
                    objectArray[numObjects-1] = null;
                    numObjects--;
                    return true;
                }
            }

            i++;
        }
        return true;
    }

    
    public void clear() {
        for(int i = 0; i < numObjects; i++){
            objectArray[i] = null;
            numObjects = 0;
        }
    }

    
    public int getFrequencyOf(T anEntry) {
        int count = 0;
        for(int i = 0; i < numObjects; i++){
            if(objectArray[i].equals(anEntry)){
                count++;
            }

        }
        return count;
    }

    
    public boolean contains(T anEntry) {
        
        return false;
    }

    
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numObjects];

        for(int i = 0; i < numObjects; i++){
            result[i] = objectArray[i];
        }
        return result;
    }

    @Override
    public BagInterface<T> union(BagInterface<T> bag2) {
        BagInterface<T> result = new ResizeableArrayBag<>();
        T[] mine = this.toArray();
        for (T elem : mine) {
            result.add(elem);
        }

        T[] otherBag = bag2.toArray();
        for (T elem : otherBag) {
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

    /**
    * The difference of two collections is a new collection of the 
    * entries that would be left in one collection after removing those 
    * that also occur in the second. 
    * @param aBag A bag that we will be using to compare the objects within it. 
    * @return result The newly created bag. 
    */
   @Override
   public BagInterface<T> difference(BagInterface<T> aBag) 
   {
      BagInterface <T> result = new ResizableArrayBag<>();
      T[] myObj = this.toArray(); // creates copies of the objects
   
      for(int index = 0; index < myObj.length; ++index)
      {
         result.add(myObj[index]); // add objects to the bag
      }
      T[] otherObj = aBag.toArray(); // creates copies of the objects
      for(int index = 0; index < otherObj.length; ++index)
      {
         if(result.contains(otherObj[index]))
         {
            result.remove(otherObj[index]); // removes objects from result if they match the otherObj array
         }
      }

      return result;
   }
}
