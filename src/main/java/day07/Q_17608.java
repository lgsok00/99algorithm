package day07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
  - 입력되는 값들을 스택에 넣는다.
  - 가장 나중에 입력된 값과 그 전 값들을 비교해,
  - 나중에 입력된 값보다 크면 count 를 증가시킨다.
 */
public class Q_17608 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      stack.push(Integer.parseInt(br.readLine()));
    }

    br.close();

    int last = stack.pop();
    // last 도 포함 시켜야하기 때문
    int count = 1;

    while(!stack.isEmpty()) {
      int temp = stack.pop();
      if (last < temp) {
        last = temp;
        count++;
      }
    }

    bw.write(count + "\n");
    bw.flush();
    bw.close();
  }
}
