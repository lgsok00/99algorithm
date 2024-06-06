package day08;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q_11286 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    var comparator = new MyComparator();

    PriorityQueue<Integer> pq = new PriorityQueue<>(comparator);

    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      if (x == 0) {
        int answer = pq.isEmpty() ? 0 : pq.poll();
        System.out.println(answer);
      } else {
        pq.offer(x);
      }
    }
  }
}

class MyComparator implements Comparator<Integer> {
  @Override
  public int compare(Integer o1, Integer o2) {
    if (Math.abs(o1) == Math.abs(o2)) {
      return o1 - o2;
    } else {
      return Math.abs(o1) - Math.abs(o2);
    }
  }
}