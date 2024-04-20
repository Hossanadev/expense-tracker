package com.hossana.expensetracker.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseRequest {
    private String category;
    private String status;
    private BigDecimal amount;
    private String description;
}
