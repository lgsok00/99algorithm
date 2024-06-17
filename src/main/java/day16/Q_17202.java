package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_17202 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String a = br.readLine();
    String b = br.readLine();

    Integer[] phoneNum = new Integer[16];
    for (int i = 0; i < 16; i++) {
      if (i % 2 == 0) {
        phoneNum[i] = Integer.valueOf(a.charAt(i / 2) + "");
      } else {
        phoneNum[i] = Integer.valueOf(b.charAt(i / 2) + "");
      }
    }

    List<Integer> list = Arrays.asList(phoneNum);
    while (list.size() > 2) {
      List<Integer> temp = new ArrayList<>();
      for (int i = 0; i < list.size() - 1; i++) {
        temp.add((list.get(i) + list.get(i + 1)) % 10);
      }
      list = temp;
    }

   list.forEach(System.out::print);
  }
}
