import java.util.*;
public class Maze {
	public static void main(String[] args) {
		Maze s = new Maze();
		int[][] maze = new int[][] {
			{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}
		};
		int[] start = {0, 4}, destination = {3, 2};
		boolean result = s.hasPath(maze, start, destination);
		System.out.println(result);
	}
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
	    if (start[0] == destination[0] && start[1] == destination[1]) return true;
	    Queue<int[]> queue = new LinkedList<int[]>();
	    queue.offer(start);
	    int m = maze.length;
	    int n = maze[0].length;
	    boolean[][] visited = new boolean[m][n];
	    visited[start[0]][start[1]] = true;
	    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	    while (!queue.isEmpty()) {
	        int[] cur = queue.poll();
	        for (int k = 0; k < dir.length; k++) {
	            int x = cur[0];
	            int y = cur[1];
	            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
	                x += dir[k][0];
	                y += dir[k][1];
	            }
	            x -= dir[k][0];
	            y -= dir[k][1];
	            if (visited[x][y]) continue;
	            visited[x][y] = true;
	            if (x == destination[0] && y == destination[1]) return true;
	            queue.offer(new int[] {x, y});
	        }
	    }
        return false;
    }
}