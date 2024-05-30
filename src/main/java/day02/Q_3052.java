package day02;

import java.util.HashSet;
import java.util.Scanner;

/*
  1. 유저 입력 받기
  2. 컬렉션에 넣어서, 그 값들을 42로 하나씩 나눠 나머지르 구한다.
  3. 나머지를 컬렉션에 넣어서 서로 다른 값들을 비교해 반환 (Set)
 */
public class Q_3052 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    HashSet<Long> remainders = new HashSet<>();

    for (int i = 0; i < 10; i++) {
      long remainder = in.nextInt() % 42;
      remainders.add(remainder);  // HashSet 사용으로 중복값 삭제
    }

    System.out.println(remainders.size());
  }
}
