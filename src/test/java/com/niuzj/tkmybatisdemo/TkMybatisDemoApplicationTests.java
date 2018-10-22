package com.niuzj.tkmybatisdemo;

import com.niuzj.tkmybatisdemo.service.ICountryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.spring.annotation.MapperScan;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan(basePackages = "com.niuzj.tkmybatisdemo.dao")
public class TkMybatisDemoApplicationTests {

    @Autowired
    private ICountryService countryService;

    /**
     * 测试tk mybatis
     */
    @Test
    public void contextLoads() {
        System.out.println(countryService.findAll());
    }

}
