import java.math.BigDecimal;
import java.util.Scanner;

public static void main(String[] args) {
    // input user
    Scanner input = new Scanner(System.in);

    System.out.print("Masukkan Golongan: ");
    String golongan = input.nextLine();

    System.out.print("Masukkan Jam Lembur: ");
    int jamLembur = input.nextInt();

    // logic get gaji pokok
    BigDecimal gajiPokok = getGajiPokok(golongan);

    // logic get gaji lembur
    BigDecimal gajiLembur = getGajiLembur(jamLembur, gajiPokok);

    // print output
    System.out.println("==== Hasil Perhitungan ====");
    System.out.println("Gaji pokok: " + gajiPokok);
    System.out.println("Gaji lembur: " + gajiLembur);
    System.out.println("Total gaji: " + gajiPokok.add(gajiLembur));

}

private static BigDecimal getGajiPokok(String golongan) {
    if (golongan.equals("A")) {
        return BigDecimal.valueOf(5000000);
    } else if (golongan.equals("B")) {
        return BigDecimal.valueOf(6500000);
    } else if (golongan.equals("C")) {
        return BigDecimal.valueOf(9500000);
    } else {
        return BigDecimal.ZERO;
    }
}

private static BigDecimal getGajiLembur(int jamLembur, BigDecimal gajiPokok) {
    if (jamLembur <= 1) {
        return gajiPokok.multiply(BigDecimal.valueOf(30)).divide(BigDecimal.valueOf(100));
    } else if (jamLembur == 2) {
        return gajiPokok.multiply(BigDecimal.valueOf(32)).divide(BigDecimal.valueOf(100));
    } else if (jamLembur == 3) {
        return gajiPokok.multiply(BigDecimal.valueOf(34)).divide(BigDecimal.valueOf(100));
    } else if (jamLembur == 4) {
        return gajiPokok.multiply(BigDecimal.valueOf(36)).divide(BigDecimal.valueOf(100));
    } else if (jamLembur >= 5) {
        return gajiPokok.multiply(BigDecimal.valueOf(38)).divide(BigDecimal.valueOf(100));
    } else {
        return BigDecimal.ZERO;
    }
}
