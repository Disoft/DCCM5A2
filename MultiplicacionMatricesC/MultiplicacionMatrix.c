#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

#define N 1000 // Tamaño de la matriz

double A[N][N], B[N][N], C[N][N];

void generateMatrix(double matrix[N][N]) {
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            matrix[i][j] = (double) rand() / RAND_MAX * 10;
}

void multiplyMatrices() {
    double start = omp_get_wtime();

    #pragma omp parallel for collapse(2)
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            double sum = 0.0;
            for (int k = 0; k < N; k++) {
                sum += A[i][k] * B[k][j];
            }
            C[i][j] = sum;
        }
    }

    double end = omp_get_wtime();
    printf("Tiempo de ejecución en OpenMP: %.6f segundos\n", end - start);
}

int main() {
    generateMatrix(A);
    generateMatrix(B);
    multiplyMatrices();
    printf("%lf\n", C[0][0]); // Mostrar un resultado
    return 0;
}
