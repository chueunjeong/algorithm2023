import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J1253Re {

  public static void main(String[] args)
    throws NumberFormatException, IOException {
    BufferedReader bufferedReader = new BufferedReader(
      new InputStreamReader(System.in)
    );
    int N = Integer.parseInt(bufferedReader.readLine());

    //숫자 배열 입력받기
    long arr[] = new long[N];
    StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Long.parseLong(st.nextToken());
    }

    //아래 작업을 위해 정렬하기
    Arrays.sort(arr);
    //좋은 수 개수 저장
    int answer = 0;

    //각각의 숫자가 좋은 수인지 확인하기
    for (int index = 0; index < N; index++) {
      //이번에 확인할 숫자
      Long key = arr[index];

      //두 가지의 서로다른 숫자를 양 끝(시작,끝)에서 검색할 인덱스들
      int start = 0, end = N - 1;

      while (start < end) {
        long sum = arr[start] + arr[end];
        //먼저 맞는 값이 나타난다해도 서로다른 두 숫자가 자기자신이 아니여야한다,
        if (sum == key) {
          if (index != start && index != end) {
            answer++;
            break;
            //아래 두 경우는 둘 중하나가 확인할 숫자 본인이고 나머지가 0인 경우이다.
            //이때는 자기 자신이면 안되기 때문에 본인을 이동시켜서 다시 좋은 수를 찾도록 한다.
          } else if (index == start) start++; else if (index == end) end--;
          //합이 작으면 커야하기 때문에 시작을 더 큰 숫자로 이동한다,
        } else if (sum < key) start++;
        //합이 더 크다면 줄여야하기때문에 끝을 더 작은 숫자로 이동한다.
        else end--;
      }
    }
  }
}
