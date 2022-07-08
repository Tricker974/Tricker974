package com.lator.tricker.mylator.myGuess.service.Impl;

import com.lator.tricker.mylator.myGuess.mapper.MyGuessMapper;
import com.lator.tricker.mylator.myGuess.pojo.MyGuessPojo;
import com.lator.tricker.mylator.myGuess.service.MyGuessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MyGuess")
public class MyGuessServiceImpl implements MyGuessService {
    @Autowired
    private MyGuessMapper myGuessMapper;
    @Override
    public void insertMyGuess(MyGuessPojo bean) {
        this.myGuessMapper.insertMyGuess(bean);
    }
    @Override
    public String queryVersion() {
        return this.myGuessMapper.queryVersion();
    }

    @Override
    public List<MyGuessPojo> queryMyGuess(MyGuessPojo bean) {
        return this.myGuessMapper.queryMyGuess(bean);
    }
}
