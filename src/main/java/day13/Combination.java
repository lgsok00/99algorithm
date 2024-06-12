package day13;

/*
  - 자바로 조합 구현하기
  - 조합은 순서를 고려 하지 않음 ({1, 2} == {2, 1})
 */
public class Combination {

  public static void main(String[] args) {
    int n = 4;
    int[] arr = {1, 2, 3, 4};
    boolean[] visited = new boolean[n];

    for (int r = 1; r <= n; r++) {
      System.out.println(n + "개 중 " + r + "개 뽑기");
      combination(arr, visited, 0, n, r);
      System.out.println();
    }
  }

  public static void combination(
          int[] arr,  // 주어진 숫자
          boolean[] visited,  // 방문을 체크하는 배열
          int start,  // 시작 위치
          int n,
          int r
  ) {
    if (r == 0) {
      for (int i = 0; i < n; i++) {
        if (visited[i]) {
          System.out.print(arr[i] + " ");
        }
      }
      System.out.println();
      return;
    }

    for (int i = start; i < n; i++) {
      visited[i] = true;
      combination(arr, visited, i + 1, n, r - 1);
      visited[i] = false;
    }
  }
}
