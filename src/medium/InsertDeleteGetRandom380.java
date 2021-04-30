package medium;

import java.util.*;

public class InsertDeleteGetRandom380 {
    public static void main(String[] args) {
        InsertDeleteGetRandom380 thisClass = new InsertDeleteGetRandom380();
    }

    class RandomizedSet {

        // store
        private List<Integer> list = new ArrayList<Integer>();

        // from value to list index;
        private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val))
            {
                return false;
            }
            else
            {
                map.put(val, list.size());
                list.add(list.size(), val);
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {

            if (map.containsKey(val))
            {
                int cIndex = map.get(val);

                // copy the tail value to cIndex and chop off the tail integer
                int endValue = list.get(list.size() - 1);
                list.set(cIndex, endValue);

                System.out.println(map.size());
                System.out.println(endValue + " " + cIndex);
                map.put(endValue, cIndex);

                map.remove(val);
                list.remove(list.size() - 1);
                System.out.println("map size "+ map.size());
                System.out.println("list size "+ list.size());
                return true;
            }
            else
            {
                return false;
            }
        }

        /** Get a random element from the set. */
        public int getRandom() {
            Random random = new Random();
            return list.get(random.nextInt(list.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}