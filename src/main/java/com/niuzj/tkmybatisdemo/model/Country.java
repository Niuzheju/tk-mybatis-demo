package com.niuzj.tkmybatisdemo.model;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.StringTypeHandler;
import tk.mybatis.mapper.annotation.ColumnType;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

//配置实体类和数据库字段映射
@NameStyle(Style.uppercase)
//表名
@Table(name = "country")
public class Country {

    @Id
    //主键自动增长
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    /**
     * name:映射字段名
     * insertable:插入时是否忽略此属性
     * updatable:更新时是否忽略此属性
     */
    @Column(name = "countryname", insertable = true, updatable = true)
    private String  countryname;

    /**
     * jdbcType:对应的数据路字段的类型
     * typeHandler:类型转换器
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR, typeHandler = StringTypeHandler.class)
    private String  countrycode;

    //标识不是数据库表中的字段
    @Transient
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryname='" + countryname + '\'' +
                ", countrycode='" + countrycode + '\'' +
                '}';
    }
}
