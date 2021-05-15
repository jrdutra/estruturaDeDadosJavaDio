package one.digitalinnovation;

public class Main {

    public static void main(String[] args){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);

        System.out.println(lista);
        System.out.println(lista.get(2));

    }

}
