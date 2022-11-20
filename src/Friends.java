import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    ALGO - MAP-DICT:
    - Given directed connection node pairs
    - Create origin node list each with list of any connected nodes regardless of direction

    EXPECTED OUTPUT of emp_friends
    1:[2]
    2:[1]
    3:[4,6]
    4:[3,5]
    5:[4]
    6:[3,7]
    7:[6]
    8:[]

 */

public class Friends {

    static Map<Integer, Set<Integer>> load_emp_ids(String[] emp_input) {
        Map<Integer, Set<Integer>> master_emp = new HashMap<Integer, Set<Integer>>();
        String[] emp_info;
        for (int i = 0; i < emp_input.length; i++) {
            emp_info = emp_input[i].split(",");
            master_emp.put(Integer.parseInt(emp_info[0]), new HashSet<Integer>());
        }
        return master_emp;
    }

    static Map<Integer, Set<Integer>> load_directed_friendships(Map<Integer, Set<Integer>> master_emp,
                                                                int[][] directed_friendships,
                                                                boolean isLtoR) {
        int fromNode, toNode;
        for (int[] pair : directed_friendships) {
            if (isLtoR) {
                fromNode = pair[0];
                toNode = pair[1];
            }
            else {
                toNode = pair[0];
                fromNode = pair[1];
            }
            master_emp.get(fromNode).add(toNode);
        }
        return master_emp;
    }

    public static void main(String[] args) {

        String[] emp_input = {
                                "1, Ray, Engr",
                                "2, Emily, HR",
                                "3, Alice, Engr",
                                "4, Donald, Executive",
                                "5, Ryan, Engr",
                                "6, Rick, HR",
                                "7, Angie, Executive",
                                "8, Bozo, Marketing"
                               };

        int[][] friends_input = {  {1, 2},
                                    {2, 1},
                                    {3, 4},
                                    {3, 6},
                                    {4, 5},
                                    {5, 4},
                                    {7, 6}
                                 };


        Map<Integer, Set<Integer>> master_emp = load_emp_ids(emp_input);

        for (Map.Entry<Integer,Set<Integer>> entry : master_emp.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        master_emp = load_directed_friendships(master_emp, friends_input, true);

        for (Map.Entry<Integer,Set<Integer>> entry : master_emp.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        master_emp = load_directed_friendships(master_emp, friends_input, false);

        for (Map.Entry<Integer,Set<Integer>> entry : master_emp.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }
}
