package day15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class WayNode implements Comparable<WayNode> {
  int end;
  int weight;

  WayNode(int end, int weight) {
    this.end = end;
    this.weight = weight;
  }

  @Override
  public int compareTo(WayNode o) {
    return this.weight - o.weight;
  }
}

/*
  - 다익스트라 알고리즘 사용
  - 두 정점을 지나가는 2개의 경우를 모두 탐색해본다.
    1. v1 을 먼저 거치고 v2로 가는 경우
    2. v2 를 먼저 거치고 v1으로 가는 경우
  - 두 경우 중 최단 거리를 출력한다.
 */
public class Q_1504 {

  static int n, e;
  // 인접한 노드와 간선
  static ArrayList<ArrayList<WayNode>> list;
  // 시작점에서 각 정점으로 가는 최단거리
  static int[] distance;
  // 방문을 확인하기 위한 배열
  static boolean[] visited;
  // 간선의 개수 최댓값 200000 x 거리 최댓값 1000
  static final int INF = 200000000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    e = Integer.parseInt(st.nextToken());

    list = new ArrayList<>();
    distance = new int[n + 1];
    visited = new boolean[n + 1];

    Arrays.fill(distance, INF);

    for (int i = 0; i <= n; i++) {
      list.add(new ArrayList<>());
    }

    // 양방향 인접 리스트
    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      // start -> end
      list.get(start).add(new WayNode(end, weight));

      // end -> start
      list.get(end).add(new WayNode(start, weight));
    }

    // 반드시 거쳐야 하는 정점
    st = new StringTokenizer(br.readLine());
    int v1 = Integer.parseInt(st.nextToken());
    int v2 = Integer.parseInt(st.nextToken());

    // 1 -> v1 -> v2 -> n
    int res1 = 0;
    res1 += dijkstra(1, v1);
    res1 += dijkstra(v1, v2);
    res1 += dijkstra(v2, n);

    // 1 -> v2 -> v1 -> n
    int res2 = 0;
    res2 += dijkstra(1, v2);
    res2 += dijkstra(v2, v1);
    res2 += dijkstra(v1, n);

    int answer = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);

    bw.write(answer + "\n");

    bw.flush();
    br.close();
    bw.close();
  }

  // 다익스트라 알고리즘
  private static int dijkstra(int start, int end) {
    Arrays.fill(distance, INF);
    Arrays.fill(visited, false);

    PriorityQueue<WayNode> pq = new PriorityQueue<>();
    boolean[] visited = new boolean[n + 1];
    pq.offer(new WayNode(start, 0));
    distance[start] = 0;

    while (!pq.isEmpty()) {
      WayNode curNode = pq.poll();
      int current = curNode.end;

      if (!visited[current]) {
        visited[current] = true;

        for (WayNode node : list.get(current)) {
          if (!visited[node.end] && distance[node.end] > distance[current] + node.weight) {
            distance[node.end] = distance[current] + node.weight;
            pq.add(new WayNode(node.end, distance[node.end]));
          }
        }
      }
    }
    return distance[end];
  }
}
