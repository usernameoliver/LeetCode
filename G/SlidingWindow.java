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
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> qMin = new PriorityQueue<>();
        PriorityQueue<Integer> qMax = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0, j = 0;
        int index = 0;
        double[] result = new double[nums.length - k + 1];
        while (j < k - 1) {
            if (qMin.size() >= qMax.size()) {
                qMax.offer(nums[j]);
            }
            else qMin.offer(nums[j]);
            j++;
        }
        while (j < nums.length) {
            System.out.println(qMin.toString());
            if (qMin.size() >= qMax.size()) {
                qMax.offer(nums[j]);
            }
            else qMin.offer(nums[j]);
            if (j != (k - 1) ) {
                if (qMax.contains(nums[i])) qMax.remove(nums[i]);
                else    qMin.remove(nums[i]);
            }
            if (k % 2 == 0) {
                int min = qMin.peek();
                int max = qMax.peek();
                result[index++] = (min + max) / 2.0;
            }
            else {
                result[index++] = qMax.peek() * 1.0;
            }
            i++;
            j++;
        }
        return result;
    }
}