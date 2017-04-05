# scsai
only for test

API Design:

/insert/customer.do     POST   include customer info , can insert customer info to datasource
/insert/autocust.do  GET   system can generate randomly a custom then insert to datasource
/error.do     GET    system will dispatcher to 500.html
/error2.do   GET  	  system will throw a Exception
/decrypt.do    POST   include parameter token=xxxxx     system will decrypt the token  and return json to brower
/encrypt/{str}.do    GET   system will encrypt the str code and return to brower
/hello.do     GET   will query count of booktypes table and return to brower
