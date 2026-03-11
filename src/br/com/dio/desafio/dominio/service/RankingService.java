package br.com.dio.desafio.dominio.service;

import br.com.dio.desafio.dominio.Dev;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class RankingService {

    public void mostrarRanking(Map<String, Dev> devs) {

        System.out.println("\n======= RANKING DE DEVS =======");

        List<Dev> ranking = devs.values().stream()
                .sorted(Comparator.comparingDouble(Dev::calcularTotalXp).reversed())
                .toList();

        if (ranking.isEmpty()) {
            System.out.println("Nenhum dev cadastrado.");
            return;
        }

        for (int i = 0; i < ranking.size(); i++) {
            Dev dev = ranking.get(i);

            System.out.println((i + 1) + "º "
                    + dev.getNome()
                    + " - XP: "
                    + dev.calcularTotalXp());
        }

        System.out.println("===============================");
    }
}
