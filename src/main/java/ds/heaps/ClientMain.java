package ds.heaps;

public class ClientMain {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(11);
        heap.insert(1);
        int size = heap.size();
        for (int i = 0; i < size; i++) {
            Integer removed = heap.remove();
            System.out.print(removed + ", ");
        }
    }
}
