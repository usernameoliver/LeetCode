import java.util.*;
public class Maze {
    public static void main (String[] args) {
        int[][] maze = new int[][] {
            {0,0,0,0,0},{1,1,0,0,1},{0,0,0,0,0},{0,1,0,0,1},{0,1,0,0,0}
        };
        int[] ball = new int[] {4, 3};
        int[] hole = new int[] {0, 1};
        Maze m = new Maze();
        String result = m.findShortestWay(maze, ball, hole);
        System.out.println(result);
    } 
    public class Pair implements Comparable<Pair> {
        int x, y, l;
        String s;
        public Pair(int x, int y, int l, String s) {
            this.x = x;
            this.y = y;
            this.l = l;
            this.s = s;
        }
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
            this.l = Integer.MAX_VALUE;
            this.s = "";
        }
        public int compareTo(Pair p) {
            return p.l == l ? s.compareTo(p.s) : l - p.l;
        }
    }
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length, n = maze[0].length;
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.offer(new Pair(ball[0], ball[1], 0, ""));
        Pair[][] points = new Pair[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                points[i][j] = new Pair(i, j);
            }
        }
        
        int[][] dirs = new int[][] {
            {0, -1}, {-1, 0}, {1, 0}, {0, 1}
        };
        String[] dirNames = new String[] {
            "d", "l", "r", "u"
        };
        q.offer(new Pair(ball[0], ball[1], 0, ""));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            System.out.println("x = " + p.x + " and y = " + p.y);
            if (points[p.x][p.y].compareTo(p) <= 0) continue;
            points[p.x][p.y] = p;
            for (int i = 0; i < 4; i++) {
                int x = p.x;
                int y = p.y;
                int l = p.l;
                int[] dir = dirs[i];
                String dirName = dirNames[i];
 
                
                while (x >= 0 && y >= 0 && x < m && y < n && maze[x][y] == 0 && (x != hole[0] || y != hole[1])) {
                    x += dir[0];
                    y += dir[1];
                    l++;
                }
                if (x != hole[0] || y != hole[1]) {
                    x -= dir[0];
                    y -= dir[1];
                    l--;
                }   
                q.offer(new Pair(x, y, l, p.s + dirName));

            }
        }
        return points[hole[0]][hole[1]].l == Integer.MAX_VALUE ? "impossible" : points[hole[0]][hole[1]].s;
    }
}