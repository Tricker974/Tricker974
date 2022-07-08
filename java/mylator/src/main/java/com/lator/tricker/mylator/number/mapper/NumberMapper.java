package com.lator.tricker.mylator.number.mapper;

import com.lator.tricker.mylator.number.pojo.NumberGuessPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;



@Mapper
@Repository
public interface NumberMapper {
    void insertResult(NumberGuessPojo bean);

    Integer queryIfExist(NumberGuessPojo bean);

    /**
     * 查询开奖结果
     * @param bean
     * @return
     */
    NumberGuessPojo queryPrizeResult(NumberGuessPojo bean);

}
