package com.sun;

public class mobil {
  private String merek;
  private int cc;

public mobil (String merek, int cc){
  this.merek = merek;
  this.cc = cc;
}
public void getinfo(){
  System.out.println("Merek: " + this.merek);
  System.out.println("cc: " + this.cc);
}
public static void main(String[] args) {
  mobil avanza = new mobil ("avanza",1200);
  avanza.getinfo();
}
}
