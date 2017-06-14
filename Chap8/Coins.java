public class Coins {
	public static void main(String[] args) {
		int n = 5;
		Coins coinsMaker = new Coins();
		int result = coinsMaker.getChanges(n);
		System.out.println(result);
	}
	public int getChanges(int n) {
		int[] denoms = new int[] {25, 10, 5, 1};
		int[][] map = new int[n + 1][denoms.length];
		return getChanges(n, 0, denoms, map);
	}
	public int getChanges(int n, int index, int[] denoms, int[][] map) {
		if (map[n][index] != 0) {
			return map[n][index];
		}
		if (index >= denoms.length - 1) return 1;
		int ways = 0;
		int currentDenom = denoms[index];
		for (int i = 0; i * currentDenom <= n; i++) {
			n -= i * currentDenom;
			ways += getChanges(n, index + 1, denoms, map);
		}
		map[n][index] = ways;
		return ways;
	}
}

