package day07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  - 입력받은 문자열을 한 글자씩 순회한다.
  - 그 글자가 대문자이면 -96(A = 65이므로) , 소문자이면 -38 (a = 97이므로)
  - 그 결과를 sum 에 더한다.
  - 2 ~ sum - 1 까지 루프를 돌면서
    - 나누어 떨어지는 수가 있으면 소수 X
    - 나누어 떨어지는 수가 없으면 소수 O
 */
public class Q_2153 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    int sum = 0;

    br.close();

    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c >= 'a' && c <= 'z') {
        sum += (int) c - 96;
      } else if (c >= 'A' && c <= 'Z') {
        sum += (int) c - 38;
      }
    }

    boolean check = false;

    // 소수 판별
    for (int i = 2; i < sum; i++) {
      if (sum % i == 0) {
        check = true;
        break;
      }
    }

    if (check) {
      bw.write("It is not a prime word.");
    } else {
      bw.write("It is a prime word.");
    }

    bw.flush();
    bw.close();
  }
}
