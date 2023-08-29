package edu.wctc.sales.impl;

import edu.wctc.sales.Sale;
import edu.wctc.sales.iface.IShippingPolicy;

public class FreeShippingPolicy implements IShippingPolicy {
    @Override
    public void applyShipping(Sale sale) {
        sale.setShipping(0);
    }
}
