package hard;

import java.util.*;

public class Hard0332ReconstructItinerary {
    class Solution {
        List<String> result = null;
        Map<String, List<Integer>> vertexToTicketsIndex = new HashMap<>();
        int ticketsLen;
        public List<String> findItinerary(List<List<String>> tickets) {
            ticketsLen = tickets.size();
            for (int i = 0; i < tickets.size(); i++){
                List<String> ti = tickets.get(i);
                List<Integer> tList = vertexToTicketsIndex.getOrDefault(ti.get(0), new ArrayList<>());
                tList.add(i);
                vertexToTicketsIndex.put(ti.get(0), tList);
            }
            for (String k : vertexToTicketsIndex.keySet()){
                List<Integer> tList = vertexToTicketsIndex.get(k);
                Collections.sort(tList, (a, b) -> tickets.get(a).get(1).compareTo(tickets.get(b).get(1))  );
                vertexToTicketsIndex.put(k, tList);
            }
            List<String> initialAirports = new ArrayList<>();
            initialAirports.add("JFK");
            dfs("JFK", new HashSet<>(), initialAirports, tickets);
            return result;
        }
        private void dfs(String curVertex, Set<Integer> ticketsUsed, List<String> airports, List<List<String>> tickets){
            if (result != null){
                return;
            }
            if (ticketsLen == ticketsUsed.size()){
                result = new ArrayList<>(airports);
                return;
            }
            if (vertexToTicketsIndex.containsKey(curVertex)){
                List<Integer> possibleTickets = vertexToTicketsIndex.get(curVertex);
                for (int i = 0; i < possibleTickets.size(); i++){
                    if ( !ticketsUsed.contains( possibleTickets.get(i) ) ){
                        ticketsUsed.add( possibleTickets.get(i) );
                        airports.add(tickets.get( possibleTickets.get(i) ).get(1) );
                        dfs(tickets.get( possibleTickets.get(i) ).get(1), ticketsUsed, airports, tickets);
                        airports.remove(airports.size() - 1);
                        ticketsUsed.remove( possibleTickets.get(i) );
                    }
                }
            }
        }
    }
}