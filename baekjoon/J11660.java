import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J11660 {

  public static void main(String[] args) throws IOException {
    //입력받기
    BufferedReader bufferedReader = new BufferedReader(
      new InputStreamReader(System.in)
    );
    StringTokenizer stringTokenizer = new StringTokenizer(
      bufferedReader.readLine()
    );

    int arrCount = Integer.parseInt(stringTokenizer.nextToken());
    int questionCount = Integer.parseInt(stringTokenizer.nextToken());

    int[][] A = new int[arrCount + 1][arrCount + 1];

    //배열에 값넣기
    for (int i = 1; i < arrCount + 1; i++) {
      //줄바꿈
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      for (int k = 1; k < arrCount + 1; k++) {
        A[i][k] = Integer.parseInt(stringTokenizer.nextToken());
      }
    }

    //2차원 합배열 채우기
    int[][] S = new int[arrCount + 1][arrCount + 1];

    for (int i = 1; i < arrCount + 1; i++) {
      for (int k = 1; k < arrCount + 1; k++) {
        S[i][k] = S[i - 1][k] + S[i][k - 1] - S[i - 1][k - 1] + A[i][k];
      }
    }

    //부분합 계산하기
    for (int i = 0; i < questionCount; i++) {
      //줄바꿈
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int x1 = Integer.parseInt(stringTokenizer.nextToken());
      int y1 = Integer.parseInt(stringTokenizer.nextToken());
      int x2 = Integer.parseInt(stringTokenizer.nextToken());
      int y2 = Integer.parseInt(stringTokenizer.nextToken());

      int result =
        S[x2][y2] - S[x1 - 1][y2] - S[x2][y1 - 1] + S[x1 - 1][y1 - 1];
      System.out.println(result);
    }
  }
}
