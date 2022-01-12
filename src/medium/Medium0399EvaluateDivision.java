package medium;

import java.util.*;

public class Medium0399EvaluateDivision {

    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Set<String> variableSet = new HashSet<>();
            for (List<String> stringList : equations){
                variableSet.add(stringList.get(0));
                variableSet.add(stringList.get(1));
            }

            List<Double> result = new ArrayList<>();

            for (List<String> stringList : queries){
                String stringFirst = stringList.get(0);
                String stringSecond = stringList.get(1);
                if (variableSet.contains(stringFirst) && variableSet.contains(stringSecond)) {

                    Set<String> visited = new HashSet<>();
                    visited.add(stringFirst);
                    Queue<Pair> queue = new LinkedList<>();
                    for ( int i = 0; i < equations.size(); i++ ){

                        List<String> varList = equations.get(i);
                        String var1 = varList.get(0);
                        String var2 = varList.get(1);
                        if (var1.equals(stringFirst)){
                            queue.add(new Pair(var2, values[i]));
                        }
                        if (var2.equals(stringFirst)){
                            queue.add(new Pair(var1, 1 / values[i]));
                        }
                    }
                    boolean foundAnswer = false;
                    while(!queue.isEmpty() ){
                        Pair top = queue.poll();

                        if (top.var.equals(stringSecond)){
                            result.add(top.res);
                            foundAnswer = true;
                            break;
                        }

                        if (!visited.contains(top.var)){
                            visited.add(top.var);

                            for ( int i = 0; i < equations.size(); i++ ){

                                List<String> varList = equations.get(i);
                                String var1 = varList.get(0);
                                String var2 = varList.get(1);
                                if (var1.equals(top.var)){
                                    queue.add(new Pair(var2, top.res * values[i]));
                                }
                                if (var2.equals(top.var)){
                                    queue.add(new Pair(var1, 1 / values[i] * top.res ) );
                                }
                            }


                        }

                    }
                    if (!foundAnswer){
                        result.add(-1.0);
                    }
                }
                else{
                    result.add(-1.0);
                }
            }


            double[] tmp = new double[result.size()];
            int tmpIdx = 0;
            for (Double d : result){
                tmp[tmpIdx++] = d;
            }
            return tmp;
        }

        class Pair{
            String var = "";
            double res = 0.0;
            public Pair(String v, double r){
                var = v;
                res = r;
            }
        }
    }

    class Solution1 {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Map<String, List<Pair>> map = new HashMap<>();

            for (int i = 0; i < equations.size(); i++){
                List<Pair> edgeList = map.getOrDefault(equations.get(i).get(0), new ArrayList<>());
                edgeList.add(new Pair(equations.get(i).get(1), values[i]));
                map.put(equations.get(i).get(0), edgeList);

                edgeList = map.getOrDefault(equations.get(i).get(1), new ArrayList<>());
                edgeList.add(new Pair(equations.get(i).get(0), 1 / values[i]));
                map.put(equations.get(i).get(1), edgeList);

            }

            double[] rlt = new double[queries.size()];
            Arrays.fill(rlt, -1.0);

            for (int i = 0; i < queries.size(); i++){
                List<String> curQuery = queries.get(i);

                String target = curQuery.get(1);

                Queue<Pair> queue = new LinkedList<>();
                queue.add( new Pair(curQuery.get(0), 1.0) );

                Set<String> visited = new HashSet<>();

                while(!queue.isEmpty()){
                    Pair top = queue.poll();

                    if (!visited.contains(top.stringValue)){
                        visited.add(top.stringValue);
                        if (map.containsKey(top.stringValue)){
                            for (Pair pair : map.get(top.stringValue)){
                                if (pair.stringValue.equals(target)){
                                    rlt[i] = top.result * pair.result;
                                    break;
                                }
                                queue.add(new Pair(pair.stringValue, top.result * pair.result ));
                            }
                        }
                    }
                }
            }
            return rlt;
        }
        class Pair{
            String stringValue = "";
            double result = 1.0;

            public Pair(String stringValue, double result){
                this.stringValue = stringValue;
                this.result = result;
            }
        }
    }
}