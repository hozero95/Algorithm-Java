package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Baekjoon
 * 5568번: 카드 놓기
 * 난이도: 실버 4
 * 분류: 자료 구조, 브루트포스 알고리즘, 해시를 사용한 집합과 맵, 백트래킹
 *
 * @author hozero
 * @since 2025-01-15
 */
@SuppressWarnings("DuplicatedCode")
public class No5568 {
    static BufferedReader br;
    static StringBuilder sb;
    static int n;
    static int k;
    static int[] cards, selected, used;
    static Set<Integer> list;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        cards = new int[n];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = Integer.parseInt(br.readLine());
        }
        selected = new int[k + 1];
        used = new int[n + 1];
        list = new HashSet<>();
    }

    static void solve(int depth) {
        if (depth == k + 1) {
            for (int i = 1; i < selected.length; i++) {
                sb.append(selected[i]);
            }
            list.add(Integer.parseInt(sb.toString()));
            sb.setLength(0);
        } else {
            for (int i = 0; i < cards.length; i++) {
                if (used[i] == 1) {
                    continue;
                }
                selected[depth] = cards[i];
                used[i] = 1;
                solve(depth + 1);
                used[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve(1);
        System.out.println(list.size());
    }
}
