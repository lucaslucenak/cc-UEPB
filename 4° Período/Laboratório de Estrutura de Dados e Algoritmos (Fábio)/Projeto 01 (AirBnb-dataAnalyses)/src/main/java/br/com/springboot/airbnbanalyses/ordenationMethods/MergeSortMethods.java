package br.com.springboot.airbnbanalyses.ordenationMethods;

import br.com.springboot.airbnbanalyses.ordenationAlgorithms.MergeSort;
import br.com.springboot.airbnbanalyses.ordenationAlgorithms.SelectionSort;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.text.ParseException;

import static br.com.springboot.airbnbanalyses.app.CsvManipulation.writeAlgorithmsFiles;

public class MergeSortMethods {
    public static void mergeSort_Prices(String pathMedioCaso, String pathMelhorCaso, String pathPiorCaso, Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights,
                                        Integer[] arrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvailability365, String[] arrayName, String[] arrayHostName,
                                        String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] arrayRoomType, String[] arrayLastReview,
                                        Double[] arrayLatitude, Double[] arrayLongitude, Double[] arrayReviewsPerMonth, Integer ini, Integer fim) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException, ParseException {

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

        MergeSort.mergeSortCrescent(arrayPrice, auxArrayPrice, arrayId, auxArrayId, arrayHostId, auxArrayHostId,
            arrayMinimumNights, auxArrayMinimumNights, arrayNumberOfReviews, auxArrayNumberOfReviews,
            arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount, arrayAvailability365,
            auxArrayAvailability365, arrayName, auxArrayName, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup,
            auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood, arrayRoomType, auxArrayRoomType,
            arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude,
            arrayReviewsPerMonth, auxArrayReviewsPerMonth, ini, fim);
        writeAlgorithmsFiles(pathMedioCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvailability365);
        MergeSort.mergeSortCrescent(arrayPrice, auxArrayPrice, arrayId, auxArrayId, arrayHostId, auxArrayHostId,
            arrayMinimumNights, auxArrayMinimumNights, arrayNumberOfReviews, auxArrayNumberOfReviews,
            arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount, arrayAvailability365,
            auxArrayAvailability365, arrayName, auxArrayName, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup,
            auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood, arrayRoomType, auxArrayRoomType,
            arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude,
            arrayReviewsPerMonth, auxArrayReviewsPerMonth, ini, fim);
        writeAlgorithmsFiles(pathMelhorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvailability365);
        SelectionSort.selectionSortDecrescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvailability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);
        MergeSort.mergeSortCrescent(arrayPrice, auxArrayPrice, arrayId, auxArrayId, arrayHostId, auxArrayHostId,
            arrayMinimumNights, auxArrayMinimumNights, arrayNumberOfReviews, auxArrayNumberOfReviews,
            arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount, arrayAvailability365,
            auxArrayAvailability365, arrayName, auxArrayName, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup,
            auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood, arrayRoomType, auxArrayRoomType,
            arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude,
            arrayReviewsPerMonth, auxArrayReviewsPerMonth, ini, fim);
            writeAlgorithmsFiles(pathPiorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvailability365);
    }

    public static void mergeSort_NumberOfReviews(String pathMedioCaso, String pathMelhorCaso, String pathPiorCaso, Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights,
                                        Integer[] arrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvailability365, String[] arrayName, String[] arrayHostName,
                                        String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] arrayRoomType, String[] arrayLastReview,
                                        Double[] arrayLatitude, Double[] arrayLongitude, Double[] arrayReviewsPerMonth, Integer ini, Integer fim) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException, ParseException {

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

        MergeSort.mergeSortCrescent(arrayNumberOfReviews, auxArrayNumberOfReviews, arrayId, auxArrayId, arrayHostId, auxArrayHostId,
                arrayMinimumNights, auxArrayMinimumNights, arrayPrice, auxArrayPrice,
                arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount, arrayAvailability365,
                auxArrayAvailability365, arrayName, auxArrayName, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup,
                auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood, arrayRoomType, auxArrayRoomType,
                arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude,
                arrayReviewsPerMonth, auxArrayReviewsPerMonth, ini, fim);
        writeAlgorithmsFiles(pathMedioCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvailability365);
        MergeSort.mergeSortCrescent(arrayNumberOfReviews, auxArrayNumberOfReviews, arrayId, auxArrayId, arrayHostId, auxArrayHostId,
                arrayMinimumNights, auxArrayMinimumNights, arrayPrice, auxArrayPrice,
                arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount, arrayAvailability365,
                auxArrayAvailability365, arrayName, auxArrayName, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup,
                auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood, arrayRoomType, auxArrayRoomType,
                arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude,
                arrayReviewsPerMonth, auxArrayReviewsPerMonth, ini, fim);
        writeAlgorithmsFiles(pathMelhorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvailability365);
        SelectionSort.selectionSortDecrescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvailability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);
        MergeSort.mergeSortCrescent(arrayNumberOfReviews, auxArrayNumberOfReviews, arrayId, auxArrayId, arrayHostId, auxArrayHostId,
                arrayMinimumNights, auxArrayMinimumNights, arrayPrice, auxArrayPrice,
                arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount, arrayAvailability365,
                auxArrayAvailability365, arrayName, auxArrayName, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup,
                auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood, arrayRoomType, auxArrayRoomType,
                arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude,
                arrayReviewsPerMonth, auxArrayReviewsPerMonth, ini, fim);
        writeAlgorithmsFiles(pathPiorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvailability365);
    }

    public static void mergeSort_Names(String pathMedioCaso, String pathMelhorCaso, String pathPiorCaso, String[] arrayName, Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights, Integer[] arrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvailability365 ,
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

        MergeSort.mergeSortCrescent_Names(arrayName, auxArrayName, arrayPrice, auxArrayPrice, arrayId, auxArrayId,
                arrayHostId, auxArrayHostId, arrayMinimumNights, auxArrayMinimumNights, arrayNumberOfReviews,
                auxArrayNumberOfReviews, arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount,
                arrayAvailability365, auxArrayAvailability365, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup,
                auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood,  arrayRoomType, auxArrayRoomType,
                arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude, 0, arrayName.length-1);

        writeAlgorithmsFiles(pathMedioCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvailability365);

        MergeSort.mergeSortCrescent_Names(arrayName, auxArrayName, arrayPrice, auxArrayPrice, arrayId, auxArrayId,
                arrayHostId, auxArrayHostId, arrayMinimumNights, auxArrayMinimumNights, arrayNumberOfReviews,
                auxArrayNumberOfReviews, arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount,
                arrayAvailability365, auxArrayAvailability365, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup,
                auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood,  arrayRoomType, auxArrayRoomType,
                arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude, 0, arrayName.length-1);

        writeAlgorithmsFiles(pathMelhorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvailability365);

        SelectionSort.selectionSortDecrescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvailability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);

        MergeSort.mergeSortCrescent_Names(arrayName, auxArrayName, arrayPrice, auxArrayPrice, arrayId, auxArrayId,
                arrayHostId, auxArrayHostId, arrayMinimumNights, auxArrayMinimumNights, arrayNumberOfReviews,
                auxArrayNumberOfReviews, arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount,
                arrayAvailability365, auxArrayAvailability365, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup,
                auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood,  arrayRoomType, auxArrayRoomType,
                arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude, 0, arrayName.length-1);

        writeAlgorithmsFiles(pathPiorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvailability365);
    }

}
