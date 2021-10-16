#include <stdio.h>
#include <stddef.h>

#include "aggregate.h"

int main() {
   
    float(*aggregates[5])(float* arr, int size) = {
        min,
        max,
        sum,
        avg,
        pseudo_avg
    };

    float arr[] = { 1.f, -4.f, 3.f, -2.f};
    float cMin = min(arr, 4);
    float min2 = aggregates[0](arr, 4);
    printf("%f %f is the current min \n", cMin, min2);
  
    return 0;
}

