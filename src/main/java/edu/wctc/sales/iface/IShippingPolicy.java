package edu.wctc.sales.iface;

import edu.wctc.sales.Sale;

public interface IShippingPolicy {
    void applyShipping(Sale sale);
}
