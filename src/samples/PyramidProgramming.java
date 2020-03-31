package samples;

import java.util.Scanner;

class Main {
    private static int prnLine(int h, String ip, int chCnt, boolean l2R, int s, int empSp) {
        StringBuilder temp = new StringBuilder();

        while (temp.length() < chCnt) temp.append(ip.charAt(s++ % ip.length()));

        for (int j = 0; j < h - empSp; j++) System.out.print(" ");

        System.out.print(l2R ? temp.toString() : temp.reverse().toString());
        System.out.println();

        return s;
    }

    private static void print(int h, String ip, boolean inv) {
        boolean l2R = true;
        int chCnt = inv ? (h * 2) - 1 : 1;
        int s = 0;

        for(int i = inv ? h : 0; inv ? i > 0: i < h;) {
            s = prnLine(h, ip, chCnt, l2R, s,  inv ? i : i+1);
            l2R = !l2R;

            if(!inv) {
                i++;
                chCnt += 2;
            }
            else{
                i--;
                chCnt -= 2;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.valueOf(scanner.nextLine());

        for (int i = 0; i < testCases; i++) {
            String ip = scanner.next();
            int h = scanner.nextInt();

            print(h, ip, scanner.nextInt() == -1 ? true : false);
        }

        scanner.close();
    }
}
