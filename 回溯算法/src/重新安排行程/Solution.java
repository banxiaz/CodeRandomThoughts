package 重新安排行程;

import java.util.*;

public class Solution {
    List<String> result;
    Map<String, Map<String, Integer>> map; //{出发城市:{目的城市,次数}}

    public List<String> findItinerary(List<List<String>> tickets) {
        result = new LinkedList<>();
        map = new HashMap<>();
        for (List<String> t : tickets) {
            Map<String, Integer> temp;
            if (map.containsKey(t.get(0))) {
                temp = map.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
            } else {
                temp = new TreeMap<>(); //按照key排序
                temp.put(t.get(1), 1);
            }
            map.put(t.get(0), temp);
        }
        System.out.println(map);
        result.add("JFK");
        backtracking(tickets.size());
        System.out.println(result);
        System.out.println(map);

        return new ArrayList<>(result);
    }

    public boolean backtracking(int tickNum) {
        if (result.size() == tickNum + 1) {
            return true;
        }
        String last = result.get(result.size() - 1);
        if (map.containsKey(last)) {
            for (Map.Entry<String, Integer> target : map.get(last).entrySet()) {
                int count = target.getValue(); //获取当前目的地剩余机票
                if (count > 0) {
                    result.add(target.getKey());
                    target.setValue(count - 1);
                    if (backtracking(tickNum)) return true;
                    result.remove(result.size() - 1);
                    target.setValue(count);
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[][] ticket = new String[][]{{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        System.out.println(Arrays.deepToString(ticket));
        List<List<String>> tickets = new ArrayList<>();
        for (String[] s : ticket) {
            tickets.add(Arrays.asList(s));
        }
        System.out.println(tickets);
        new Solution().findItinerary(tickets);
    }
}
