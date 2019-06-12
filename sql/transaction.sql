SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for transaction
-- ----------------------------
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction`
(
  `txhash`        char(64) NOT NULL,
  `time`          datetime,
  `amount`        double,
  `size`          int,
  `weight`        float,
  `blockhash`     char(64) NOT NULL,
  `confirmations` int,
  PRIMARY KEY (`txhash`),
  index `idx_time` (`time`),
  index `idx_blockhash` (`blockhash`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
