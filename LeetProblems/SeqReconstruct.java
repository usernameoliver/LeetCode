import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by olive on 4/10/2017.
 */
public class SeqReconstruct {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        List<List<Integer>> permutations = findPermutations(org);

        System.out.println(permutations.toString());
        boolean isSubset = isSubsetOf(permutations, seqs);
        return isSubset;
    }
    public List<List<Integer>> findPermutations(int[] org) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(result, list, org, 0);
        return result;
    }
    public void dfs(List<List<Integer>> result, List<Integer> list, int[] org, int pos) {
        result.add(new ArrayList<Integer>(list));
        for (int i = pos; i < org.length; i++) {
            list.add(org[i]);
            dfs(result, list, org, i + 1);
            list.remove(list.size() - 1);
        }
    }
    public boolean isSubsetOf(List<List<Integer>> big, List<List<Integer>> small) {
        if (small.size() > big.size())  return false;
        HashSet<Integer> bigSet = new HashSet<>(), smallSet = new HashSet<>();
        for (List<Integer> list : big) {
            bigSet.addAll(list);
        }
        for (List<Integer> list : small) {
            smallSet.addAll(list);
        }
        return bigSet.size() >= smallSet.size();
    }

    public static void main(String[] args) {
        int[] org = new int[] {1, 2, 3};
        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list2.add(2);
        list2.add(3);

        lists.add(list1);
        lists.add(list2);

        SeqReconstruct sqR = new SeqReconstruct();
        boolean res = sqR.sequenceReconstruction(org, lists);
        System.out.println(res);
    }
}
