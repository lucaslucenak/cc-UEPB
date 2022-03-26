package br.com.springboot.airbnbanalyses.ordenationMethods;

import br.com.springboot.airbnbanalyses.app.AirBnbAnalysesApplication;
import br.com.springboot.airbnbanalyses.entities.AirBnbListings;
//import br.com.springboot.airbnbanalyses.ordenationAlgorithms.QuickSort;
import br.com.springboot.airbnbanalyses.ordenationAlgorithms.QuickSort_MedianaDe3;
import br.com.springboot.airbnbanalyses.ordenationAlgorithms.SelectionSort;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import static br.com.springboot.airbnbanalyses.app.CsvManipulation.writeAlgorithmsFiles;

public class QuickSort_MedianaDe3_Methods {
    public static double[] quickSortMD3_Prices(String pathMedioCaso, String pathMelhorCaso, String pathPiorCaso, Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights, Integer[] arrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvaiability365, String[] arrayName,
                                        String[] arrayHostName, String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] arrayRoomType, String[] arrayLastReview, Double[] arrayLatitude, Double[] arrayLongitude, Double[] arrayReviewsPerMonth, Integer a, Integer b) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException, ParseException {

        long initialTime_mediumCase, initialTime_bestCase, initialTime_worstCase, finalTime_mediumCase, finalTime_bestCase, finalTime_worstCase;
        double executionTime_mediumCase, executionTime_bestCase, executionTime_worstCase;
        double[] executionTimes = new double[3];

        initialTime_mediumCase = System.nanoTime();
        QuickSort_MedianaDe3.quickSortMD3Crescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365,
                arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, a, b);
        finalTime_mediumCase = System.nanoTime();
        executionTime_mediumCase = ((finalTime_mediumCase - initialTime_mediumCase) / 1000000d);
        executionTimes[0] = executionTime_mediumCase;

        writeAlgorithmsFiles(pathMedioCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);

        initialTime_bestCase = System.nanoTime();
        QuickSort_MedianaDe3.quickSortMD3Crescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365,
                arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, a, b);
        finalTime_bestCase = System.nanoTime();
        executionTime_bestCase = ((finalTime_bestCase - initialTime_bestCase) / 1000000d);
        executionTimes[1] = executionTime_bestCase;

        writeAlgorithmsFiles(pathMelhorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);
        SelectionSort.selectionSortDecrescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);

        initialTime_worstCase = System.nanoTime();
        QuickSort_MedianaDe3.quickSortMD3Crescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365,
                arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, a, b);
        finalTime_worstCase = System.nanoTime();
        executionTime_worstCase = ((finalTime_worstCase - initialTime_worstCase) / 1000000d);
        executionTimes[2] = executionTime_worstCase;

        writeAlgorithmsFiles(pathPiorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);

        return executionTimes;
    }

    public static double[] quickSortMD3_NumberOfReviews(String pathMedioCaso, String pathMelhorCaso, String pathPiorCaso, Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights, Integer[] arrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvaiability365, String[] arrayName,
                                               String[] arrayHostName, String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] arrayRoomType, String[] arrayLastReview, Double[] arrayLatitude, Double[] arrayLongitude, Double[] arrayReviewsPerMonth, Integer a, Integer b) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException, ParseException {

        long initialTime_mediumCase, initialTime_bestCase, initialTime_worstCase, finalTime_mediumCase, finalTime_bestCase, finalTime_worstCase;
        double executionTime_mediumCase, executionTime_bestCase, executionTime_worstCase;
        double[] executionTimes = new double[3];

        initialTime_mediumCase = System.nanoTime();
        QuickSort_MedianaDe3.quickSortMD3Crescent(arrayNumberOfReviews, arrayId, arrayHostId, arrayMinimumNights, arrayPrice, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, a, b);
        finalTime_mediumCase = System.nanoTime();
        executionTime_mediumCase = ((finalTime_mediumCase - initialTime_mediumCase) / 1000000d);
        executionTimes[0] = executionTime_mediumCase;

        writeAlgorithmsFiles(pathMedioCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);

        initialTime_bestCase = System.nanoTime();
        QuickSort_MedianaDe3.quickSortMD3Crescent(arrayNumberOfReviews, arrayId, arrayHostId, arrayMinimumNights, arrayPrice, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, a, b);
        finalTime_bestCase = System.nanoTime();
        executionTime_bestCase = ((finalTime_bestCase - initialTime_bestCase) / 1000000d);
        executionTimes[1] = executionTime_bestCase;

        writeAlgorithmsFiles(pathMelhorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);
        SelectionSort.selectionSortDecrescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);

        initialTime_worstCase = System.nanoTime();
        QuickSort_MedianaDe3.quickSortMD3Crescent(arrayNumberOfReviews, arrayId, arrayHostId, arrayMinimumNights, arrayPrice, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, a, b);
        finalTime_worstCase = System.nanoTime();
        executionTime_worstCase = ((finalTime_worstCase - initialTime_worstCase) / 1000000d);
        executionTimes[2] = executionTime_worstCase;

        writeAlgorithmsFiles(pathPiorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);

        return executionTimes;
    }

    public static double[] quickSortMD3_Names(String pathMedioCaso, String pathMelhorCaso, String pathPiorCaso, Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights, Integer[] arrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvaiability365, String[] arrayName,
                                          String[] arrayHostName, String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] arrayRoomType, String[] arrayLastReview, Double[] arrayLatitude, Double[] arrayLongitude, Double[] arrayReviewsPerMonth, Integer a, Integer b) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException, ParseException {

        long initialTime_mediumCase, initialTime_bestCase, initialTime_worstCase, finalTime_mediumCase, finalTime_bestCase, finalTime_worstCase;
        double executionTime_mediumCase, executionTime_bestCase, executionTime_worstCase;
        double[] executionTimes = new double[3];

        initialTime_mediumCase = System.nanoTime();
        QuickSort_MedianaDe3.quickSortMD3_Names(arrayName, arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, a, b);
        finalTime_mediumCase = System.nanoTime();
        executionTime_mediumCase = ((finalTime_mediumCase - initialTime_mediumCase) / 1000000d);
        executionTimes[0] = executionTime_mediumCase;

        writeAlgorithmsFiles(pathMedioCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);

        initialTime_bestCase = System.nanoTime();
        QuickSort_MedianaDe3.quickSortMD3_Names(arrayName, arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, a, b);
        finalTime_bestCase = System.nanoTime();
        executionTime_bestCase = ((finalTime_bestCase - initialTime_bestCase) / 1000000d);
        executionTimes[1] = executionTime_bestCase;

        writeAlgorithmsFiles(pathMelhorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);
        SelectionSort.selectionSortDecrescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);

        initialTime_worstCase = System.nanoTime();
        QuickSort_MedianaDe3.quickSortMD3_Names(arrayName, arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, a, b);
        finalTime_worstCase = System.nanoTime();
        executionTime_worstCase = ((finalTime_worstCase - initialTime_worstCase) / 1000000d);
        executionTimes[2] = executionTime_worstCase;

        writeAlgorithmsFiles(pathPiorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);

        return executionTimes;
    }
}
