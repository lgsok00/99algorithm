package day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/*
  - 주어진 값들을 어디에 저장해야 할 지
  - 주어진 입력값이 크므로 한 번만 루프를 돌도록 설계
  - 사전식으로 출력 -> 정렬해야 함
 */
public class Q_4358 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    TreeMap<String, Integer> map = new TreeMap<>();  // TreeMap => 자동으로 내부에서 정렬해 줌.

    int count = 0;
    String tree = br.readLine();

    while (tree != null) {
      map.put(tree, map.getOrDefault(tree, 0) + 1);
      count++;
      tree = br.readLine();
    }

    br.close();

    StringBuilder sb = new StringBuilder();

    for (var t : map.entrySet()) {
      double d = (t.getValue() / (double) count) * 100;

      sb.append(t.getKey())
              .append(" ")
              .append(String.format("%.4f", d))
              .append("\n");
    }
    System.out.println(sb);
  }
}
