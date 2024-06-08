package day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Graph {

  public static void main(String[] args) {
    undirectedGraphUsingAdjacencyMatrix();
    directedGraphUsingAdjacencyMatrix();
    undirectedGraphUsingAdjacencyList();
    directedGraphUsingAdjacencyList();
  }

  public static void printGraphByMatrix(int[][] matrix) {
    for (int[] row : matrix) {
      System.out.println(Arrays.toString(row));
    }
  }

  private static void printGraphByList(List<ArrayList<Integer>> nodeList) {
    for (ArrayList<Integer> list : nodeList) {
      System.out.println(Arrays.toString(list.toArray()));
    }
  }

  // 무방향 그래프 인접 행렬
  public static void undirectedGraphUsingAdjacencyMatrix() {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();  // 정점 개수 1, 2, 3
    int m = s.nextInt();

    int[][] matrix = new int[n + 1][m + 1];  // 1, 2, 3

    for (int i = 0; i < m; i++) {
      int v1 = s.nextInt();
      int v2 = s.nextInt();
      matrix[v1][v2] = 1;
      matrix[v2][v1] = 1;
    }

    printGraphByMatrix(matrix);
  }
  // 방향 그래프 인접 행렬
  public static void directedGraphUsingAdjacencyMatrix() {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int m = s.nextInt();

    int[][] matrix = new int[n + 1][m + 1];

    for (int i = 0; i < m; i++) {
      int from = s.nextInt();
      int to = s.nextInt();

      matrix[from][to] = 1;
    }

    printGraphByMatrix(matrix);
  }

  // 무방향 그래프 인접 리스트
  public static void undirectedGraphUsingAdjacencyList() {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int m = s.nextInt();

    List<ArrayList<Integer>> nodeList = new ArrayList<>();

    for (int i = 0; i <= n; i++) {
      nodeList.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      int v1 = s.nextInt();
      int v2 = s.nextInt();

      nodeList.get(v1).add(v2);
      nodeList.get(v2).add(v1);
    }

    printGraphByList(nodeList);
  }

  // 방향 그래프 인접 리스트
  public static void directedGraphUsingAdjacencyList() {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int m = s.nextInt();

    List<ArrayList<Integer>> nodeList = new ArrayList<>();

    for (int i = 0; i <= n; i++) {
      nodeList.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      int from = s.nextInt();
      int to = s.nextInt();

      nodeList.get(from).add(to);
    }

    printGraphByList(nodeList);
  }
}
