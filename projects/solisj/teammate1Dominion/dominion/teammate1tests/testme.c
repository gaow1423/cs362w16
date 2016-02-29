#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<time.h>

char inputChar()
{
  char c;
  c = rand() % (126-32) + 32;
  

  
    return c;
}

char *inputString()
{
    char *t = malloc(6); 
    for(int i = 0; i < 5; i++){
      t[i] = (char) ((rand() % (123 -97)) + 97);
      //printf("%c", (char) t[i]);
    }

    t[5] = '\0';
    return t;
}

void testme()
{
  int tcCount = 0;
 ;
  char c;
  int state = 0;
  while (1)
  {
    tcCount++;
    c = inputChar();
    char *s = inputString();
    printf("Iteration %d: c = %c, s = %s, state = %d\n", tcCount, c, s, state);

    if (c == '[' && state == 0) state = 1;
    if (c == '(' && state == 1) state = 2;
    if (c == '{' && state == 2) state = 3;
    if (c == ' '&& state == 3) state = 4;
    if (c == 'a' && state == 4) state = 5;
    if (c == 'x' && state == 5) state = 6;
    if (c == '}' && state == 6) state = 7;
    if (c == ')' && state == 7) state = 8;
    if (c == ']' && state == 8) state = 9;
    if (s[0] == 'r' && s[1] == 'e'
       && s[2] == 's' && s[3] == 'e'
       && s[4] == 't' && s[5] == '\0'
       && state == 9)
    {
      printf("error ");
      exit(200);
    }
    free(s);
  }
}


int main(int argc, char *argv[])
{
    srand(time(NULL));
    testme();
    return 0;
}