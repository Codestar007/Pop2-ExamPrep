package Mock_Practical.worksheet;

import java.util.HashMap ;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by kjeged01 on 03/06/2018.
 */
public class RarestAge {
    public static int rarestAge (Map<String , Integer> m) {
        if (m == null || m.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Map<Integer, Integer> counts = new TreeMap<>();
        for (String name : m.keySet()) {
            int age = m.get(name);
            if (counts.containsKey(age)) {
                counts.put(age, counts.get(age) + 1);
            } else {
                counts.put(age, 1);
            }
        }

        int minCount = m.size() + 1;
        int rareAge = -1;

        for (int age : counts.keySet()) {
            int count = counts.get(age);
            if (count < minCount) {
                minCount = count;
                rareAge = age;
            }
        }
        return rareAge;
    }
}
