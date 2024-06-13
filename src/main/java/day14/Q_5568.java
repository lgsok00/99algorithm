package day14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Q_5568 {

  static int n;
  static int k;

  static String[] card;
  static boolean[] visited;
  static HashSet<String> set = new HashSet<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 카드의 게수
    n = Integer.parseInt(br.readLine());
    // 뽑을 카드의 개수
    k = Integer.parseInt(br.readLine());

    card = new String[n];

    for (int i = 0; i < n; i++) {
      card[i] = br.readLine();
    }

    visited = new boolean[n];

    select(k, "");

    bw.write(set.size() + "\n");

    br.close();
    bw.flush();
    bw.close();
  }

  private static void select(int k, String str) {
    if (k == 0) {
      set.add(str);
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        select(k - 1, str + card[i]);
        visited[i] = false;
      }
    }
  }
}
