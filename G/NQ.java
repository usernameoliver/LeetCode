import java.util.*;
public class NQ {
    public static void main(String[] args) {
        int n = 4;
        NQ nq = new NQ();
        List<List<String>> result = nq.solveNQueens(n);
        for (List<String> list : result) {
            for (String line : list) {
                System.out.println(line);
            }
            System.out.println();
        }
    }
    private int size;
    public List<List<String>> solveNQueens(int n) {
        size = n;
        List<List<String>> result = new ArrayList<>();
        if (n == 0)    return result;
        for (int ci = 0; ci < size; ci++) {
            int[] rows = new int[size];
            Arrays.fill(rows, -1);
            placeQ(ci, result, rows);
        }
        return result;
    }
    public void placeQ(int ci, List<List<String>> result, int[] rows) {
        if (size == ci) {
            List<String> list = convertArrayToList(rows);
            System.out.println(list.toString());
            System.out.println("-----------------");
            result.add(list);
        }
        else {
            for (int ri = 0; ri < size; ri++) {
                if (isValid(rows, ri, ci)) {
                    rows[ci] = ri;
                    placeQ(ci + 1, result, rows);
                }
            }
        }
    }
    //row = rows[col]
    public boolean isValid(int[] rows, int row, int col) {
        for (int ci = 0; ci < col; ci++) {
            int rowExist = rows[ci];
            if (rowExist == row)    return false;
            if (Math.abs(row - rowExist) == Math.abs(col - ci))    return false;
        }
        return true;
    }

    public List<String> convertArrayToList(int[] rows) {
        for (int i : rows) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("&&&&&&&&&&&&&");
        List<String> list = new ArrayList<>();
        for (int j = 0; j < size; j++) {
            char[] line = new char[size];
            Arrays.fill(line, '.');
            int ci = rows[j];
            line[ci] = 'Q';
            list.add(new String(line)); 
        }
        return list; 
    }
}