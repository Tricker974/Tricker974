package com.lator.tricker.mylator.myGuess.mapper;

import com.lator.tricker.mylator.myGuess.pojo.MyGuessPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MyGuessMapper {
    void insertMyGuess(MyGuessPojo bean);

    String queryVersion();

    List<MyGuessPojo> queryMyGuess(MyGuessPojo bean);
}
