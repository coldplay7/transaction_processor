package com.demo.induction.tp.util;

import com.demo.induction.tp.model.Transaction;
import com.demo.induction.tp.model.Violation;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TransactionValidatorTest {

    @Test
    public void test_validate() {

        List<Violation> actualViolations = TransactionValidator.validate(transactions());
        List<Violation> expectedViolations = violations();

        assertEquals(expectedViolations, actualViolations);
    }

    @Test
    public void test_validateTransactionNarration() {
        List<Violation> violations = TransactionValidator.validate(Arrays.asList(new Transaction("D", BigDecimal.valueOf(10), null)));

        assertTrue(violations.size() == 1);
        assertTrue(violations.stream().filter(violation -> violation.getDescription().equalsIgnoreCase("Narration cannot be null or empty"))
                .count() == 1);

    }

    public List<Transaction> transactions() {
        return Arrays.asList(
                new Transaction("", BigDecimal.valueOf(10), ""),
                new Transaction("", BigDecimal.valueOf(0), "test narration")
        );
    }

    public List<Violation> violations() {
        return Arrays.asList(
                new Violation(0, "type", "type must be any of C or D"),
                new Violation(0, "narration", "Narration cannot be null or empty"),
                new Violation(1, "type", "type must be any of C or D"),
                new Violation(1, "amount", "Amount field is not valid.")
        );
    }

}
