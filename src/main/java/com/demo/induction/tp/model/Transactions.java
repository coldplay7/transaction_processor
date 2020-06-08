package com.demo.induction.tp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "TransactionList")
public class Transactions {

    private List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @XmlElement(name = "Transaction")
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
