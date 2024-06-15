package day16;

public class Example {

  private static int fiboCnt = 0;
  private static int fiboDpCnt = 0;

  public static void main(String[] args) {
    System.out.println(fibo(10));
    System.out.println(fiboDp(10));
    System.out.println(fiboDpWithoutRecursive(10));

    System.out.println("fiboCnt: " + fiboCnt);
    System.out.println("fiboDpCnt: " + fiboDpCnt);
  }

  // 단순 피보나치 수 재귀 구연
  // f(n) = f(n - 1) + f(n - 2)
  private static int fibo(int n) {
    if (n == 0) {
      fiboCnt++;
      return 0;
    }
    if (n == 1) {
      fiboCnt++;
      return 1;
    }

    // fibo(3) = fibo(2) + fibo(1) = fibo(1) + fibo(0) + 1 = 1 + 1 = 2
    // fibo(4) = fibo(3) + fibo(2) = fibo(2) + fibo(1) + fibo(1) + fibo(0) = fibo(1) + fibo(0) + 1 + 1 + 0 = 1 + 1 + 1 = 3
    // fibo(5) = fibo(4) + fibo(3) = 3 + 2 = 5
    return fibo(n - 1) + fibo(n - 2);
  }

  // 피보나치 수 top-down dp
  private static int fiboDp(int n) {
    int memo[] = new int[n + 1];

    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }

    if (memo[n] != 0) {
      return memo[n];
    }

    // 메모이제이션
    memo[n] = fiboDp(n - 1) + fiboDp(n - 2);

    return memo[n];
  }

  // 피보나치 수 bottom-up dp
  private static int fiboDpWithoutRecursive(int n) {
    int memo[] = new int[n + 1];

    memo[0] = 0;
    memo[1] = 1;

    for (int i = 2; i <= n; i++) {
      fiboDpCnt++;
      // i = 5
      // memo[5] = memo[4] + memo[3]
      memo[i] = memo[i - 1] + memo[i - 2];
    }

    return memo[n];
  }
}