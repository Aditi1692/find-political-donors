import java.util.Collections;
import java.util.PriorityQueue;

public class CalculateMedian {

	PriorityQueue<Double> maxHeap;//lower half
    PriorityQueue<Double> minHeap;//higher half
    
    public CalculateMedian(){
        maxHeap = new PriorityQueue<Double>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Double>();
    }
 
    // Adds a number into the data structure.
    public void addNum(double curr_amount) {
        maxHeap.offer(curr_amount);
        minHeap.offer(maxHeap.poll());
 
        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
 
    // Returns the median of current data stream
    public int findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (int)Math.round((double)(maxHeap.peek()+(minHeap.peek()))/2);
        }else{
            return (int) Math.round(maxHeap.peek());
        }
    }

	public int getSize() {
		return maxHeap.size()+minHeap.size();
	}
}
