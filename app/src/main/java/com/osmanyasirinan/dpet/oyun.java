package com.osmanyasirinan.dpet;

public class oyun {

    int can, guc, para;
    int kilo = 10;
    int uykuSayac = 0, aclikSayac = 0, kakaSayac = 0, uykucanSayac = 0;
    boolean uyku = false, aclik = false, kaka = false;

    public String uyu(){
        if (aclikSayac == 5){
            aclik = true;
            aclikSayac = 0;
        }

        if (kakaSayac == 7){
            kaka = true;
            kakaSayac = 0;
        }

        uykuSayac = 0;
        uyku = false;
        kakaSayac++;
        aclikSayac++;
        uykuSayac++;
        uykucanSayac++;
        if (uykucanSayac == 5) {
            can++;
            uykucanSayac = 0;
        }
        return " uyudu!";
    }

    public String yemekYe(){
        if (uykuSayac == 5){
            uyku = true;
            uykuSayac = 0;
        }

        if (kakaSayac == 7){
            kaka = true;
            kakaSayac = 0;
        }

        if (uyku != true){
            aclikSayac = 0;
            kilo += 2;
            uykuSayac++;
            kakaSayac++;
            aclik = false;
            can++;
            return " yemek yedi ve kilosu arttı!";
        }else {
            return " çok uykusu var!";
        }
    }

    public String savas(){

        if (uykuSayac == 5){
            uyku = true;
            uykuSayac = 0;
        }

        if (kakaSayac == 7){
            kaka = true;
            kakaSayac = 0;
        }

        if (aclikSayac == 5){
            aclik = true;
            aclikSayac = 0;
        }


        if (can <= 10){
            return " canı çok az!";
        }else if (kilo >= 30){
            return " çok kilolu!";
        }else if (uyku == true){
            return " çok uykusu var!";
        }else if(aclik == true){
            return " çok aç!";
        }else {
            guc += 5;
            para += 2;
            kakaSayac++;
            uykuSayac++;
            aclikSayac++;
            can -= 3;
            return " savaştı ve ganimet kazandı!";
        }
    }

    public String sporYap(){

        if (uykuSayac == 5){
            uyku = true;
            uykuSayac = 0;
        }

        if (kakaSayac == 7){
            kaka = true;
            kakaSayac = 0;
        }


        if (aclikSayac == 5){
            aclik = true;
            aclikSayac = 0;
        }
        if (uyku == true){
            return " çok uykusu var!";
        }else if(aclik == true){
            return " çok aç!";
        }else if(para < 2){
            return " spora gitmesi için parası yok!";
        }else {
            kilo -= 1;
            uykuSayac++;
            para--;
            kakaSayac++;
            can++;
            return " spora gitti ve kilo verdi!";
        }
    }

    public String buyHome(){
        if (para < 30){
            return "Ev almak için yeterince parası yok!";
        }else {
            para -= 30;
            return "Ev satın alındı!";
        }
    }

    // Getting string methods

    public String getCan(){
        return "" + can;
    }

    public String getGuc(){
        return "" + guc;
    }

    public String getPara(){
        return "" + para;
    }
}
