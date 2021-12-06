package com.trade.coin.model;

import java.time.LocalTime;
public class GetTime {
	public boolean getTime() {
		LocalTime now = LocalTime.now();
		// 시, 분, 초 구하기
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		//9시에 open
		if(hour == 9 && minute == 0 && (second >= 0 && second < 1))
			return true;
		else 
			return false;
	}
}
