import java.util.*;

/**
 * Created by olive on 4/9/2017.
 */
public class EvaluateDivision {
        HashMap<String, ArrayList<Double>> edgeMap = new HashMap<>();
        HashMap<String, ArrayList<String>> nodeMap = new HashMap<>();
//        public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
//            int n = values.length;
//       //     Map<String, List<String>> nodeMap = new HashMap<>();
//       //     Map<String, List<Double>> edgeMap = new HashMap<>();
//            for (int i = 0; i < n; i++) {
//                String n1 = equations[i][0];
//                String n2 = equations[i][1];
//                ArrayList<String> neighborsOfN1 = nodeMap.getOrDefault(n1, new ArrayList<>());
//                neighborsOfN1.add(n2);
//                nodeMap.put(n1, neighborsOfN1);
//                ArrayList<Double> edgesOfN1 = edgeMap.getOrDefault(n1, new ArrayList<>());
//                edgesOfN1.add(values[i]);
//                edgeMap.put(n1, edgesOfN1);
//            }
//            double[] result = new double[queries.length];
//            for (int i = 0; i < queries.length; i++) {
//                String[] query = queries[i];
//                result[i] = dfs(query[0], query[1], nodeMap, edgeMap, new HashSet<String>(), 1.0);
//                if (result[i] == 0.0) result[i] = -1.0;
//            }
//            return result;
//        }
public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    HashMap<String, ArrayList<String>> pairs = new HashMap<String, ArrayList<String>>();
    HashMap<String, ArrayList<Double>> valuesPair = new HashMap<String, ArrayList<Double>>();
    for (int i = 0; i < equations.length; i++) {
        String[] equation = equations[i];
        if (!pairs.containsKey(equation[0])) {
            pairs.put(equation[0], new ArrayList<String>());
            valuesPair.put(equation[0], new ArrayList<Double>());
        }
        if (!pairs.containsKey(equation[1])) {
            pairs.put(equation[1], new ArrayList<String>());
            valuesPair.put(equation[1], new ArrayList<Double>());
        }
        pairs.get(equation[0]).add(equation[1]);
        pairs.get(equation[1]).add(equation[0]);
        valuesPair.get(equation[0]).add(values[i]);
        valuesPair.get(equation[1]).add(1/values[i]);
    }

    double[] result = new double[queries.length];
    for (int i = 0; i < queries.length; i++) {
        String[] query = queries[i];
        result[i] = dfs(query[0], query[1], pairs, valuesPair, new HashSet<String>(), 1.0);
        if (result[i] == 0.0) result[i] = -1.0;
    }
    return result;
}
        public double dfs(String start, String end, HashMap<String, ArrayList<String>> nodeMap, HashMap<String, ArrayList<Double>> edgeMap, HashSet<String> set, double value) {
            if (set.contains(start))  return 0.0;
            if (!nodeMap.containsKey(start))   return 0.0;
            if (start.equals(end))  return value;
            set.add(start);
            ArrayList<String> neighbors = nodeMap.get(start);
            ArrayList<Double> valueList = edgeMap.get(start);
            double temp = 0.0;
            for (int i = 0; i < neighbors.size(); i++) {
                String neighbor = neighbors.get(i);
                double val = valueList.get(i);
                temp = dfs(neighbor, end, nodeMap, edgeMap, set, value * val);
                if (temp != 0.0)    break;
            }
            set.remove(start);
            return temp;
        }
        public static void main(String[] args) {
            String[][] eqs = new String[][] {{"a", "b"}, {"b", "c"}};
            double[] values = new double[] {2.0, 3.0};
            String[][] queries = new String[][] {{"a", "c"}, {"b", "c"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
            EvaluateDivision ed = new EvaluateDivision();
            double[] results = ed.calcEquation(eqs, values, queries);
            System.out.println(ed.nodeMap.entrySet());
            System.out.println(ed.edgeMap.entrySet());
            for (double result : results) {
                System.out.println(result);
            }
        }
}
