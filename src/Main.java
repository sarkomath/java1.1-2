public class Main {
    public static void main(String[] args) {
        // TODO: подставлять номер карты нужно сюда между двойными кавычками, без пробелов
        String number1 = "373999272365521";
        String number2 = "376190281873195";
        String number3 = "373028515166130";
        System.out.println(String.format("Result is %s", isValidCardNumber(number1) ? "OK" : "FAIL"));
        System.out.println(String.format("Result is %s", isValidCardNumber(number2) ? "OK" : "FAIL"));
        System.out.println(String.format("Result is %s", isValidCardNumber(number3) ? "OK" : "FAIL"));
    }

    public static boolean isValidCardNumber(String number) {
        if (number == null) {
            return false;
        }

        if (number.length() != 16) {
            return false;
        }

        long result = 0;
        for (int i = 0; i < number.length(); i++) {
            int digit;
            try {
                digit = Integer.parseInt(number.charAt(i) + "");
            } catch (NumberFormatException e) {
                return false;
            }

            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            result += digit;
        }

        return (result != 0) && (result % 10 == 0);
    }
}