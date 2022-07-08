package com.lator.tricker.mylator.number.service.Impl;

import com.lator.tricker.mylator.number.mapper.NumberMapper;
import com.lator.tricker.mylator.number.pojo.NumberGuessPojo;
import com.lator.tricker.mylator.number.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("NumberService")
public class NumberServiceImpl implements NumberService {
@Autowired
private NumberMapper numberMapper;


    @Override
    public void insertResult(NumberGuessPojo bean) {
        this.numberMapper.insertResult(bean);
    }

    @Override
    public Integer queryIfExist(NumberGuessPojo bean) {
        return this.numberMapper.queryIfExist(bean);
    }

    @Override
    public NumberGuessPojo queryPrizeResult(NumberGuessPojo bean) {
        return this.numberMapper.queryPrizeResult(bean);
    }
}
