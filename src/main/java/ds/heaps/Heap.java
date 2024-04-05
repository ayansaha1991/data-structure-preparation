package ds.heaps;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    List<Integer> elements;

    public Heap() {
        this.elements = new ArrayList<>();
    }

    public void insert(Integer data) {
        this.elements.add(data);
        if (this.elements.size() > 1) {
            upHeap(this.elements.size()-1);
        }
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
        int leftChildIndex = left(index);
        int rightChildIndex = right(index);
        Integer currentParent = this.elements.get(index);
        int min = index;

        if (leftChildIndex < size() && this.elements.get(leftChildIndex) < currentParent) {
            min = leftChildIndex;
        }
        if (rightChildIndex < size() && this.elements.get(rightChildIndex) < currentParent) {
            min = rightChildIndex;
        }

        if (min != index) {
            swap(min, index);
            downHeap(index);
        }
    }

    private int left(int index) {
        return index *2 + 1;
    }
    private int right(int index) {
        return index * 2 + 2;
    }


    int size(){
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

    private void swap(int i, int j){
        Integer temp = this.elements.get(i);
        this.elements.set(i, this.elements.get(j));
        this.elements.set(j, temp);

    }

    private int parent(int index) {
        return (index -1 )/2;
    }
}
