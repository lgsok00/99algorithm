package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
/*
  - HashMap을 활용해 입력된 과일 개수를 모두 더해준다.
  - 더한 값이 5가 있다면 YES 출력
 */
public class Q_27160 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    // String = 과일, Integer = 과일 수
    HashMap<String, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String[] split = br.readLine().split(" ");
      // 이미 존재하는 과일이라면
      if (map.containsKey(split[0])) {
        // Value 값 증가
        map.put(split[0], map.get(split[0]) + Integer.parseInt(split[1]));
      }
      // Map 에 없는 과일이라면
      else {
        // 새로운 Key-Value 추가
        map.put(split[0], Integer.parseInt(split[1]));
      }
    }

    if (map.containsValue(5)) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
}
