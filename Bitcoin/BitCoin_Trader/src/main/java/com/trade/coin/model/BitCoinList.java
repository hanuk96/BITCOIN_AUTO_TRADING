package com.trade.coin.model;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.trade.coin.model.dto.Coin;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BitCoinList {
	public ArrayList<Coin> coinList() throws ParseException, IOException {
		
		OkHttpClient client = new OkHttpClient();
		ArrayList<Coin> list = new ArrayList<Coin>();
		
		Request request = new Request.Builder()
		  .url("https://api.upbit.com/v1/market/all?isDetails=false")
		  .get()
		  .addHeader("Accept", "application/json")
		  .build();
		
		Response response = client.newCall(request).execute();
		String result = response.body().string();
		
		JSONParser jsonParse = new JSONParser();
	    JSONArray bitCoinList = (JSONArray) jsonParse.parse(result);      
       
       for (int i = 0; i < bitCoinList.size(); i++) {
    	   Object obj = bitCoinList.get(i);
    	   JSONObject jsonObj = (JSONObject) obj;
    	   Coin coin = new Coin();
    	   coin.setMarket((String) jsonObj.get("market"));
    	   coin.setEnglishName((String) jsonObj.get("english_name"));
    	   coin.setKoreanName((String) jsonObj.get("korean_name"));
    	   list.add(coin);
        }
       
       	return list;
	}
}
