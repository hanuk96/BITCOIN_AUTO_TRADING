package com.trade.coin.model.dto;

public class Coin {
	private String market;
	private String koreanName;
	private String englishName;
	
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public String getKoreanName() {
		return koreanName;
	}
	public void setKoreanName(String koreanName) {
		this.koreanName = koreanName;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
}
