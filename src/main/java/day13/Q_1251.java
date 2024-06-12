package day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

/*
  - 브루트 포스 활용
  - 단어가 나눠지는 모든 경우 찾기
  - 나눈 단어를 뒤집고 붙여서 List 에 담고 사전순으로 정렬 후 맨 앞 인덱스 값 추출
 */
public class Q_1251 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String word = br.readLine();

    ArrayList<String> list = new ArrayList<>();

    for (int i = 1; i < word.length() - 1; i++) {
      for (int j = i + 1; j < word.length(); j++) {
        String answer = "";

        // 단어를 세 개로 나눈 후 합친다.
        answer += reverse(0, i, word);
        answer += reverse(i, j, word);
        answer += reverse(j, word.length(), word);

        // 연결한 단어를 List 에 추가한다.
        list.add(answer);
      }
    }

    // 오름차순 정렬
    Collections.sort(list);

    bw.write(list.get(0));

    br.close();
    bw.flush();
    bw.close();
  }

  // 문자열을 잘라서 뒤집는 메서드
  private static String reverse(int i, int j, String word) {
    StringBuilder sb = new StringBuilder();
    sb.append(word.substring(i, j));
    sb.reverse();
    return sb.toString();
  }
}
