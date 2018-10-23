package com.niuzj.tkmybatisdemo;

import com.niuzj.tkmybatisdemo.dao.CountryMapper;
import com.niuzj.tkmybatisdemo.model.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan(basePackages = "com.niuzj.tkmybatisdemo.dao")
public class TkMybatisDemoApplicationTests {

    @Autowired
    private CountryMapper countryMapper;

    /**
     * 查询所有
     */
    @Test
    public void contextLoads() {
        System.out.println(countryMapper.selectAll());
    }

    /**
     * 使用实体类作为条件查询
     * 非空的属性都会作为查询条件,且查询条件间关系为and
     */
    @Test
    public void test01(){
        Country country = new Country();
        country.setId(10011);
        country.setCountrycode("1022");
        List<Country> list = countryMapper.select(country);
        System.out.println(list);
    }

    /**
     * 新增记录
     * 插入所有字段,没有值的为null
     */
    @Test
    public void test02(){
        Country country = new Country();
        country.setCountrycode("004");
        int n = countryMapper.insert(country);
        System.out.println(n);
    }

    /**
     * 只插入有值的字段,其他字段在sql中不出现
     */
    @Test
    public void test03(){
        Country country = new Country();
        country.setCountrycode("004");
        int n = countryMapper.insertSelective(country);
        System.out.println(n);
    }

    /**
     * 按id删除
     */
    @Test
    public void test04(){
        countryMapper.deleteByPrimaryKey(10011);
    }

    /**
     * 按id更新
     */
    @Test
    public void test05(){
        Country country = new Country();
        country.setId(10012);
        country.setCountryname("中国");
        country.setCountrycode("001");
        countryMapper.updateByPrimaryKey(country);
    }

}
