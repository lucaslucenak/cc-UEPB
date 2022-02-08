package br.com.springboot.airbnbanalyses.ordenationMethods;

import br.com.springboot.airbnbanalyses.app.AirBnbAnalysesApplication;
import br.com.springboot.airbnbanalyses.app.CsvManipulation;
import br.com.springboot.airbnbanalyses.entities.AirBnbListings;
import br.com.springboot.airbnbanalyses.ordenationAlgorithms.InsertionSort;
import br.com.springboot.airbnbanalyses.ordenationAlgorithms.SelectionSort;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import static br.com.springboot.airbnbanalyses.app.CsvManipulation.writeAlgorithmsFiles;

public class InsertionSortMethods {
    public static void insertionSort_Prices(String pathMedioCaso, String pathMelhorCaso, String pathPiorCaso, Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights, Integer[] arrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvaiability365, String[] arrayName,
                                            String[] arrayHostName, String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] arrayRoomType, String[] arrayLastReview, Double[] arrayLatitude, Double[] arrayLongitude, Double[] arrayReviewsPerMonth) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException, ParseException {

        InsertionSort.insertionSortCrescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);
        writeAlgorithmsFiles(pathMedioCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);
        InsertionSort.insertionSortCrescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);
        writeAlgorithmsFiles(pathMelhorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);
        SelectionSort.selectionSortDecrescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);
        InsertionSort.insertionSortCrescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);
        writeAlgorithmsFiles(pathPiorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);
    }

    public static void insertionSort_NumberOfReviews(String pathMedioCaso, String pathMelhorCaso, String pathPiorCaso, Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights, Integer[] arrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvaiability365, String[] arrayName,
                                            String[] arrayHostName, String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] arrayRoomType, String[] arrayLastReview, Double[] arrayLatitude, Double[] arrayLongitude, Double[] arrayReviewsPerMonth) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException, ParseException {

        InsertionSort.insertionSortCrescent(arrayNumberOfReviews, arrayId, arrayHostId, arrayMinimumNights, arrayPrice, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);
        writeAlgorithmsFiles(pathMedioCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);
        InsertionSort.insertionSortCrescent(arrayNumberOfReviews, arrayId, arrayHostId, arrayMinimumNights, arrayPrice, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);
        writeAlgorithmsFiles(pathMelhorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);
        SelectionSort.selectionSortDecrescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);
        InsertionSort.insertionSortCrescent(arrayNumberOfReviews, arrayId, arrayHostId, arrayMinimumNights, arrayPrice, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);
        writeAlgorithmsFiles(pathPiorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);
    }

    public static void insertionSort_Names(String pathMedioCaso, String pathMelhorCaso, String pathPiorCaso, Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights, Integer[] arrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvaiability365, String[] arrayName,
                                           String[] arrayHostName, String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] arrayRoomType, String[] arrayLastReview, Double[] arrayLatitude, Double[] arrayLongitude, Double[] arrayReviewsPerMonth) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException, ParseException {
        InsertionSort.insertionSortCrescent_Names(arrayName, arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);
        writeAlgorithmsFiles(pathMedioCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);
        InsertionSort.insertionSortCrescent_Names(arrayName, arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);
        writeAlgorithmsFiles(pathMelhorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);
        SelectionSort.selectionSortDecrescent(arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayName, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);
        InsertionSort.insertionSortCrescent_Names(arrayName, arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvaiability365, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth);
        writeAlgorithmsFiles(pathPiorCaso, arrayId, arrayName, arrayHostId, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayLatitude, arrayLongitude, arrayRoomType, arrayPrice, arrayMinimumNights, arrayNumberOfReviews, arrayLastReview, arrayReviewsPerMonth, arrayCalculatedHostListingsCount, arrayAvaiability365);
    }
}
