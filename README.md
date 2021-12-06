# BitCoin_Auto_Trading



- 변동성 돌파 + 10일치 이동평균 상승장 투자 전략 이용


- neovisionaries 웹소켓 라이브러리를 이용하여 UPBIT에서 제공하는 Web Socket API를 실시간으로 받아온다.


- 하락장의 경우에는 매수하지 않는 전략을 택하여, 손실율을 최소화 한다.



**변동성 돌파**

  당일 시가 + (전날 고가 - 전날 저가) * 0.5 를 변동 시가로 잡고 돌파시 구매하는 전략

**상승장**

  10일동안의 이동 평균 상승량을 구하여, 현재의 시가가 이동 평균 상승량 이상일 경우에 매수하는 전략



매수 기준: 변동성 돌파 & 상승장의 경우 5000 KRW에 바로 매수합니다.

매도 기준: 한국 서버기준 09시에 전날의 종가 전량 매도합니다.



[참고] https://wikidocs.net/21888 위키독스
