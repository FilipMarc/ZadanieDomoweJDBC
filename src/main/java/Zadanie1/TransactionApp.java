package Zadanie1;

import sun.jvm.hotspot.debugger.win32.coff.TestDebugInfo;

import java.util.Scanner;

public class TransactionApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Co chcesz zrobić:");
            System.out.println("1. Dodawanie");
            System.out.println("2. Modyfikacja");
            System.out.println("3. Usuwanie");
            System.out.println("4. Przychody");
            System.out.println("5. Wydatki");
            System.out.println("0. Koniec");

            int input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1:
                    TransactionCreate.main(new String[0]);
                    break;
                case 2:
                    TransactionUpdate.main(new String[0]);
                    break;
                case 3:
                    TransactionDelete.main(new String[0]);
                    break;
                case 4:
                    TransactionIncome.main(new String[0]);
                    break;
                case 5:
                    TransactionExpenses.main(new String[0]);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Błędny wybór!");
            }
        }
    }
}
