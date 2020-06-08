package com.demo.induction.tp;

import com.demo.induction.tp.model.Transaction;
import com.demo.induction.tp.model.Violation;
import com.demo.induction.tp.util.TransactionUtil;
import com.demo.induction.tp.util.TransactionValidator;

import java.io.InputStream;
import java.util.List;

public class AbstractTransactionProcessor implements TransactionProcessor {

    protected List<Transaction> transactions;

    @Override
    public void importTransactions(InputStream is) {
    }

    @Override
    public List<Transaction> getImportedTransactions() {
        return this.transactions;
    }

    @Override
    public List<Violation> validate() {
        return TransactionValidator.validate(this.transactions);
    }

    @Override
    public boolean isBalanced() {
        return TransactionUtil.isBalanced(this.transactions);
    }
}
