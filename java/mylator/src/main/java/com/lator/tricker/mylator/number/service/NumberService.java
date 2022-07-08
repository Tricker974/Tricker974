package com.lator.tricker.mylator.number.service;

import com.lator.tricker.mylator.number.pojo.NumberGuessPojo;

public interface NumberService {
    void insertResult(NumberGuessPojo bean);

    Integer queryIfExist(NumberGuessPojo bean);

    NumberGuessPojo queryPrizeResult(NumberGuessPojo bean);
}
