package io.cjf.bitcoinexplorer0612.dao;

import io.cjf.bitcoinexplorer0612.po.TransactionDetail;

public interface TransactionDetailMapper {
    int deleteByPrimaryKey(Long txDetailId);

    int insert(TransactionDetail record);

    int insertSelective(TransactionDetail record);

    TransactionDetail selectByPrimaryKey(Long txDetailId);

    int updateByPrimaryKeySelective(TransactionDetail record);

    int updateByPrimaryKey(TransactionDetail record);
}