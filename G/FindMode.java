import java.util.*;

public class FindMode {
  
    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
 
    public static int[] findMode(TreeNode root) {
        if (root == null)   return null;
        Map<Integer, Integer> count = new HashMap<>();
        tranverse(root, count);
        List<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        System.out.println(count.entrySet());
        for (int key : count.keySet()) {
            if (count.get(key) > max) {
                result = new ArrayList<>();
                result.add(key);
            }
            else if (count.get(key) == max) {
                result.add(key);
            }
            else {
                continue;
            }
        }
        int[] arrayResult = result.stream().mapToInt(i->i).toArray();
        return arrayResult;
    }
    
    public static void tranverse(TreeNode node, Map<Integer, Integer> count) {
        if (node.left != null)  tranverse(node.left, count);
        int val = node.val;
        int occur = count.getOrDefault(val, 0);
        occur++;
        count.put(val, occur);
        if (node.right != null) tranverse(node.right, count);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        a.right = b;
        FindMode fm = new FindMode();
        int [] result = fm.findMode(a);
        for (int i : result) {
            System.out.println(i);
        }
    }
}