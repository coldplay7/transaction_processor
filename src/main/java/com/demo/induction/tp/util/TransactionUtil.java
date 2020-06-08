package com.demo.induction.tp.util;

import com.demo.induction.tp.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public class TransactionUtil {

    public static boolean isBalanced(List<Transaction> transactions) {

        BigDecimal d = transactions.parallelStream()
                .filter(transaction -> transaction.getType().equalsIgnoreCase("D"))
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal c = transactions.parallelStream()
                .filter(transaction -> transaction.getType().equalsIgnoreCase("C"))
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return d.equals(c);
    }

}
