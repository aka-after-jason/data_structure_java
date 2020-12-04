package com.aj.interview.stack;

/**
 * @author aka_after_jason
 * @date 12/4/20
 */

import java.util.HashMap;
import java.util.Stack;

/**
 * 有效的括号
 *
 */
public class BracketIsValid {


    /**
     * 第一种方式,这种方式不推荐
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        while (s.contains("{}") || s.contains("[]") || s.contains("()")) {
            s = s.replace("{}","");
            s = s.replace("[]","");
            s = s.replace("()","");
        }
        return s.isEmpty();
    }

    /**
     * 第二种方法：使用栈来解决（推荐）
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') { // 左字符
                stack.push(c);
            }else { // 右字符
                if (stack.isEmpty()) return false;
                char left = stack.pop();
                if (left == '(' && c != ')') return false;
                if (left == '{' && c != '}') return false;
                if (left == '[' && c != ']') return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 第三种方法，使用hashmap
     * @param s
     * @return
     */
    public static boolean isValid3(String s) {
        HashMap<Character,Character> map = new HashMap<>();
            map.put('(',')');
            map.put('{','}');
            map.put('[',']');
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) { // 左字符
                stack.push(c);
            }else { // 右字符
                if (stack.isEmpty()) return false;
                if (c != map.get(stack.pop())) return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 测试方法
     * @param args
     */
    public static void main(String[] args) {
        String s = "[]{}()";
        System.out.println(isValid(s));
        System.out.println(isValid2(s));
        System.out.println(isValid3(s));

        s = "{}[()";
        System.out.println(isValid(s));
        System.out.println(isValid2(s));
        System.out.println(isValid3(s));
    }
}
