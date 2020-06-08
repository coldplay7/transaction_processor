package com.demo.induction.tp;

import com.demo.induction.tp.model.Transactions;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.InputStream;

public class XmlTransactionProcessor extends AbstractTransactionProcessor {

    @Override
    public void importTransactions(InputStream is) {
        try {
            JAXBContext context = JAXBContext.newInstance(Transactions.class);
            Transactions transactions = (Transactions) context.createUnmarshaller().unmarshal(is);
            this.transactions = transactions.getTransactions();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}