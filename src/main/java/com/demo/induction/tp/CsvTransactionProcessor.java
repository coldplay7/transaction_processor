package com.demo.induction.tp;

import com.demo.induction.tp.model.Transaction;
import com.demo.induction.tp.util.CsvParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;

import static com.demo.induction.tp.constant.CsvIndex.*;

public class CsvTransactionProcessor extends AbstractTransactionProcessor {

    @Override
    public void importTransactions(InputStream is) {
        this.transactions = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            br.lines().forEach(line -> {
                transactions.add(new Transaction(CsvParser.parse(line, TYPE),
                        BigDecimal.valueOf(Double.parseDouble(CsvParser.parse(line, AMOUNT))),
                        CsvParser.parse(line, NARRATION)));
            });
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
