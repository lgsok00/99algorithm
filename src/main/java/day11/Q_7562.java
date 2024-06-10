package day11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_7562 {
  static int[][] chessBoard;
  static boolean[][] visited;
  static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
  static int[] dy = {2, 1, -1, -2, 2, 1, -1, -2};

  static int startX, startY, endX, endY;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 테스트 케이스 개수
    int t = Integer.parseInt(br.readLine());

    StringTokenizer st;

    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());

      chessBoard = new int[n][n];
      visited = new boolean[n][n];

      st = new StringTokenizer(br.readLine());
      // 현재 위치
      startX = Integer.parseInt(st.nextToken());
      startY = Integer.parseInt(st.nextToken());

      // 목표 위치
      st = new StringTokenizer(br.readLine());
      endX = Integer.parseInt(st.nextToken());
      endY = Integer.parseInt(st.nextToken());

      bw.write(bfs(startX, startY) + "\n");

    }
    br.close();
    bw.flush();
    bw.close();
  }

  private static int bfs(int startX, int startY) {
    Queue<Node> queue = new LinkedList<>();
    // 큐에 시작 위치 추가
    queue.offer(new Node(startX, startY, 0));
    visited[startX][startY] = true;

    while (!queue.isEmpty()) {
      // 현재 위치 반환
      Node now = queue.poll();
      int nowX = now.x;
      int nowY = now.y;

      // 현재 위치가 목표 위치라면 이동횟수 반환
      if (nowX == endX && nowY == endY) {
        return now.count;
      }

      // 다음 이동 좌표
      for (int i = 0; i < 8; i++) {
        int nextX = nowX + dx[i];
        int nextY = nowY + dy[i];

        // 이동 경로가 체스판의 범위를 벗어난다면
        if (nextX < 0 || nextY < 0 || nextX >= chessBoard.length || nextY >= chessBoard.length) {
          continue;
        }
        // 이미 방문한 좌표라면
        if (visited[nextX][nextY]) {
          continue;
        }
        // 방문 체크
        visited[nextX][nextY] = true;

        // 다음 이동 좌표와 현재 이동횟수 + 1 값을 추가하여 큐에 담음
        queue.offer(new Node(nextX, nextY, now.count + 1));
      }
    }
    return -1;
  }
}

class Node {
  int x;
  int y;
  int count;

  public Node(int x, int y, int count) {
    this.x = x;
    this.y = y;
    this.count = count;
  }
}
