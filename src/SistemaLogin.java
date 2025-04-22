import java.util.Random;
import java.util.Scanner;

public class SistemaLogin { //classe principal com a main

    public static String gerarCaptcha(int tamanho) { //metodo para gerar um captcha
        String chars = "ABCDEDFGHIJKLMNOPQRSTUVWXYZ123456789!@#$"; //caracteres permitidos no captcha
        Random random = new Random();
        StringBuilder codicoGeradoCaptcha = new StringBuilder();

        for (int i = 0; i < tamanho; i++) { //gera um captcha com caracteres aleatórios
            int indice = random.nextInt(chars.length());
            codicoGeradoCaptcha.append(chars.charAt(indice));
        }
        return codicoGeradoCaptcha.toString(); //retorna o captcha gerado
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Login login = Login.getInstancia(); //obtem a instancia unica da classe de login

        //credenciais setadas de exemplo para o login
        login.setCredencial("michel", "4321");

        System.out.println("===== Sistema de login =====");
        System.out.println("Digite seu nome de usuário: ");
        String usuario = scanner.nextLine();

        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine();

        String captcha = gerarCaptcha(6); //limita o tamanho do captcha
        System.out.println("O código gerado é: " + captcha);
        System.out.println("Digite o código para verificar se você não é um robô!");
        String captchaDigitado = scanner.nextLine();

        boolean loginBemSucedido = login.autenticar(usuario, senha, captcha, captchaDigitado); //tenta autenticar o usuario

        if (loginBemSucedido == true) { //da o resultado da tentativa de login
            System.out.println("Login realizado com sucesso!");
        } else {
            System.out.println("Falha no login!");
        }

    }

}
