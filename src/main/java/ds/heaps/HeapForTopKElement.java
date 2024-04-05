package ds.heaps;

import java.util.ArrayList;
import java.util.List;

public class HeapForTopKElement {

    private List<Integer> items;
    private int k;

    public HeapForTopKElement(int k) {
        this.k = k;
        this.items = new ArrayList<>();
    }

    public static void main(String[] args) {
        HeapForTopKElement heap1 = new HeapForTopKElement(3);
        heap1.addItem(3);
        heap1.addItem(4);
        heap1.addItem(5);
        heap1.addItem(8);
        heap1.addItem(2);
        heap1.addItem(3);
        System.out.println(heap1.findTopKthItem());
        System.out.println();
        heap1.addItem(5);
        System.out.println(heap1.findTopKthItem());
        heap1.addItem(10);
        System.out.println(heap1.findTopKthItem());
        System.out.println(heap1.findTopKthItem());
        System.out.println(heap1.findTopKthItem());
        heap1.addItem(3);
        System.out.println(heap1.findTopKthItem());
        heap1.addItem(5);
        System.out.println(heap1.findTopKthItem());


    }

    private int getItem() {
        if (this.items.size() == 0 ){
            throw new RuntimeException("Empty Heap");
        }
        return this.items.get(0);
    }

    public int findTopKthItem() {
        if (k > items.size() ) {
            return -1;
        }
        return getItem();
    }

    public HeapForTopKElement() {
        this.items = new ArrayList<>();
    }

    public void addItem(Integer item) {
        if (!items.isEmpty() && items.size() == k && item < items.get(0)) {
            return;
        }
        items.add(item);
        if (items.size() > 1) {
            upheap( items.size()-1);
        }
        if (items.size() > k) {
            removeItem();
        }
    }

    public Integer removeItem() {

        Integer removedItem = this.items.get(0);
        Integer last = this.items.get(this.items.size() - 1);
        this.items.set(0, last);

        if (this.items.size() > 0) {
            downHeap(0);
        }

        return removedItem;
    }

    private void downHeap(int index) {

        if (index == this.items.size() - 1) {
            return;
        }

        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;

        if (leftChild < this.items.size() && this.items.get(index) > this.items.get(leftChild)) {
            swap(index, leftChild);
            downHeap(leftChild);
        } else if (rightChild < this.items.size() &&this.items.get(index) > this.items.get(rightChild)) {
            swap(index, rightChild);
            downHeap(rightChild);
        }
    }

    private void upheap(int index) {

        if (index == 0) {
            return;
        }

        int parentIndex = index/2;

        if (this.items.get(parentIndex) > this.items.get(index)) {
            swap(index, parentIndex);
            upheap(parentIndex);
        }

    }

    private void swap(int i, int j){
        Integer temp = this.items.get(i);
        this.items.set(i, this.items.get(j));
        this.items.set(j, temp);

    }

}
