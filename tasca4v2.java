import java.util.*;
import java.math.*;

public class tasca4v2 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int p, n;
        System.out.print("Quantes piràmides vols?: ");
        p = sc.nextInt();
        System.out.print("Quina alçada té la piràmide? ");
        n = sc.nextInt();
        
        for (int i = 0; i < p; i++) {
            for (int j = 1; j <= n + 1; j++) {
                for (int x = (j * 2 - 1) / -2 - (n - j + 1); x <= (j * 2 - 1) / 2 + (n - j + 1); x++)
                    System.out.print(Math.abs(x) > (j * 2 - 1) / 2 ? "." : n - Math.abs(x));
                System.out.println();
            }
        }
    }
}
