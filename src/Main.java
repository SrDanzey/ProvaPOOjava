import visitante.VisitanteEntity;
import visitante.VisitanteService;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<VisitanteEntity> visitanteEntities = new ArrayList<>();
        VisitanteService visitanteService = new VisitanteService();
        int continua;

        do {
            VisitanteEntity visitante = new VisitanteEntity();

            visitante.setNome(JOptionPane.showInputDialog(null, "Informe seu nome"));
            visitante.setFone(JOptionPane.showInputDialog(null, "Informe o numero do telefone"));
            visitante.setCidade(JOptionPane.showInputDialog(null, "Informe a cidade que reside"));
            visitante.setSexo(JOptionPane.showInputDialog(null, "Informe o seu sexo M/F").toUpperCase());
            visitante.setProfissao(JOptionPane.showInputDialog(null, "Informe a sua profissão"));
            visitante.setAnoNascimento(JOptionPane.showInputDialog(null, "Informe a sua data de nascimento" +
                    "\nFormato da data: dd/MM/yyyy"));
            visitanteEntities.add(visitante);

            continua = JOptionPane.showConfirmDialog(null, "Deseja cadastrar mais um visitante?");

        } while(continua == 0);

        JOptionPane.showMessageDialog(null,
                "Total de visitantes: " + visitanteService.totalVisitante(visitanteEntities) + "\n" +
                        "Total de visitantes homens: " + visitanteService.totalVisitanteHomem(visitanteEntities) + "\n" +
                        "Total de visitantes mulheres: " + visitanteService.totalVisitanteMulher(visitanteEntities) + "\n" +
                        "Total de visitantes Homens em porcentual: " + visitanteService.totalVisitanteHomemPorcentual(visitanteEntities) + "\n" +
                        "Total de visitantes Mulher em porcentual: " + visitanteService.totalVisitanteMulherPorcentual(visitanteEntities) + "\n" +
                        "Total de visitantes Menores de idade: " + visitanteService.visitanteMenorDeIdade(visitanteEntities) + "\n");



    }



}
