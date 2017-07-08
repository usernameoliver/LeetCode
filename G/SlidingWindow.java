import java.util.*;
public class SlidingWindow {
    public static void main(String[] args) {
        int[] input = new int[] {1,3,-1,-3,5,3,6,7};
        int k = 3;
        SlidingWindow sw = new SlidingWindow();
        double[] result = sw.medianSlidingWindow(input, k);
        for (double x : result) {
            System.out.println(x);
        }
    }
    private PriorityQueue<Integer> minQ = new PriorityQueue<>();
    private PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums.length < k)    return new double[0];

        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i <= nums.length; i++) {
            
            if (i >= k) {
                result[i - k] = getMedian(k);
                remove(nums[i - k]);
            }


            if (i < nums.length) {
                add(nums[i], k);
            }

            
        }
        return result;
    }
    private void remove(int num) {
        if (minQ.contains(num)) {
            minQ.remove(num);
        }
        else {
            maxQ.remove(num);
        }
        resizeHeaps();
    }
    //minQ: 3
    //maxQ: 1, -1

    //minQ: 3, 1
    //maxQ: -1
    //num = -1
    private void add(int num, int k) {
        double median = getMedian(k);
        if (num < median) {
            maxQ.offer(num);
        }
        else {
            minQ.offer(num);
        }
        resizeHeaps();
    }
    private void resizeHeaps() {
        if (maxQ.size() > minQ.size()) {
            minQ.add(maxQ.poll());
    	}
        if (minQ.size() - maxQ.size() > 1) {
            maxQ.add(minQ.poll());
        }
    }
    private double getMedian(int k) {
        if (maxQ.isEmpty() && minQ.isEmpty())   return 0.0;
        double minTop = minQ.isEmpty() ? 0.0 : (minQ.peek() * 1.0);
        double  maxTop = maxQ.isEmpty() ? 0.0 : (maxQ.peek() * 1.0);
        if (k % 2 == 0) return (maxTop + minTop) / 2.0;
        else    return minTop;
    }
}