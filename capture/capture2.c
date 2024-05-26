#include <stdio.h>
#include <stdlib.h>

long long int func1(long long int n) {
    long long int sum = 0;
    long long int count = 0;
    
    while (count < n) {
        sum += 3;
        count++;
    }
    
    return sum;
}

int main(int argc, char *argv[]) {
    long long int n = atoll(argv[1]);
    long long int result = func1(n);
    printf("Result: %lli\n", result);
    return 0;
}

//3736234946 * 3 = 11208704838
