#include <stdio.h>

int main() {
    int arr1[] = {1, 3, 5};
    int arr2[] = {2, 4, 6};

    int n1 = 3;
    int n2 = 3;

    int result[6];

    int i = 0, j = 0, k = 0;

    while (i < n1 && j < n2) {
        if (arr1[i] < arr2[j]) {
            result[k] = arr1[i];
            i++;
        } else {
            result[k] = arr2[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        result[k] = arr1[i];
        i++;
        k++;
    }

    while (j < n2) {
        result[k] = arr2[j];
        j++;
        k++;
    }

    for (i = 0; i < k; i++) {
        printf("%d ", result[i]);
    }

    return 0;
}
