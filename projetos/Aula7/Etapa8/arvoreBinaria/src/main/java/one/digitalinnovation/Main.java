package one.digitalinnovation;

import one.digitalinnovation.model.Obj;

public class Main {

    public static void main(String[] args){

        //BinNo<Obj> binNo = new BinNo<>(new Obj(1, "teste"));
        //BinNo<ObjSimples> binNo2 = new BinNo<>(new ObjSimples(1, "teste"));

        ArvoreBinaria<Obj> minhaArvore = new ArvoreBinaria<>();

        minhaArvore.inserir(new Obj(4));
        minhaArvore.inserir(new Obj(2));
        minhaArvore.inserir(new Obj(5));
        minhaArvore.inserir(new Obj(1));
        minhaArvore.inserir(new Obj(3));
        minhaArvore.inserir(new Obj(6));
        minhaArvore.inserir(new Obj(7));

        minhaArvore.exibirInOrdem();
        minhaArvore.exibirPreOrdem();
        minhaArvore.exibirPosOrdem();

        minhaArvore.remover(new Obj(7));
        minhaArvore.exibirInOrdem();

        minhaArvore.remover(new Obj(2));
        minhaArvore.exibirInOrdem();

    }

}
