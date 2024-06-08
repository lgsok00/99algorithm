package day10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
  - 문자열의 첫 인덱스를 스택에 넣는다 (")")
  - 문자열을 1 ~ 끝까지 순회한다.
    - 문자열의 i 번째 인덱스가 "(" 라면, 스택에 넣는다.
    - 문자열의 i 번째 인덱스가 ")" 라면,
      - 스택이 비어있지 않고, 맨 위의 있는게 "(" 라면 스택에서 뺀다.
      - 둘 중 하나라도 아니라면 스택에 넣는다.
 */
public class Q_11899 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 올바르지 않은 괄호열
    String s = br.readLine();

    br.close();

    // 불완전한 괄호를 담는 스택
    Stack<Character> stack = new Stack<>();

    // 괄호열의 첫 번째 인덱스를 스택에 넣는다.
    stack.push(s.charAt(0));

    for (int i = 1; i < s.length(); i++) {
      // 괄호열의 i 번째 인덱스
      char c = s.charAt(i);
      /*
        - 닫는 괄호 다음 여는 괄호가 나오면
        - 앞 뒤로 괄호가 필요하므로 스택에 추가한다.
       */
      if (c == '(') {
        stack.push(c);
      } else if (c == ')') {
        // 닫는 괄호 전에 여는 괄호가 나왔으므로 올바른 괄호열이다.
        if (!stack.isEmpty() && stack.peek() == '(') {
          stack.pop();
        } else {
          stack.push(c);
        }
      }
    }
    bw.write(String.valueOf(stack.size()));

    bw.flush();
    bw.close();
  }
}
