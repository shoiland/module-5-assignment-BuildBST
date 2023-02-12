public class Main {
    public static void main(String[] args) {
        BST<Integer> numbers = new BST<>();
        numbers.add(50);
        numbers.add(25);
        numbers.add(100);
        numbers.add(10);
        numbers.add(75);
        numbers.add(125);
        numbers.add(90);
        numbers.add(115);
        numbers.add(117);
        System.out.println(numbers.remove(100));

    }
}
