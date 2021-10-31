public class ArvoreBinaria {
    // Atributos
    private No raiz;
    private int tamanho;
    // Construtor
    public ArvoreBinaria() {
        raiz = null;
        tamanho = 0;
    }
    // Métodos
    public void inserir(int valor) {
        if (raiz == null) {
            raiz = new No(valor);
            tamanho++;
        } else {
            inserir(raiz, valor);
        }
    }
    private void inserir(No no, int valor) {
        if (valor < no.getValor()) {
            if (no.getEsquerda() == null) {
                no.setEsquerda(new No(valor));
                tamanho++;
            } else {
                inserir(no.getEsquerda(), valor);
            }
        } else {
            if (no.getDireita() == null) {
                no.setDireita(new No(valor));
                tamanho++;
            } else {
                inserir(no.getDireita(), valor);
            }
        }
    }
    public void remover(int valor) {
        if (raiz != null) {
            remover(raiz, valor);
        }
    }
    private void remover(No no, int valor) {
        if (no != null) {
            if (valor < no.getValor()) {
                remover(no.getEsquerda(), valor);
            } else if (valor > no.getValor()) {
                remover(no.getDireita(), valor);
            } else {
                if (no.getEsquerda() == null && no.getDireita() == null) {
                    no = null;
                    tamanho--;
                } else if (no.getEsquerda() == null) {
                    no.setValor(no.getDireita().getValor());
                    no.setDireita(no.getDireita().getDireita());
                    tamanho--;
                } else if (no.getDireita() == null) {
                    no.setValor(no.getEsquerda().getValor());
                    no.setEsquerda(no.getEsquerda().getEsquerda());
                    tamanho--;
                } else {
                    no.setValor(no.getDireita().getValor());
                    remover(no.getDireita(), no.getDireita().getValor());
                }
            }
        }
    }
    public int getTamanho() {
        return tamanho;
    }
    public void imprimir() {
        if (raiz != null) {
            imprimir(raiz);
        }
    }
    private void imprimir(No no) {
        if (no != null) {
            imprimir(no.getEsquerda());
            System.out.println(no.getValor());
            imprimir(no.getDireita());
        }
    }
    public boolean buscar(int valor) {
        if (raiz != null) {
            return buscar(raiz, valor);
        }
        return false;
    }
    private boolean buscar(No no, int valor) {
        if (no != null) {
            if (valor == no.getValor()) {
                return true;
            } else if (valor < no.getValor()) {
                return buscar(no.getEsquerda(), valor);
            } else {
                return buscar(no.getDireita(), valor);
            }
        }
        return false;
    }
    public int altura() {
        if (raiz != null) {
            return altura(raiz);
        }
        return 0;
    }
    private int altura(No no) {
        if (no != null) {
            int esquerda = altura(no.getEsquerda());
            int direita = altura(no.getDireita());
            if (esquerda > direita) {
                return esquerda + 1;
            } else {
                return direita + 1;
            }
        }
        return 0;
    }
    public int profundidade(int valor) {
        if (raiz != null) {
            return profundidade(raiz, valor);
        }
        return 0;
    }
    private int profundidade(No no, int valor) {
        if (no != null) {
            if (valor == no.getValor()) {
                return 0;
            } else if (valor < no.getValor()) {
                return profundidade(no.getEsquerda(), valor) + 1;
            } else {
                return profundidade(no.getDireita(), valor) + 1;
            }
        }
        return 0;
    }
    public int maior() {
        if (raiz != null) {
            return maior(raiz);
        }
        return 0;
    }
    private int maior(No no) {
        if (no != null) {
            if (no.getDireita() == null) {
                return no.getValor();
            } else {
                return maior(no.getDireita());
            }
        }
        return 0;
    }
    public int menor() {
        if (raiz != null) {
            return menor(raiz);
        }
        return 0;
    }
    private int menor(No no) {
        if (no != null) {
            if (no.getEsquerda() == null) {
                return no.getValor();
            } else {
                return menor(no.getEsquerda());
            }
        }
        return 0;
    }
    public int soma() {
        if (raiz != null) {
            return soma(raiz);
        }
        return 0;
    }
    private int soma(No no) {
        if (no != null) {
            return soma(no.getEsquerda()) + soma(no.getDireita()) + no.getValor();
        }
        return 0;
    }
    
 public static void main(String[] args) {
  // Cria a arvore
    ArvoreBinaria arvore = new ArvoreBinaria();
    // Insere os elementos na arvore
    arvore.insere(10);
    arvore.insere(5);
    arvore.insere(15);
    arvore.insere(2);
    arvore.insere(7);
    arvore.insere(12);
    arvore.insere(17);
    arvore.insere(13);
    arvore.insere(18);
    arvore.insere(20);
    arvore.insere(25);
    arvore.insere(30);

    // Imprime a arvore
    arvore.imprimir();
    System.out.println("\n");
    // Remove um elemento da arvore
    arvore.remover(10);
    // Imprime a arvore
    arvore.imprimir();
    System.out.println("\n");
    // Busca um elemento na arvore
    System.out.println("Busca: " + arvore.buscar(10));
    System.out.println("\n");
    // Imprime a altura da arvore
    System.out.println("Altura: " + arvore.altura());
    System.out.println("\n");
    // Imprime a profundidade de um elemento na arvore
    System.out.println("Profundidade: " + arvore.profundidade(10));
    System.out.println("\n");
    // Imprime o maior elemento da arvore
    System.out.println("Maior: " + arvore.maior());
    System.out.println("\n");
    // Imprime o menor elemento da arvore
    System.out.println("Menor: " + arvore.menor());
    System.out.println("\n");
    // Imprime a soma dos elementos da arvore
    System.out.println("Soma: " + arvore.soma());
    System.out.println("\n");


     
 }
}


