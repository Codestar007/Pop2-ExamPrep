package Practice_Practical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by kjeged01 on 03/06/2018.
 */
public class University {
    public static void main(String[] args) {
        new University().run();
    }
    class Course {
        private String name;
        private int id;

        //Constructor
        Course(String name, int id) {
            this.name = name;
            this.id = id;
        }
    }
    public void run() {
        Map<String, Map<String, Integer>> uni = new HashMap<>();

        Map<String, Integer> cs = new HashMap<>();
        cs.put("Information Systems", 300);
        cs.put("Data Management", 300);
        uni.put("Computing", new HashMap<>(cs));

        Map<String, Integer> eng = new HashMap<>();
        eng.put("Mechanical", 100);
        eng.put("Civil", 150);
        uni.put("Engineering", new HashMap<>(eng));

        Map<String, Integer> bus = new HashMap<>();
        bus.put("Management", 800);
        uni.put("Business", new HashMap<>(bus));

        System.out.println("Hello");

        System.out.println("Number of departments: " + uni.size());
        System.out.println("Computing programes size: " + uni.get("Computing").size());
        System.out.println("Engineering dept student total: " + sum(uni.get("Engineering").values()
                .stream().collect(toList())));

        System.out.println("Hello2");

    }
    private Integer sum(List<Integer> list){
        Integer total = new Integer(0);
        for(Integer i: list){
            total = total + i;
        }
        return total;
    }
}
