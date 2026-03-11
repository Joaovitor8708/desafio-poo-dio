import br.com.dio.desafio.dominio.*;
import br.com.dio.desafio.dominio.service.RankingService;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Dev> devs = new HashMap<>();
        RankingService rankingService = new RankingService();

        // Conteúdos do bootcamp
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Aprenda Java do zero");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JavaScript");
        curso2.setDescricao("Aprenda JS");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Tire dúvidas ao vivo");
        mentoria.setData(LocalDate.now());

        // Bootcamp
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Bootcamp focado em Java");

        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        int opcao = -1;

        while (opcao != 0) {

            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1 -> {
                    System.out.print("Nome do Dev: ");
                    String nome = scanner.nextLine();

                    Dev dev = new Dev();
                    dev.setNome(nome);

                    devs.put(nome, dev);

                    System.out.println("Dev criado com sucesso!");
                }

                case 2 -> {
                    System.out.print("Nome do Dev: ");
                    String nome = scanner.nextLine();

                    Dev dev = devs.get(nome);

                    if (dev != null) {
                        dev.inscreverBootcamp(bootcamp);
                        System.out.println("Dev inscrito no Bootcamp!");
                    } else {
                        System.out.println("Dev não encontrado.");
                    }
                }

                case 3 -> {
                    System.out.print("Nome do Dev: ");
                    String nome = scanner.nextLine();

                    Dev dev = devs.get(nome);

                    if (dev != null) {
                        dev.progredir();
                        System.out.println("Conteúdo concluído!");
                    } else {
                        System.out.println("Dev não encontrado.");
                    }
                }

                case 4 -> {
                    System.out.print("Nome do Dev: ");
                    String nome = scanner.nextLine();

                    Dev dev = devs.get(nome);

                    if (dev != null) {
                        System.out.println("Conteúdos inscritos:");
                        System.out.println(dev.getConteudosInscritos());
                    } else {
                        System.out.println("Dev não encontrado.");
                    }
                }

                case 5 -> {
                    System.out.print("Nome do Dev: ");
                    String nome = scanner.nextLine();

                    Dev dev = devs.get(nome);

                    if (dev != null) {
                        System.out.println("Conteúdos concluídos:");
                        System.out.println(dev.getConteudosConcluidos());
                    } else {
                        System.out.println("Dev não encontrado.");
                    }
                }

                case 6 -> {
                    System.out.print("Nome do Dev: ");
                    String nome = scanner.nextLine();

                    Dev dev = devs.get(nome);

                    if (dev != null) {
                        System.out.println("XP total: " + dev.calcularTotalXp());
                    } else {
                        System.out.println("Dev não encontrado.");
                    }
                }

                case 7 -> {
                    System.out.println("\nDevs cadastrados:");
                    devs.keySet().forEach(System.out::println);
                }

                case 8 -> rankingService.mostrarRanking(devs);

                case 0 -> System.out.println("Encerrando sistema...");

                default -> System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {

        System.out.println("\n=========== BOOTCAMP JAVA ===========");
        System.out.println("1 - Criar Dev");
        System.out.println("2 - Inscrever Dev no Bootcamp");
        System.out.println("3 - Progredir conteúdo");
        System.out.println("4 - Ver conteúdos inscritos");
        System.out.println("5 - Ver conteúdos concluídos");
        System.out.println("6 - Ver XP do Dev");
        System.out.println("7 - Listar Devs cadastrados");
        System.out.println("8 - Ver ranking de Devs");
        System.out.println("0 - Sair");
        System.out.println("=====================================");
        System.out.print("Escolha uma opção: ");
    }
}