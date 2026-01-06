public class Main {
    public static void main(String[] args) {
        Treap<String> treap = new Treap<>(222);
        Treap<Integer> treap1 = new Treap<>();
        treap1.add(4, 19);
        treap1.add(2, 31);
        treap1.add(6, 70);
        treap1.add(1, 84);
        treap1.add(3, 12);
        treap1.add(5, 83);
        treap1.add(7, 26);


        treap.add("h", 9);
        treap.add("a", 2);
        treap.add("e", 0);
        treap.add("c", 4);
        treap.add("i", 7);

        //System.out.println(treap.toString());
        System.out.println(treap1.toString());

        treap.delete("i");
        System.out.println(treap.toString());

        //System.out.println(treap.find("h"));

    }
}