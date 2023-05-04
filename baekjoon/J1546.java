import java.util.Scanner;

public class J1546 {

  public static void main(String[] args) {
    //입력받기
    Scanner snr = new Scanner(System.in);
    int count = snr.nextInt();
    int[] scores = new int[count];

    for (int i = 0; i < count; i++) {
      scores[i] = snr.nextInt();
    }

    //최대 점수값 찾기 & 합계 구하기
    long max = scores[0];
    long sum = 0;
    for (int score : scores) {
      if (max <= score) max = score;
      sum += score;
    }

    //결과 값
    double result = (sum * 100.0 / max) / count;
    System.out.println(result);
  }
}
