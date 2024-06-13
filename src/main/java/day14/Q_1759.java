package day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;

/*
  - 최소 한 개의 모음 + 최소 두 개의 자음
  - 조합을 활용하여 구현

 */
public class Q_1759 {

  static int l, c;
  static char[] input;
  static char[] password;

  static Set<Character> moms = Set.of('a', 'e', 'i', 'o', 'u');

  static StringBuilder answer = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    l = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    input = new char[c];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < c; i++) {
      input[i] = st.nextToken().charAt(0);
    }

    Arrays.sort(input);

    password = new char[l];

    combination(0, l, 0, 0);

    System.out.println(answer);
  }

  private static void combination(int start, int r, int momCount, int sonCount) {
    if (r == 0) {
      // 탈출 조건
      if (momCount >= 1 && sonCount >= 2) {
        answer.append(new String(password)).append("\n");
      }
      return;
    }

    for (int i = start; i < input.length; i++) {
      char curChar = input[i];
      password[l - r] = curChar;

      if (moms.contains(curChar)) {
        combination(i + 1, r - 1, momCount + 1, sonCount);
      } else {
        combination(i + 1, r - 1, momCount, sonCount + 1);
      }
    }
  }
}
