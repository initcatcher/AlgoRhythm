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
    static int ans;


    static void solve(){
        int count = 0;

        while(N != 2){
            // System.out.println(N);
            long sqrt = (long)Math.sqrt(N);
            if(sqrt * sqrt == N){
                N = sqrt;
                count++;
            }else{
                long next = (sqrt+1)*(sqrt+1);
                count += next - N;
                N = next;
            }
        }
        // System.out.println();
        ans = count;
    }


    public static void main(String[] args) throws Exception {
        readLine();
        T = nextInt();
        for (int t = 1; t <= T; t++) {
            readLine();
            N = nextLong();
            solve();

            bw.write("#" + t + " " + ans + "\n");
        }
        bwEnd();
    }
}