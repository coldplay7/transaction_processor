package com.demo.induction.tp;

import com.demo.induction.tp.model.Transaction;
import com.demo.induction.tp.model.Violation;
import com.demo.induction.tp.util.TestUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.*;

public class XmlTransactionProcessorTest {
    private XmlTransactionProcessor transactionProcessor;

    @Before
    public void init() {
        this.transactionProcessor = new XmlTransactionProcessor();
    }

    @Test
    public void test_xml_sample() throws FileNotFoundException {
        List<Transaction> expectedTransactions = TestUtil.getSampleTransaction();

        transactionProcessor.importTransactions(new FileInputStream("src\\test\\resources\\sample.xml"));
        List<Transaction> actualTransactions = transactionProcessor.getImportedTransactions();
        assertEquals(5, actualTransactions.size());
        boolean balanced = transactionProcessor.isBalanced();
        assertFalse(balanced);
        List<Violation> violations = transactionProcessor.validate();
        assertEquals(0, violations.size());

        assertEquals(expectedTransactions, actualTransactions);
    }

    @Test
    public void test_xml_balanced() throws FileNotFoundException {

        transactionProcessor.importTransactions(new FileInputStream("src\\test\\resources\\xml_balanced.xml"));
        assertTrue(transactionProcessor.isBalanced());

        List<Transaction> actualTransactions = transactionProcessor.getImportedTransactions();
        List<Transaction> expectedTransaction = TestUtil.getBalancedTransaction();

        assertEquals(expectedTransaction, actualTransactions);

    }

    @Test
    public void test_xml_violations() throws FileNotFoundException {
        transactionProcessor.importTransactions(new FileInputStream("src\\test\\resources\\xml_violations.xml"));
        List<Violation> actualViolations = transactionProcessor.validate();
        List<Violation> expectedViolations = TestUtil.getViolations();
        assertEquals(expectedViolations, actualViolations);

    }

}
