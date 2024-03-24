import java.util.Scanner;


class LargestNumber {
    public static void main(String[] args) {
        double A, B, C;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value for A: ");
        A = scanner.nextFloat();
        
        System.out.print("Enter the value for B: ");
        B = scanner.nextFloat();

        System.out.print("Enter the value for C: ");
        C = scanner.nextFloat();

        System.out.print("Largest Value is: ");

        if (A > B) {
            if (A > C) {
                System.out.printf("%.1f\n", A);
            } else {
                System.out.printf("%.1f\n", C);
            }
        } else {
            if (C > B) {
                System.out.printf("%.1f\n", C); 
            } else {
                System.out.printf("%.1f\n", B);
            }
        }

        scanner.close();
    }
}