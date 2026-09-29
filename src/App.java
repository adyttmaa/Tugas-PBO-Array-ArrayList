public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("=== MEMULAI SIMULASI SISTEM BANK ===");
        Bank bankUnram = new Bank();

        System.out.println("\nMendaftarkan 5 Nasabah Baru...");
        bankUnram.addCustomer("dika", "putra");
        bankUnram.addCustomer("zaki", "Santoso");
        bankUnram.addCustomer("zakaria", "qurniawan");
        bankUnram.addCustomer("iky", "hisam");
        bankUnram.addCustomer("dani", "Smith");
        
        System.out.println("Total nasabah saat ini: " + bankUnram.getNumOfCustomers());

        System.out.println("\nMencoba mendaftarkan nasabah ke-6 (Seharusnya Gagal)...");
        bankUnram.addCustomer("Joko", "Anwar");

        System.out.println("\nMencetak buku rekening untuk semua nasabah...");
        bankUnram.getCustomer(0).setAccount(new Account(1000000.0));
        bankUnram.getCustomer(1).setAccount(new Account(500000.0));
        bankUnram.getCustomer(2).setAccount(new Account(250000.0));
        bankUnram.getCustomer(3).setAccount(new Account(750000.0));
        bankUnram.getCustomer(4).setAccount(new Account(0.0));

        System.out.println("\nSimulasi Transaksi...");
        
        System.out.print("- dika setor Rp 500.000 -> ");
        boolean status1 = bankUnram.getCustomer(0).getAccount().deposit(500000.0);
        System.out.println(status1 ? "Berhasil" : "Gagal");

        System.out.print("- zaki tarik Rp 800.000 (Saldo cuma 500rb) -> ");
        boolean status2 = bankUnram.getCustomer(1).getAccount().withdraw(800000.0);
        System.out.println(status2 ? "Berhasil" : "Gagal (Ditolak Sistem)");

        System.out.print("- dani tarik Rp 50.000 (Saldo 0) -> ");
        boolean status3 = bankUnram.getCustomer(4).getAccount().withdraw(50000.0);
        System.out.println(status3 ? "Berhasil" : "Gagal (Ditolak Sistem)");

        System.out.print("iky tarik Rp 50.000 -> ");
        boolean status4 = bankUnram.getCustomer(3).getAccount().withdraw(50000);
        System.out.println(status4 ? "Berhasil" : "Gagal (Ditolak Sistem)");

        System.out.println("\n=== LAPORAN AKHIR REKENING NASABAH ===");
        for (int i = 0; i < bankUnram.getNumOfCustomers(); i++) {
            Customer c = bankUnram.getCustomer(i);
            String namaLengkap = c.getFirstName() + " " + c.getLastName();
            double saldoAkhir = c.getAccount().getBalance();
            
            System.out.println((i + 1) + ". " + namaLengkap + " - Saldo: Rp " + saldoAkhir);
        }
    }
}
