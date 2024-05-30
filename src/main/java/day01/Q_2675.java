package day01;

import java.util.Scanner;

public class Q_2675 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    // 테스트 개수 만큼 반복
    for (int i = 0; i < t; i++) {
      int r = in.nextInt();
      String s = in.next();  // nextLine() 사용 -> 공백까지 반복

      for (int j = 0; j < s.length(); j++) {
        // 한 글자당 r 만큼 반복
        for (int k = 0; k < r; k++) {
          // String -> char
          System.out.print(s.charAt(j));
        }
      }
      System.out.println();
    }
  }
}
