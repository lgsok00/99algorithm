package day05;

import java.util.Scanner;

public class Q_1018 {

  /*
    - 최악의 경우 = 64 (8 x 8 체스판을 전부 색칠하는 경우)
    - 전체 정사각형에서 나올 수 있는 체스판의 경우의 수
      - (n - 7) * (m - 7)
    - 루프를 순회하면서, 선택한 체스판의 첫번째 색깔을 기준으로 count 값 증가
      - 첫번째 체스칸 = 다음 체스칸 => count++
      - 체스칸 색깔 반전
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    int m = in.nextInt();

    boolean[][] matrix = new boolean[n + 100][m + 100];

    for (int i = 0; i < n; i++) {
      String str = in.next();
      for (int j = 0; j < m; j++) {
        matrix[i][j] = (  str.charAt(j) == 'W');
      }
    }

    int chessRow = n - 7;
    int chessColumn = m - 7;
    int answer = 64;

    for (int i = 0; i < chessRow; i++) {
      for (int j = 0; j < chessColumn; j++) {
        // 최솟값 구하기
        answer = Math.min(answer, solve(matrix, i, j));
      }
    }

    System.out.println(answer);
  }

  public static int solve(boolean[][] matrix, int x, int y) {
    int chessX = x + 8;
    int chessY = y + 8;
    int count = 0;

    boolean curColor = matrix[x][y];

    for (int i = x; i < chessX; i++){
      for (int j = y; j < chessY; j++){
        if (matrix[i][j] != curColor) {
          count++;
        }
        curColor = (!curColor);
      }
      curColor = (!curColor);
    }
    return Math.min(count, 64 - count);
  }
}
