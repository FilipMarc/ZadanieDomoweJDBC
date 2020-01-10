package Zadanie1;

import java.util.Scanner;

public class TransactionCreate {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Podaj typ: ");
        String type = sc.nextLine();

        System.out.println("Podaj opis: ");
        String description = sc.nextLine();

        System.out.println("Podaj wartość: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.println("Podaj datę: ");
        String date = sc.nextLine();

        Transaction transaction = new Transaction(type,description,amount,date);

        TransactionDao transactionDao = new TransactionDao();
        transactionDao.insert(transaction);
    }
}
