package fop.w7stack;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BracketStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(correctExpressionChecker(s) ? "YES" : "NO");
    }

    private static boolean correctExpressionChecker(String s) {
        MyStack stack = new MyStack();
        Map<Character,Character> mp = new HashMap<>();
        mp.put(']','[');
        mp.put('}','{');
        mp.put(')','(');
        // ()([[{{}}]]))
        for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k) == '(' || s.charAt(k) == '[' && s.charAt(k) == '{')
                stack.add(s.charAt(k));
            else {
                if (stack.isEmpty())
                    return false;
                if (stack.top() == mp.get(s.charAt(k)))
                    stack.pop();
                else
                    return false;
            }
        }
        return (stack.isEmpty());
    }

}
