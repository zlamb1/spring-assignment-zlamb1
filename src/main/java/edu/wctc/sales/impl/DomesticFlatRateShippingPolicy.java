package edu.wctc.sales.impl;

import edu.wctc.sales.Sale;
import edu.wctc.sales.iface.IShippingPolicy;

public class DomesticFlatRateShippingPolicy implements IShippingPolicy {
    @Override
    public void applyShipping(Sale sale) {
        if (sale.getCountry().equals("United States")) {
            sale.setShipping(5.99);
        } else {
            sale.setShipping(sale.getAmount() / 10);
        }
    }
}
