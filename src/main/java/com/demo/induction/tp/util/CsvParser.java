package com.demo.induction.tp.util;

import com.demo.induction.tp.constant.CsvIndex;
import com.demo.induction.tp.exception.CsvParseException;

import static com.demo.induction.tp.constant.CsvIndex.AMOUNT;

public class CsvParser {

    private static final String DELIMITER = ",";

    public static String parse(String line, CsvIndex index) {

        assert line != null;
        String[] split = line.split(DELIMITER, CsvIndex.values().length);

        int length = split.length;
        int ordinal = index.ordinal();
        if (length > ordinal) {
            sanitizeAmountIndex(index, split, ordinal);
            return split[ordinal];
        } else {
            throw new CsvParseException("Exception occurred while parsing line. ");
        }

    }

    private static void sanitizeAmountIndex(CsvIndex index, String[] split, int ordinal) {
        if (AMOUNT == index && split[ordinal].isEmpty()) {
            split[ordinal] = "0";
        }
    }

}
