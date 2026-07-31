package one.digitalinnovation;

import one.digitalinnovation.model.Obj;

public class Main {

    public static void main(String[] args){

        ArvoreBinaria<Obj> minhaArvore = new ArvoreBinaria<>();

		minhaArvore.inserir(new Obj(13));
		minhaArvore.inserir(new Obj(10));
		minhaArvore.inserir(new Obj(25));
		minhaArvore.inserir(new Obj(2));
		minhaArvore.inserir(new Obj(12));
		minhaArvore.inserir(new Obj(20));
		minhaArvore.inserir(new Obj(31));
		minhaArvore.inserir(new Obj(29));
		minhaArvore.exibirPreOrdem();
		System.out.println("\n");
		minhaArvore.print(System.out);
		
		// encontrado Bug em remover Nós que tenham filhos -- corrigido
		minhaArvore.remover(new Obj(25));
		minhaArvore.inserir(new Obj(33));
		minhaArvore.inserir(new Obj(26));
		System.out.println("\n");
		minhaArvore.exibirPreOrdem();
		System.out.println("\n");
		minhaArvore.print(System.out);

    }

}
