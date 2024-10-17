import java.util.ArrayList;
import java.util.List;

public class Calculus {
  // Método para calcular a expressão
  public String calcularResultado(String expression) {
      String[] partsEx = expression.split(" ");
      List<String> partsList = new ArrayList<>();

      // Exibir partes da expressão
      System.out.printf(">> Expression Parts: [ | ");
      for (String part : partsEx) {
          System.out.printf(part + " | ");
          if (part.equals("π")) {
              partsList.add(Math.PI + "");
          } else if (part.equals("e")) {
              partsList.add(Math.E + "");
          } else {
              partsList.add(part);
          }
      }
      System.out.printf("]\n");

      // Primeiro, resolver ^, *, /
      for (int i = 0; i < partsList.size(); i++) {
          if (partsList.get(i).equals("^")) {
              double base = Double.parseDouble(partsList.get(i - 1));
              double exponent = Double.parseDouble(partsList.get(i + 1));
              double result = Math.pow(base, exponent);
              partsList.set(i - 1, String.valueOf(result));
              partsList.remove(i);
              partsList.remove(i);
              i--;
          }
      }

      for (int i = 0; i < partsList.size(); i++) {
          if (partsList.get(i).equals("*") || partsList.get(i).equals("/") || partsList.get(i).equals("÷")) {
              double left = Double.parseDouble(partsList.get(i - 1));
              double right = Double.parseDouble(partsList.get(i + 1));
              double result;
              if (partsList.get(i).equals("*")) {
                  result = left * right;
              } else {
                  if (right == 0) {
                      return ">> Error: Divisão por zero";
                  }
                  result = left / right;
              }
              partsList.set(i - 1, String.valueOf(result));
              partsList.remove(i);
              partsList.remove(i);
              i--;
          }
      }

      // Depois, resolver +, -
      double finalResult = Double.parseDouble(partsList.get(0));
      for (int i = 1; i < partsList.size(); i += 2) {
          String operator = partsList.get(i);
          double right = Double.parseDouble(partsList.get(i + 1));
          if (operator.equals("+")) {
              finalResult += right;
          } else if (operator.equals("-")) {
              finalResult -= right;
          }
      }

      return String.valueOf(finalResult);
  }
}
