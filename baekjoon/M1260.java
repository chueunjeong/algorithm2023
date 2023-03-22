import java.util.*;

public class M1260 {

    static boolean visited[];
    static ArrayList<Integer> list[];

    public static void main(String[] args) {
        Scanner snr=new Scanner(System.in);
        int N=snr.nextInt(); //정점
        int M=snr.nextInt(); //간선
        int V=snr.nextInt(); //시작점

        visited=new boolean[N+1];
        list=new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            list[i]=new ArrayList<Integer>();
        }

        for(int i=1;i<=M;i++){
            int N1=snr.nextInt();
            int N2=snr.nextInt();
            list[N1].add(N2);
            list[N2].add(N1);
        }
        for(int i=1;i<=N;i++){
            Collections.sort(list[i]);
        }
        DFS(V);
        System.out.println();
        visited=new boolean[N+1];
        BFS(V);

    }
    public static void DFS(int current){
        visited[current]=true;
        System.out.print(current+" ");
        for(int n : list[current]){
            if(!visited[n]) {
                DFS(n);
            }
        }
        return;
    }
    public static void BFS(int start){
        Queue<Integer> queue= new LinkedList<Integer>();
        queue.add(start);

        while(!queue.isEmpty()){
            int next=queue.poll();
            System.out.print(next+" ");
            visited[next]=true;
            for(int n : list[next]){
                if(!visited[n]) {
                    queue.add(n);
                    visited[n]=true;
                }
            }
        }
    }
}
