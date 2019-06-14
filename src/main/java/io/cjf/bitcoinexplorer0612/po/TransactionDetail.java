package io.cjf.bitcoinexplorer0612.po;

public class TransactionDetail {
    private Long txDetailId;

    private String address;

    private Double amount;

    private Byte type;

    private String txhash;

    public Long getTxDetailId() {
        return txDetailId;
    }

    public void setTxDetailId(Long txDetailId) {
        this.txDetailId = txDetailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash == null ? null : txhash.trim();
    }
}