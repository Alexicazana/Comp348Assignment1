#include <stdio.h>
#include <stddef.h>

#include "aggregate.h"

typedef float(*AGGFLOAT)(float *, int);

int main()
{
    AGGFLOAT aggregates[5] = { 
        min, 
        max, 
        sum, 
        avg, 
        pseudo_avg 
    };

    float arr1[] = { 1.f, 3.5f, 4.f, 3.f, 5.f };
    float arr2[] = { 2.f, 3.f, 5.f, 4.f, 6.f, 5.f, 7.f, 9.f, 0.f, 2.f };

    const char* funcNames[] = {
        "FMIN",
        "FMAX",
        "FSUM",
        "FAVG",
        "FPSEUDO_AVG"
    };

    for(int i = 0; i < 5; i ++) {
        printf("%s %f\n", funcNames[i], aggregates[i](arr1, 5));
        printf("%s %f\n", funcNames[i], aggregates[i](arr2, 10));
    }

    min(arr1, -1);

    return 0;
}