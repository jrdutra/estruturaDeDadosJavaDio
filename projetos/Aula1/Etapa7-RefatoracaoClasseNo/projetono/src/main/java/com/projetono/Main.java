package com.projetono;

public class Main {

    public static void main(String[] args){
        No<String> no1 = new No<String>("Conteúdo no1");
        //Tentar setar o conteúdo como string
        No<String> no2 = new No<>("Conteúdo no2");
        no1.setProximoNo(no2);

        No<String> no3 = new No("Conteúdo no3");
        no2.setProximoNo(no3);

        No<String> no4 = new No("Conteúdo no4");
        no3.setProximoNo(no4);

        System.out.println(no1.toStringEncadeado());
        System.out.println(no2.toStringEncadeado());
        System.out.println(no3.toStringEncadeado());
        System.out.println(no4.toStringEncadeado());
    }

}
