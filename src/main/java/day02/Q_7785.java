package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
  - HashMap 에 이름과 상태를 저장한다.
  - 같은 이름이 나오면 그 key 값을 삭제하고 아니면 Map 에 추가한다.
  - ArrayList 에 추가해 역순으로 정렬하고 출력한다.
 */
public class Q_7785 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    HashMap<String, String> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      String name = st.nextToken();
      String status = st.nextToken();

      // 같은 이름이 나올 경우 (퇴근)
      if (map.containsKey(name)) {
        map.remove(name);
      }
      // 같은 이름이 없으면 (출근)
      else {
        map.put(name, status);
      }
    }
    br.close();

    /*
     - sort 하기 위해 ArrayList 생성
     - HashMap 의 Key 값만 ArrayList 로 생성
     */
    ArrayList<String> list = new ArrayList<>(map.keySet());
    // reverseOrder() -> 내림차순 정렬
    list.sort(Collections.reverseOrder());
    for (String s : list) {
      System.out.println(s);
    }
  }
}
