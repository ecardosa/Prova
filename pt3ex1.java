import java.util.Scanner;
public class pt3ex1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);


        System.out.print("Quantes piràmides vols? ");
        int p= sc.nextInt();
        System.out.print("Quina alçada té cada piràmide? ");
        int n= sc.nextInt();

        for (int a = 0; a < p; a++) {
            for (int i = 0; i < n; i++) {
                for (int h = i; h < n; h++) {
                    System.out.print(".");
                }
                System.out.println();
            }
        }
    }

}