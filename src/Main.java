
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cpf;
        int peso;
        int sumFirstDigit = 0;
        int sumSecondDigit = 0;
        int firstDigit = 0;
        int secondDigit = 0;

        System.out.println("Digite o cpf");
        cpf = sc.next();
        cpf = cpf.replaceAll("[^0-9]", "");

        try {
            peso = 10;

            for (int i = 0; i < 9; i++) {
                sumFirstDigit += Character.getNumericValue(cpf.charAt(i)) * peso--;
            }
            firstDigit = (sumFirstDigit * 10) % 11;

            firstDigit = (firstDigit == 10) ? 0 : firstDigit;

            
            peso = 11;

            for (int i = 0; i < 9; i++) {

                sumSecondDigit += Character.getNumericValue(cpf.charAt(i)) * peso--;
            }

            sumSecondDigit += firstDigit * peso;

            secondDigit = (sumSecondDigit * 10) % 11;

            secondDigit = (secondDigit == 10) ? 0 : secondDigit;

            if (firstDigit != Character.getNumericValue(cpf.charAt(9))
                    || secondDigit != Character.getNumericValue(cpf.charAt(10)) || cpf.length() != 11) {
                System.out.println("CPF INVÁLIDO");
            } else {
                System.out.println("CPF VÁLIDO");
            }
        } catch (Exception e) {
            System.out.println("Alguma coisa deu errado");

        }

        sc.close();
    }
}
