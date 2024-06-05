package day07;

import java.util.Scanner;
import java.util.Stack;

public class Q_9012 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();


    for (int i = 0; i < t; i++) {
      String str = in.next();
      System.out.println(solve(str) ? "YES" : "NO");
    }
  }

  /*
    - 여는 괄호를 스택에 넣고 닫는 괄호는 빼버린다.
   */
  private static boolean solve(String str) {
    Stack<Character> stack = new Stack<>();

    for (char c : str.toCharArray()) {
      if (c == '(') {
        stack.push(c);
        // 닫는 괄호일 땐 뺀다.
      } else {
        // 여는 괄호가 없다면
        if (stack.isEmpty()) {
          return false;
        }
        stack.pop();
      }
    }
    return stack.isEmpty();
  }
}
