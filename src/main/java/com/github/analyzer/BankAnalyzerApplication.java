package com.github.analyzer;

import com.github.analyzer.domain.BankTransaction;
import com.github.analyzer.service.BankStatementCSVParser;
import com.github.analyzer.service.BankTransactionProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BankAnalyzerApplication {

    private static final String RESOURCES = "src/main/resources/transactionBank.csv";

    public static void main(String[] args) throws IOException {

        final Path path = Path.of(RESOURCES);
        final List<String> lines = Files.readAllLines(path);
        List<BankTransaction> bankTransactions = BankStatementCSVParser.parseLinesFromCSV(lines);
        BankTransactionProcessor bankTransactionProcessor = new BankTransactionProcessor(bankTransactions);

        System.out.println("Total amount for all transactions is " + bankTransactionProcessor.calculateTotalAmount());

    }
}
