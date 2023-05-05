import java.util.Arrays;
import java.util.Scanner;

public class J1940 {

  public static void main(String[] args) {
    Scanner snr = new Scanner(System.in);
    int N = snr.nextInt();
    int A = snr.nextInt();

    //배열 입력받기
    int[] arr = new int[N];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = snr.nextInt();
    }

    //배열 오름차순 정렬
    Arrays.sort(arr);

    int s = 0, e = N - 1;

    int sum = 0;
    int answer = 0;

    //끝점이 배열 안에 있을 동안
    while (s < e) {
      sum = arr[s] + arr[e];
      //해당하는 값일 경우
      if (sum == A) {
        answer++;
        s++;
        e--;
      } else if (sum < A) {
        s++;
      } else {
        e--;
      }
    }

    System.out.println(answer);
  }
}
