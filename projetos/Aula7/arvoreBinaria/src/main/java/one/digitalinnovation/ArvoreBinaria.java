package one.digitalinnovation;

import java.io.PrintStream;

public class ArvoreBinaria<T extends Comparable<T>> {

	private BinNode<T> raiz;

	public ArvoreBinaria() {
		this.raiz = null;
	}

	public void inserir(T conteudo) {
		BinNode<T> novoNo = new BinNode<>(conteudo);
		raiz = inserirNode(raiz, novoNo);
	}

	private BinNode<T> inserirNode(BinNode<T> atual, BinNode<T> novoNo) {
		if (atual == null) {
			return novoNo;
		} else if (novoNo.getConteudo().compareTo(atual.getConteudo()) < 0) {
			atual.setNoEsq(inserirNode(atual.getNoEsq(), novoNo));
		} else {
			atual.setNoDir(inserirNode(atual.getNoDir(), novoNo));
		}
		return atual;
	}

	public void exibirInOrdem() {
		System.out.println("\nExibindo InOrdem");
		exibirInOrdem(this.raiz);
	}

	private void exibirInOrdem(BinNode<T> atual) {
		if (atual != null) {
			exibirInOrdem(atual.getNoEsq());
			System.out.print(atual.getConteudo() + ", ");
			exibirInOrdem(atual.getNoDir());
		}
	}

	public void exibirPosOrdem() {
		System.out.println("\nExibindo PosOrdem");
		exibirPosOrdem(this.raiz);
	}

	private void exibirPosOrdem(BinNode<T> atual) {
		if (atual != null) {
			exibirPosOrdem(atual.getNoEsq());
			exibirPosOrdem(atual.getNoDir());
			System.out.print(atual.getConteudo() + ", ");
		}
	}

	public void exibirPreOrdem() {
		System.out.println("\nExibindo PreOrdem");
		exibirPreOrdem(this.raiz);
	}

	private void exibirPreOrdem(BinNode<T> atual) {
		if (atual != null) {
			System.out.print(atual.getConteudo() + ", ");
			exibirPreOrdem(atual.getNoEsq());
			exibirPreOrdem(atual.getNoDir());
		}
	}

	// Método para chamada de remoção de nós
	public void remover(T conteudo) {
		raiz = removerNode(raiz, conteudo);
	}

	// Encontrar o elemento mínimo da subárvore
	private T minimumElement(BinNode<T> atual) {
		while (atual.getNoDir() != null)
			atual = atual.getNoDir();
		return atual.getConteudo();
	}

	private BinNode<T> removerNode(BinNode<T> atual, T conteudo) {
		if (atual == null)
			return null;
		else if (conteudo.compareTo(atual.getConteudo()) < 0)
			atual.setNoEsq(removerNode(atual.getNoEsq(), conteudo));
		else if (conteudo.compareTo(atual.getConteudo()) > 0)
			atual.setNoDir(removerNode(atual.getNoDir(), conteudo));
		else {
			if (atual.getNoEsq() == null && atual.getNoDir() == null)
				return null;
			else if (atual.getNoDir() == null)
				return atual.getNoEsq();
			else if (atual.getNoEsq() == null)
				return atual.getNoDir();
			else {
				atual.setConteudo(minimumElement(atual.getNoEsq()));
				atual.setNoEsq(removerNode(atual.getNoEsq(), atual.getConteudo()));
			}
		}
		return atual;
	}

	private String traversePreOrder(BinNode<T> root) {

		if (root == null) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		sb.append(root.getConteudo());

		String pointerRight = "└──";
		String pointerLeft = (root.getNoDir() != null) ? "├──" : "└──";

		traverseNodes(sb, "", pointerLeft, root.getNoEsq(), root.getNoDir() != null);
		traverseNodes(sb, "", pointerRight, root.getNoDir(), false);

		return sb.toString();
	}

	private void traverseNodes(StringBuilder sb, String padding, String pointer, BinNode<T> node,
			boolean hasRightSibling) {

		if (node != null) {

			sb.append("\n");
			sb.append(padding);
			sb.append(pointer);
			sb.append(node.getConteudo());

			StringBuilder paddingBuilder = new StringBuilder(padding);
			if (hasRightSibling) {
				paddingBuilder.append("│  ");
			} else {
				paddingBuilder.append("   ");
			}

			String paddingForBoth = paddingBuilder.toString();
			String pointerRight = "└──";
			String pointerLeft = (node.getNoDir() != null) ? "├──" : "└──";

			traverseNodes(sb, paddingForBoth, pointerLeft, node.getNoEsq(), node.getNoDir() != null);
			traverseNodes(sb, paddingForBoth, pointerRight, node.getNoDir(), false);

		}

	}

	public void print(PrintStream os) {
		os.print(traversePreOrder(raiz));
	}

}
