package com.algoship.okkyclone.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"0.Test"})
@AllArgsConstructor
@RestController
@RequestMapping("/api/test")
public class TestController {
    @ApiOperation(value="swagger테스트", notes = "키워드를 검색결과로 리턴")
    @GetMapping("/search")
    public String searchTest(String keyword){
        return "검색결과 : " + keyword;
    }
}
