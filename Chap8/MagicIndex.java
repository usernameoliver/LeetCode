public class MagicIndex {
	public static void main(String[] args) {
		int[] input = new int[] {-1, 1, 2, 6, 7, 8};
		MagicIndex mi = new MagicIndex();
		int result = mi.getIndex(input);
		System.out.println(result);
	}
	public int getIndex(int[] nums) {
		int start = 0, end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] > mid) {
				end = mid;
			}
			else if (nums[mid] < mid) {
				start = mid;
			}
			else {
				return mid;
			}
		}
		if (start == nums[start])	return start;
		if (end == nums[end])	return end;
		return -1;
	} 
}