package day14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q_30821 {

  static int count;
  static int[] list;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 정 n 각형 꼭짓점의 개수
    int n = Integer.parseInt(br.readLine());

    list = new int[n];
    for (int i = 0; i < n; i++) {
      list[i] = i;
    }

    visited = new boolean[n];

    combination(list, visited, 0, 5);

    bw.write(count + "\n");

    br.close();
    bw.flush();
    bw.close();
  }

  private static void combination(int[] list, boolean[] visited, int start, int r) {
    if (r == 0) {
      count++;
      return;
    }

    for (int i = start; i < list.length; i++) {
      visited[i] = true;
      combination(list, visited, i + 1, r - 1);
    }
  }
}
