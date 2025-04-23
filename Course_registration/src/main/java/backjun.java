
import java.util.*;
import java.io.*;

public class backjun {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i =0; i<T ; i++){
            int charge = Integer.parseInt(br.readLine());
            int Q = 0;
            int D = 0;
            int N = 0;
            int P = 0;
            Q = charge/25;
            charge%=25;
            D = charge/10;
            charge%=10;
            N = charge/5;
            charge%=5;
            P = charge;
            bw.write(Q + " " + D + " " + N + " " + P + "\n");
        }
        br.close();
        bw.close();
    }
}
