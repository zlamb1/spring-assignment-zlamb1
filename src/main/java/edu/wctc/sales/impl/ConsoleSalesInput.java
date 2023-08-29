package edu.wctc.sales.impl;

import edu.wctc.sales.Sale;
import edu.wctc.sales.iface.ISalesInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleSalesInput implements ISalesInput {

    @Override
    public List<Sale> getSales() {
        Scanner scanner = new Scanner(System.in);
        List<Sale> sales = new ArrayList<>();

        while (true) {
            System.out.print("Enter new sale (y/n)? ");
            String resp = scanner.nextLine();
            if (resp == null || !resp.toLowerCase().equals("y")) {
                break;
            }

            Sale sale = new Sale();
            System.out.print("Enter sale customer: ");
            String customer = scanner.nextLine();
            if (customer == null) {
                System.out.println("Please enter a valid customer name!");
                continue;
            }
            sale.setCustomerName(customer);

            System.out.print("Enter sale country: ");
            String country = scanner.nextLine();
            if (country == null) {
                System.out.println("Please enter a valid country name!");
                continue;
            }
            sale.setCountry(country);

            try {
                System.out.print("Enter sale amount: ");
                double amount = Double.parseDouble(scanner.nextLine());
                sale.setAmount(amount);
            } catch (NumberFormatException exc) {
                System.out.println("You must enter a valid number!");
                continue;
            }

            try {
                System.out.print("Enter sale tax: ");
                double tax = Double.parseDouble(scanner.nextLine());
                sale.setTax(tax);
            } catch (NumberFormatException exc) {
                System.out.println("You must enter a valid number!");
                continue;
            }

            sales.add(sale);
            System.out.println();
        }

        System.out.println();
        return sales;
    }
}
