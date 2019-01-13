package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)?");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();
            if (ch == 'i') {
                System.out.print("Health expenditures: ");
                double expenditures = sc.nextDouble();
                list.add(new Individual(name, anualIncome, expenditures));
            } else {
                System.out.print("Number of employees: ");
                int nEmployees = sc.nextInt();
                list.add(new Company(name, anualIncome, nEmployees));
            }
        }
        System.out.println();
        System.out.println("TAXES PAID:");
        for (TaxPayer taxPayer : list) {
            System.out.println(taxPayer);
        }
        double sum = 0.0;
        for (TaxPayer taxPayer : list) {
            sum += taxPayer.tax();
        }
        System.out.printf("Total TAXES: %.2f", sum);

        sc.close();
    }
}
