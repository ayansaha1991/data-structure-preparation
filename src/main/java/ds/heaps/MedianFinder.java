package ds.heaps;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> (b-a));
    PriorityQueue<Integer> right = new PriorityQueue<>();

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);

        System.out.println(medianFinder.findMedian());
    }

    public void addNum(int num) {

        if (num < findMedian()) {
            left.add(num);
        } else {
            right.add(num);
        }
        
        int leftSize = left.size();
        int rightSize = right.size();
        int diff = Math.abs(leftSize - rightSize);

        if (diff > 1) {
            if (leftSize > rightSize) {
                Integer item = left.poll();
                right.add(item);
            } else {
                Integer item = right.poll();
                left.add(item);
            } 
        }
        
    }

    public double findMedian() {

        if (left.size() == 0 && right.size() == 0) {
            return Integer.MIN_VALUE;
        }
        // event sized
        if (left.size() > 0 && right.size() > 0 && ((left.size() + right.size()) % 2 == 0)) {
            double d1 = left.peek();
            double d2 = right.peek();
            return   (d1 +  d2)/2;
        }
        // odd sized
        else {
            if (left.size() > right.size()) {
                return left.peek();
            } else {
                return right.peek();
            }
        }
    }
}
