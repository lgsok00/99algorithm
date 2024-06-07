package day09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_11399 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 배열 입력 받기
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // 최솟값을 구하기 위해 오름차순 정렬
    Arrays.sort(arr);

    // 시간 총 합
    int sum = 0;
    // 이전까지 대기 시간 합
    int prev = 0;

    for (int i = 0; i < n; i++) {
      prev += arr[i];
      sum += prev;
    }

    bw.write(sum + "\n");

    bw.flush();
    br.close();
  }
}
