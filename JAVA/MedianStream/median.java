// package JAVA.MedianStream;
import java.util.PriorityQueue;
import java.util.Collections;
class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public MedianFinder() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());

        if(max.size() < min.size()){
            max.offer(min.poll());
        }       
    }
    
    public double findMedian() {
        if(max.size()>min.size()) return max.peek();
        return (max.peek()+min.peek())/2.0;
    }
}


