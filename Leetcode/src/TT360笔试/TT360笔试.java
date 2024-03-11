package TT360笔试;


import java.util.Scanner;

public class TT360笔试 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

        for (int t = 0; t < T; t++) {
            String s = scanner.nextLine();
            String tStr = scanner.nextLine();

            if (canTransform(s, tStr)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }

    public static boolean canTransform(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.length() == t.length()) {
            return s.equals(t);
        }

        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}
