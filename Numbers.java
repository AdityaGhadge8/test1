import java.util.Scanner;

class Cal{
    public int factorial(int num) {
        int result = 1;
        for (int i = num; i >= 1; i--) {
            result = result * i;
        }
        return result;
    }

    public int power(int num, int pow) {
        int result = 1;
        if (pow == 0) {
            return 1;
        }
        if (num == 0) {
            return 0;
        }

        for (int i = 1; i <= pow; i++) {
            result = result * num;
        }
        return result;
    }

    public void printFibonacci(int num) { // 0, 1, 1, 2, 3, 5, 8, 13, 21
        int a = 0;
        int b = 1;
        int c = 0;

        for (int i = 1; i < num; i++) {
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }
    }

    public void printPrime(int num) { // 2 3 5 7

        int icnt;
        for (int i = 2; i <= num; i++) {
            icnt = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    icnt++;
                    if (icnt > 2) {
                        break;
                    }
                }
            }
            if (icnt == 2) {
                System.out.println(i);
            }
        }
    }

    public int countDigits(int num)// 123
    {
        int temp = num;
        int icnt = 0;
        while (temp != 0) {
            icnt++;
            temp = temp / 10;
        }

        return icnt;
    }

    public int reverseDigit(int num)// 123
    {
        int temp = num;
        int rem = 0;
        int rev = 0;
        while (temp != 0) {
            rem = temp % 10;
            rev = rev * 10 + rem;
            temp = temp / 10;
        }
        return rev;
    }

    public void armstrongRange(int num) // 153| 1^3 + 5^3 + 3^3 = 153
    {
        int temp = 0;
        int rem = 0;
        int sum = 0;

        for (int i = 1; i <= num; i++) {
            temp = i;
            sum = 0;
            while (temp != 0) {
                rem = temp % 10;
                int pow = countDigits(i);
                sum = sum + power(rem, pow);
                temp = temp / 10;
            }
            if (sum == i) {
                System.out.println(i);
            }
        }
    }

    public void armstrongRangeIndividual(int num)// 153
    {
        int rem = 0;
        int sum = 0;
        int temp = 0;
        int icnt = 0;
        int pow = 1;

        for (int i = 1; i <= num; i++) {
            temp = i;
            sum = 0;
            icnt = 0;

            while (temp != 0) {
                temp = temp / 10; // 3
                icnt++;
            }
            temp = i;
            while (temp != 0) {
                rem = temp % 10; // 3
                pow = 1;
                for (int k = 1; k <= icnt; k++) {

                    pow = pow * rem;
                }
                sum = sum + pow;
                temp = temp / 10;
            }

            if (sum == i) {
                System.out.println(i);
            }

        }
    }

    public boolean checkLeapyear(int year) {
        boolean check = false;
        if (year % 400 == 0) {
            check = true;
        }
        if (year % 100 != 0 && year % 4 == 0) {
            check = true;
        }

        return check;
    }
}

public class Numbers {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Cal obj = new Cal();
        System.out.println("Choose an option:");
        System.out.println("1. Factorial");
        System.out.println("2. Power");
        System.out.println("3. Fibonachhi");
        System.out.println("4. Prime range");
        System.out.println("5. Count digits");
        System.out.println("6. Reverse number");
        System.out.println("7. Armstrong range");
        System.out.println("8. check leap year");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter a number to find its factorial:");
                int num = sc.nextInt();
                int factorialResult = obj.factorial(num);
                System.out.println("Factorial of " + num + " is " + factorialResult);
                break;
            case 2:
                System.out.println("Enter the base number:");
                int base = sc.nextInt();
                System.out.println("Enter the exponent:");
                int exponent = sc.nextInt();
                int powerResult = obj.power(base, exponent);
                System.out.println(base + " raised to the power of " + exponent + " is " + powerResult);
                break;
            case 3:
                System.out.println("Enter range for fibonachhi:");
                int num2 = sc.nextInt();
                obj.printFibonacci(num2);
                break;
            case 4:
                System.out.println("enter range for prime");
                num2 = sc.nextInt();
                obj.printPrime(num2);
                break;

            case 5:
                System.out.println("Enter number");
                num2 = sc.nextInt();
                System.out.println(obj.countDigits(num2));
                break;

            case 6:
                System.out.println("Enter number to reverse");
                num2 = sc.nextInt();
                System.out.println(obj.reverseDigit(num2));
                break;
            case 7:
                System.out.println("Enter numbber");
                num2 = sc.nextInt();
                obj.armstrongRangeIndividual(num2);
                break;
            case 8:
                System.out.println("Enter year");
                num2 = sc.nextInt();
                System.out.println(obj.checkLeapyear(num2));
                break;
            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}
