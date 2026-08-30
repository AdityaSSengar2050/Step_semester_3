#include <stdio.h>

int main() {
    int nums[] = {1, 2, 3, 4, 5, 6, 7};
    int n = 7;
    int k = 3;

    int newArray[7];

    k = k % n;

    for (int i = 0; i < n; i++) {
        newArray[(i + k) % n] = nums[i];
    }

    for (int i = 0; i < n; i++) {
        printf("%d ", newArray[i]);
    }

    return 0;
}
