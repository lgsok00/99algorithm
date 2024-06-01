package day04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;

/*
  - 단어를 저장할 List 를 만들고, 사용된 단어를 저장할 Set 을 만든다.
  - 반복문을 수행하면서 입력한 단어가 "?" 가 아니면 Set 에 저장하고, "?" 라면 그 인덱스를 idx 에 저장한다.
  - 반복문을 통해 후보 단어를 입력 받으면서 조건문을 수행한다.
    - 단어가 하나일 경우,
    - 이미 사용된 단어일 경우,
    - "?" 가 List 처음에 있는 경우,
    - "?" 가 List 마지막에 있는 경우,
    - "?" 가 List 중간에 있는 경우
 */
public class Q_28432 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 주어진 단어를 저장
    ArrayList<String> words = new ArrayList<>();
    // 이미 사용된 단어 저장
    HashSet<String> usedWords = new HashSet<>();

    int n = Integer.parseInt(br.readLine());
    int idx = -1;  // "?" 의 위치


    for (int i = 0; i < n; i++) {
      String word = br.readLine();
      // "?" 가 아닌 단어 (사용한 단어) -> usedWords 에 저장
      if (!"?".equals(word)) {
        usedWords.add(word);
      } else {
        // "?" 위치 저장
        idx = i;
      }
      words.add(word);
    }

    int m = Integer.parseInt(br.readLine());

    for (int i = 0; i < m; i++) {
      String candidateWord = br.readLine();
      // 단어가 하나일 경우
      if (n == 1) {
        bw.write(candidateWord + "\n");
        break;
      }
      // 이미 사용된 단어일 경우
      if (usedWords.contains(candidateWord)) {
        continue;
      }
      // "?" 가 리스트의 처음에 있는 경우
      if (idx == 0) {
        // "?" 다음 단어의 첫 글자가 후보 단어의 마지막 글자와 같다면
        if (words.get(idx + 1).charAt(0) == candidateWord.charAt(candidateWord.length() - 1)) {
          bw.write(candidateWord + "\n");
          break;
        }
        // "?" 가 리스트의 마지막에 있는 경우
      } else if (idx == n - 1) {
        // "?" 전 단어의 마지막 글자가 후보 단어의 첫 글자와 같다면
        if (words.get(idx - 1).charAt(words.get(idx - 1).length() - 1) == candidateWord.charAt(0)) {
          bw.write(candidateWord + "\n");
          break;
        }
        // // "?" 가 리스트의 중간에 있는 경우
      } else {
        // "?" 다음 단어의 첫 글자와 후보 단어의 마지막 글자가 같고
        // "?" 전 단어의 마지막 글자와 후보 단어의 첫 글자가 같다면
        if (words.get(idx + 1).charAt(0) == candidateWord.charAt(candidateWord.length() - 1) &&
                words.get(idx - 1).charAt(words.get(idx - 1).length() - 1) == candidateWord.charAt(0)) {
          bw.write(candidateWord + "\n");
          break;
        }
      }
    }
    br.close();
    bw.flush();
    bw.close();
  }
}
