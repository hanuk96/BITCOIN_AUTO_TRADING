package com.trade.coin.model.dto;

public class DateTradeDto {
	private String market;
	private String candleDateTimeUtc;
	private String candleDateTimeKst;
	
	private Double open;
	private Double high;
	private Double low;
	private Double price;
	private Double volume;
	private Double prevClosingPrice;
	
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public String getCandleDateTimeUtc() {
		return candleDateTimeUtc;
	}
	public void setCandleDateTimeUtc(String candleDateTimeUtc) {
		this.candleDateTimeUtc = candleDateTimeUtc;
	}
	public String getCandleDateTimeKst() {
		return candleDateTimeKst;
	}
	public void setCandleDateTimeKst(String candleDateTimeKst) {
		this.candleDateTimeKst = candleDateTimeKst;
	}
	public Double getOpen() {
		return open;
	}
	public void setOpen(Double open) {
		this.open = open;
	}
	public Double getHigh() {
		return high;
	}
	public void setHigh(Double high) {
		this.high = high;
	}
	public Double getLow() {
		return low;
	}
	public void setLow(Double low) {
		this.low = low;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getVolume() {
		return volume;
	}
	public void setVolume(Double volume) {
		this.volume = volume;
	}
	public Double getPrevClosingPrice() {
		return prevClosingPrice;
	}
	public void setPrevClosingPrice(Double prevClosingPrice) {
		this.prevClosingPrice = prevClosingPrice;
	}
	
	
}
