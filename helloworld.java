import java.util.Scanner;

public class helloworld {

    static Scanner scan = new Scanner(System.in);

    static int arrSize;
    static int dimension;

    static double array[];
    static double arrDis1[];
    static double arrDist2[];

    public static void main() {

        while(true){
            guzelYazi("\n=== HIGH SCHOOL MENU ===\n", 25);
            guzelYazi("[1] Statistical Information about an Array\n", 25);
            guzelYazi("[2] Distance Between Two Arrays\n", 25);
            guzelYazi("[3] Exit Program\n", 25);
            guzelYazi("Please select an option: ", 25);

            if(!scan.hasNextInt()){
                guzelYazi("\nInvalid input ! Please enter a number (1, 2 or 3).\n", 27);
                scan.nextLine();
                continue;
            }

            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    option1Yazilar();
                    break;
                case 2:
                    option2();
                    break;
                case 3:
                    guzelYazi("\nProgram terminated by the user. Goodbye!\n", 27);
                default:
                    guzelYazi("\nInvalid choice! Please select 1, 2, or 3.\n", 25);
            }
        }
    }

public static int safeIntInput(String message) {
    while (true) {
        guzelYazi(message, 27);
        if (scan.hasNextInt()) {
            return scan.nextInt();
        } else {
            guzelYazi("\nInvalid input! Please enter an integer.\n", 27);
            scan.next(); 
        }
    }
}

