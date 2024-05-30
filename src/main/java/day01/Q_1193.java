package day01;

import java.util.Scanner;

/*
  - 1. x 값이 해당 범위에 값이 나올 때까지 반복
  - 해당 범위 값이라면,
  - 2. 해당 대각선의 칸의 개수가 홀 or 짝인지 판별
  - 3. 해당 대각선 첫 원소, x 값, 해당 대각선의 칸의 개수 => 분수 구하기
 */
public class Q_1193 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int x = in.nextInt();

    in.close();

    int crossCount = 1;  // 해당 범위 대각선의 칸 개수
    int prevCountSum = 0;  // 해당 대각선 직전 대각선 까지의 칸 개수 총합

    while (true) {
      // 입력 값의 범위 판별
      if (x <= prevCountSum + crossCount) {
        // 해당 대각선의 칸의 개수가 홀수라면
        if (crossCount % 2 == 1) {
          /*
            - 분모 (감소) => 고정값 - 증가값(= 증가값 - 고정값 - 고정값)
            -              현재대각선의 칸 개수 - (x - 직전 대각선까지 칸 누적합 - 1);
            - 분자 (증가) => 증가값 - 고정값
            -              x - 직전 대각선까지 칸 누적합
           */
          System.out.println((crossCount - (x - prevCountSum - 1)) + "/" + (x - prevCountSum));
          break;
        }
        else {
          /*
            - 대각선 칸의 개수가 홀수일 때와 반대
           */
          System.out.println((x - prevCountSum) + "/" + (crossCount - (x - prevCountSum - 1)));
          break;
        }
      }
      else {
        prevCountSum += crossCount;
        crossCount++;
      }
    }
  }
}
