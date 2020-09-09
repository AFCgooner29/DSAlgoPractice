package september;
import java.io.*;
import java.util.*;


public class HackerEarthQuestionDjkstra {
    public static class Pair{
        String edge;
        long val;
        public Pair(String eg,long v){
            this.edge = eg;
            this.val = v;
        }
    }
    public static class PairCompare implements Comparator<Pair>{
        public int compare(Pair a,Pair b){
            if(a.val<b.val){
                return 1;
            }
            else if(a.val>b.val){
                return -1;
            }
            return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int C = Integer.parseInt(line[1]);
            int u = Integer.parseInt(line[2]);

            int[][] edge = new int[N-1][3];
            for(int i_edge = 0; i_edge < N-1; i_edge++)
            {
            	String[] arr_edge = br.readLine().split(" ");
            	for(int j_edge = 0; j_edge < arr_edge.length; j_edge++)
            	{
            		edge[i_edge][j_edge] = Integer.parseInt(arr_edge[j_edge]);
            	}
            }

            long out_ = solve(N, C, u, edge);
            System.out.println(out_);
            
         }

         wr.close();
         br.close();
    }
    static long solve(int N, int C, int u, int[][] edge){
       // Type your code here
       int[][] graph = new int[N+1][N+1];
       for(int i = 0;i<edge.length;i++){
           int x = edge[i][0];
           int y = edge[i][1];
           int w = edge[i][2];
           graph[x][y] = w;
           graph[y][x] = w;
       }
       
       long summ = 0;
       int[] parents = new int[graph.length];
       dijkstra(graph,u,parents);
        HashMap<String,Long> hp = new HashMap<String,Long>();
        for(int i =1;i<graph[u].length;i++){
            summ+=graph[u][i];
        }
        if(C==0){
            return summ;
        }
        long valDecrement = 0;
        for(int i =1;i<graph[u].length;i++){
            //System.out.println(parents[i]);
            countParents(hp,u,parents,i);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(hp.size(),new PairCompare());
        for(String i : hp.keySet()){
            String[] xy = i.split(",");
            long val = graph[Integer.parseInt(xy[0])][Integer.parseInt(xy[1])]; 
            hp.put(i,hp.get(i)*val);
            pq.add(new Pair(i,hp.get(i)));
        }
        while(C!=0 && !pq.isEmpty()){
            Pair temp = pq.poll();
            valDecrement+=temp.val;
            C--;
        }
        if(pq.isEmpty())
            return 0;
        return summ - valDecrement;
    }
    static void countParents(HashMap<String,Long> hp,int start,int[] parents,int i){
        if(start==i){
            return;
        }
        if(!hp.containsKey(i+","+parents[i]) && !hp.containsKey(parents[i]+","+i)){
            hp.put(i+","+parents[i],(long)0);
        }
        if(hp.containsKey(i+","+parents[i])){
            hp.put(i+","+parents[i],(long)hp.get(i+","+parents[i])+1);
        }
        else if(hp.containsKey(parents[i]+","+i)){
            hp.put(parents[i]+","+i,(long)hp.get(parents[i]+","+i)+1);
        }
        countParents(hp,start,parents,parents[i]);
    }
    static int selectMin(int[] value,boolean[] processed){
        int mini = Integer.MAX_VALUE;
        int ver =-1;
        for(int i=1;i<value.length;i++){
            if(processed[i]==false && value[i]<mini){
                ver = i;
                mini = value[i];
            }
        }
        return ver;
    }
    static void dijkstra(int[][] graph,int start,int[] parents){
        int n = graph.length ;
        int[] minLens = new int[n];
        for(int i=1;i<graph[start].length;i++){
            if(i!=start && graph[start][i]!=0){
                minLens[i] = graph[start][i];
            }
            else if(i!=start){
                minLens[i] = Integer.MAX_VALUE;
            }
        }
        boolean[] added = new boolean[n];
        Arrays.fill(added,false);
        Arrays.fill(parents,start);
        parents[start] = start;
        for(int i=1;i<n-1;i++){
            int U = selectMin(minLens,added);
            added[U] = true;
            for(int j=1;j<n;j++){
                if(graph[U][j]!=0 && added[j]==false && minLens[U]!=Integer.MAX_VALUE && (minLens[U]+graph[U][j]<minLens[j])){
                    minLens[j] = minLens[U]+graph[U][j];
                    parents[j] = U;
                }
            }
        }
        for(int i = 1;i<graph.length;i++){
            if(i!=start && graph[start][i]==0){
                graph[start][i] = minLens[i];
            }
        }
    }
}
