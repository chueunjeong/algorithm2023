import java.util.Scanner;

public class J2018 {

  public static void main(String[] args) {
    Scanner snr = new Scanner(System.in);
    int N = snr.nextInt();

    //자기 자신이 있기 때문에 1로 시작한다.
    int answer = 1;

    int start = 0, end = 0;

    //end가 N일때까지
    int sum = 0;
    while (end < N) {
      //더한 구간의 합이 N인 경우
      if (sum == N) {
        answer++;
        end++;
        sum += end;
      } else if (sum < N) {
        //더한 구간의 합이 N보다 작을 경우
        end++;
        sum += end;
      } else {
        //더한 구간의 합이 N보다 큰 경우
        sum -= start;
        start++;
      }
    }
    System.out.println(answer);
  }
}
