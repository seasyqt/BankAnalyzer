package com.github.analyzer.service;

import com.github.analyzer.domain.BankTransaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class BankStatementCSVParser {
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private static BankTransaction parseFromCSV(final String line) {
        final String[] columns = line.split(",");

        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new BankTransaction(date, amount, description);
    }

    public static List<BankTransaction> parseLinesFromCSV(final List<String> lines) {
        return lines
                .stream()
                .map(BankStatementCSVParser::parseFromCSV)
                .collect(Collectors.toList());
    }


}
