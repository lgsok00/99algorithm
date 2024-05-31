package day03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  - 피보나치 수의 재귀 함수와 동적 프로그래밍을 메서드로 구현
 */
public class Q_24416 {

  static int fibCount = 0;  // 재귀 함수의 호출 횟수를 저장하기 위한 변수
  static int fibonacciCount = 0;  // 동적 프로그래밍의 호출 횟수를 저장하기 위한 변수
  static int[] fibonacciArr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    fibonacciArr = new int[n];
    br.close();

    fib(n);
    fibonacci(n);

    bw.write(fibCount + " " + fibonacciCount);

    bw.flush();
    bw.close();
  }

  // 재귀 호출 코드
  private static int fib(int n) {
    if (n == 1 || n == 2) {
      fibCount++;
      return 1;
    } else {
     return fib(n - 1) + fib(n - 2);
    }
  }

  // 동적 프로그래밍 코드
  private static int fibonacci(int n) {
    fibonacciArr[0] = 1;
    fibonacciArr[1] = 1;
    for (int i = 2; i < n; i++) {
      fibonacciCount++;
      fibonacciArr[i] = fibonacciArr[i - 1] + fibonacciArr[i - 2];
    }
    return fibonacciArr[n - 1];  // 배열은 0 부터 시작하므로
  }
}
