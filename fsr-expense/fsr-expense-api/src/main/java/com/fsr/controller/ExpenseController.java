package com.fsr.controller;


import com.fsr.constant.PageConstant;
import com.fsr.constant.ResultCode;
import com.fsr.datatransfer.DataTransfer;
import com.fsr.domain.Expense;
import com.fsr.dto.PaginatedResult;
import com.fsr.dto.StatusResult;
import com.fsr.service.ExpenseService;
import com.fsr.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Hasee on 2017/4/25.
 */
@RestController
@RequestMapping("/expense")
@CrossOrigin(origins = "http://localhost:8088")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @Autowired
    @Qualifier("expenseDataTransfer")
    private DataTransfer expenseDataTransfer;

    @GetMapping
    public ResponseEntity<?> getBooks(@RequestParam(value = "page", required = false) String pageString,
                                      @RequestParam(value = "pageSize", required = false) String perPageString) {
        // Parse request parameters
       // int page = PageUtil.parsePage(pageString, PageConstant.PAGE);
        //int perPage = PageUtil.parsePerPage(perPageString, PageConstant.PER_PAGE);
        /*String str = "{\"tableData\":[{\n" +
                "          \"date\": \"2016-05-02\",\n" +
                "          \"name\": \"PM\",\n" +
                "          \"address\": \"上海市普陀区金沙江路 1518 弄\"\n" +
                "        }, {\n" +
                "          \"date\": \"2016-05-04\",\n" +
                "          \"name\": \"LQ\",\n" +
                "          \"address\": \"上海市普陀区金沙江路 1518 弄\"\n" +
                "        }, {\n" +
                "          \"date\": \"2016-05-01\",\n" +
                "          \"name\": \"WL\",\n" +
                "          \"address\": \"上海市普陀区金沙江路 1518 弄\"\n" +
                "        }, {\n" +
                "          \"date\": \"2016-05-03\",\n" +
                "          \"name\": \"FB\",\n" +
                "          \"address\": \"上海市普陀区金沙江路 1518 弄\"\n" +
                "        }]}";*/
        int page = PageUtil.parsePage(pageString, PageConstant.PAGE);
        int perPage = PageUtil.parsePerPage(perPageString, PageConstant.PER_PAGE);

        return ResponseEntity
                .ok(new PaginatedResult()
                        .setData(expenseDataTransfer.transfer(expenseService.getExpensesByPage(page, perPage)))
                        .setCurrentPage(page)
                        .setTotal(expenseService.selectCount())
                        .setTotalPage(expenseService.getTotalPage(perPage)));
                     //   .setTotal(expenseService.selectCount());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addExpense(@RequestBody Expense expense) {
        StatusResult statusResult = new StatusResult();
        try{
            expenseService.insertExpense(expense);

            statusResult
                    .setCode(ResultCode.SUCCESS)
                    .setMessage("添加支出成功");
        } catch(Exception e) {
            e.printStackTrace();
            statusResult
                    .setCode(ResultCode.ERROR)
                    .setMessage("添加支出失败");
        }

        return ResponseEntity
                .ok(statusResult);
    }

    public ExpenseController(){
        System.out.println("controller init");
    }
}
