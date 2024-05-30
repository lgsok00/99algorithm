package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  1. BufferedReader 로 입력 받기
  2. StringTokenizer 로 공백(" ")을 기준으로 문자열 분리하기
 */
public class Q_1152 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    System.out.println(st.countTokens());
  }
}
