#include <stdio.h>
#include <time.h>
#include <stdlib.h>

int main(void) {
	int toss = 0;
	int call = 0;
	srand(time(NULL));
	
	toss = rand() % 2;
	
	printf("Say head or tail! press 0 for head and 1 for tail:nn");
	scanf("%d", &call);
	if(call==0 || call==1)
	{
		if(toss == call)
		{
			if(toss==1)
			printf("You called it correctly ... it is tailn");
			else
			printf("You called it correctly ... it is headn");
		}
		else
		{
			if(toss==1)
			printf("No way ...it is head !n");
			else
			printf("No way ... it is tail!n");
		}
	}
	else
	printf("Invalid call!!!!!nn");
	return 0;
}