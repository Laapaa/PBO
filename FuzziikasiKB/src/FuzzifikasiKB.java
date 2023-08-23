/**
 Tugas Fuzzifikasi Kecerdasan Buatan
 Anggota Kelompok
 *
 */
public class FuzzifikasiKB {

    private double kecepatanLambat;
    private double kecepatanCepat;
    private double suhuRendah;
    private double suhuTinggi;
    private double a_predikat1, a_predikat2, a_predikat3, a_predikat4;
    private double z1, z2, z3, z4;
    public double zTotal,z,a_pred_z ;

    public void fuzzifikasiKecepatan(double kecepatan) {
        if (kecepatan <= 1000) {
            kecepatanLambat = 1;
            kecepatanCepat = 0;
        } else if (kecepatan >= 1000 && kecepatan <= 5000) {
            kecepatanLambat = (5000 - kecepatan) / (5000 - 1000);
            kecepatanCepat = (kecepatan - 1000) / (5000 - 1000);
        } else {
            kecepatanLambat = 0;
            kecepatanCepat = 1;
        }
        System.out.println("derajat keanggotaan kecepatan cepat : " + kecepatanCepat);
        System.out.println("derajat keanggotaan kecepatan lambat : " + kecepatanLambat);
    }

    public void fuzzifikasiSuhu(double suhu) {
        if (suhu <= 100) {
            suhuRendah = 1;
            suhuTinggi = 0;
        } else if (suhu >= 100 && suhu <= 600) {
            suhuRendah = (600 - suhu) / (600 - 100);
            suhuTinggi = (suhu - 100) / (600 - 100);
        } else {
            suhuRendah = 0;
            suhuTinggi = 1;
        }
        System.out.println("derajat keanggotaan suhu rendah : " + suhuRendah);
        System.out.println("derajat keanggotaan suhu tinggi : " + suhuTinggi);
    }

    public void mesinInferensi() {
        {
            // IF kecepatan LAMBAT dan suhu TINGGI then Frekuensi   KECIL
            a_predikat1 = Math.min(kecepatanLambat, suhuTinggi);
            z1 = 7000 - a_predikat1 * (7000 - 2000);
            System.out.println("a predikat 1 : " + a_predikat1 + " | " + "z1 : " + z1);

            // IF kecepatan LAMBAT dan suhu RENDAH then Frekuensi KECIL
            a_predikat2 = Math.min(kecepatanLambat, suhuRendah);
            z2 = 7000 - a_predikat2 * (7000 - 2000);
            System.out.println("a predikat 2 : " + a_predikat2 + " | " + "z2 : " + z2);

            // IF kecepatan CEPAT dan suhu TINGGI then Frekuensi BESAR
            a_predikat3 = Math.min(kecepatanCepat, suhuTinggi);
            z3 = 2000 - a_predikat3 * (2000 - 7000);
            System.out.println("a predikat 3 : " + a_predikat3+ " | " + "z3 : " + z3);

            // IF kecepatan CEPAT dan suhu RENDAH then Frekuensi BESAR
            a_predikat4 = Math.min(kecepatanCepat, suhuRendah);
            z4 = 2000 - a_predikat4 * (2000 - 7000);
            System.out.println("a predikat 4 : " + a_predikat4 + " | " + "z4 : " + z4);
        }
    }

    public void defuzzifikasi(){
        a_pred_z = (a_predikat1*z1)+(a_predikat2*z2)+(a_predikat3*z3)+(a_predikat4*z4) ;
        z = a_predikat1+a_predikat2+a_predikat3+a_predikat4 ;
        zTotal = a_pred_z/z ;
        System.out.println("Output Fuzzy berupa Frekuensi Kipas : "+zTotal + " Hz");
    }

    public static void main(String[] args) {
        FuzzifikasiKB fs = new FuzzifikasiKB();
        double kec = 4000 ; double suhu = 300 ;
        System.out.println("========== INPUT FUZZY ==========");
        System.out.println("Kecepatan : " + kec + " rpm");
        System.out.println("Suhu      : " + suhu + " kelvin");
        System.out.println("========== FUZZIFIKASI KECEPATAN ==========");
        fs.fuzzifikasiKecepatan(kec);
        System.out.println("========== FUZZIFIKASI SUHU ==========");
        fs.fuzzifikasiSuhu(suhu);
        System.out.println("========== INFERENSI MESIN ==========");
        fs.mesinInferensi();
        System.out.println("========== DEFUZZIFIKASI ==========");
        fs.defuzzifikasi() ;
    }
}