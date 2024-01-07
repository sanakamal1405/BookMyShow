BookMyShow is clone of famous booking website bookymyshow.com.
The application comprises complete end-to-end flow of booking a show. 
The project consists of various features built following the S.O.L.I.D principles and design patterns such as :
1. Apart from booking movie tickets alike bookmyshow.com, BookMyShow provides booking of diffrent fun events foe eg at present it can also be used to book for movies, Theatre plays , Fun Activity etc,and can be easily extended to book travel tickets etc.
2. Multiple startegies to calculate final price following the strategy design pattern.
3. Efficient transaction handling at Isolation Level that ensures no duplicate booking.
4. Just like bookmyshow user can fetch upcoming movies to plan booking.


   Any many more such as Builder pattern to ensure integrity of the invoices and ticket generated at the end.

   The exceptions are handled via Custom Exceptions for easy debugging.

   The following tables are created and relationship between the entities are also handled via JPA.

   
![bms-db](https://github.com/sanakamal1405/BookMyShow/assets/61350623/e4b69782-0dc5-477e-a739-2e6115ce996d)


Below shows movie-creation and latest-movie api in action :


![movie-creation](https://github.com/sanakamal1405/BookMyShow/assets/61350623/58ac2871-568b-42bd-8edb-c7487c3bb213)
![latest-movies](https://github.com/sanakamal1405/BookMyShow/assets/61350623/0b0d19d1-2a44-4103-8d37-23baf308f59d)
