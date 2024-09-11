package candidatura;
import java.util.concurrent.ThreadLocalRandom;
public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("Processo Seletivo");
        analisarCandidato(1900.0);
        analisarCandidato(2200.0);
        analisarCandidato(2000.0);     
        String[] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Mirela", "Daniela", "Jorge"};
        String[] candidatosSelecionados = selecaoCandidatos(candidatos);
        imprimirSelecionados(candidatosSelecionados);

    }

    public static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO RESULTADO DEMAIS CANDIDATO");
        }
    }

    public static String[] selecaoCandidatos(String[] candidatos) {
        int indiceSelecionados = 0;
        int indiceCandidatoAtual = 0;
        double salarioBase=2000.0;
        String[] candidatosSelecionados = new String[5];
        while (extracted(candidatos, indiceSelecionados, indiceCandidatoAtual)) {
            String candidato = candidatos[indiceCandidatoAtual];
            double salarioPretendido = valorPretendido();
            //System.out.println(salarioPretendido + " é o salário pretendido pelo " + candidato);
            if (salarioPretendido <= salarioBase) {
                //System.out.println("O candidato " + candidato + " foi selecionado para a entrevista.");
                candidatosSelecionados[indiceSelecionados] = candidato;
                indiceSelecionados++;
            }
            indiceCandidatoAtual++;
            }
        return candidatosSelecionados;
    }

    private static boolean extracted(String[] candidatos, int candidatosSelecionados, int indiceCandidatoAtual) {
        return candidatosSelecionados < 5 && indiceCandidatoAtual < candidatos.length;
    }

    public static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2100);
    }

    public static void imprimirSelecionados(String[] candidatos) {
        System.out.println("Imprimindo a lista de candidatos");
        for (String candidato : candidatos) {
            System.out.println("O candidato selecionado para a entrevista foi o " + candidato);
        }
    }
}
