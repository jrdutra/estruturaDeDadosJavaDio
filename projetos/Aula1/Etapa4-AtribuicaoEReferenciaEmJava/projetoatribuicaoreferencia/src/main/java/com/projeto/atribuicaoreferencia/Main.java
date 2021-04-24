package com.estruturadedados;

public class Main {
    public static void main(String[] args){
        int a = 1;
        int b = a;
        System.out.println("a=" + a + " b=" + b);
        a = 2;
        System.out.println("a=" + a + " b=" + b);

        class MeuObj{
            Integer num;
            public MeuObj(Integer n){
                this.num = n;
            }

            public void setNum(Integer num) {
                this.num = num;
            }

            @Override
            public String toString() {
                return this.num.toString();
            }
        }

        MeuObj objA = new MeuObj(1);
        MeuObj objb = objA;
        System.out.println("objA=" + objA + " objb=" + objb);

        objA.setNum(2);
        System.out.println("objA=" + objA + " objb=" + objb);
    }
}