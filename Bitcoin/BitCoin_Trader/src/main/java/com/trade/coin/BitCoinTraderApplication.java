package com.trade.coin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.trade.coin.model.BitCoinList;
import com.trade.coin.model.BitWebSocketAccount;
import com.trade.coin.model.dto.Coin;
import java.util.ArrayList;

@SpringBootApplication
public class BitCoinTraderApplication {

	public static void main(String[] args)throws Exception{
		SpringApplication.run(BitCoinTraderApplication.class, args);
		BitWebSocketAccount bitweb = new BitWebSocketAccount();
		
		//비트코인 종류
		BitCoinList bitcoinlist = new BitCoinList();
		ArrayList<Coin> coinList = bitcoinlist.coinList();		
		
		//실시간 투자
		bitweb.connection(coinList);
	}
}