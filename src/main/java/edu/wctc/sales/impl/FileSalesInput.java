package edu.wctc.sales.impl;

import edu.wctc.sales.Sale;
import edu.wctc.sales.iface.ISalesInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSalesInput implements ISalesInput {

    @Override
    public List<Sale> getSales() {
        File salesFile = new File("sales.txt");
        Scanner reader = null;

        try {
            reader = new Scanner(salesFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<Sale> sales = new ArrayList<>();
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            Sale sale = new Sale();

            final String[] split = line.split(",");
            if (split.length < 4) {
                continue;
            }
            sale.setCustomerName(split[0]);
            sale.setCountry(split[1]);
            try {
                sale.setAmount(Double.parseDouble(split[2]));
                sale.setTax(Double.parseDouble(split[3]));
            } catch (NumberFormatException exc) {
                // if we cannot parse either double the sale is formatted incorrectly
                // we will disregard it
                continue;
            }

            sales.add(sale);
        }

        reader.close();
        return sales;
    }

}
