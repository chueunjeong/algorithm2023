import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class J11002 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(
      new InputStreamReader(System.in)
    );
    //출력을 버퍼에 넣고 한 번에 출력
    BufferedWriter bufferedWriter = new BufferedWriter(
      new OutputStreamWriter(System.out)
    );

    StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
    //숫자 개수, 슬라이딩 윈도우 입력받기
    int N = Integer.parseInt(st.nextToken());
    int sliderSize = Integer.parseInt(st.nextToken());

    //데이터를 기록할 Deque
    Deque<Node> deque = new LinkedList<>();

    //숫자 배열 입력받기
    st = new StringTokenizer(bufferedReader.readLine());
    for (int i = 0; i < N; i++) {
      long now = Long.parseLong(st.nextToken());

      //맨 처음 노드를 넣을 때, 비어있기 때문에 에러발생 방지
      //내가 지금 넣은 값보다 앞의 수가 작아질 때까지 목록의 끝을 삭제하기
      while (!deque.isEmpty() && deque.getLast().num >= now) deque.removeLast();
      deque.addLast(new Node(i, now));

      //슬라이드 크기보다 멀어졌을 때, 맨 앞을 삭제한다,
      if (i - deque.getFirst().index >= sliderSize) deque.removeFirst();

      bufferedWriter.write(deque.getFirst().num + " ");
    }
    bufferedReader.close();
    bufferedWriter.flush();
  }
}

class Node {

  int index;
  long num;

  public Node(int index, long num) {
    this.index = index;
    this.num = num;
  }

  @Override
  public String toString() {
    return "Node [index=" + index + ", num=" + num + "]";
  }
}
