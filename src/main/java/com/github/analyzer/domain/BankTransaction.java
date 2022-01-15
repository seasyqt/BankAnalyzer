package com.github.analyzer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;

@Data
@AllArgsConstructor
public class BankTransaction {

    private LocalDate date;
    private double amount;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankTransaction)) return false;
        BankTransaction that = (BankTransaction) o;
        return Double.compare(that.getAmount(), getAmount()) == 0 &&
                getDate().equals(that.getDate()) &&
                getDescription().equals(that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getAmount(), getDescription());
    }
}
