import java.util.Scanner;
import java.util.*;

public class tasca3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int m;
        System.out.print("Entra l'alçada del triangle: ");
        m = sc.nextInt();

        for (int i = 1; i <= m; i++) {
            for (int e = 1; e <= i; e++) {
                System.out.print(e + (e == i ? "" : ", "));
            }
            System.out.println("");
        }
    }
}