package br.com.springboot.airbnbanalyses.ordenationAlgorithms;

public class InsertionSort {

    public static void insertionSortCrescent(Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights, Integer[] arrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvailability365, String[] arrayName,
                                             String[] arrayHostName, String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] arrayRoomType, String[] arrayLastReview, Double[] arrayLatitude, Double[] arrayLongitude, Double[] arrayReviewsPerMonth) {
        int n = arrayPrice.length;
        for (int j = 1; j < n; j++) {
            Integer key = arrayPrice[j];
            Integer key2 = arrayId[j];
            Integer key3 = arrayHostId[j];
            Integer key4 = arrayMinimumNights[j];
            Integer key5 = arrayNumberOfReviews[j];
            Integer key6 = arrayCalculatedHostListingsCount[j];
            Integer key7 = arrayAvailability365[j];
            String key8 = arrayName[j];
            String key9 = arrayHostName[j];
            String key10 = arrayNeighbourhoodGroup[j];
            String key11 = arrayNeighbourhood[j];
            String key12 = arrayRoomType[j];
            String key13 = arrayLastReview[j];
            Double key14 = arrayLatitude[j];
            Double key15 = arrayLongitude[j];
            Double key16 = arrayReviewsPerMonth[j];
            int i = j-1;
            while ( (i > -1) && ( arrayPrice [i] > key ) ) {
                arrayPrice [i+1] = arrayPrice [i];
                arrayId[i + 1] = arrayId[i];
                arrayHostId[i + 1] = arrayHostId[i];
                arrayMinimumNights[i + 1] = arrayMinimumNights[i];
                arrayNumberOfReviews[i + 1] = arrayNumberOfReviews[i];
                arrayCalculatedHostListingsCount[i + 1] = arrayCalculatedHostListingsCount[i];
                arrayAvailability365[i + 1] = arrayAvailability365[i];
                arrayName[i + 1] = arrayName[i];
                arrayHostName[i + 1] = arrayHostName[i];
                arrayNeighbourhoodGroup[i + 1] = arrayNeighbourhoodGroup[i];
                arrayNeighbourhood[i + 1] = arrayNeighbourhood[i];
                arrayRoomType[i + 1] = arrayRoomType[i];
                arrayLastReview[i + 1] = arrayLastReview[i];
                arrayLatitude[i + 1] = arrayLatitude[i];
                arrayLongitude[i + 1] = arrayLongitude[i];
                arrayReviewsPerMonth[i + 1] = arrayReviewsPerMonth[i];
                i--;
            }
            arrayPrice[i+1] = key;
            arrayId[i+1] = key2;
            arrayHostId[i+1] = key3;
            arrayMinimumNights[i+1] = key4;
            arrayNumberOfReviews[i+1] = key5;
            arrayCalculatedHostListingsCount[i+1] = key6;
            arrayAvailability365[i+1] = key7;
            arrayName[i+1] = key8;
            arrayHostName[i+1] = key9;
            arrayNeighbourhoodGroup[i+1] = key10;
            arrayNeighbourhood[i+1] = key11;
            arrayRoomType[i+1] = key12;
            arrayLastReview[i+1] = key13;
            arrayLatitude[i+1] = key14;
            arrayLongitude[i+1] = key15;
            arrayReviewsPerMonth[i+1] = key16;
        }
    }

    public static void insertionSortCrescent_Names(String[] arrayName, Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights, Integer[] arrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvailability365 ,
                                                String[] arrayHostName, String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] arrayRoomType, String[] arrayLastReview, Double[] arrayLatitude, Double[] arrayLongitude, Double[] arrayReviewsPerMonth) {
        int i,j;
        String aux1;
        Integer aux2;
        Integer aux3;
        Integer aux4;
        Integer aux5;
        Integer aux6;
        Integer aux7;
        Integer aux8;
        String aux9;
        String aux10;
        String aux11;
        String aux12;
        String aux13;
        Double aux14;
        Double aux15;
        Double aux16;

        for (j = 1; j < arrayName.length; j++) {
            aux1 = arrayName[j];
            aux2 = arrayPrice[j];
            aux3 = arrayId[j];
            aux4 = arrayHostId[j];
            aux5 = arrayMinimumNights[j];
            aux6 = arrayNumberOfReviews[j];
            aux7 = arrayCalculatedHostListingsCount[j];
            aux8 = arrayAvailability365[j];
            aux9 = arrayHostName[j];
            aux10 = arrayNeighbourhoodGroup[j];
            aux11 = arrayNeighbourhood[j];
            aux12 = arrayRoomType[j];
            aux13 = arrayLastReview[j];
            aux14 = arrayLatitude[j];
            aux15 = arrayLongitude[j];
            aux16 = arrayReviewsPerMonth[j];

            i = j - 1;

            while (i >= 0) {
                if (aux1.compareTo(arrayName[i]) > 0) {
                    break;
                }
                arrayName[i + 1] = arrayName[i];
                arrayPrice[i + 1] = arrayPrice[i];
                arrayId[i + 1] = arrayId[i];
                arrayHostId[i + 1] = arrayHostId[i];
                arrayMinimumNights[i + 1] = arrayMinimumNights[i];
                arrayNumberOfReviews[i + 1] = arrayNumberOfReviews[i];
                arrayCalculatedHostListingsCount[i + 1] = arrayCalculatedHostListingsCount[i];
                arrayAvailability365[i + 1] = arrayAvailability365[i];
                arrayHostName[i + 1] = arrayHostName[i];
                arrayNeighbourhoodGroup[i + 1] = arrayNeighbourhoodGroup[i];
                arrayNeighbourhood[i + 1] = arrayNeighbourhood[i];
                arrayRoomType[i + 1] = arrayRoomType[i];
                arrayLastReview[i + 1] = arrayLastReview[i];
                arrayLatitude[i + 1] = arrayLatitude[i];
                arrayLongitude[i + 1] = arrayLongitude[i];
                arrayReviewsPerMonth[i + 1] = arrayReviewsPerMonth[i];

                i--;
            }
            arrayName[i + 1] = aux1;
            arrayPrice[i + 1] = aux2;
            arrayId[i + 1] = aux3;
            arrayHostId[i + 1] = aux4;
            arrayMinimumNights[i + 1] = aux5;
            arrayNumberOfReviews[i + 1] = aux6;
            arrayCalculatedHostListingsCount[i + 1] = aux7;
            arrayAvailability365[i + 1] = aux8;
            arrayHostName[i + 1] = aux9;
            arrayNeighbourhoodGroup[i + 1] = aux10;
            arrayNeighbourhood[i + 1] = aux11;
            arrayRoomType[i + 1] = aux12;
            arrayLastReview[i + 1] = aux13;
            arrayLatitude[i + 1] = aux14;
            arrayLongitude[i + 1] = aux15;
            arrayReviewsPerMonth[i + 1] = aux16;
        }
    }

}