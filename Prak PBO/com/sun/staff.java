package com.sun;

class staff extends karyawan {
  private String Kodestaff;
 
  public staff(String kodestaff){
    super(kodeKaryawan, nama);
    this.Kodestaff = kodestaff;
  }
  public void setKodeStaff(String kodestaff){
    this.Kodestaff = kodestaff;
  }
  public void getKodeStaff(){
    System.out.println("kode Staff: " + this.Kodestaff);
  }
  public void kerja(){
    this.nama + "Sedang Mengerjakan Tugas"
  }
  @Override //getinfo() akan menimpa getinfo() yang ada di karyawan
  public void getInfo(){
    super.getInfo();
    System.out.println("Kode Staff: " + this.kodestaff);
  }
}
