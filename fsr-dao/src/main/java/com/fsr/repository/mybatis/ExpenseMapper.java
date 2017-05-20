package com.fsr.repository.mybatis;

import com.fsr.domain.Expense;
import com.fsr.repository.ExpenseRepository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by Hasee on 2017/4/25.
 */
@Mapper
public interface ExpenseMapper extends ExpenseRepository {
    @Override
    List<Expense> getExpensesByPage(@Param("offset") Integer offset, @Param("perPage") Integer perPage);

    @Override
    Long selectCount();

    @Override
    Expense getExpenseById(Long id);

    @Override
    Integer insertExpense(Expense expense);
}
