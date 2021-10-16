#ifndef AGGREGATE_H
#define AGGREGATE_H
//if this aggregate_h was to be defined, then it would ignore everything else down here
//that is, until the #endif command (which ends the if altogether and ends search)

//defining func
float min(float* array, int size);
float max(float* array, int size);
float sum(float* array, int size);
float avg(float* array, int size);
float pseudo_avg(float* array, int size);


#endif
