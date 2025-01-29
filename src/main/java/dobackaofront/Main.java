package dobackaofront;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Inserir Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Atualizar Produto");
            System.out.println("4 - Excluir Produto");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();

                    Produto novoProduto = new Produto(nome, preco, quantidade);
                    produtoDAO.inserirProduto(novoProduto);
                    break;

                case 2:
                    List<Produto> produtos = produtoDAO.listarProdutos();
                    System.out.println("\n===== Lista de Produtos =====");
                    for (Produto p : produtos) {
                        System.out.println(p);
                    }
                    break;

                case 3:
                    System.out.print("ID do produto a atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo preço: ");
                    double novoPreco = scanner.nextDouble();
                    System.out.print("Nova quantidade: ");
                    int novaQuantidade = scanner.nextInt();

                    Produto produtoAtualizado = new Produto(idAtualizar, novoNome, novoPreco, novaQuantidade);
                    produtoDAO.atualizarProduto(produtoAtualizado);
                    break;

                case 4:
                    System.out.print("ID do produto a excluir: ");
                    int idExcluir = scanner.nextInt();
                    produtoDAO.excluirProduto(idExcluir);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

