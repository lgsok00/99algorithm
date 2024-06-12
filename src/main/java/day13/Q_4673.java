package day13;

public class Q_4673 {

  public static void main(String[] args) {

    // 10000 까지 계산해야 하므로 10001
    boolean[] checked = new boolean[10001];

    for (int i = 1; i <= 10000; i++) {
      int n = d(i);

      // 10000 보다 큰 수는 필요 없으므로
      if (n < 10001) {
        checked[n] = true;
      }
    }

    for (int i = 1; i <= 10000; i++) {
      // false 라면 => 생성자가 없는 수라면
      if (!checked[i]) {
        System.out.println(i);
      }
    }

  }

  private static int d(int n) {
    int sum = n;

    while (n != 0) {
      // 첫 번재 자리 수
      sum = sum + (n % 10);
      // 더해진 첫 자리 수를 없애기 위해 나눠준다.
      n = n / 10;
    }
    return sum;
  }
}
