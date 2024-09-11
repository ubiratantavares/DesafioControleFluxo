package candidatura;
import java.util.concurrent.ThreadLocalRandom;
public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("Processo Seletivo");
        analisarCandidato(1900.0);
        analisarCandidato(2200.0);
        analisarCandidato(2000.0);     
        String[] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Mirela", "Daniela", "Jorge"};
        selecaoCandidatos(candidatos);

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

    public static void selecaoCandidatos(String[] candidatos) {
        int candidatosSelecionados = 0;
        int indiceCandidatoAtual = 0;
        double salarioBase=2000.0;
        while (extracted(candidatos, candidatosSelecionados, indiceCandidatoAtual)) {
            String candidato = candidatos[indiceCandidatoAtual];
            double salarioPretendido = valorPretendido();
            //System.out.println(salarioPretendido + " é o salário pretendido pelo " + candidato);
            if (salarioPretendido <= salarioBase) {
                System.out.println("O candidato " + candidato + " foi selecionado para a entrevista.");
                candidatosSelecionados++;
            }
            indiceCandidatoAtual++;
            }
    }

    private static boolean extracted(String[] candidatos, int candidatosSelecionados, int indiceCandidatoAtual) {
        return candidatosSelecionados < 5 && indiceCandidatoAtual < candidatos.length;
    }

    public static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
}
