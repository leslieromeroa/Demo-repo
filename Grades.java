public class Students {
    public static void main(String[] args) {
        int[][] grades = {
            {90, 78, 96, 98},
            {78, 90, 78, 88},
            {90, 80, 85, 91}
        };

        calculateStudentAverages(grades);
        calculateSubjectAverages(grades);
    }

    public static void calculateStudentAverages(int[][] grades) {
        System.out.println("Average per student:");
        for (int i = 0; i < grades.length; i++) {
            int sum = 0;
            for (int j = 0; j < grades[i].length; j++) {
                sum += grades[i][j];
            }
            double average = (double) sum / grades[i].length;
            System.out.println("Students " + (i + 1) + ": " + average);
        }
    }

    public static void calculateSubjectAverages(int[][] grades) {
        System.out.println("Average per subject:");
        int subjects = grades[0].length;
        for (int j = 0; j < subjects; j++) {
            int sum = 0;
            for (int i = 0; i < grades.length; i++) {
                sum += grades[i][j];
            }
            double average = (double) sum / grades.length;
            System.out.println("Materia " + (j + 1) + ": " + average);
        }
    }
}
