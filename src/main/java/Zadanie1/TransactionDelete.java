package Zadanie1;

import java.util.Scanner;

public class TransactionDelete {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TransactionDao transactionDao = new TransactionDao();

        System.out.println("Podaj id: ");

        long id = sc.nextLong();
        sc.nextLine();

        transactionDao.deleteTransaction(id);
        System.out.println("Usunięto!");
    }
}
