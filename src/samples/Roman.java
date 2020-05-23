package samples;

public class Roman {
    private static int getValue(char input) {
        switch(input) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }

    private static boolean canSubstract(char prev, char current) {
        switch(prev) {
            case 'I' : return (current == 'V' || current == 'X');
            case 'X' : return (current == 'L' || current == 'C');
            case 'C' : return (current == 'D' || current == 'M');
            default: return false;
        }
    }

    private static int convertToDecimal(String input) throws Exception {
        if(input == null || input.trim().length() == 0) {
            return 0;
        }

        int dCount = 0, lCount = 0, vCount = 0, iCount = 0, xCount = 0, cCount = 0, mCount = 0;
        int total = 0;
        int currentValue = 0;

        for(int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if(current == 'D') dCount++;
            if(current == 'L') lCount++;
            if(current == 'V') vCount++;

            if(current == 'I' && input.substring(i, i + 3) == "III") iCount++; else iCount = 0;
            if(current == 'X') xCount++; else xCount = 0;
            if(current == 'C') cCount++; else cCount = 0;
            if(current == 'M') mCount++; else mCount = 0;


            if(dCount > 1 || lCount > 1 || vCount > 1 || iCount > 3 || xCount > 3 || cCount > 3 || mCount > 3) {
                throw new Exception("invalid input");
            }

            currentValue = getValue(current);

            if(i > 0 && canSubstract(input.charAt(i - 1), current)) {
                total -= (getValue(input.charAt(i - 1)) * 2);
            }

            total += currentValue;
        }

        return total;
    }

    public static void main(String[] args) throws Exception {
        String input1 = "MMVI";

        System.out.println("for input = MMVI, output is :" + convertToDecimal(input1));

        String input2 = "MCMXLIV";

        System.out.println("for input = MCMXLIV, output is :" + convertToDecimal(input2));
    }
}
