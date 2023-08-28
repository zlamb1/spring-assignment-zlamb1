package edu.wctc.sales.impl;

import edu.wctc.sales.Country;
import edu.wctc.sales.Sale;
import edu.wctc.sales.iface.ISalesReport;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SummarySalesReport implements ISalesReport {
    private final Locale locale = new Locale("en", "US");
    private final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
    private List<Country> countries = new ArrayList<>();

    private void processCountry(Sale sale) {
        Country country = null;
        for (Country c : countries) {
            if (sale.getCountry().equals(c.getName())) {
                country = c;
            }
        }

        if (country == null) {
            country = new Country(sale.getCountry());
            countries.add(country);
        }

        country.setAmount(country.getAmount() + sale.getAmount());
        country.setTax(country.getTax() + sale.getTax());
        country.setShipping(country.getShipping() + sale.getShipping());
    }

    @Override
    public void generateReport(List<Sale> salesList) {
        for (Sale sale : salesList) {
            processCountry(sale);
        }

        System.out.println("SALES SUMMARY REPORT");
        System.out.printf("%-15s", "Country");
        System.out.printf("%-10s", "Amount");
        System.out.printf("%-10s", "Tax");
        System.out.printf("%-10s", "Shipping");
        System.out.println();
        for (Country country : countries) {
            System.out.printf("%-15s", country.getName());
            System.out.printf("%-10s", currencyFormatter.format(country.getAmount()));
            System.out.printf("%-10s", currencyFormatter.format(country.getTax()));
            System.out.printf("%-10s", currencyFormatter.format(country.getShipping()));
            System.out.println();
        }
    }
}
