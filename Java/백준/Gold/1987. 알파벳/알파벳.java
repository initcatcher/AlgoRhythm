import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    
    static int R, C;
    static char[][] board;
    static int ans = 0;
    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    static boolean isOk(int y, int x) {
        return y >= 0 && y < R && x >= 0 && x < C;
    }
    
    static void dfs(int y, int x, int mask, int count) {
        ans = Math.max(ans, count);
        
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            
            if (isOk(ny, nx)) {
                int letter = board[ny][nx] - 'A';
                if ((mask & (1 << letter)) == 0) {  // 아직 방문하지 않은 알파벳이면
                    dfs(ny, nx, mask | (1 << letter), count + 1);
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for (int i = 0; i < R; i++){
            board[i] = br.readLine().toCharArray();
        }
        int initialMask = 1 << (board[0][0] - 'A');
        dfs(0, 0, initialMask, 1);
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
