package com.fsr.controller;

import com.fsr.constant.PageConstant;
import com.fsr.dto.PaginatedResult;
import com.fsr.service.HomeService;
import com.fsr.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Hasee on 2017/4/25.
 */
@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "http://localhost:8088")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @GetMapping
    public ResponseEntity<?> getAllHomes(@RequestParam(value = "page", required = false) String pageString,
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
                        .setData(homeService.getAllHomes())
                        .setCurrentPage(page));
                       // .setTotalPage(categoryService.getTotalPage(perPage)))
    }

   public HomeController(){
        System.out.println("home controller init");
    }
}
