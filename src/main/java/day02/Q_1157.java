package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
  - 대소문자 상관없이 빈도수를 증가시켜야 함
  - 대문자는 -65('A'), 소문자는 -97('a') 빼주면 해당 알파벳 인덱스
    - ex) C(67) - 65 = 2
          a(97) - 97 = 0
 */
public class Q_1157 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[26];  // 영문자의 빈도수를 나타내는 배열
    String s = br.readLine();

    for (int i = 0; i < s.length(); i++) {
      // 순회하는 인덱스의 문자가 대문자일 때
      if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
        arr[s.charAt(i) - 'A']++;  // 해당 인덱스의 값 1 증가
      }
      else {
        arr[s.charAt(i) - 'a']++;
      }
    }

    int max = -1;
    char ch = '?';

    for (int i = 0; i < 26; i++) {
      if (arr[i] > max) {
        max = arr[i];
        ch = (char) (i + 65);  // 대문자로 출력해야하므로 65를 더한다.
      }
      // 최대 개수 문자가 2개 이상이므로
      else if (arr[i] == max) {
        ch = '?';
      }
    }

    System.out.print(ch);
  }
}
