package day06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q_1244 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 스위치 개수
    int switches = Integer.parseInt(br.readLine());
    // 스위치 상태
    int[] state = new int[switches + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());

    // 상태 입력
    for (int i = 1; i <= switches; i++) {
      state[i] = Integer.parseInt(st.nextToken());
    }

    // 학생 수
    int student = Integer.parseInt(br.readLine());

    for (int i = 0; i < student; i++) {
      st = new StringTokenizer(br.readLine());
      int gender = Integer.parseInt(st.nextToken());
      int number = Integer.parseInt(st.nextToken());

      // 남학생일 경우
      if (gender == 1) {
        for (int j = number; j <= switches; j += number) {
          if (j % number == 0) {
            state[j] = state[j] == 1 ? 0 : 1;
          }
        }
        // 여학생일 경우
      } else {
        state[number] = state[number] == 1 ? 0 : 1;
        int count = 1;
        while (number - count >= 1 && number + count <= switches) {
          if (state[number - count] == state[number + count]) {
            state[number - count] = state[number -count] == 1 ? 0 : 1;
            state[number + count] = state[number + count] == 1 ? 0 : 1;
          } else {
            break;
          }
          count++;
        }
      }
    }

    br.close();

    for (int i = 1; i <= switches; i++) {
      bw.write(state[i] + " ");
      // 20번을 넘어가는 경우
      if (i % 20 == 0) {
        bw.write("\n");
      }
    }

    bw.flush();
    bw.close();
  }
}
