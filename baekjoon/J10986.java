import java.util.Scanner;

public class J10986 {

  public static void main(String[] args) {
    //입력받기
    Scanner snr = new Scanner(System.in);
    int count = snr.nextInt();
    int M = snr.nextInt();

    //합배열 만들기
    long[] S = new long[count];
    S[0] = snr.nextInt();
    for (int k = 1; k < count; k++) {
      S[k] = S[k - 1] + snr.nextInt();
    }

    //결과값을 저장할 변수
    long result = 0;
    //M으로 나눴을 때, 같은 나머지를 가진 구간 개수 저장
    long[] C = new long[M];

    //합배열을 M으로 나누기
    for (int k = 0; k < count; k++) {
      int reminder = (int) (S[k] % M);
      //[1] 나눈 값이 0인 구간 찾기
      if (reminder == 0) result++;
      S[k] = reminder;
      //나머지 값에 따라 개수 세기
      C[reminder]++;
    }

    //[2] 같은 나머지 값 내에서 2가지 구간을 구했을 경우를 결과값에 더하기
    for (int k = 0; k < M; k++) {
      if (C[k] > 1) result += C[k] * (C[k] - 1) / 2;
    }

    System.out.println(result);
  }
}
