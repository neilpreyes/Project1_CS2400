package CS_2400.Project_1;

public class ArrayBagTest {
    BagInterface<String> bagA = new ResizeableArrayBag<>();
        BagInterface<String> bagB = new ResizeableArrayBag<>();

        bagA.add("Hi");
        bagA.add("World");
        bagB.add("Hello");
        bagB.add("World");

        System.out.println(Arrays.toString(bagA.union(bagB).toArray()));
        System.out.println(Arrays.toString(bagA.intersection(bagB).toArray()));
        System.out.println(Arrays.toString(bagA.difference(bagB).toArray()));
}
