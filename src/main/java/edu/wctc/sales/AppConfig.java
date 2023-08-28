package edu.wctc.sales;

import edu.wctc.sales.iface.ISalesInput;
import edu.wctc.sales.iface.ISalesReport;
import edu.wctc.sales.impl.DetailSalesReport;
import edu.wctc.sales.impl.FileSalesInput;
import edu.wctc.sales.impl.SummarySalesReport;
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
    ISalesReport salesReport() {
        return new SummarySalesReport();
    }

}
