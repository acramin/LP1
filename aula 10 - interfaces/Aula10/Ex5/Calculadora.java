package Ex5;

class Calculadora {
    public Calculadora() {
    }

    public String calcularResultado(String expressao) {
        String[] partes = expressao.split(" ");
        double resultadoParcial = Double.parseDouble(partes[0]);

        for (int i = 1; i < partes.length - 1; i += 2) {
            String operador = partes[i];
            double proximoNumero = Double.parseDouble(partes[i + 1]);

            switch (operador) {
                case "+":
                    resultadoParcial += proximoNumero;
                    break;
                case "-":
                    resultadoParcial -= proximoNumero;
                    break;
                case "*":
                    resultadoParcial *= proximoNumero;
                    break;
                case "/":
                    if (proximoNumero != 0) {
                        resultadoParcial /= proximoNumero;
                    } else {
                        return "Erro: Divisão por zero";
                    }
                    break;
                default:
                    return "0";
            }
        }

        return "" + resultadoParcial;
    }
}
