package day07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
  - 입력받은 사이즈 만큼의 덱을 만들고, 숫자를 채운다.
  - 뽑고자 하는 수를 담을 배열을 만들고 숫자를 입력 받는다.
  - indexOf 를 활용해 덱에서 찾고자 하는 수의 위치를 저장한다.
  - 덱의 크기가 홀수/짝수 인지에 따라 중간 지점을 설정하고, 중간 지점과 타겟 위치를 비교해 연산한다.
 */
public class Q_1021 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    // 큐의 크기
    int n = Integer.parseInt(st.nextToken());
    // 뽑아내려고 하는 수의 개수
    int m = Integer.parseInt(st.nextToken());

    LinkedList<Integer> deque = new LinkedList<Integer>();
    // 2, 3 번 연산을 수행한 횟수
    int count = 0;

    // 덱에 숫자 추가
    for (int i = 1; i <= n; i++) {
      deque.offer(i);
    }

    // 뽑고자 하는 수를 담은 배열
    int[] choice = new int[m];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < m; i++) {
      choice[i] = Integer.parseInt(st.nextToken());
    }

    br.close();

    for (int i = 0; i < m; i++) {
      // 뽑고자 하는 수의 위치 저장
      int target = deque.indexOf(choice[i]);
      int half;

      /*
        - 덱의 원소가 짝수 개라면, 중간 지점 = 절반 - 1
        - 덱의 원소가 홀수 개라면, 중간 지점 = 절반
       */
      if (deque.size() % 2 == 0) {
        half = deque.size() / 2 - 1;
      } else {
        half = deque.size() / 2;
      }

      // 뽑고자 하는 수가 중간 지점 보다 앞에 있을 경우
      if (target <= half) {
        // 2번 연산
        for (int j = 0; j < target; j++) {
          int temp = deque.pollFirst();
          deque.offerLast(temp);
          count++;
        }
        // 뽑고자 하는 수가 중간 지점 보다 뒤에 있을 경우
      } else {
        // 3번 연산
        for (int j = 0; j < deque.size() - target; j++) {
          int temp = deque.pollLast();
          deque.offerFirst(temp);
          count++;
        }
      }
      // 덱에서 수를 뽑아냈으므로 맨 앞 원소 삭제
      deque.pollFirst();
    }
    bw.write(String.valueOf(count));

    bw.flush();
    bw.close();
  }
}
