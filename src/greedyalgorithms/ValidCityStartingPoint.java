package greedyalgorithms;

public class ValidCityStartingPoint {

    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {
        // Write your code here.
        int valAtCity = Integer.MAX_VALUE;
        int answer = 0;

        int fuelRemaining = 0;


        for (int j = 1; j <= distances.length; j++) {
            fuelRemaining += ((fuel[j - 1] * mpg) - distances[j - 1]);
            if (valAtCity > fuelRemaining) {
                valAtCity = fuelRemaining;
                answer = j;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] distances = {5, 25, 15, 10, 15};
        int[] fuels = {1, 2, 1, 0, 3};
        int mpg = 10;

        System.out.println(validStartingCity(distances, fuels, mpg));
    }
}
