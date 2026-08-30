#include <stdio.h>

int main() {
    int nums[] = {1, 2, 3, 1};
    int n = 4;
    int duplicate = 0;

    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (nums[i] == nums[j]) {
                duplicate = 1;
                break;
            }
        }

        if (duplicate) {
            break;
        }
    }

    if (duplicate)
        printf("true");
    else
        printf("false");

    return 0;
}
