package com.game;

import java.util.Random;
import java.util.Scanner;

import static com.game.MyColor.*;

public class Game{
    public static void main(String[] args){
        Scanner inputUser = new Scanner(System.in);
        Random rendom = new Random();

        int score = 0;
        boolean play = true;

        while(play){
            // clear screan setelah program dimulai kembali
            clearScrean();
            int angkaAcak;
            int jumblahPercobaan = 0;

            System.out.println(ANSI_BLUE + "Selamat Datang Di Game Tebak Angka!" + ANSI_RESET);

            // Pemilihan Level
            System.out.print(ANSI_YELLOW + "Silahkan Pilih Level Anda (1/2/3) : " + ANSI_RESET);
            int level = inputUser.nextInt();

            switch (level) {
                case 1:
                    angkaAcak = rendom.nextInt(10) + 1;
                    break;
                case 2:
                    angkaAcak = rendom.nextInt(50) + 1;
                    break;
                case 3:
                    angkaAcak = rendom.nextInt(100) + 1;
                    break;
                default:
                    System.out.println("Level yang dipilih tidak valid. Memilih level 1 secara default.");
                    angkaAcak = rendom.nextInt(10) + 1;
                    break;
            }

            if(level == 1){
                jumblahPercobaan = 5;
            }else if(level == 2){
                jumblahPercobaan = 10;
            }else if(level == 3){
                jumblahPercobaan = 15;
            }


            // Penebakan angka
            if(level == 1){
                System.out.print(ANSI_GREEN + "Silahkan Masukan Tebakan Pertama Anda 1 -> 10: " + ANSI_RESET);
            }else if(level == 2){
                System.out.print(ANSI_CYAN + "Silahkan Masukan Tebakan Pertama Anda 1 -> 50: " + ANSI_RESET);
            }else if(level == 3){
            System.out.print(ANSI_RED + "Silahkan Masukan Tebakan Pertama Anda 1 -> 100: " + ANSI_RESET);
            }else{
                System.out.println("level tidak ditemukan");
            }
            

            while(jumblahPercobaan > 0){

                int tebakan = inputUser.nextInt();
                jumblahPercobaan--;

                // System Keluar Dari Game
                System.out.println(ANSI_BLUE + "\nJIKA ANDA INGIN KELUAR DARI PERMAINAN KETIK 'k' JIKA INGGIN LANJUT KETIK 'l' " + ANSI_RESET);
                String jawaban = inputUser.next();
                if(jawaban.equalsIgnoreCase("k")){
                    play = false;
                    break;
                }

                // Pengecekan Angka Yang Di Tebak, Sesuai dengan inputUser
                if(tebakan == angkaAcak){

                    // pembaruan angkaAcak sesuai level yang di pilih
                    if(level == 1){
                        score+=10;
                        jumblahPercobaan+=3;
                        angkaAcak = rendom.nextInt(10)+1;
                    }else if(level == 2){
                        score+=20;
                        jumblahPercobaan+=4;
                        angkaAcak = rendom.nextInt(50)+1;
                    }else if(level == 3){
                        score+=30;
                        jumblahPercobaan+=5;
                        angkaAcak = rendom.nextInt(100)+1;
                    }else{

                    }
                    

                    System.out.println(ANSI_GREEN + "Selamat Anda Berhasil Menebak Angka!" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "Score Anda Saat Ini : " + score + ANSI_RESET);
                    System.out.println("Jumblah Percobaan Anda saat ini + Bonus Kemenangan-> lvl 1 = +3 | lvl 2 = +4 | lvl 3 = +5 : " + jumblahPercobaan);
                    System.out.print(ANSI_GREEN + "Silahkan Tebak Angka Lagi : " + ANSI_RESET);
                }else if(tebakan < angkaAcak){
                    System.out.println(ANSI_GREEN + "Tebakan Anda Terlalu Rendah. Sisa Percobaan : " + jumblahPercobaan + ANSI_RESET);
                    System.out.print("Silahkan Masukan Angka Lagi : ");
                }else if(tebakan > angkaAcak){
                    System.out.println(ANSI_RED + "Tebakan Anda Terlalu Tinggi. Sisa Percobaan : " + jumblahPercobaan + ANSI_RESET);
                    System.out.print("Silahkan Masukan Angka Lagi : ");
                }
            }

            // Proses Jika Penebakan Angka salah
            if(jumblahPercobaan == 0){
                System.out.println(ANSI_RED + "Maaf Percobaan Habis. Jawaban Yang Benar Adalah : " + angkaAcak + ANSI_RESET);
                score -=5;
                System.out.println(ANSI_RED + "Karna Anda Kalah Maka Score akan dikurangi 5 score anda saat ini menjadi : " + score + ANSI_RESET);
            }

            // System Melanjutkan Kembali Atau Tidak, JIka Ya Maka Game Akan Dimulai Kembali
            // Dengan Score Terakhir yang Diraih Oleh Player, Jka TIdak Program Akan Keluar
            // Dan Score Akan Di Reset 
            System.out.println(ANSI_YELLOW + "Apakah Anda Ingin Bermain Lagi? (ya/tidak)" + ANSI_RESET);
            String jawaban = inputUser.next();
            if(!jawaban.equalsIgnoreCase("ya")){
                play = false;
            }
        }

    }

    // System Clear Screan (Untuk membersihkan Console Secara Otomatis)
    public static void clearScrean(){
    try{
        if(System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.print("\033\143");
        }else{
            System.out.print("\033\143");
        }
    } catch(Exception e){
        System.err.println("clear screan gagal");
        }

    }
}
