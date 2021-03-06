package com.trade.coin.model;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFactory;
import com.trade.coin.model.dto.Coin;

public class BitWebSocketAccount {
    private static final String SERVER = "wss://api.upbit.com/websocket/v1";
    private static double limit = 0.0;
    private static double limit20 = 0.0;
    public void connection(ArrayList<Coin> coinList) throws IOException, WebSocketException
    {
    	GetTime now= new GetTime();
        //Connect to the UPBIT server - WebSocket
        WebSocket ws = new WebSocketFactory()
        .setConnectionTimeout(5000)
        .createSocket(SERVER)
        .addListener(new WebSocketAdapter() {//In Real time
        	@Override
        	public void onBinaryMessage(WebSocket websocket, byte[] binary) throws ParseException, IOException, NoSuchAlgorithmException {
              String result = new String(binary);
              JSONParser jsonParse = new JSONParser();
              JSONObject jsonObj = (JSONObject)jsonParse.parse(result);
              if(now.getTime() || limit == 0.0 || limit20 == 0.0) {//자정에 구해야함 OR 서버가 처음 켜졌을때 
	              //어제 오늘기반 변동성 돌파
	              DateTrade dt = new DateTrade();
	              //10일치 데이터 기반 상승장 투자
	              DateTrade10 dt10 = new DateTrade10();
	              //목표가
	              limit = dt.week(); limit20 = dt10.week();
	              System.out.println("변동성 확인 지표: " + limit);
	              System.out.println("10일간 이동평균: " + limit20);	              
	              //매매 로직!
	              SellCoin sell = new SellCoin();
	              sell.sell();
              }
        	  
              //매수 로직!
              if(limit < (Double) jsonObj.get("tp") &&  limit20 < (Double) jsonObj.get("tp")) {
            	  //현재가
            	  System.out.println("현재가: " + (Double) jsonObj.get("tp"));
            	  System.out.println("변동: " + (String) jsonObj.get("c"));
            	  //매수하기
            	  BuyCoin buyCoin = new BuyCoin();
            	  buyCoin.buy();
              }
            }
        }).connect();
      
        //ONLY BIT-COIN 
        //ticker - 현재가, trade - 체결, orderbook - 호가 
        String input = "[{\"ticket\":\"test\"},{\"type\":\"ticker\",\"codes\":[\"KRW-BTC\"]},{\"format\":\"SIMPLE\"}]";
        ws.sendText(input);
     }
}
//전체 비트코인
//        while(true) {
//	        //ticker - 현재가, trade - 체결, orderbook - 호가 
//	        for (int i = 0; i < coinList.size(); i++) {
//	        	//"[{\"ticket\":\"test\"},{\"type\":\"ticker\",\"codes\":[\"KRW-BTC\"]},{\"format\":\"SIMPLE\"}]"
//	        	String input = "[{\"ticket\":\"test\"},{\"type\":\"ticker\",\"codes\":[\""
//	        			+ coinList.get(i).getMarket()
//	        			+ "\"]},{\"format\":\"SIMPLE\"}]";
//	        	ws.sendText(input);
//			}
//        }