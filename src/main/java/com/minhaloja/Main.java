package com.minhaloja;

import com.minhaloja.domain.models.User;
import com.minhaloja.domain.models.UserCliente;
import com.minhaloja.domain.models.UserVendedor;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static User usuarioAtual;
    private static ApplicationService applicationService = new ApplicationService();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean continuar = true;

    public static void main(String[] args) throws Exception {

        while (continuar) {
            if (usuarioAtual == null) menuInicial();
            else if (usuarioAtual.getClass() == UserCliente.class) menuCliente();
            else if (usuarioAtual.getClass() == UserVendedor.class) menuVendedor();
        }

    }

    private static void menuCliente() {
        logo();

        System.out.print(
                "   1. Cadastrar Video Game\n" +
                "   0. Sair\n\n" +
                "   > "
        );

        int escolha = scanner.nextInt();
        if (escolha <= 0) continuar = false; // Sai do loop

        switch (escolha) {
            case 1:
                System.out.print("Produtos: \n" +
                        applicationService.getProdutosString());
                System.out.print("Sua escolha (ID): ");
                Integer idProduto = scanner.nextInt();
                applicationService.cadastrarVenda(
                        usuarioAtual.getEmail(),
                        null, // fiz cagada
                        idProduto,
                        applicationService.getProduto(idProduto).getPreco()
                );
                break;
        }

    }

    private static void menuVendedor() {
        Random random = new Random();
        logo();

        System.out.print(
                "   1. Comprar\n" +
                        "   0. Sair\n\n" +
                        "   > "
        );

        int escolha = scanner.nextInt();
        if (escolha <= 0) continuar = false; // Sai do loop

        switch (escolha) {
            case 1:
                System.out.print("Produtos: \n" +
                        applicationService.getProdutosString());
                System.out.print("Nome do Video Game: ");
                String nomeJogo = scanner.next();
                System.out.print("Preco do produto: ");
                BigDecimal precoJogo = scanner.nextBigDecimal();
                applicationService.cadastrarVideoGame(
                        random.nextInt(),
                        nomeJogo,
                        precoJogo
                );
                break;
        }
    }

    private static void menuInicial() throws Exception {
        logo();

        System.out.print("   1. Cadastrar usuário\n" +
                "   2. Logar\n" +
                "   3. Listar Vendedores e Clientes" +
                "   0. Sair\n\n" +
                "   > "
        );

        int escolha = scanner.nextInt();
        if (escolha <= 0) continuar = false; // Sai do loop

        switch (escolha) {
            case 1:
                logo();

                System.out.print("    Nome: ");
                String nome = scanner.next();
                System.out.print("    Email: ");
                String email = scanner.next();
                System.out.print("    Senha: ");
                String senha = scanner.next();

                System.out.print("   1. Cliente\n" +
                        "   2. Vendedor\n\n" +
                        "   > "
                );
                int escolhaCadastro = scanner.nextInt();
                if (escolhaCadastro == 1) applicationService.cadastrarCliente(
                        nome, email, senha);
                else if (escolhaCadastro == 2) applicationService.cadastrarVendedor(
                        nome, email, senha);
                else throw new InvalidParameterException("Escolha Inválida");
                break;

            case 2:
                logo();

                System.out.print("    Email: ");
                String loginEmail = scanner.next();
                System.out.print("    Senha: ");
                String loginSenha = scanner.next();


                int escolhaLogin = scanner.nextInt();

                Optional<User> usuario =
                        applicationService.login(loginEmail, loginSenha);
                if (usuario.isPresent()) {
                    usuarioAtual = usuario.get();
                } else throw new Exception("Senha inválida ou usuário não existe!");
                break;

            case 3:
                System.out.println("Vendedores: \n" +
                        applicationService.getVendedores().toString());
                System.out.println("Clientes: \n" +
                        applicationService.getClientes().toString());
        }

    }

    private static void logo(){;
        System.out.println("#####################################\n" +
                        "#           MinhaLoja               #\n" +
                        "#####################################\n" +
                        "Usuário Atual: " + usuarioAtual.getNome()
        );
    }
}
