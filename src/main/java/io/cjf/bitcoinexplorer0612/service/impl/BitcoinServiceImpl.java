package io.cjf.bitcoinexplorer0612.service.impl;

import com.alibaba.fastjson.JSONObject;
import io.cjf.bitcoinexplorer0612.api.BitcoinRestApi;
import io.cjf.bitcoinexplorer0612.dao.BlockMapper;
import io.cjf.bitcoinexplorer0612.po.Block;
import io.cjf.bitcoinexplorer0612.service.BitcoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BitcoinServiceImpl implements BitcoinService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BitcoinRestApi bitcoinRestApi;

    @Autowired
    private BlockMapper blockMapper;

    @Override
    @Async
    public void syncBlock(String blockhash) {
        logger.info("begin to sync block from {}", blockhash);
        String tempBlockhash = blockhash;
        while (tempBlockhash != null && !tempBlockhash.isEmpty()){
            JSONObject blockJson = bitcoinRestApi.getBlock(tempBlockhash);
            Block block = new Block();
            block.setBlockhash(blockJson.getString("hash"));
            block.setHeight(blockJson.getInteger("height"));
            Long time = blockJson.getLong("time");
            block.setTime(new Date(time * 1000));
            block.setTxsize(blockJson.getShort("nTx"));
            block.setSize(blockJson.getInteger("size"));
            block.setWeight(blockJson.getFloat("weight"));
            block.setDifficulty(blockJson.getDouble("difficulty"));
            block.setPrevBlock(blockJson.getString("previousblockhash"));
            block.setNextBlock(blockJson.getString("nextblockhash"));
            blockMapper.insert(block);
            tempBlockhash = block.getNextBlock();
        }
        logger.info("end sync block");
    }
}
