import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

/*
    ALGO:  stack

    create an ezpression validator to test if brackets are correctly matched

 */
public class Expressions {

    static boolean isValidExpression(String expr) {

        Map<Character, Character> opens = Map.ofEntries(
                entry('(', ')'),
                entry('[', ']'),
                entry('{', '}')
        );

        Map<Character, Character> closes = Map.ofEntries(
                entry(')', '('),
                entry(']', '['),
                entry('}', '{')
        );

        List<Character> stack = new ArrayList<Character>();
        int top = -1;
        char [] expr_arr = expr.toCharArray();
        char open_match, top_stack;
        System.out.println("Initialized stack:  " + top + ":" + stack);
        for (char val : expr_arr) {
            if (opens.containsKey(val)) {
                stack.add(val);
                top++;
                System.out.println("Pushed stack: " + top + ":" + stack);
            }
            else if (closes.containsKey(val)) {
                open_match = closes.get(val);
                if (top != -1) {
                    top_stack = stack.get(top);
                } else {
                    System.out.println("Error:  Missing lead open bracket.");
                    return false;
                }
                if (top_stack == open_match) {
                    stack.remove(stack.size() - 1);
                    top--;
                    System.out.println("Popped Stack:  " + open_match + ":" + top + ":" + stack);
                } else {
                    System.out.println("Error:  mismatched brackets.");
                    return false;
                }
            }
        }
        System.out.println("Final Stack:  " + top + ":  " + stack);
        if (stack.size() == 0) {
            return true;
        } else {
            System.out.println("Error:  Missing closed brackets.");
            return false;
        }
    }

    public static void main(String[] args) {

        // Test 1: True
        // String expr = "[a]";

        // Test 2: True
        // String expr = "{(ab)cd}";

        // Test 3: False
        // String expr = "c]";

        // test 4: False
        String expr = "([b]";

        boolean isValid = isValidExpression(expr);
        System.out.println(expr + ": isValid:" + isValid);

    }
}
