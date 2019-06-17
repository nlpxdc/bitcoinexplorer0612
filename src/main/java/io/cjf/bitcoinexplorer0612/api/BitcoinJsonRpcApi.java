package io.cjf.bitcoinexplorer0612.api;

import com.alibaba.fastjson.JSONObject;

public interface BitcoinJsonRpcApi {

    JSONObject getBlockchainInfo() throws Throwable;
}
