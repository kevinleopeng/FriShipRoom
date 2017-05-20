package com.fsr.repository;

import com.fsr.domain.Expense;

import java.util.List;

/**
 * Created by Hasee on 2017/4/25.
 */
public interface ExpenseRepository {
    List<Expense> getExpensesByPage(Integer offset, Integer perPage);

    Long selectCount();

    Expense getExpenseById(Long id);

    Integer insertExpense(Expense expense);
}
