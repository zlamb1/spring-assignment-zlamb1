package edu.wctc.sales;

import edu.wctc.sales.iface.ISalesInput;
import edu.wctc.sales.iface.ISalesReport;
import edu.wctc.sales.iface.IShippingPolicy;
import edu.wctc.sales.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("edu.wctc.sales")
public class AppConfig {

    @Bean
    ISalesInput salesInput() {
        return new FileSalesInput();
    }

    @Bean
    IShippingPolicy shippingPolicy() {
        return new DomesticFlatRateShippingPolicy();
    }

    @Bean
    ISalesReport salesReport() {
        return new SummarySalesReport();
    }

}
