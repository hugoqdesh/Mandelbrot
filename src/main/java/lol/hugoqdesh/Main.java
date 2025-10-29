package lol.hugoqdesh;

public class Main {
    static void main() {
        int width = 800;
        int height = 600;
        int n = 255;

        for(int i = 0; i < height; i++) {
            double y = (i / 600.0) * 4 - 2;

            for(int j = 0; j < width; j++) {
                double x = (j / 800.0) * 4 - 2;

                double zImaginary = 0;
                double zReal = 0;

                int count = 0;
                while (count < n) {
                    double cReal = x;
                    double cImaginary = y;

                    double tempReal = zReal * zReal - zImaginary * zImaginary + cReal;
                    double tempImaginary = 2 * zReal * zImaginary + cImaginary;

                    zReal = tempReal;
                    zImaginary = tempImaginary;

                    if (zReal * zReal + zImaginary * zImaginary > 4) {
                        break;
                    }

                    count++;
                }

                System.out.println("x: " + x + " y: " + y);
            }
        }
    }
}
