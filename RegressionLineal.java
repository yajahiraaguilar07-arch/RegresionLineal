public class RegressionLineal {

    public static double[] calcularMinimosCuadrados(double[] x, double[] y) {

        int n = x.length;
        double sumaX = 0, sumaY = 0, sumaX2 = 0, sumaY2 = 0, sumaXY = 0;

        for (int i = 0; i < n; i++) {
            sumaX += x[i];
            sumaY += y[i];
            sumaX2 += x[i] * x[i];
            sumaY2 += y[i] * y[i];
            sumaXY += x[i] * y[i];
        }

        double beta1 = (n * sumaXY - sumaX * sumaY) /
                (n * sumaX2 - sumaX * sumaX);

        double beta0 = (sumaY - beta1 * sumaX) / n;

        double pearsonR = (n * sumaXY - sumaX * sumaY) /
                Math.sqrt((n * sumaX2 - sumaX * sumaX) *
                        (n * sumaY2 - sumaY * sumaY));

        double r2 = pearsonR * pearsonR;

        System.out.println("--- REGRESION LINEAL ---");
        System.out.println("Numero de datos: " + n);
        System.out.println("Suma de X: " + sumaX);
        System.out.println("Suma de Y: " + sumaY);
        System.out.println("Suma de X^2: " + sumaX2);
        System.out.println("Suma de Y^2: " + sumaY2);
        System.out.println("Suma de XY: " + sumaXY);

        System.out.printf("Pendiente (beta1): %.4f%n", beta1);
        System.out.printf("Intercepto (beta0): %.4f%n", beta0);
        System.out.printf("Ecuacion: y = %.4f + %.4fx%n", beta0, beta1);
        System.out.printf("Coeficiente de Pearson (r): %.4f%n", pearsonR);
        System.out.printf("Coeficiente de determinacion (r^2): %.4f%n", r2);

        return new double[]{beta0, beta1, pearsonR, r2};
    }

    public static double predecir(double beta0, double beta1, double x) {
        return beta0 + beta1 * x;
    }
}
