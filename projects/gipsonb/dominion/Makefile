CFLAGS = -Wall -fpic -coverage -lm

rngs.o: rngs.h rngs.c
	gcc -c rngs.c -g  $(CFLAGS)

dominion.o: dominion.h dominion.c rngs.o
	gcc -c dominion.c -g  $(CFLAGS)

playdom: dominion.o playdom.c
	gcc -o playdom playdom.c -g dominion.o rngs.o $(CFLAGS)

testDrawCard: testDrawCard.c dominion.o rngs.o
	gcc -o testDrawCard -g  testDrawCard.c dominion.o rngs.o $(CFLAGS)

badTestDrawCard: badTestDrawCard.c dominion.o rngs.o
	gcc -o badTestDrawCard -g  badTestDrawCard.c dominion.o rngs.o $(CFLAGS)

testBuyCard: testDrawCard.c dominion.o rngs.o
	gcc -o testDrawCard -g  testDrawCard.c dominion.o rngs.o $(CFLAGS)

testAll: dominion.o testSuite.c
	gcc -o testSuite testSuite.c -g  dominion.o rngs.o $(CFLAGS)

interface.o: interface.h interface.c
	gcc -c interface.c -g  $(CFLAGS)

runtests: testDrawCard 
	./testDrawCard &> unittestresult.out
	gcov dominion.c >> unittestresult.out
	cat dominion.c.gcov >> unittestresult.out
	
randomtestcard.out: randomtestcard.c dominion.o rngs.o 

	gcc -o randomtestcard dominion.o rngs.o randomtestcard.c $(CFLAGS)
	echo "Results for running random test on village card" > randomtestcard.out
	randomtestcard >> randomtestcard.out
	
randomtestadventurer.out: randomtestadventurer.c dominion.o rngs.o

	gcc -o randomtestadventurer randomtestadventurer.c dominion.o rngs.o $(CFLAGS)
	echo "Results for running random test on adventurer card" > randomtestadventurer.out
	randomtestadventurer >> randomtestadventurer.out
	
unittestresults.out: unittest1.c unittest2.c unittest3.c unittest4.c cardtest1.c cardtest2.c cardtest3.c cardtest4.c dominion.o rngs.o
	echo "Result for running Dominion Unit Tests:" > unittestresults.out
	
	echo "*******************" >> unittestresults.out
	echo "unittest1.c:" >> unittestresults.out
	gcc -o unittest1 dominion.o rngs.o unittest1.c $(CFLAGS)
	unittest1 >> unittestresults.out
	gcov dominion.c -b >> unittestresults.out
	echo "*******************" >> unittestresults.out
	
	echo "*******************" >> unittestresults.out
	echo "unittest2.c:" >> unittestresults.out
	gcc -o unittest2 dominion.o rngs.o unittest2.c $(CFLAGS)
	unittest2 >> unittestresults.out
	gcov dominion.c -b  >> unittestresults.out
	echo "*******************" >> unittestresults.out
	
	echo "*******************" >> unittestresults.out
	echo "unittest3.c:" >> unittestresults.out
	gcc -o unittest3 dominion.o rngs.o unittest3.c $(CFLAGS)
	unittest3 >> unittestresults.out
	gcov dominion.c -b >> unittestresults.out
	echo "*******************" >> unittestresults.out
	
	echo "*******************" >> unittestresults.out
	echo "unittest4.c:" >> unittestresults.out
	gcc -o unittest4 dominion.o rngs.o unittest4.c $(CFLAGS)
	unittest4 >> unittestresults.out
	gcov dominion.c -b >> unittestresults.out
	echo "*******************" >> unittestresults.out
	
	echo "*******************" >> unittestresults.out
	echo "cardtest1.c:" >> unittestresults.out
	gcc -o cardtest1 dominion.o rngs.o cardtest1.c $(CFLAGS)
	cardtest1 >> unittestresults.out
	gcov dominion.c -b >> unittestresults.out
	echo "*******************" >> unittestresults.out
	
	echo "*******************" >> unittestresults.out
	echo "cardtest2.c:" >> unittestresults.out
	gcc -o cardtest2 dominion.o rngs.o cardtest2.c $(CFLAGS)
	cardtest2 >> unittestresults.out
	gcov dominion.c -b >> unittestresults.out
	echo "*******************" >> unittestresults.out
	
	echo "*******************" >> unittestresults.out
	echo "cardtest3.c:" >> unittestresults.out
	gcc -o cardtest3 dominion.o rngs.o cardtest3.c $(CFLAGS)
	cardtest3 >> unittestresults.out
	gcov dominion.c -b >> unittestresults.out
	echo "*******************" >> unittestresults.out
	
	echo "*******************" >> unittestresults.out
	echo "cardtest4.c:" >> unittestresults.out
	gcc -o cardtest4 dominion.o rngs.o cardtest4.c $(CFLAGS)
	cardtest4 >> unittestresults.out
	gcov dominion.c -b >> unittestresults.out
	echo "*******************" >> unittestresults.out
	
player: player.c interface.o
	gcc -o player player.c -g  dominion.o rngs.o interface.o $(CFLAGS)

all: playdom player testDrawCard testBuyCard badTestDrawCard

clean:
	rm -f *.o *.out playdom.exe playdom test.exe test player player.exe testInit testInit.exe *.gcov *.gcda *.gcno *.so badTestDrawCard testDrawCard unittest1 unittest2 unittest3 unittest4 cardtest1 cardtest2 cardtest3 cardtest4 randomtestadventurer randomtestcard
