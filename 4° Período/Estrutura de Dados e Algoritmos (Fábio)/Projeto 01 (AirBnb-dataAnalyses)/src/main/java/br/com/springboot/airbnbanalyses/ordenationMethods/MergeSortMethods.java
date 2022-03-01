package br.com.springboot.airbnbanalyses.ordenationMethods;

import br.com.springboot.airbnbanalyses.ordenationAlgorithms.MergeSort;
import br.com.springboot.airbnbanalyses.ordenationAlgorithms.SelectionSort;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.text.ParseException;

import static br.com.springboot.airbnbanalyses.app.CsvManipulation.writeAlgorithmsFiles;

public class MergeSortMethods {
    public static double[] mergeSort_Prices(String pathMedioCaso, String pathMelhorCaso, String pathPiorCaso, Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights,
                                        Integer[] arrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvailability365, String[] arrayName, String[] arrayHostName,
                                        String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] arrayRoomType, String[] arrayLastReview,
                                        Double[] arrayLatitude, Double[] arrayLongitude, Double[] arrayReviewsPerMonth, Integer ini, Integer fim) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException, ParseException {

        long initialTime_mediumCase, initialTime_bestCase, initialTime_worstCase, finalTime_mediumCase, finalTime_bestCase, finalTime_worstCase;
        double executionTime_mediumCase, executionTime_bestCase, executionTime_worstCase;
        double[] executionTimes = new double[3];

        String[] auxArrayName = new String[arrayName.length];
        Integer[] auxArrayPrice = new Integer[arrayPrice.length];
        Integer[] auxArrayId = new Integer[arrayId.length];
        Integer[] auxArrayHostId = new Integer[arrayHostId.length];
        Integer[] auxArrayMinimumNights = new Integer[arrayMinimumNights.length];
        Integer[] auxArrayNumberOfReviews = new Integer[arrayNumberOfReviews.length];
        Integer[] auxArrayCalculatedHostListingsCount = new Integer[arrayCalculatedHostListingsCount.length];
        Integer[] auxArrayAvailability365 = new Integer[arrayAvailability365.length];
        String[] auxArrayHostName = new String[arrayHostName.length];
        String[] auxArrayNeighbourhoodGroup = new String[arrayNeighbourhoodGroup.length];
        String[] auxArrayNeighbourhood = new String[arrayNeighbourhood.length];
        String[] auxArrayRoomType = new String[arrayRoomType.length];
        String[] auxArrayLastReview = new String[arrayLastReview.length];
        Double[] auxArrayLatitude = new Double[arrayLatitude.length];
        Double[] auxArrayLongitude = new Double[arrayLongitude.length];
        Double[] auxArrayReviewsPerMonth = new Double[arrayReviewsPerMonth.length];

        initialTime_mediumCase = System.nanoTime();
        MergeSort.mergeSortCrescent(arrayPrice, auxArrayPrice, arrayId, auxArrayId, arrayHostId, auxArrayHostId,
            arrayMinimumNights, auxArrayMinimumNights, arrayNumberOfReviews, auxArrayNumberOfReviews,
            arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount, arrayAvailability365,
            auxArrayAvailability365, arrayName, auxArrayName, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup,
            auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood, arrayRoomType, auxArrayRoomType,
            arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude,
            arrayReviewsPerMonth, auxArrayReviewsPerMonth, ini, fim);
        finalTime_mediumCase = System.nanoTime();
        executionTime_mediumCase = ((finalTime_mediumCase - initialTime_mediumCase) / 1000000d);
        executionTimes[0] = executionTime_mediumCase;

        writeAlgorithmsFiles(pathMedioCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvailability365);

        initialTime_bestCase = System.nanoTime();
        MergeSort.mergeSortCrescent(arrayPrice, auxArrayPrice, arrayId, auxArrayId, arrayHostId, auxArrayHostId,
            arrayMinimumNights, auxArrayMinimumNights, arrayNumberOfReviews, auxArrayNumberOfReviews,
            arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount, arrayAvailability365,
            auxArrayAvailability365, arrayName, auxArrayName, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup,
            auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood, arrayRoomType, auxArrayRoomType,
            arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude,
            arrayReviewsPerMonth, auxArrayReviewsPerMonth, ini, fim);
        finalTime_bestCase = System.nanoTime();
        executionTime_bestCase = ((finalTime_bestCase - initialTime_bestCase) / 1000000d);
        executionTimes[1] = executionTime_bestCase;

        writeAlgorithmsFiles(pathMelhorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvailability365);
        SelectionSort.selectionSortDecrescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvailability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);

        initialTime_worstCase = System.nanoTime();
        MergeSort.mergeSortCrescent(arrayPrice, auxArrayPrice, arrayId, auxArrayId, arrayHostId, auxArrayHostId,
            arrayMinimumNights, auxArrayMinimumNights, arrayNumberOfReviews, auxArrayNumberOfReviews,
            arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount, arrayAvailability365,
            auxArrayAvailability365, arrayName, auxArrayName, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup,
            auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood, arrayRoomType, auxArrayRoomType,
            arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude,
            arrayReviewsPerMonth, auxArrayReviewsPerMonth, ini, fim);
        finalTime_worstCase = System.nanoTime();
        executionTime_worstCase = ((finalTime_worstCase - initialTime_worstCase) / 1000000d);
        executionTimes[2] = executionTime_worstCase;

        writeAlgorithmsFiles(pathPiorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvailability365);

        return executionTimes;
    }

    public static double[] mergeSort_NumberOfReviews(String pathMedioCaso, String pathMelhorCaso, String pathPiorCaso, Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights,
                                        Integer[] arrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvailability365, String[] arrayName, String[] arrayHostName,
                                        String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] arrayRoomType, String[] arrayLastReview,
                                        Double[] arrayLatitude, Double[] arrayLongitude, Double[] arrayReviewsPerMonth, Integer ini, Integer fim) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException, ParseException {

        long initialTime_mediumCase, initialTime_bestCase, initialTime_worstCase, finalTime_mediumCase, finalTime_bestCase, finalTime_worstCase;
        double executionTime_mediumCase, executionTime_bestCase, executionTime_worstCase;
        double[] executionTimes = new double[3];

        String[] auxArrayName = new String[arrayName.length];
        Integer[] auxArrayPrice = new Integer[arrayPrice.length];
        Integer[] auxArrayId = new Integer[arrayId.length];
        Integer[] auxArrayHostId = new Integer[arrayHostId.length];
        Integer[] auxArrayMinimumNights = new Integer[arrayMinimumNights.length];
        Integer[] auxArrayNumberOfReviews = new Integer[arrayNumberOfReviews.length];
        Integer[] auxArrayCalculatedHostListingsCount = new Integer[arrayCalculatedHostListingsCount.length];
        Integer[] auxArrayAvailability365 = new Integer[arrayAvailability365.length];
        String[] auxArrayHostName = new String[arrayHostName.length];
        String[] auxArrayNeighbourhoodGroup = new String[arrayNeighbourhoodGroup.length];
        String[] auxArrayNeighbourhood = new String[arrayNeighbourhood.length];
        String[] auxArrayRoomType = new String[arrayRoomType.length];
        String[] auxArrayLastReview = new String[arrayLastReview.length];
        Double[] auxArrayLatitude = new Double[arrayLatitude.length];
        Double[] auxArrayLongitude = new Double[arrayLongitude.length];
        Double[] auxArrayReviewsPerMonth = new Double[arrayReviewsPerMonth.length];

        initialTime_mediumCase = System.nanoTime();
        MergeSort.mergeSortCrescent(arrayNumberOfReviews, auxArrayNumberOfReviews, arrayId, auxArrayId, arrayHostId, auxArrayHostId,
                arrayMinimumNights, auxArrayMinimumNights, arrayPrice, auxArrayPrice,
                arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount, arrayAvailability365,
                auxArrayAvailability365, arrayName, auxArrayName, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup,
                auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood, arrayRoomType, auxArrayRoomType,
                arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude,
                arrayReviewsPerMonth, auxArrayReviewsPerMonth, ini, fim);
        finalTime_mediumCase = System.nanoTime();
        executionTime_mediumCase = ((finalTime_mediumCase - initialTime_mediumCase) / 1000000d);
        executionTimes[0] = executionTime_mediumCase;

        writeAlgorithmsFiles(pathMedioCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvailability365);

        initialTime_bestCase = System.nanoTime();
        MergeSort.mergeSortCrescent(arrayNumberOfReviews, auxArrayNumberOfReviews, arrayId, auxArrayId, arrayHostId, auxArrayHostId,
                arrayMinimumNights, auxArrayMinimumNights, arrayPrice, auxArrayPrice,
                arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount, arrayAvailability365,
                auxArrayAvailability365, arrayName, auxArrayName, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup,
                auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood, arrayRoomType, auxArrayRoomType,
                arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude,
                arrayReviewsPerMonth, auxArrayReviewsPerMonth, ini, fim);
        finalTime_bestCase = System.nanoTime();
        executionTime_bestCase = ((finalTime_bestCase - initialTime_bestCase) / 1000000d);
        executionTimes[1] = executionTime_bestCase;

        writeAlgorithmsFiles(pathMelhorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvailability365);
        SelectionSort.selectionSortDecrescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvailability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);

        initialTime_worstCase = System.nanoTime();
        MergeSort.mergeSortCrescent(arrayNumberOfReviews, auxArrayNumberOfReviews, arrayId, auxArrayId, arrayHostId, auxArrayHostId,
                arrayMinimumNights, auxArrayMinimumNights, arrayPrice, auxArrayPrice,
                arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount, arrayAvailability365,
                auxArrayAvailability365, arrayName, auxArrayName, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup,
                auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood, arrayRoomType, auxArrayRoomType,
                arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude,
                arrayReviewsPerMonth, auxArrayReviewsPerMonth, ini, fim);
        finalTime_worstCase = System.nanoTime();
        executionTime_worstCase = ((finalTime_worstCase - initialTime_worstCase) / 1000000d);
        executionTimes[2] = executionTime_worstCase;

        writeAlgorithmsFiles(pathPiorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvailability365);

        return executionTimes;
    }

    public static double[] mergeSort_Names(String pathMedioCaso, String pathMelhorCaso, String pathPiorCaso, String[] arrayName, Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights, Integer[] arrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvailability365 ,
                                       String[] arrayHostName, String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] arrayRoomType, String[] arrayLastReview, Double[] arrayLatitude, Double[] arrayLongitude, Double[] arrayReviewsPerMonth, Integer ini, Integer fim) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException, ParseException {

        String[] auxArrayName = new String[arrayName.length];
        Integer[] auxArrayPrice = new Integer[arrayPrice.length];
        Integer[] auxArrayId = new Integer[arrayId.length];
        Integer[] auxArrayHostId = new Integer[arrayHostId.length];
        Integer[] auxArrayMinimumNights = new Integer[arrayMinimumNights.length];
        Integer[] auxArrayNumberOfReviews = new Integer[arrayNumberOfReviews.length];
        Integer[] auxArrayCalculatedHostListingsCount = new Integer[arrayCalculatedHostListingsCount.length];
        Integer[] auxArrayAvailability365 = new Integer[arrayAvailability365.length];
        String[] auxArrayHostName = new String[arrayHostName.length];
        String[] auxArrayNeighbourhoodGroup = new String[arrayNeighbourhoodGroup.length];
        String[] auxArrayNeighbourhood = new String[arrayNeighbourhood.length];
        String[] auxArrayRoomType = new String[arrayRoomType.length];
        String[] auxArrayLastReview = new String[arrayLastReview.length];
        Double[] auxArrayLatitude = new Double[arrayLatitude.length];
        Double[] auxArrayLongitude = new Double[arrayLongitude.length];
        Double[] auxArrayReviewsPerMonth = new Double[arrayReviewsPerMonth.length];

        long initialTime_mediumCase, initialTime_bestCase, initialTime_worstCase, finalTime_mediumCase, finalTime_bestCase, finalTime_worstCase;
        double executionTime_mediumCase, executionTime_bestCase, executionTime_worstCase;
        double[] executionTimes = new double[3];

        initialTime_mediumCase = System.nanoTime();
        MergeSort.mergeSortCrescent_Names(arrayName, auxArrayName, arrayPrice, auxArrayPrice, arrayId, auxArrayId,
                arrayHostId, auxArrayHostId, arrayMinimumNights, auxArrayMinimumNights, arrayNumberOfReviews,
                auxArrayNumberOfReviews, arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount,
                arrayAvailability365, auxArrayAvailability365, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup,
                auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood,  arrayRoomType, auxArrayRoomType,
                arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude, arrayReviewsPerMonth, auxArrayReviewsPerMonth, 0, arrayName.length-1);
        finalTime_mediumCase = System.nanoTime();
        executionTime_mediumCase = ((finalTime_mediumCase - initialTime_mediumCase) / 1000000d);
        executionTimes[0] = executionTime_mediumCase;

        writeAlgorithmsFiles(pathMedioCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvailability365);

        initialTime_bestCase = System.nanoTime();
        MergeSort.mergeSortCrescent_Names(arrayName, auxArrayName, arrayPrice, auxArrayPrice, arrayId, auxArrayId,
                arrayHostId, auxArrayHostId, arrayMinimumNights, auxArrayMinimumNights, arrayNumberOfReviews,
                auxArrayNumberOfReviews, arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount,
                arrayAvailability365, auxArrayAvailability365, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup,
                auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood,  arrayRoomType, auxArrayRoomType,
                arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude, arrayReviewsPerMonth, auxArrayReviewsPerMonth, 0, arrayName.length-1);
        finalTime_bestCase = System.nanoTime();
        executionTime_bestCase = ((finalTime_bestCase - initialTime_bestCase) / 1000000d);
        executionTimes[1] = executionTime_bestCase;

        writeAlgorithmsFiles(pathMelhorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvailability365);
        SelectionSort.selectionSortDecrescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvailability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);

        initialTime_worstCase = System.nanoTime();
        MergeSort.mergeSortCrescent_Names(arrayName, auxArrayName, arrayPrice, auxArrayPrice, arrayId, auxArrayId,
                arrayHostId, auxArrayHostId, arrayMinimumNights, auxArrayMinimumNights, arrayNumberOfReviews,
                auxArrayNumberOfReviews, arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount,
                arrayAvailability365, auxArrayAvailability365, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup,
                auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood,  arrayRoomType, auxArrayRoomType,
                arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude, arrayReviewsPerMonth, auxArrayReviewsPerMonth, 0, arrayName.length-1);
        finalTime_worstCase = System.nanoTime();
        executionTime_worstCase = ((finalTime_worstCase - initialTime_worstCase) / 1000000d);
        executionTimes[2] = executionTime_worstCase;

        writeAlgorithmsFiles(pathPiorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvailability365);

        return executionTimes;
    }
}
