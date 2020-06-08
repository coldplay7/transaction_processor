package com.demo.induction.tp.util;

import com.demo.induction.tp.constant.CsvIndex;
import com.demo.induction.tp.exception.CsvParseException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CsvParserTest {
    @Test
    public void test_csv_parser() {
        String line = "D,61.22,Electricity bill";

        String type = CsvParser.parse(line, CsvIndex.TYPE);
        String amount = CsvParser.parse(line, CsvIndex.AMOUNT);
        String narration = CsvParser.parse(line, CsvIndex.NARRATION);

        assertEquals("D", type);
        assertEquals("61.22", amount);
        assertEquals("Electricity bill", narration);

    }

    @Test(expected = CsvParseException.class)
    public void test_throws_csvParseException() {
        String line1 = "D,61.22";
        String parse = CsvParser.parse(line1, CsvIndex.NARRATION);
    }

    @Test(expected = AssertionError.class)
    public void test_throws_assertionError() {
        CsvParser.parse(null, CsvIndex.NARRATION);
    }
}
