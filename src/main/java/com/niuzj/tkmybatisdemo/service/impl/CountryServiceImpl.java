package com.niuzj.tkmybatisdemo.service.impl;

import com.niuzj.tkmybatisdemo.dao.CountryMapper;
import com.niuzj.tkmybatisdemo.model.Country;
import com.niuzj.tkmybatisdemo.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements ICountryService {

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public List<Country> findAll() {
        return countryMapper.selectAll();
    }
}
