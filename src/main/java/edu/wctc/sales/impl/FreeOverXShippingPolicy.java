package edu.wctc.sales.impl;

import edu.wctc.sales.Sale;
import edu.wctc.sales.iface.IShippingPolicy;

public class FreeOverXShippingPolicy implements IShippingPolicy {

    private int x;
    FreeOverXShippingPolicy(int x) {
        this.x = x;
    }

    @Override
    public void applyShipping(Sale sale) {
        if (sale.getAmount() > x) {
            sale.setShipping(0);
        } else {
            sale.setShipping(sale.getAmount() / 10);
        }
    }
}
