package day12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q_1863 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int answer = 0;

    // 건물 높이 변화를 체크하는 스택
    Stack<Integer> stack = new Stack<>();

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      // 스택이 비어있지 않고, 들어온 값이 y 보다 크다면 => 작은 빌딩
      while (!stack.isEmpty() && stack.peek() > y) {
        answer++;
        stack.pop();
      }
      // 스택이 비어있지 않고, 들어온 값고 y 값이 같다면 => 같은 빌딩
      if (!stack.isEmpty() && stack.peek() == y) {
        continue;
      }
      // 건물의 높이가 높아졌다면, stack 에 추가
      if (y > 0) {
        stack.push(y);
      }
    }

    // 스택에 남아있는 높이 처리
    while (!stack.isEmpty()) {
      stack.pop();
      answer++;
    }

    bw.write(answer + "\n");
    bw.flush();
    br.close();
    bw.close();
  }
}
