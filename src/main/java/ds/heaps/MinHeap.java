package ds.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinHeap {

    List<Integer> elements;

    public MinHeap() {
        this.elements = new ArrayList<>();
    }

    public void insert(Integer data ) {
        this.elements.add(data);
//        if (this.elements.size() > 1) {
            upHeap(this.elements.size()-1);
//        }
    }

    public Integer get() {
        if (this.elements.size() == 0) {
            throw new IllegalArgumentException("");
        }
        return  this.elements.get(0);
    }

    //removing first element
    public Integer remove(){
        if (size() == 0 ) throw  new IllegalArgumentException();

        int temp = this.elements.get(0);
        // removing the last element
        int lastElement = this.elements.remove(size()-1);

        // No need to rebalanced if the heap contains only one element
        if (!this.elements.isEmpty()) {
            this.elements.set(0, lastElement);
            downHeap(0);
        }

        return temp;
    }

    private void downHeap(int index) {
        int min = index;
        int leftChildIndex = left(index);
        int rightChildIndex = right(index);
        int parentElement = this.elements.get(min);

        if (index == size()-1) return;

        if (rightChildIndex < size() && this.elements.get(rightChildIndex) < parentElement) {
            min = rightChildIndex;
        }

        if (leftChildIndex < size() && this.elements.get(leftChildIndex) < this.elements.get(min)  ) {
            min = leftChildIndex;
        }


        if (min != index) {
            swap(min, index);
            downHeap(min);
        }
    }

    private int left(int index) {
        return index *2 + 1;
    }
    private int right(int index) {
        return index * 2 + 2;
    }


    public int size(){
        return this.elements.size();
    }

    private void upHeap(int index) {

        if (index == 0) {
            return;
        }
        int parent = parent(index);
        if (this.elements.get(parent) > this.elements.get(index)) {
            swap(parent, index);
            upHeap(parent);
        }
    }

    private void swap(int first, int second){
        Integer temp = this.elements.get(first);
        this.elements.set(first, this.elements.get(second));
        this.elements.set(second, temp);

    }

    private int parent(int index) {
        return (index -1 )/2;
    }
}
