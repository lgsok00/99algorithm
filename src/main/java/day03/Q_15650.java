package day03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q_15650 {

  public static int[] arr;
  public static int n;
  public static int m;
  public static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    br.close();

    arr = new int[m];

    // 시작 숫자 1, 깊이 0
    dfs(1, 0);

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  /*
    - start : 현재 위치
    - depth : 깊이
    - arr 에 i 가 담기고, 다음 재귀에는 i + 1 부터 탐색
    - depth + 1 => start + 1
   */
  public static void dfs(int start, int depth) {

    // 깊이가 m 과 같을 경우
    if (depth == m) {
      for (int val : arr) {
        sb.append(val).append(' ');
      }
      sb.append('\n');
      return;
    }

    // 재귀하면서 백트래킹
    for (int i = start; i <= n; i++) {
      arr[depth] = i;
      // 다음 재귀에 i + 1 을 넘겨주고, 깊이도 1 증가시킨다.
      dfs(i + 1, depth + 1);
    }
  }
}
