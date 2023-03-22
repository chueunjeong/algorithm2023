import java.util.*;

public class M13023 {
    static boolean[] visited;
    static ArrayList<Integer> list[];
    static int answer;
    public static void main(String[] args) {
        Scanner snr=new Scanner(System.in);
        int N=snr.nextInt(); //사람 수
        int M=snr.nextInt(); //친구 관계 수

        visited=new boolean[N];
        list=new ArrayList[N];
        for (int i=0; i< N; i++){
            list[i]=new ArrayList<Integer>();
        }

        for (int i=0; i< M; i++){
            int a=snr.nextInt();
            int b=snr.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        for(int n=0; n<N; n++){
            DFS(n,1);
            if(answer==1)
                break;
        }
        System.out.println(answer);
    }

    static void DFS(int node,int depth){
        if((depth==5)||(answer==1)){
            answer=1;
            return;
        }
        visited[node]=true;
        for(int n : list[node]){
            if(!visited[n]){
                DFS(n,depth+1);
            }
        }
        visited[node]=false;
    }
}