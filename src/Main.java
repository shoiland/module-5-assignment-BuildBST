public class Main {
    public static void main(String[] args) {
        BST<Integer> numbers = new BST<>();
        numbers.add(35);
        numbers.add(27);
        numbers.add(22);
        numbers.add(55);
        numbers.add(46);
        numbers.add(57);
        numbers.add(32);
        System.out.println("hey");
        numbers.remove(34);
        numbers.remove(32);
        System.out.println("hey");

    }
}
