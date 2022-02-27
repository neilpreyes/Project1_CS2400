package CS_2400.Project_1;

import java.util.Arrays;

public class LinkedBagTest {
    public static void main(String[] args){
        BagInterface<String> bagA = new LinkedBag<>();
        BagInterface<String> bagB = new LinkedBag<>();

        bagA.add("Hi");
        bagA.add("World");
        bagB.add("Hello");
        bagB.add("World");

        System.out.println(Arrays.toString(bagA.union(bagB).toArray()));
        System.out.println(Arrays.toString(bagA.intersection(bagB).toArray()));
        System.out.println(Arrays.toString(bagA.difference(bagB).toArray()));
    }
}
