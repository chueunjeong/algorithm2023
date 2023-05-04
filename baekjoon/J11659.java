import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class J11659 {

  public static void main(String[] args) throws IOException {
    //입력받기
    BufferedReader bufferedReader = new BufferedReader(
      new InputStreamReader(System.in)
    );
    StringTokenizer stringTokenizer = new StringTokenizer(
      bufferedReader.readLine()
    );

    int numCount = Integer.parseInt(stringTokenizer.nextToken());
    int questionCount = Integer.parseInt(stringTokenizer.nextToken());

    //합배열 초기화
    long[] S = new long[numCount + 1];

    //줄바꿈
    stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    //합배열 값넣기
    for (int i = 1; i < S.length; i++) {
      S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
    }

    //질문받기
    for (int i = 0; i < questionCount; i++) {
      //줄바꿈
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int s = Integer.parseInt(stringTokenizer.nextToken());
      int e = Integer.parseInt(stringTokenizer.nextToken());

      System.out.println(S[e] - S[s - 1]);
    }
  }
}
