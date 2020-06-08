package com.demo.induction.tp.util;

import com.demo.induction.tp.model.Transaction;
import com.demo.induction.tp.model.Violation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransactionValidator {

    public static List<Violation> validate(List<Transaction> transactions) {

        List<Violation> violations = new ArrayList<>();
        int order = 0;
        for (Transaction transaction : transactions) {
            validateTransactionType(violations, transaction, order);
            validateTransactionAmount(violations, transaction, order);
            validateTransactionNarration(violations, transaction, order);
            order = order + 1;
        }
        return violations;
    }

    private static void validateTransactionNarration(List<Violation> violations, Transaction transaction, Integer order) {
        String narration = transaction.getNarration();
        if (null == narration || narration.isEmpty()) {
            violations.add(new Violation(order, "narration", "Narration cannot be null or empty"));
        }
    }

    private static void validateTransactionAmount(List<Violation> violations, Transaction transaction, Integer order) {
        BigDecimal amount = transaction.getAmount();
        if (null == amount || amount.signum() <= 0) {
            violations.add(new Violation(order, "amount", "Amount field is not valid."));
        }
    }

    /*TODO  enum for transaction type */
    private static void validateTransactionType(List<Violation> violations, Transaction transaction, Integer order) {
        String type = transaction.getType();
        if (null == type) {
            violations.add(new Violation(order, "type", "Type cannot be null"));
        } else if (!(type.equalsIgnoreCase("D") || type.equalsIgnoreCase("C"))) {
            violations.add(new Violation(order, "type", "type must be any of C or D"));
        }
    }
}
