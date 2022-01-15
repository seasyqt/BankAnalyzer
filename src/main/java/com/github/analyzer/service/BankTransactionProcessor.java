package com.github.analyzer.service;

import com.github.analyzer.domain.BankTransaction;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@AllArgsConstructor
public class BankTransactionProcessor {

    private List<BankTransaction> bankTransactions;

    public double calculateTotalAmount() {
        return bankTransactions
                .stream()
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }

    public long countInMonth(Month month) {
        return bankTransactions
                .stream()
                .map(BankTransaction::getDate)
                .map(LocalDate::getMonth)
                .filter(month::equals).count();
    }
}
