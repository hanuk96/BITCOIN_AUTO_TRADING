package com.trade.coin.model.dto;

public class MyAccount {
	@Override
	public String toString() {
		return "내 계좌 [이름: " + currency + ", 보유 금액: " + balance + ", 매수 평균가: "
				+ avgBuyPrice + ", 매수 평균가 수정 여부: " + avgBuyPriceModified + "]";
	}
	private String currency; 
	private String balance; 
	private String locked;
	private String avgBuyPrice; 
	private Boolean avgBuyPriceModified; 
	private String unitCurrency;
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getLocked() {
		return locked;
	}
	public void setLocked(String locked) {
		this.locked = locked;
	}
	public String getAvgBuyPrice() {
		return avgBuyPrice;
	}
	public void setAvgBuyPrice(String avgBuyPrice) {
		this.avgBuyPrice = avgBuyPrice;
	}
	public Boolean getAvgBuyPriceModified() {
		return avgBuyPriceModified;
	}
	public void setAvgBuyPriceModified(Boolean avgBuyPriceModified) {
		this.avgBuyPriceModified = avgBuyPriceModified;
	}
	public String getUnitCurrency() {
		return unitCurrency;
	}
	public void setUnitCurrency(String unitCurrency) {
		this.unitCurrency = unitCurrency;
	} 
	
}
