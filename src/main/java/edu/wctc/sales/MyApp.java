package edu.wctc.sales;

import edu.wctc.sales.iface.ISalesInput;
import edu.wctc.sales.iface.ISalesReport;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MyApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        ((SalesApp)context.getBean("salesApp")).generateSales();
    }
}
