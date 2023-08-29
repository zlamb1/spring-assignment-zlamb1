package edu.wctc.sales;

import edu.wctc.sales.iface.ISalesInput;
import edu.wctc.sales.iface.ISalesReport;
import edu.wctc.sales.iface.IShippingPolicy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SalesApp {

    private ISalesInput salesInput;
    private IShippingPolicy shippingPolicy;
    private ISalesReport salesReport;

    private List<Sale> sales;

    public SalesApp(ISalesInput salesInput, IShippingPolicy shippingPolicy, ISalesReport salesReport) {
        this.salesInput = salesInput;
        this.shippingPolicy = shippingPolicy;
        this.salesReport = salesReport;
    }

    public void generateSales() {
        sales = salesInput.getSales();
        for (Sale sale : sales) {
            shippingPolicy.applyShipping(sale);
        }

        salesReport.generateReport(sales);
    }

}
