package com.demo.induction.tp.util;

import com.demo.induction.tp.model.Transaction;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TransactionUtilTest {

    @Test
    public void test_isBalanced_returns_true() {

        assertTrue(TransactionUtil.isBalanced(Arrays.asList(new Transaction("D", new BigDecimal(100.00), null),
                new Transaction("D", BigDecimal.valueOf(200.00), null),
                new Transaction("C", BigDecimal.valueOf(300.00), null)
        )));
    }

    @Test
    public void test_isBalanced_returns_false() {
        assertFalse(TransactionUtil.isBalanced(Arrays.asList(new Transaction("D", new BigDecimal(100.00), null),
                new Transaction("D", BigDecimal.valueOf(200.00), null),
                new Transaction("C", BigDecimal.valueOf(400.00), null)
        )));
    }
}
