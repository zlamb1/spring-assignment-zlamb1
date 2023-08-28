package edu.wctc.sales.impl;

import edu.wctc.sales.Country;
import edu.wctc.sales.Sale;
import edu.wctc.sales.iface.ISalesReport;

import java.text.NumberFormat;
import java.util.*;

public class DetailSalesReport implements ISalesReport {

    private final Locale locale = new Locale("en", "US");
    private final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

    @Override
    public void generateReport(List<Sale> salesList) {
        System.out.println("SALES DETAIL REPORT");
        System.out.printf("%-20s", "Customer");
        System.out.printf("%-15s", "Country");
        System.out.printf("%-10s", "Amount");
        System.out.printf("%-10s", "Tax");
        System.out.printf("%-10s", "Shipping");
        System.out.println();

        for (Sale sale : salesList) {
            System.out.printf("%-20s", sale.getCustomerName());
            System.out.printf("%-15s", sale.getCountry());
            System.out.printf("%-10s", currencyFormatter.format(sale.getAmount()));
            System.out.printf("%-10s", currencyFormatter.format(sale.getTax()));
            System.out.printf("%-10s", currencyFormatter.format(sale.getShipping()));
            System.out.println();
        }
    }
}
