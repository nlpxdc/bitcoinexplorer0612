package io.cjf.bitcoinexplorer0612.service;

import io.cjf.bitcoinexplorer0612.dto.BlockListDTO;

import java.util.List;

public interface BlockService {

    List<BlockListDTO> getRecentBlocks();
}
