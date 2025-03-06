import java.io.*;
import java.util.*;

public class Main {
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

    static int[][] grid = new int[20][20];
    static int R,C;

    static int ans = 0;

    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};


    static boolean isOk(int y, int x){
        return 0<=y && y<R && 0<=x && x<C;
    }

    static class Horse {
        int y;
        int x;
        int mask;

        Horse(int y, int x, int mask){
            this.y = y;
            this.x = x;
            this.mask = mask;
        }
    }

    static int getCur(int mask){
        int count = 0;
        for (int i = 0; i < 26; i++) 
            if((mask & 1<<i) > 0) count++;
        return count;
    }


    static void solve(){
        
        HashMap<String,Boolean> map = new HashMap<>(); 
        Queue<Horse> queue = new LinkedList<>();
        queue.offer(new Horse(0,0, 1<<grid[0][0]));
        while(!queue.isEmpty()){
            Horse cur = queue.poll();

            ans = Math.max(ans, getCur(cur.mask));

            for (int k = 0; k < 4; k++) {
                int nextY = cur.y + dy[k];
                int nextX = cur.x + dx[k];


                if(isOk(nextY, nextX) && (cur.mask & 1<<grid[nextY][nextX]) == 0){
                    int newMask = cur.mask | 1<< grid[nextY][nextX];
                    String key = new String("" +nextY + " " +nextX +newMask);
                    if(map.containsKey(key)) continue;
                    map.put(key,true);
                    queue.offer(new Horse(nextY, nextX, newMask));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        readLine();
        R= nextInt();
        C = nextInt();
        for (int i = 0; i < R; i++){
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < C; j++)
                grid[i][j] = tmp[j] - 'A';
        }
        
        solve();
        

        bw.write(String.format("%d\n",ans));
        bwEnd();
    }
}