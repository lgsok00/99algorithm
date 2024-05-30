package day01;

import java.util.Scanner;

public class Q_2438 {
  public static void main(String[] args) {
    // Scanner로 입력 받기
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.close();

    // 줄 반복
    for (int i = 1; i <= n; i++) {
      // 별을 찍는 부분
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      // 줄 바꿈
      System.out.println();
    }
  }
}