public static double safeDoubleInput(String message) {
    while (true) {
        guzelYazi(message, 27);
        if (scan.hasNextDouble()) {
            return scan.nextDouble();
        } else {
            guzelYazi("\nInvalid input! Please enter a numeric value.\n", 27);
            scan.next();
        }
    }
}
        

    public static void option1Yazilar() {
        arrSize = safeIntInput("Please specify the array size: ");

        if (arrSize == 0) {
            guzelYazi("Array is empty. Please enter elements first.", 27);
            return;
        }

        array = new double[arrSize];

        for (int i = 1; i < arrSize + 1; i++) {
            array[i-1] = safeDoubleInput("Enter element " + i + ": ");
        }

        guzelYazi("The given array's elements: ", 27);
        for (int i = 0; i < arrSize; i++) {
            if(i != arrSize-1){
                System.out.print(array[i] + ", ");
            }else{
                System.out.println(array[i]);
            }
        }
        guzelYazi("Here are the median, arithmetic mean, geometric mean, and harmonic mean for the given array: \n", 27);
        guzelYazi("Median: " + findMedian() + "\n", 27);
        guzelYazi("Arithmetic Mean: " + arithmeticMean() + "\n", 27);
        if(geometricMean() == 0){
            guzelYazi("Geometric mean is undefined for non-positive numbers.\n", 27);
        }else{
            guzelYazi("Geometric Mean: " + geometricMean() + "\n", 27);
        }
        guzelYazi("Harmonic Mean: " + harmonicMean() + "\n", 27);
    }

    public static double findMedian(){
        double simdilikArr[] = new double[arrSize];

        for(int i=0;i<arrSize;i++){
            simdilikArr[i] = array[i];
        }
        sortYap(simdilikArr);

        double median;
        if(arrSize % 2 == 0){
            median = simdilikArr[arrSize/2];
        }else{
            median = (array[arrSize / 2 - 1] + array[arrSize / 2]) / 2;
        }
        return median;
    }

    public static void sortYap(double arr[]){
        for (int i = 0; i < arrSize - 1; i++) {
            for (int j = i + 1; j < arrSize; j++) {
                if (array[i] > array[j]) {
                    double temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static double arithmeticMean() {
        double sum = 0;

        for (int i = 0; i < arrSize; i++) {
            sum += array[i];
        }

        double mean = sum / arrSize;
        return mean; 
    }


    public static double geometricMean() {
        double product = 1.0;
        boolean invalid = false;

        for (int i = 0; i < arrSize; i++) {
            if (array[i] <= 0) {
                invalid = true;
                break;
            }
            product *= array[i];
        }

        if (invalid) {
            return 0;
        }

        return Math.pow(product, 1.0 / arrSize);
    }


    public static double harmonicMean() {
        double reciprocalSum = harmonicSumRecursive(0);  
        return arrSize / reciprocalSum;  
    }

    private static double harmonicSumRecursive(int index) {
        if (index == arrSize - 1) {
            return 1.0 / array[index];
        }
        return (1.0 / array[index]) + harmonicSumRecursive(index + 1);
    }

    public static void guzelYazi(String text, int delay) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    

    public static void option2(){
        dimension = safeIntInput("Please enter the dimension: ");

        arrDis1 = new double[dimension];
        arrDist2 = new double[dimension];

        guzelYazi("Please enter the elements for the FIRST array \n", 27);
        for(int i=1;i<dimension+1;i++){
            double value = safeDoubleInput("Enter element " + i + " (0-9): ");

            if(value > 9 || value < 0){
                guzelYazi("Invalid value! Please enter value between 0-9. \n", 27);
                i--;
                continue;
            }
            arrDis1[i-1] = value;
        }

        guzelYazi("Please enter the elements for the SECOND array \n", 27);
        for(int i=1;i<dimension+1;i++){
            double value = safeDoubleInput("Enter element " + i + " (0-9): ");

            if(value > 9 || value < 0){
                guzelYazi("Invalid value! Please enter value between 0-9. \n", 27);
                i--;
                continue;
            }
            arrDist2[i-1] = value;
        }

        guzelYazi("First array's elements: ", 27);
        for (int i = 0; i < dimension; i++) {
            if (i != dimension - 1){
                guzelYazi(arrDis1[i] + ", ", 27);
            }else{
                guzelYazi(arrDis1[i] + "\n", 27);
            }    
        }


        guzelYazi("Second array's elements: ", 27);
        for(int i=0;i<dimension;i++){
            if(i != dimension-1){
                guzelYazi(arrDist2[i] + ", ", 27);
            }else{
                guzelYazi(arrDist2[i] + "", 27);
            }
        }
        System.out.println();

        double mDistance = manhattanDistance(arrDist2, arrDis1);
        double eDistance = euclideanDistance(arrDist2, arrDis1);
        double cSimilarity = cosineSimilarity(arrDist2, arrDis1);

        guzelYazi(" \n", 27);
        guzelYazi("Manhattan Distance: " + mDistance + "\n", 27);
        guzelYazi("Euclidean Distance: " + eDistance + "\n", 27);
        if(cSimilarity == 0){
            guzelYazi("Cosine similarity undefined — one of the vectors has zero length.\n", 27);
        }else{
            guzelYazi("Cosine Similarity: " + cSimilarity + "\n", 27);
        }
    }

    public static double manhattanDistance(double arr1[], double arr2[]){
        double sum = 0;
        
        for(int i=0;i<arr1.length;i++){
            double diff = arr1[i] - arr2[i];
            if(diff < 0){
                diff = -diff;
            }
            sum += diff;
        }
        return sum;
    }

    public static double euclideanDistance(double arr1[], double arr2[]){
        double sumSquare = 0;
        for(int i=0;i<arr1.length;i++){
            double diff = arr1[i] - arr2[i];
            sumSquare += diff * diff; //pifaqor gibi dusun bunu
        }

        double x = sumSquare;
        double root = sumSquare/2;

        for(int i=0;i<20;i++){ //her iterasyon cevaba dahada yaklastiriyor
            root = (root+x/root)/2;
        }
  
        return root;
    }

    public static double cosineSimilarity(double[] a, double[] b) {
        double dot = 0.0;
        double normA = 0.0;
        double normB = 0.0;

        for (int i = 0; i < a.length; i++) {
            dot += a[i] * b[i];          // dot productu buluyor
            normA += a[i] * a[i];
            normB += b[i] * b[i];
        }

        double magnitudeA = Math.sqrt(normA);
        double magnitudeB = Math.sqrt(normB);

        if (magnitudeA == 0 || magnitudeB == 0) {
            return 0;
        }

        return dot / (magnitudeA * magnitudeB);
    }
}

