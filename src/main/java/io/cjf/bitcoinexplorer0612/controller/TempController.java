package io.cjf.bitcoinexplorer0612.controller;

import com.alibaba.fastjson.JSONObject;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import io.cjf.bitcoinexplorer0612.api.BitcoinJsonRpcApi;
import io.cjf.bitcoinexplorer0612.api.BitcoinRestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

@RestController
@RequestMapping("/temp")
public class TempController {

    @Autowired
    private BitcoinRestApi bitcoinRestApi;

    @Autowired
    private BitcoinJsonRpcApi bitcoinJsonRpcApi;

    @GetMapping("/test")
    public String test() throws Throwable {
//        JSONObject blockChainInfo = bitcoinRestApi.getBlockChainInfo();
//        JSONObject blockNoTxDetails = bitcoinRestApi.getBlockNoTxDetails("00000000000ed3139372c0b8449f0fb1778b128f247546a551316edf5e531fb7");

        JSONObject blockchainInfo = bitcoinJsonRpcApi.getBlockchainInfo();
        return null;
    }
}
