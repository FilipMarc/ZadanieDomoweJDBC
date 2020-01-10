package Zadanie1;

import java.util.Scanner;

public class TransactionUpdate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TransactionDao transactionDao = new TransactionDao();

        System.out.println("Podaj id elementu który chcesz zaktualizoać");
        long id = sc.nextLong();
        sc.nextLine();

        System.out.println("Podaj typ: ");
        String type = sc.nextLine();

        System.out.println("Podaj opis: ");
        String description = sc.nextLine();

        System.out.println("Podaj wartość : ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.println("Podaj datę : ");
        String date = sc.nextLine();

        Transaction transaction = new Transaction(id,type,description,amount,date);
        TransactionDao transactDao = new TransactionDao();
        transactDao.updateTransaction(transaction);
    }
}
