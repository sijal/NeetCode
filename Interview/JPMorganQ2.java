public class JPMorganQ2 {
    //factors of 3 and 5 hackerrank question JPMorgan
    //https://github.com/lalik77/Factors-of-3-and-5-/blob/master/getIdealNums.java
    static long getIdealNums(long low, long high) // 3 and 5 as primitive factors
    {
        
        int count = 0; // counter 

        for (long i = low; i <= high; i++) {
            long num = i;

            // While num is divisible by 3, divide it by 3
            while (num % 3 == 0)
                num /= 3;

            // While num is divisible by 5, divide it by 5
            while (num % 5 == 0)
                num /= 5;

            // If num got reduced to 1 then it has
            // only 3 and 5 as prime factors
            if (num == 1)
                count++;
        }

        return count;
    }
// Second way

    static int exp(int base, long n) {

        // 2^3=8 , 2^x=8 -> x = ln8/ln2 , otherwise x=Math.log(8)/Math/log(2)

        return (int) ( Math.log(n)/Math.log(base) );
    }

    static long  getIdealNumber (long low,long high) {

        // low<= 3^exp3*5^exp5 <= high

        int exp3_Max= exp(3,high);
        int exp5_Max= exp(5,high);

        System.out.printf("Max exp3 (3^exp3_max) = %d , Max exp5(5^exp5_Max) = %d" , exp3_Max , exp5_Max );
        System.out.println(" ");


        int idealCounter=0;

        long n3=1L;


        for (int i=0;i<=exp3_Max;i++) {

            long n5=1l;
         
            for (int j=0;j<=exp5_Max;j++) {

                long num = n3*n5;
                System.out.printf("3^%d * 5^%d = %d%n", i, j, num);

                if (num>high) {
                    break ;
                }
                if (num>=low) {
                    System.out.println("---> " + num);
                    idealCounter++;
                }
                n5*=5;

            }
            n3*=3;
        }

        return idealCounter;



    }
}
