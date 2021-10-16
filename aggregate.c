#include <stdio.h>
#include <stddef.h>

#include "aggregate.h"
#line 5

float min(float* array, int size){

    if(array == NULL || size <= 0){
        fprintf(stderr, "FATAL ERROR in line %i\n", __LINE__);
    }

    float currentMin = array[0];

    for(int i = 0; i < size ; i++){
        if(array [i] < currentMin){
            currentMin = array [i];
        }
        
    }

    return currentMin;

}

float max(float* array, int size){

    if(array == NULL || size <= 0){
        fprintf(stderr, "FATAL ERROR in line %i\n", __LINE__);
    }

    float currentMax = array[0];

    for(int i = 0; i < size ; i++){
        if(array [i] > currentMax){
            currentMax = array [i];
        }
        
    }

    return currentMax;
}

float sum(float* array, int size){

    if(array == NULL || size <= 0){
        fprintf(stderr, "FATAL ERROR in line %i\n", __LINE__);
    }

    float addedSum = 0;

    for(int i = 0; i < size ; i++){
        addedSum += array[i];
    }

    return addedSum;
}

float avg(float* array, int size){
    if(array == NULL || size <= 0){
        fprintf(stderr, "FATAL ERROR in line %i\n", __LINE__);
    }

    return sum(array, size) / (float)size; //since sum has already defined type parameters, so here we just need to pass those parameters

}

float pseudo_avg(float* array, int size){
    if(array == NULL || size <= 0){
        fprintf(stderr, "FATAL ERROR in line %i\n", __LINE__);
    }

    return (min(array, size) + max(array, size)) / 2.f;
}
