package com.demo.induction.tp;

import com.demo.induction.tp.model.Transaction;
import com.demo.induction.tp.model.Violation;

import java.io.InputStream;
import java.util.List;


public interface TransactionProcessor {

    void importTransactions(InputStream is);

    List<Transaction> getImportedTransactions();

    List<Violation> validate();

    boolean isBalanced();
}


