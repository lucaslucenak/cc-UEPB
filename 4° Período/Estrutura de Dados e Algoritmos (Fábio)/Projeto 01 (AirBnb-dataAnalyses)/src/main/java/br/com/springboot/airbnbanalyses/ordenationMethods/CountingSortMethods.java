package br.com.springboot.airbnbanalyses.ordenationMethods;

import br.com.springboot.airbnbanalyses.ordenationAlgorithms.CountingSort;
import br.com.springboot.airbnbanalyses.ordenationAlgorithms.SelectionSort;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.text.ParseException;

import static br.com.springboot.airbnbanalyses.app.CsvManipulation.writeAlgorithmsFiles;

public class CountingSortMethods {
    public static void countigSort_Prices(String pathMedioCaso, String pathMelhorCaso, String pathPiorCaso, Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights, Integer[] arrayNumberOfReviews,
                                          Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvaiability365, String[] arrayName, String[] arrayHostName, String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood,
                                          String[] arrayRoomType, String[] arrayLastReview, Double[] arrayLatitude, Double[] arrayLongitude, Double[] arrayReviewsPerMonth, int size) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException, ParseException {

        CountingSort.countSortCrescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, size);
        writeAlgorithmsFiles(pathMedioCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);
        CountingSort.countSortCrescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, size);
        writeAlgorithmsFiles(pathMelhorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);
        SelectionSort.selectionSortDecrescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);
        CountingSort.countSortCrescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, size);
        writeAlgorithmsFiles(pathPiorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);


    }

    public static void countigSort_NumberOfReviews(String pathMedioCaso, String pathMelhorCaso, String pathPiorCaso, Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights, Integer[] arrayNumberOfReviews,
                                          Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvaiability365, String[] arrayName, String[] arrayHostName, String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood,
                                          String[] arrayRoomType, String[] arrayLastReview, Double[] arrayLatitude, Double[] arrayLongitude, Double[] arrayReviewsPerMonth, int size) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException, ParseException {

        CountingSort.countSortCrescent(arrayNumberOfReviews, arrayId, arrayHostId, arrayMinimumNights, arrayPrice, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, size);
        writeAlgorithmsFiles(pathMedioCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);
        CountingSort.countSortCrescent(arrayNumberOfReviews, arrayId, arrayHostId, arrayMinimumNights, arrayPrice, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, size);
        writeAlgorithmsFiles(pathMelhorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);
        SelectionSort.selectionSortDecrescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);
        CountingSort.countSortCrescent(arrayNumberOfReviews, arrayId, arrayHostId, arrayMinimumNights, arrayPrice, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, size);
        writeAlgorithmsFiles(pathPiorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);
    }

    public static void countigSort_Names() {

    }
}
