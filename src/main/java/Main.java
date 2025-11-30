import java.math.BigDecimal;
import java.util.Scanner;

public static void main(String[] args) {
    // input user
    Scanner input = new Scanner(System.in);

    System.out.print("Masukkan Golongan: ");
    String golongan = input.nextLine();

    System.out.print("Masukkan Jam Lembur: ");
    int jamLembur = input.nextInt();

    BigDecimal[] arrayGaji = {BigDecimal.valueOf(5000000), BigDecimal.valueOf(6500000), BigDecimal.valueOf(9500000)};
    int[] arrayPersenLembur = {30, 32, 34, 36, 38};

    // logic get index gaji pokok
    int indexGajiPokok = getIndexGajiPokok(golongan);

    // logic get index persen gaji lembur
    int indexPersenGajiLembur = getIndexPersenGajiLembur(jamLembur);

    BigDecimal gajiPokok = arrayGaji[indexGajiPokok];
    int persenGajiLembur = arrayPersenLembur[indexPersenGajiLembur];
    BigDecimal gajiLembur = gajiPokok.multiply(BigDecimal.valueOf(persenGajiLembur)).divide(BigDecimal.valueOf(100));
    BigDecimal totalGaji = gajiPokok.add(gajiLembur);

    // print output
    System.out.println("==== Hasil Perhitungan ====");
    System.out.println("Gaji Pokok: " + gajiPokok);
    System.out.println("Gaji Lembur: " + gajiLembur);
    System.out.println("Total Gaji: " + totalGaji);

}

private static int getIndexGajiPokok(String golongan) {
    if (golongan.equalsIgnoreCase("A")) {
        return 0;
    } else if (golongan.equalsIgnoreCase("B")) {
        return 1;
    } else if (golongan.equalsIgnoreCase("C")) {
        return 2;
    } else {
        System.out.println("Golongan tidak valid");
        throw new RuntimeException("Golongan tidak valid");
    }
}

private static int getIndexPersenGajiLembur(int jamLembur) {
    if (jamLembur <= 1) {
        return 0;
    } else if (jamLembur == 2) {
        return 1;
    } else if (jamLembur == 3) {
        return 2;
    } else if (jamLembur == 4) {
        return 3;
    } else if (jamLembur >= 5) {
        return 4;
    } else {
        System.out.println("Jam Lembur tidak valid");
        throw new RuntimeException("Jam Lembur tidak valid");
    }
}