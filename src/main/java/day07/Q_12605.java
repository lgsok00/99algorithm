package day07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
  - 입력 받은 문자열을 공백(" ")을 기준으로 나눠 배열에 저장한다.
  - 배열의 원소를 스택에 저장하고, pop 을 통해 역순으로 꺼낸다.
 */
public class Q_12605 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    Stack<String> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      String[] strArr = str.split(" ");

      // 스택에 저장
      for (String s : strArr) {
        stack.push(s);
      }
      bw.write("Case #" + (i + 1) + ": ");

      // pop 으로 꺼내기
      for (int j = 0; j < strArr.length; j++) {
        bw.write(stack.pop() + " ");
      }
      bw.write("\n");
    }

    br.close();
    bw.flush();
    bw.close();
  }
}
