package io.cjf.bitcoinexplorer0612.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.cjf.bitcoinexplorer0612.api.BitcoinJsonRpcApi;
import io.cjf.bitcoinexplorer0612.api.BitcoinRestApi;
import io.cjf.bitcoinexplorer0612.dto.BlockGetDTO;
import io.cjf.bitcoinexplorer0612.dto.BlockListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/block")
public class BlockController {

    @Autowired
    private BitcoinRestApi bitcoinRestApi;

    @Autowired
    private BitcoinJsonRpcApi bitcoinJsonRpcApi;

    @GetMapping("/getRecentBlocks")
    public List<BlockListDTO> getRecentBlocks() throws Throwable {
        ArrayList<BlockListDTO> blockListDTOS = new ArrayList<>();
//
//        BlockListDTO blockListDTO = new BlockListDTO();
//        blockListDTO.setBlockhash("00000000000000000024b3d4793dcbba032d3fc28a0d77a37d466b956fb68aa5");
//        blockListDTO.setHeight(580644);
//        blockListDTO.setTime(new Date());
//        blockListDTO.setTxsize((short) 2390);
//        blockListDTO.setSize(1257767);
//        blockListDTOS.add(blockListDTO);
//
//        BlockListDTO blockListDTO2 = new BlockListDTO();
//        blockListDTO2.setBlockhash("00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b");
//        blockListDTO2.setHeight(580643);
//        blockListDTO2.setTime(new Date());
//        blockListDTO2.setTxsize((short) 2702);
//        blockListDTO2.setSize(1322496);
//        blockListDTOS.add(blockListDTO2);

        JSONObject blockChainInfo = bitcoinRestApi.getBlockChainInfo();
        Integer blockHeight = blockChainInfo.getInteger("blocks");
        Integer blockFromHeight = blockHeight - 5;

        String blockhash = bitcoinJsonRpcApi.getBlockhashByHeight(blockFromHeight);


        List<JSONObject> blockHeaders = bitcoinRestApi.getBlockHeaders(blockhash, 5);

        for (Object blockHeader : blockHeaders) {
            JSONObject jsonObject = (JSONObject) blockHeader;
            BlockListDTO blockListDTO = new BlockListDTO();
            blockListDTO.setBlockhash(jsonObject.getString("hash"));
            blockListDTO.setHeight(jsonObject.getInteger("height"));
            Long time = jsonObject.getLong("time");
            blockListDTO.setTime(new Date(1000*time));
            blockListDTO.setTxsize(jsonObject.getShort("nTx"));
            //todo
            blockListDTO.setSize(null);
            blockListDTOS.add(blockListDTO);
        }

        return blockListDTOS;
    }

    @GetMapping("/getByBlockhash")
    public BlockGetDTO getByBlockhash(@RequestParam String blockhash) {
        BlockGetDTO blockGetDTO = new BlockGetDTO();
        blockGetDTO.setBlockhash("00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b");
        blockGetDTO.setHeight(580643);
        blockGetDTO.setPrevBlcok("00000000000000000005ac7036789bfec28d230dff491f3382f6daf6523f5c44");
        blockGetDTO.setNextBlock("00000000000000000024b3d4793dcbba032d3fc28a0d77a37d466b956fb68aa5");
        blockGetDTO.setMerkleRoot("07ac3d1c827b5c3ef69a7341bbdb2bf72339139b5f9e7e782d1bc82265b17798");
        blockGetDTO.setTime(new Date().getTime());
        blockGetDTO.setFees(8766.38);
        blockGetDTO.setTxSize((short) 2702);
        blockGetDTO.setSize(1322496);
        blockGetDTO.setDifficulty(7409399249090.25);

        return blockGetDTO;
    }

    @GetMapping("/getByHeight")
    public BlockGetDTO getByHeight(@RequestParam Integer height) {

        BlockGetDTO blockGetDTO = new BlockGetDTO();
        blockGetDTO.setBlockhash("00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b");
        blockGetDTO.setHeight(580643);
        blockGetDTO.setPrevBlcok("00000000000000000005ac7036789bfec28d230dff491f3382f6daf6523f5c44");
        blockGetDTO.setNextBlock("00000000000000000024b3d4793dcbba032d3fc28a0d77a37d466b956fb68aa5");
        blockGetDTO.setMerkleRoot("07ac3d1c827b5c3ef69a7341bbdb2bf72339139b5f9e7e782d1bc82265b17798");
        blockGetDTO.setTime(new Date().getTime());
        blockGetDTO.setFees(8766.38);
        blockGetDTO.setTxSize((short) 2702);
        blockGetDTO.setSize(1322496);
        blockGetDTO.setDifficulty(7409399249090.25);

        return blockGetDTO;
    }


}
