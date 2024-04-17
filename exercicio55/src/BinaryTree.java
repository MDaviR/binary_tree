import java.util.Scanner;

class Arvore {
    double InputNumeroEscolhido;
    Arvore esquerda;
    Arvore direita;

    public Arvore(double InputNumeroEscolhido) {
        this.InputNumeroEscolhido = InputNumeroEscolhido;
        this.esquerda = null;
        this.direita = null;
    }
}

class ArvoreBinaria {
    Arvore raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void adicionar(double InputNumeroEscolhido) {
        this.raiz = adicionar(this.raiz, InputNumeroEscolhido);
    }

    private Arvore adicionar(Arvore atual, double InputNumeroEscolhido) {
        if (atual == null) {
            return new Arvore(InputNumeroEscolhido);
        }

        if (InputNumeroEscolhido < atual.InputNumeroEscolhido) {
            atual.esquerda = adicionar(atual.esquerda, InputNumeroEscolhido);
        } else if (InputNumeroEscolhido > atual.InputNumeroEscolhido) {
            atual.direita = adicionar(atual.direita, InputNumeroEscolhido);
        } else {
            System.out.println("O numero escolhido " + InputNumeroEscolhido + " já pertence a arvore.");
        }

        return atual;
    }

    public void remover(double InputNumeroEscolhido) {
        this.raiz = removedor(this.raiz, InputNumeroEscolhido);
    }

    private Arvore removedor(Arvore atual, double InputNumeroEscolhido) {
        if (atual == null) {
            System.out.println("O numero informado " + InputNumeroEscolhido + " não existe na árvore.");
            return null;
        }

        if (InputNumeroEscolhido < atual.InputNumeroEscolhido) {
            atual.esquerda = removedor(atual.esquerda, InputNumeroEscolhido);
        } else if (InputNumeroEscolhido > atual.InputNumeroEscolhido) {
            atual.direita = removedor(atual.direita, InputNumeroEscolhido);
        } else {
            if (atual.esquerda == null) {
                System.out.println("O numero " + InputNumeroEscolhido + " foi removido da árvore.");
                return atual.direita;
            } else if (atual.direita == null) {
                System.out.println("O numero " + InputNumeroEscolhido + " foi removido da árvore.");
                return atual.esquerda;
            } else {
                atual.InputNumeroEscolhido = encontrarMinimo(atual.direita).InputNumeroEscolhido;
                atual.direita = removedor(atual.direita, atual.InputNumeroEscolhido);
            }
        }

        return atual;
    }

    private Arvore encontrarMinimo(Arvore atual) {
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual;
    }

    public void mostrar() {
        System.out.println("Numeros da arvore binaria:");

        if (this.raiz == null) {
            System.out.println("A arvore esta vazia.");
            return;
        }

        ordenacaoDasFolhas(this.raiz);
    }

    private void ordenacaoDasFolhas(Arvore atual) {
        if (atual != null) {
            ordenacaoDasFolhas(atual.esquerda);
            System.out.print(atual.InputNumeroEscolhido + " ");
            ordenacaoDasFolhas(atual.direita);
        }
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        Scanner mateus = new Scanner(System.in);
        ArvoreBinaria arvoreMateus = new ArvoreBinaria();

        for (int i = 0; i < 5; i++) {
            System.out.print("Digite um número real: ");
            double numero = mateus.nextDouble();
            arvoreMateus.adicionar(numero);
        }

        //System.out.print("Digite um número real para remover: ");
        //double numero = mateus.nextDouble();
        //arvoreMateus.remover(numero);

        arvoreMateus.mostrar();

        mateus.close();
    }
}

