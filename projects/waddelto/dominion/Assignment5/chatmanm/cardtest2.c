/*
 * cardtest2.c
 *
 
 */

/*
 * Include the following lines in your makefile:
 *
 * cardtest1: cardtest2.c dominion.o rngs.o
 *      gcc -o cardtest2 -g  cardtest2.c dominion.o rngs.o $(CFLAGS)
 */

#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"
#include <stdlib.h>


int testAdventurerCard(int p, struct gameState *G1)
{
    struct gameState G2;
    int preCount = 0;
    int postCount = 0;
    
    preCount = countTreasure(p, G1); // counts the number of Treasure in hand
    cardEffect(adventurer, 0, 0, 0, G1, 0, 0);
    postCount = countTreasure(p, G1); // counts the number of Treasure after playing adventurer card
    
    assert(postCount - preCount == 2);
    return 0;
}

int countTreasure(int p, struct gameState *G1) {
    int cnt = 0;
    
    for (int i = 0; i < G1->handCount[p]; i++) {
        if (G1->hand[p][i] == copper || G1->hand[p][i] == silver || G1->hand[p][i] == gold) {
            cnt++;
        }
    }
    return(cnt);
}

int main() {
    struct gameState G1;
    int p;
    
    printf("Testing Card: Adventurer\n");
    
    p = floor(Random() * MAX_PLAYERS);
    G1.deckCount[p] = floor(Random() * MAX_DECK);
    G1.discardCount[p] = floor(Random() * MAX_DECK);
    G1.handCount[p] = floor(Random() * MAX_HAND);
    
    for(int j = 0; j < G1.deckCount[p]; j++){
        G1.deck[p][j] = floor(Random() * (27));
    }
    for(int j = 0; j < G1.handCount[p]; j++){
        G1.hand[p][j] = floor(Random() * (27));
    }
    for(int j = 0; j < G1.discardCount[p]; j++){
        G1.discard[p][j] = floor(Random() * (27));
    }
    
    testAdventurerCard(p, &G1);
    
    printf("Testing Success!\n");
    
    return 0;
}