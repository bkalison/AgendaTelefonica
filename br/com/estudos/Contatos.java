package br.com.estudos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contatos {
    static Scanner s = new Scanner(System.in);

    private static List<Contatos> contatos = new ArrayList<>();
    private String nome;
    private String sobrenome;
    private String telefone;

    public Contatos(String nome,  String sobrenome, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;

    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone.trim();
    }

    public void create() {
        System.out.println("Digite o Primeiro nome do contato");
        String nome = s.next();
        System.out.println("Digite o sobrenome do contato");
        String sobrenome = s.next();
        System.out.println("Digite o Telefone");
        String telefone = validateTelefone();

        if (nome.isEmpty() || sobrenome.isEmpty() || telefone.isEmpty()) {
            System.out.println("ERRO, CAMPOS INVALIDOS");
            return;
        }

        Contatos contato = new Contatos(nome, sobrenome, telefone);
        contatos.add(contato);
        System.out.println("Nome :" + nome + " " + sobrenome + '\n' +"Telefone :" + telefone);
        System.out.println("Criado com sucesso !");
    }

    private static String validateTelefone() {
        String telefone = s.next();

        // Remover espaços em branco no início e no final
        telefone = telefone.trim();

        // Padrão para aceitar apenas números e '()'
        Pattern pattern = Pattern.compile("[()0-9]+");
        Matcher matcher = pattern.matcher(telefone);

        // Se a entrada não corresponder ao padrão, solicite novamente
        while (!matcher.matches()) {
            System.out.println("Formato de telefone inválido. Digite novamente: ");
            telefone = s.nextLine().trim();
            matcher = pattern.matcher(telefone);
        }

        return telefone;
    }

    public void remove() {

        System.out.println("Qual contato deseja remover :");
        int index = s.nextInt();
        if (index >= 0 && index < contatos.size()) {
            contatos.remove(index);
            System.out.println("Removido com sucesso!");
        } else {
            System.out.println("Índice inválido. Contato não removido.");
        }
    }

    public void imprime() {
        for (int i = 0; i < contatos.size(); i++) {
            System.out.println("Índice: " + i + " - " + contatos.get(i));
        }
    }

    public static void visualizaContato() {
        System.out.println("Digite qual contato deseja visualizar :");
        int index = s.nextInt();

        if (index >= 0 && index < contatos.size()) {
            Contatos contato = contatos.get(index);
            System.out.println(contato);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione qual você deseja editar:");
        for (int i = 0; i < contatos.size(); i++) {
            System.out.println("============"+ '\n'+ "Índice: " + i +  '\n' + contatos.get(i) + '\n'+ "============" );
        }

        System.out.print("Digite o índice do contato que deseja editar: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < contatos.size()) {
            Contatos contato = contatos.get(index);
            System.out.print("Novo nome: ");
            String novoNome = scanner.next();
            System.out.println("Novo sobrenome: ");
            String novoSobrenome = scanner.next();
            System.out.print("Novo telefone: ");
            String novoTelefone = scanner.next();

            contato.setNome(novoNome);
            contato.setSobrenome(novoSobrenome);
            contato.setTelefone(novoTelefone.trim());

            System.out.println("Contato editado com sucesso!");
        } else {
            System.out.println("Índice inválido. Contato não editado.");
        }
    }


    public static void pesquisa() {
        boolean encontrado = false;
        Scanner s = new Scanner(System.in);

        System.out.println("Digite o nome do contato :");
        String nome = s.next();

        for (Contatos contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                System.out.println(contato);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum contato encontrado com o nome: " + nome);
        }
    }

    @Override
    public String toString() {
        return "Nome : " + this.nome + '\n' +
                "Telefone : " + this.telefone;
    }
}