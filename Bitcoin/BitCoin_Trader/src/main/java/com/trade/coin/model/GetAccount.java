package com.trade.coin.model;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.trade.coin.model.dto.MyAccount;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.IOException;
import java.util.UUID;

public class GetAccount {
    public MyAccount getAllAccount() throws ParseException, org.json.simple.parser.ParseException {
    	String accessKey = "SECRET KEY";
	String secretKey = "SECRET KEY";
        String serverUrl = "https://api.upbit.com";
        
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        String jwtToken = JWT.create()
                .withClaim("access_key", accessKey)
                .withClaim("nonce", UUID.randomUUID().toString())
                .sign(algorithm);
	    
        String authenticationToken = "Bearer " + jwtToken;
        MyAccount account = null;
	
        try {
		 HttpClient client = HttpClientBuilder.create().build();
		 HttpGet request = new HttpGet(serverUrl + "/v1/accounts");
		 request.setHeader("Content-Type", "application/json");
		 request.addHeader("Authorization", authenticationToken);

		 HttpResponse response = client.execute(request);
		 HttpEntity entity = response.getEntity();
		 String result = EntityUtils.toString(entity, "UTF-8");
         	JSONParser jsonParse = new JSONParser();
         	JSONArray myaccount = (JSONArray) jsonParse.parse(result);
	
         for (int i = 0; i < myaccount.size(); i++) {
		Object obj = myaccount.get(i);
		JSONObject jsonObj = (JSONObject) obj;
		account = new MyAccount();
		if(!((String) jsonObj.get("currency")).equals("KRW")) continue;

		account.setCurrency((String) jsonObj.get("currency"));
		account.setAvgBuyPrice((String) jsonObj.get("avg_buy_price"));
		account.setBalance((String) jsonObj.get("balance"));
		account.setLocked((String) jsonObj.get("locked"));
		account.setUnitCurrency((String) jsonObj.get("unit_currency"));
		account.setAvgBuyPriceModified((boolean)jsonObj.get("avg_buy_price_modified"));
		System.out.println(account);
		break;
        	}
        } catch (IOException e) {
            e.printStackTrace();
        }
        return account;
    }
}
