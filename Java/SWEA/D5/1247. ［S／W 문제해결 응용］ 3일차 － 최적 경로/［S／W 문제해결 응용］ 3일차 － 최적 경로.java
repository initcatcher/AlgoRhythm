import java.io.*;
import java.util.*;

public class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;

    static void bwEnd() throws IOException {bw.flush();bw.close();}

    static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine());
    }

    static int nextInt(){
        return Integer.parseInt(st.nextToken());
    }

    static long nextLong(){
        return Long.parseLong(st.nextToken());
    }


    static int T;
    static long N;
    static int ans = Integer.MAX_VALUE;

    static int[] company = new int[2];
    static int[] home = new int[2];
    static int[][] clients = new int [10][2];
    static boolean[] visited = new boolean[10];
    static ArrayList<Integer> arr = new ArrayList<>();
    static int endClient;
    static int startClient;

    static int getDiff(int[] start, int[] end){
        return Math.abs(start[1]-end[1]) + Math.abs(start[0]-end[0]);
    }

    static void solve(int total){
        
        if(arr.size() == N-1){
            int res = total + getDiff(clients[arr.get(arr.size()-1)], clients[endClient]);
            // System.out.println(arr.toString() + endClient);
            // System.out.println(res);
            if(res < ans){
                
                ans =res;
                // System.out.println("ans"+res);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i] && i != endClient && i != startClient){
                visited[i] = true;
                int diff = getDiff(clients[arr.get(arr.size()-1)], clients[i]);
                arr.add(i);
                solve(total +diff);
                visited[i] = false;
                arr.remove(arr.size()-1);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        readLine();
        T = nextInt();
        for (int t = 1; t <= T; t++) {
            // if(t==2){
            //     break;
            // }
            readLine();
            N = nextInt();
            readLine();
            company[1] = nextInt();
            company[0] = nextInt();
            home[1] = nextInt();
            home[0] = nextInt();
            ans = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                clients[i][1]= nextInt();
                clients[i][0]= nextInt();
            }

            for(int i=0; i<N; ++i){
                for(int j=0; j<N; ++j){
                    if(i==j) continue;
                    visited[i] = true;
                    arr.add(i);
                    visited[j] = true;
                    startClient = i;
                    endClient = j;
                    int initDis = getDiff(company, clients[i]) + getDiff(clients[j], home);
                    solve(initDis);
                    // System.out.println("end");

                    Arrays.fill(visited, false);
                    arr.clear();
                }
            }
        
            // visited[0] = true;
            // arr.add(0);
            // solve(0);
            // for (int i = 0; i < N; i++) {
            //     System.out.println(Arrays.toString(clients[i]));
            // }
            // System.out.println(ans);

            bw.write("#" + t + " " + ans + "\n");
        }
        bwEnd();
    }
}