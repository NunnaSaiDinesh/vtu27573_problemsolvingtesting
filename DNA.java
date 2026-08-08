import java.util.*;

class DNA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine().trim();
        String pat = sc.nextLine().trim();

        int m = pat.length();
        int[] lps = new int[m];

        // Create LPS array
        for (int i = 1, j = 0; i < m; ) {
            if (pat.charAt(i) == pat.charAt(j))
                lps[i++] = ++j;
            else if (j > 0)
                j = lps[j - 1];
            else
                i++;
        }

        // Search pattern
        for (int i = 0, j = 0; i < text.length(); ) {
            if (text.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.print((i - j) + " ");
                j = lps[j - 1];
            } else if (i < text.length() && text.charAt(i) != pat.charAt(j)) {
                if (j > 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }

        sc.close();
    }
}

