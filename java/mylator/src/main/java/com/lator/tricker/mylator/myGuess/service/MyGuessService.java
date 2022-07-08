package com.lator.tricker.mylator.myGuess.service;

import com.lator.tricker.mylator.myGuess.pojo.MyGuessPojo;

import java.util.List;

public interface MyGuessService {

    void insertMyGuess(MyGuessPojo bean);

    String queryVersion();

    List<MyGuessPojo> queryMyGuess(MyGuessPojo bean);
}
