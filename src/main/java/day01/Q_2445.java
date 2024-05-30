package day01;

import java.util.Scanner;

public class Q_2445 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.close();

    // (위쪽 부분) n줄 까지 반복
    for (int i = 1; i <= n; i++) {
      // 별 찍는 부분
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      // 공백 부분
      for (int k = 1; k <= 2 * (n - i); k++) {
        System.out.print(" ");
      }
      // 별 찍는 부분
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      // 줄 바꿈
      System.out.println();
    }

    // (아래쪽 부분)
    for (int i = n - 1; i > 0; i--) {
      // 별 찍기 부분
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      // 공백 부분
      for (int k = 1; k <= 2 * (n - i); k++) {
        System.out.print(" ");
      }
      // 별 찍기 부분
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      // 줄 바꿈
      System.out.println();
    }
  }
}
