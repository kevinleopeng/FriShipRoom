package com.fsr.service;

import com.fsr.domain.Expense;

import java.util.List;

/**
 * Created by Hasee on 2017/4/25.
 */
public interface ExpenseService {
    List<Expense> getExpensesByPage(Integer page, Integer perPage);

    Integer getTotalPage(Integer perPage);

    Integer insertExpense(Expense expense);

    Long selectCount();
}
