package day01;

import java.util.Scanner;

/*
  - sum = (입력받은 월 - 1) 월의 합 + 입력받은 일
  - sum % 7 => 요일을 구한다.
 */
public class Q_1924 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int x = in.nextInt();
    int y = in.nextInt();

    in.close();

    int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};  // 각 월의 총 일수
    String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};  // 요일

    int sum = 0;

    // 입력 받은 월 - 1 까지 월의 총 일수를 더한다.
    for (int i = 0; i < x - 1; i++) {
      sum += month[i];
    }

    // 입력받은 일 수를 더한다.
    sum += y;

    // 7로 나눈 나머지의 값을 인덱스로 같은 요일을 구한다.
    System.out.println(days[sum % 7]);
  }
}
