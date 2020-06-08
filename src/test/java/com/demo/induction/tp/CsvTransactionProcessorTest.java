package com.demo.induction.tp;

import com.demo.induction.tp.model.Transaction;
import com.demo.induction.tp.model.Violation;
import com.demo.induction.tp.util.TestUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.*;

public class CsvTransactionProcessorTest {
    private TransactionProcessor transactionProcessor;

    @Before
    public void init() {
        this.transactionProcessor = new CsvTransactionProcessor();
    }


    @Test
    public void test_csv_sample() throws FileNotFoundException {

        transactionProcessor.importTransactions(new FileInputStream(new File("src\\test\\resources\\sample.csv")));
        List<Transaction> actualTransactions = this.transactionProcessor.getImportedTransactions();

        List<Transaction> expectedTransactions = TestUtil.getSampleTransaction();

        assertEquals(expectedTransactions, actualTransactions);

        assertEquals(0, transactionProcessor.validate().size());
        assertFalse(transactionProcessor.isBalanced());
    }

    @Test
    public void test_csv_balanced() throws FileNotFoundException {

        transactionProcessor.importTransactions(new FileInputStream("src\\test\\resources\\csv_balanced.csv"));
        assertTrue(transactionProcessor.isBalanced());

        List<Transaction> actualTransactions = transactionProcessor.getImportedTransactions();
        List<Transaction> expectedTransaction = TestUtil.getBalancedTransaction();

        assertEquals(expectedTransaction, actualTransactions);

    }

    @Test
    public void test_csv_violations() throws FileNotFoundException {
        transactionProcessor.importTransactions(new FileInputStream("src\\test\\resources\\csv_violations.csv"));
        List<Violation> actualViolations = transactionProcessor.validate();
        List<Violation> expectedViolations = TestUtil.getViolations();
        assertEquals(expectedViolations, actualViolations);
    }

}
