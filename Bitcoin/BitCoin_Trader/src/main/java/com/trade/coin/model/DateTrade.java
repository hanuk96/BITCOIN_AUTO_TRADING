package com.trade.coin.model;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.trade.coin.model.dto.DateTradeDto;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DateTrade {
	public double week() throws IOException, ParseException {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
		  .url("https://api.upbit.com/v1/candles/days?market=KRW-BTC&count=5")
		  .get()
		  .addHeader("Accept", "application/json")
		  .build();
		
		Response response = client.newCall(request).execute();
		String result = response.body().string();
		JSONParser jsonParse = new JSONParser();
	    JSONArray timeList = (JSONArray) jsonParse.parse(result);      
       
	    ArrayList<DateTradeDto> list = new ArrayList<DateTradeDto>();
        for (int i = 0; i < timeList.size(); i++) {
    	   JSONObject jsonObj = (JSONObject) timeList.get(i);
    	   DateTradeDto date = new DateTradeDto();
    	   date.setMarket(((String) jsonObj.get("market")));
    	   date.setCandleDateTimeUtc(((String) jsonObj.get("candle_date_time_utc")));
    	   date.setCandleDateTimeKst(((String) jsonObj.get("candle_date_time_kst")));//한국 기준
    	   date.setOpen(((Double) jsonObj.get("opening_price")));//시가
    	   date.setHigh(((Double) jsonObj.get("high_price")));//최고가
    	   date.setLow(((Double) jsonObj.get("low_price")));//저가
    	   date.setPrice(((Double) jsonObj.get("trade_price")));//종가
    	   date.setVolume(((Double) jsonObj.get("candle_acc_trade_volume")));//누적 거래량
    	   date.setPrevClosingPrice(((Double) jsonObj.get("prev_closing_price")));
    	   list.add(date);
        }
       //계산
        double t_open = list.get(0).getOpen();
        double y_high = list.get(1).getHigh();
        double y_low = list.get(1).getLow();
        //당일 시가 + 레인지 * 0.5
        double target = t_open + (y_high - y_low) * 0.5;
        
        return target;
	}
}
