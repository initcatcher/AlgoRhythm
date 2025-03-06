import java.io.*;
import java.util.*;
import java.awt.Point;

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
    static char[][] grid = new char[300][];
    static int N;

    static int ans;

    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};

    static int[][]dir = new int[][]{{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1}};


    static boolean[][] visited = new boolean[300][300];

    static boolean isOk(int y, int x){
        return 0<=y && y<N && 0<=x && x<N;
    }

    static void init(){
        for (int i = 0; i < N; i++) 
            Arrays.fill(visited[i], false);
    }

    static boolean isBlank(int y, int x){
        if(grid[y][x] == '*') return false;

        for (int k = 0; k < 8; k++) {
            int nextY = y + dir[k][0];
            int nextX = x + dir[k][1];
            if(isOk(nextY,nextX) && grid[nextY][nextX] == '*') 
                return false;
            
        }

        return true;
    }

    static void print(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(String.format("%d ", visited[i][j] ? 1 : 0));
            }
            System.out.println();
        }
    }


    static void solve(){
        int count = 0;
        Queue<Point> queue = new LinkedList<>();
        for (int y = 0; y < N; y++){
            for (int x = 0; x < N; x++) {
                if(visited[y][x]) continue;
                if(!isBlank(y, x)) continue;

                count++;
                visited[y][x]= true;
                queue.offer(new Point(x,y));
                while(!queue.isEmpty()){
                    Point cur = queue.poll();

                    if(!isBlank(cur.y, cur.x)){
                        continue;
                    }

                    for (int k = 0; k < 8; k++) {
                        int nextY = cur.y + dir[k][0];
                        int nextX = cur.x + dir[k][1];
                        if(isOk(nextY,nextX)&& grid[nextY][nextX] == '.' &&!visited[nextY][nextX]){
                            visited[nextY][nextX] = true;
                            queue.offer(new Point(nextX,nextY));
                        }
                    }
                }
            }
        }
        for (int y = 0; y < N; y++){
            for (int x = 0; x < N; x++) {
                if(visited[y][x]) continue;
                if(grid[y][x]=='*') continue;

                visited[y][x] = true;
                count++;
            }
        }

        ans = count;
    }


    public static void main(String[] args) throws Exception {
        readLine();
        T = nextInt();
        for (int t = 1; t <= T; t++) {
            readLine();
            N = nextInt();
            for (int i = 0; i < N; i++)
                grid[i] = br.readLine().toCharArray();
            init();
            solve();

            // print();
            
            bw.write("#" + t + " " + ans + "\n");
        }
        bwEnd();
    }
}