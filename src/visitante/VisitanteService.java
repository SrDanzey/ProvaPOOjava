package visitante;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class VisitanteService {

    public int totalVisitante(ArrayList<VisitanteEntity> visitantes){
        return visitantes.size();
    }

    public int totalVisitanteHomem(ArrayList<VisitanteEntity> visitantes){
        int i = 0;
        for (VisitanteEntity visitante: visitantes) {
            if(visitante.getSexo().equals("M")) i++;
        }
        return i;
    }

    public int totalVisitanteMulher(ArrayList<VisitanteEntity> visitantes){
        int i = 0;
        for (VisitanteEntity visitante: visitantes) {
            if(visitante.getSexo().equals("F")) i++;
        }
        return i;
    }

    public String totalVisitanteHomemPorcentual(ArrayList<VisitanteEntity> visitantes){
        int totalVisitante = totalVisitante(visitantes);
        int totalHomem = totalVisitanteHomem(visitantes);

        return ((totalHomem*100)/totalVisitante) + "%";
    }

    public String totalVisitanteMulherPorcentual(ArrayList<VisitanteEntity> visitantes){
        int totalVisitante = totalVisitante(visitantes);
        int totalMulher = totalVisitanteMulher(visitantes);

        return ((totalMulher*100)/totalVisitante) + "%";
    }

    public int visitanteMenorDeIdade(ArrayList<VisitanteEntity> visitantes){
        int i = 0;
        for (VisitanteEntity visitante: visitantes) {
            if (calculaIdade(visitante.getAnoNascimento())<18) i++;
        }
        return i;
    }

    public int calculaIdade(String dataNascimento){
        int idade = 0;
        Calendar formatNascimento = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            formatNascimento.setTime(sdf.parse(dataNascimento));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        idade = today.get(Calendar.YEAR) - formatNascimento.get(Calendar.YEAR);
        if (formatNascimento.get(Calendar.MONTH) > today.get(Calendar.MONTH)) {
            idade--;
        } else{
            if ((formatNascimento.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH)) && (formatNascimento.get(Calendar.MONTH) == today.get(Calendar.MONTH))){
                idade--;
            };
        }
        return idade;
    }
}
