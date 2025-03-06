import java.io.*;
import java.util.*;
import java.awt.Point;

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

    static int T;
    static int[][] grid = new int[100][100];
    static int R,C;

    static boolean[][] visited = new boolean[100][100];

    static int ansTime;
    static int ans;

    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};

    static int[][]dir = new int[][]{{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1}};



    static boolean isOk(int y, int x){
        return 0<=y && y<R && 0<=x && x<C;
    }

    static boolean isBlank(int y, int x){
        if(grid[y][x] == '*') return false;

        for (int k = 0; k < 4; k++) {
            int nextY = y + dy[k];
            int nextX = x + dx[k];
            if(isOk(nextY,nextX) && grid[nextY][nextX] == 1) 
                return false;
            
        }

        return true;
    }

    static void print(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(String.format("%d ", grid[i][j]));
            }
            System.out.println();
        }
        System.out.println();
    }

    static void init(){
        for (int i = 0; i < R; i++)
            Arrays.fill(visited[i], false);
    }

    static int melting(){
        init();
        
        int count = 0;

        Queue<Point> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.offer(new Point(0,0));
        while(!queue.isEmpty()){
            Point cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nextY = cur.y + dy[k];
                int nextX = cur.x + dx[k];

                if(isOk(nextY, nextX) && !visited[nextY][nextX]){
                    visited[nextY][nextX] = true;
                    if(grid[nextY][nextX] == 1){
                        count++;
                        grid[nextY][nextX] = 0;
                    }else{
                        queue.offer(new Point(nextX,nextY));
                    }
                }
            }
        }

        return count;
    }


    static void solve(){
        int prev = 0;
        int time = 0;

        while(true){
            int cur =melting();
            if(cur == 0)
                break;
            time++;
            prev = cur;
        }
        ansTime = time;
        ans = prev;
    }


    public static void main(String[] args) throws Exception {
        readLine();
        R= nextInt();
        C = nextInt();
        for (int i = 0; i < R; i++){
            readLine();
            for (int j = 0; j < C; j++)
                grid[i][j] = nextInt();
        }
        solve();

        bw.write(String.format("%d\n%d\n", ansTime,ans));
        bwEnd();
    }
}