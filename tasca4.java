import java.util.*;
import java.math.*;

public class tasca4 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int p, n;
        System.out.print("Quantes piràmides vols?: ");
        p = sc.nextInt();
        System.out.print("Quina alçada té la piràmide?");
        n = sc.nextInt();
        
        for (int i = 0; i < p; i++) {
            for (int j = 1; j <= n+1; j++) {
                for (int e = n; e >= j; e--) {
                    System.out.print(".");
                }
                for (int x = (j*2-1) / -2; x <= (j*2-1) / 2; x++) {
                    System.out.print(n - Math.abs(x));
                }
                for (int e = n; e >= j; e--) {
                    System.out.print(".");
                }
                System.out.println();
            }
        }
    }
}
