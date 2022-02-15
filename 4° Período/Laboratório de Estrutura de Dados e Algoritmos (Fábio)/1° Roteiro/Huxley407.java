import java.util.*;
import java.util.function.*;

public class HuxleyCode {
    public static void main(String[] args) {
        List<Integer[]> entradaDados = new ArrayList<>();
        List<Integer> saidaDados = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        Integer[] recive;

        while(entrada.hasNext()){
            recive = new Integer[] {
                    entrada.nextInt(), entrada.nextInt()
            };
            entradaDados.add(recive);
        }
        entrada.close();

        UnaryOperator<Integer> funcao = (n) -> {
            if(n % 2 == 0) {
                return n / 2;
            }
            return (n * 3) + 1;
        };

        Consumer<Integer[]> outputFinal = (n) -> {
            int numMax = 0, num = 1;

            for(int i = Math.min(n[0], n[1]); i <= Math.max(n[0], n[1]); i++) {
                int j = i;

                while(j > 1) {
                    num++;
                    j = funcao.apply(j);
                }

                if (num > numMax) {
                    numMax = num;
                }

                num = 1;
            }
            saidaDados.add(numMax);
        };
        entradaDados.forEach(outputFinal);

        for(int i = 0; i < entradaDados.size(); i++) {
            System.out.printf("%d %d %d\n", entradaDados.get(i)[0], entradaDados.get(i)[1], saidaDados.get(i));
        }
    }
}