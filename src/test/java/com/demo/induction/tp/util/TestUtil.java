package com.demo.induction.tp.util;

import com.demo.induction.tp.model.Transaction;
import com.demo.induction.tp.model.Violation;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class TestUtil {
    public static List<Transaction> getTransaction_balanced() {
        return Arrays.asList(new Transaction("C", new BigDecimal(100), "foo narration"),
                new Transaction("D", new BigDecimal(100), "foo narration"));

    }

    public static List<Transaction> getSampleTransaction() {
        Transaction t1 = new Transaction("D", BigDecimal.valueOf(61.22), "Electricity bill");
        Transaction t2 = new Transaction("D", BigDecimal.valueOf(52.14), "Social security payment");
        Transaction t3 = new Transaction("D", BigDecimal.valueOf(200.00), "Payment sent to x");
        Transaction t4 = new Transaction("C", BigDecimal.valueOf(1920.00), "Salary");
        Transaction t5 = new Transaction("D", BigDecimal.valueOf(150.00), "Car rental");
        return Arrays.asList(t1, t2, t3, t4, t5);
    }

    public static List<Transaction> getBalancedTransaction() {
        Transaction t1 = new Transaction("D", BigDecimal.valueOf(10.00), "Electricity bill");
        Transaction t2 = new Transaction("D", BigDecimal.valueOf(20.00), "Social security payment");
        Transaction t3 = new Transaction("D", BigDecimal.valueOf(30.00), "Payment sent to x");
        Transaction t4 = new Transaction("D", BigDecimal.valueOf(40.00), "Car rental");
        Transaction t5 = new Transaction("C", BigDecimal.valueOf(100.00), "Salary");
        return Arrays.asList(t1, t2, t3, t4, t5);
    }

    public static List<Violation> getViolations() {
        return Arrays.asList(
                new Violation(0, "type", "type must be any of C or D"),
                new Violation(0, "narration", "Narration cannot be null or empty"),
                new Violation(1, "type", "type must be any of C or D"),
                new Violation(1, "amount", "Amount field is not valid."),
                new Violation(2, "amount", "Amount field is not valid."),
                new Violation(3, "amount", "Amount field is not valid."),
                new Violation(3, "narration", "Narration cannot be null or empty")
        );
    }


}
