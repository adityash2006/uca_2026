#include <stdio.h>
#include <time.h>

static void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

static void bubbleSort(int arr[], int n) {
    for (int i = 0; i < n - 1; ++i) {
        int swapped = 0;
        for (int j = 0; j < n - i - 1; ++j) {
            if (arr[j] > arr[j + 1]) {
                swap(&arr[j], &arr[j + 1]);
                swapped = 1;
            }
        }
        if (!swapped) {
            break;
        }
    }
}

static void insertionSort(int arr[], int n) {
    for (int i = 1; i < n; ++i) {
        int key = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            --j;
        }
        arr[j + 1] = key;
    }
}

static void selectionSort(int arr[], int n) {
    for (int i = 0; i < n - 1; ++i) {
        int minIndex = i;
        for (int j = i + 1; j < n; ++j) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        if (minIndex != i) {
            swap(&arr[i], &arr[minIndex]);
        }
    }
}

static int partition(int arr[], int low, int high) {
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; ++j) {
        if (arr[j] <= pivot) {
            ++i;
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i + 1], &arr[high]);
    return i + 1;
}

static void quickSortRecursive(int arr[], int low, int high) {
    if (low < high) {
        int pivotIndex = partition(arr, low, high);
        quickSortRecursive(arr, low, pivotIndex - 1);
        quickSortRecursive(arr, pivotIndex + 1, high);
    }
}

static void quickSort(int arr[], int n) {
    if (n > 0) {
        quickSortRecursive(arr, 0, n - 1);
    }
}

static void merge(int arr[], int left, int mid, int right, int temp[]) {
    int i = left;
    int j = mid + 1;
    int k = left;

    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j]) {
            temp[k++] = arr[i++];
        } else {
            temp[k++] = arr[j++];
        }
    }

    while (i <= mid) {
        temp[k++] = arr[i++];
    }

    while (j <= right) {
        temp[k++] = arr[j++];
    }

    for (i = left; i <= right; ++i) {
        arr[i] = temp[i];
    }
}

static void mergeSortRecursive(int arr[], int left, int right, int temp[]) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        mergeSortRecursive(arr, left, mid, temp);
        mergeSortRecursive(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);
    }
}

static void mergeSort(int arr[], int n) {
    int *temp = (int *)malloc((size_t)n * sizeof(int));
    if (temp == NULL) {
        return;
    }

    mergeSortRecursive(arr, 0, n - 1, temp);
    free(temp);
}

static void heapify(int arr[], int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && arr[left] > arr[largest]) {
        largest = left;
    }

    if (right < n && arr[right] > arr[largest]) {
        largest = right;
    }

    if (largest != i) {
        swap(&arr[i], &arr[largest]);
        heapify(arr, n, largest);
    }
}

static void heapSort(int arr[], int n) {
    for (int i = n / 2 - 1; i >= 0; --i) {
        heapify(arr, n, i);
    }

    for (int i = n - 1; i > 0; --i) {
        swap(&arr[0], &arr[i]);
        heapify(arr, i, 0);
    }
}

static void fillRandomArray(int arr[], int n) {
    for (int i = 0; i < n; ++i) {
        arr[i] = rand() % (n * 10 + 1);
    }
}

static void fillAscendingArray(int arr[], int n) {
    for (int i = 0; i < n; ++i) {
        arr[i] = i;
    }
}

static void fillDescendingArray(int arr[], int n) {
    for (int i = 0; i < n; ++i) {
        arr[i] = n - i;
    }
}



int main() {
    clock_t start, end;
    double time_taken;
    int size = 8000;

    for (int i = 0; i < 8; i++) {

        int *arr = (int *)malloc(size * sizeof(int));

        // Ascending array
        fillAscendingArray(arr, size);
        start = clock();

        bubbleSort(arr, size);

        end = clock();
        time_taken = ((double)(end - start) * 1000) / CLOCKS_PER_SEC;
        printf("Ascending Array Sort Time: %.3f ms\n", time_taken);

        // Descending array
        fillDescendingArray(arr, size);
        start = clock();

        bubbleSort(arr, size);

        end = clock();
        time_taken = ((double)(end - start) * 1000) / CLOCKS_PER_SEC;
        printf("Descending Array Sort Time: %.3f ms\n", time_taken);

        // Second ascending array
        fillAscendingArray(arr, size);
        start = clock();

        bubbleSort(arr, size);

        end = clock();
        time_taken = ((double)(end - start) * 1000) / CLOCKS_PER_SEC;
        printf("Second Ascending Array Sort Time: %.3f ms\n\n", time_taken);

        size += 4000;
    }

    return 0;
}