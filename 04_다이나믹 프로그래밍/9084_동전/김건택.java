import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 동전 개수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coins = new int[N];

            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine()); // 목표 금액
            int[] dp = new int[M + 1];

            dp[0] = 1; // 0원을 만드는 경우는 1가지

            for (int coin : coins) {
                for (int i = coin; i <= M; i++) {
                    dp[i] += dp[i - coin];
                }
            }

            System.out.println(dp[M]);
        }
    }
}
