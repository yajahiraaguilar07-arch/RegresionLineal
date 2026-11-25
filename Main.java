public class Main {
    public static void main(String[] args) {

        double[] x = {1, 2, 3, 4, 5};
        double[] y = {2, 4, 5, 4, 6};

        double[] resultados = RegressionLineal.calcularMinimosCuadrados(x, y);

        double beta0 = resultados[0];
        double beta1 = resultados[1];
        double pearsonR = resultados[2];
        double r2 = resultados[3];

        double xValor = 6;
        double prediccion = RegressionLineal.predecir(beta0, beta1, xValor);

        System.out.println();
        System.out.println("--- PREDICCION ---");
        System.out.println("Valor de X: " + xValor);
        System.out.printf("Valor estimado de Y: %.4f%n", prediccion);
    }
}
