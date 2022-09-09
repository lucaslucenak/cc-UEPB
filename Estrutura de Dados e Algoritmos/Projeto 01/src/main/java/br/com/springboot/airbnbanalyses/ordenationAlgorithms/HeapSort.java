package br.com.springboot.airbnbanalyses.ordenationAlgorithms;

public class HeapSort {

    public static void heapSortCrescent_Price(Integer[] array, Integer[] array2, Integer[] array3, Integer[] array4, Integer[] array5, Integer[] array6,
                                              Integer[] array7, String[] array8, String[] array9, String[] array10, String[] array11, String[] array12, String[] array13,
                            Double[] array14, Double[] array15, Double[] array16) {

        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            applyHeapSortCrescent_Price(array, array2, array3, array4, array5, array6, array7, array8, array9, array10, array11, array12, array13, array14, array15, array16, n, i);
        }

        for (int j = n - 1; j > 0; j--) {
            Integer aux = array[0];
            Integer aux2 = array2[0];
            Integer aux3 = array3[0];
            Integer aux4 = array4[0];
            Integer aux5 = array5[0];
            Integer aux6 = array6[0];
            Integer aux7 = array7[0];
            String aux8 = array8[0];
            String aux9 = array9[0];
            String aux10 = array10[0];
            String aux11 = array11[0];
            String aux12 = array12[0];
            String aux13 = array13[0];
            Double aux14 = array14[0];
            Double aux15 = array15[0];
            Double aux16 = array16[0];

            array[0] = array[j];
            array2[0] = array2[j];
            array3[0] = array3[j];
            array4[0] = array4[j];
            array5[0] = array5[j];
            array6[0] = array6[j];
            array7[0] = array7[j];
            array8[0] = array8[j];
            array9[0] = array9[j];
            array10[0] = array10[j];
            array11[0] = array11[j];
            array12[0] = array12[j];
            array13[0] = array13[j];
            array14[0] = array14[j];
            array15[0] = array15[j];
            array16[0] = array16[j];

            array[j] = aux;
            array2[j] = aux2;
            array3[j] = aux3;
            array4[j] = aux4;
            array5[j] = aux5;
            array6[j] = aux6;
            array7[j] = aux7;
            array8[j] = aux8;
            array9[j] = aux9;
            array10[j] = aux10;
            array11[j] = aux11;
            array12[j] = aux12;
            array13[j] = aux13;
            array14[j] = aux14;
            array15[j] = aux15;
            array16[j] = aux16;
            applyHeapSortCrescent_Price(array, array2, array3, array4, array5, array6, array7, array8, array9, array10, array11, array12, array13, array14, array15, array16, j, 0);
        }
    }

    private static void applyHeapSortCrescent_Price(Integer[] array, Integer[] array2, Integer[] array3, Integer[] array4, Integer[] array5, Integer[] array6,
                                                    Integer[] array7, String[] array8, String[] array9, String[] array10, String[] array11, String[] array12, String[] array13,
                                                    Double[] array14, Double[] array15, Double[] array16, int n, int i) {

        int raiz = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < n && array[esquerda] > array[raiz]) {
            raiz = esquerda;
        }
        if (direita < n && array[direita] > array[raiz]) {
            raiz = direita;
        }

        if (raiz != i) {
            Integer aux = array[i];
            Integer aux2 = array2[i];
            Integer aux3 = array3[i];
            Integer aux4 = array4[i];
            Integer aux5 = array5[i];
            Integer aux6 = array6[i];
            Integer aux7 = array7[i];
            String aux8 = array8[i];
            String aux9 = array9[i];
            String aux10 = array10[i];
            String aux11 = array11[i];
            String aux12 = array12[i];
            String aux13 = array13[i];
            Double aux14 = array14[i];
            Double aux15 = array15[i];
            Double aux16 = array16[i];

            array[i] = array[raiz];
            array2[i] = array2[raiz];
            array3[i] = array3[raiz];
            array4[i] = array4[raiz];
            array5[i] = array5[raiz];
            array6[i] = array6[raiz];
            array7[i] = array7[raiz];
            array8[i] = array8[raiz];
            array9[i] = array9[raiz];
            array10[i] = array10[raiz];
            array11[i] = array11[raiz];
            array12[i] = array12[raiz];
            array13[i] = array13[raiz];
            array14[i] = array14[raiz];
            array15[i] = array15[raiz];
            array16[i] = array16[raiz];

            array[raiz] = aux;
            array2[raiz] = aux2;
            array3[raiz] = aux3;
            array4[raiz] = aux4;
            array5[raiz] = aux5;
            array6[raiz] = aux6;
            array7[raiz] = aux7;
            array8[raiz] = aux8;
            array9[raiz] = aux9;
            array10[raiz] = aux10;
            array11[raiz] = aux11;
            array12[raiz] = aux12;
            array13[raiz] = aux13;
            array14[raiz] = aux14;
            array15[raiz] = aux15;
            array16[raiz] = aux16;

            applyHeapSortCrescent_Price(array, array2, array3, array4, array5, array6, array7, array8, array9, array10, array11, array12, array13, array14, array15, array16, n, raiz);
        }
    }

    public static void heapSortCrescent_Names(String[] arrayName, Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights, Integer[] arrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvailability365 ,
                               String[] arrayHostName, String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] arrayRoomType, String[] arrayLastReview, Double[] arrayLatitude, Double[] arrayLongitude, Double[] arrayReviewsPerMonth) {

        int n = arrayName.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            aplicarHeapStr(arrayName, arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvailability365, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, n, i);
        }

        for (int j = n - 1; j > 0; j--) {

            String aux1 = arrayName[0];
            Integer aux2 = arrayPrice[0];
            Integer aux3 = arrayId[0];
            Integer aux4 = arrayHostId[0];
            Integer aux5 = arrayMinimumNights[0];
            Integer aux6 = arrayNumberOfReviews[0];
            Integer aux7 = arrayCalculatedHostListingsCount[0];
            Integer aux8 = arrayAvailability365[0];
            String aux9 = arrayHostName[0];
            String aux10 = arrayNeighbourhoodGroup[0];
            String aux11 = arrayNeighbourhood[0];
            String aux12 = arrayRoomType[0];
            String aux13 = arrayLastReview[0];
            Double aux14 = arrayLatitude[0];
            Double aux15 = arrayLongitude[0];
            Double aux16 = arrayReviewsPerMonth[0];

            arrayName[0] = arrayName[j];
            arrayPrice[0] = arrayPrice[j];
            arrayId[0] = arrayId[j];
            arrayHostId[0] = arrayHostId[j];
            arrayMinimumNights[0] = arrayMinimumNights[j];
            arrayNumberOfReviews[0] = arrayNumberOfReviews[j];
            arrayCalculatedHostListingsCount[0] = arrayCalculatedHostListingsCount[j];
            arrayAvailability365[0] = arrayAvailability365[j];
            arrayHostName[0] = arrayHostName[j];
            arrayNeighbourhoodGroup[0] = arrayNeighbourhoodGroup[j];
            arrayNeighbourhood[0] = arrayNeighbourhood[j];
            arrayRoomType[0] = arrayRoomType[j];
            arrayLastReview[0] = arrayLastReview[j];
            arrayLatitude[0] = arrayLatitude[j];
            arrayLongitude[0] = arrayLongitude[j];
            arrayReviewsPerMonth[0] = arrayReviewsPerMonth[j];

            arrayName[j] = aux1;
            arrayPrice[j] = aux2;
            arrayId[j] = aux3;
            arrayHostId[j] = aux4;
            arrayMinimumNights[j] = aux5;
            arrayNumberOfReviews[j] = aux6;
            arrayCalculatedHostListingsCount[j] = aux7;
            arrayAvailability365[j] = aux8;
            arrayHostName[j] = aux9;
            arrayNeighbourhoodGroup[j] = aux10;
            arrayNeighbourhood[j] = aux11;
            arrayRoomType[j] = aux12;
            arrayLastReview[j] = aux13;
            arrayLatitude[j] = aux14;
            arrayLongitude[j] = aux15;
            arrayReviewsPerMonth[j] = aux16;

            aplicarHeapStr(arrayName, arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvailability365, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth,j, 0);
        }
    }

    private static void aplicarHeapStr(String[] arrayName, Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights, Integer[] arrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvailability365 ,
                                       String[] arrayHostName, String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] arrayRoomType, String[] arrayLastReview, Double[] arrayLatitude, Double[] arrayLongitude, Double[] arrayReviewsPerMonth,int n, int i) {
        int raiz = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < n && arrayName[esquerda].compareTo(arrayName[raiz]) > 0) {
            raiz = esquerda;
        }
        if (direita < n && arrayName[direita].compareTo(arrayName[raiz]) > 0) {
            raiz = direita;
        }

        if (raiz != i) {

            String aux1 = arrayName[i];
            Integer aux2 = arrayPrice[i];
            Integer aux3 = arrayId[i];
            Integer aux4 = arrayHostId[i];
            Integer aux5 = arrayMinimumNights[i];
            Integer aux6 = arrayNumberOfReviews[i];
            Integer aux7 = arrayCalculatedHostListingsCount[i];
            Integer aux8 = arrayAvailability365[i];
            String aux9 = arrayHostName[i];
            String aux10 = arrayNeighbourhoodGroup[i];
            String aux11 = arrayNeighbourhood[i];
            String aux12 = arrayRoomType[i];
            String aux13 = arrayLastReview[i];
            Double aux14 = arrayLatitude[i];
            Double aux15 = arrayLongitude[i];
            Double aux16 = arrayReviewsPerMonth[i];

            arrayName[i] = arrayName[raiz];
            arrayPrice[i] = arrayPrice[raiz];
            arrayId[i] = arrayId[raiz];
            arrayHostId[i] = arrayHostId[raiz];
            arrayMinimumNights[i] = arrayMinimumNights[raiz];
            arrayNumberOfReviews[i] = arrayNumberOfReviews[raiz];
            arrayCalculatedHostListingsCount[i] = arrayCalculatedHostListingsCount[raiz];
            arrayAvailability365[i] = arrayAvailability365[raiz];
            arrayHostName[i] = arrayHostName[raiz];
            arrayNeighbourhoodGroup[i] = arrayNeighbourhoodGroup[raiz];
            arrayNeighbourhood[i] = arrayNeighbourhood[raiz];
            arrayRoomType[i] = arrayRoomType[raiz];
            arrayLastReview[i] = arrayLastReview[raiz];
            arrayLatitude[i] = arrayLatitude[raiz];
            arrayLongitude[i] = arrayLongitude[raiz];
            arrayReviewsPerMonth[i] = arrayReviewsPerMonth[raiz];

            arrayName[raiz] = aux1;
            arrayPrice[raiz] = aux2;
            arrayId[raiz] = aux3;
            arrayHostId[raiz] = aux4;
            arrayMinimumNights[raiz] = aux5;
            arrayNumberOfReviews[raiz] = aux6;
            arrayCalculatedHostListingsCount[raiz] = aux7;
            arrayAvailability365[raiz] = aux8;
            arrayHostName[raiz] = aux9;
            arrayNeighbourhoodGroup[raiz] = aux10;
            arrayNeighbourhood[raiz] = aux11;
            arrayRoomType[raiz] = aux12;
            arrayLastReview[raiz] = aux13;
            arrayLatitude[raiz] = aux14;
            arrayLongitude[raiz] = aux15;
            arrayReviewsPerMonth[raiz] = aux16;


            aplicarHeapStr(arrayName, arrayPrice, arrayId, arrayHostId, arrayMinimumNights, arrayNumberOfReviews, arrayCalculatedHostListingsCount, arrayAvailability365, arrayHostName, arrayNeighbourhoodGroup, arrayNeighbourhood, arrayRoomType, arrayLastReview, arrayLatitude, arrayLongitude, arrayReviewsPerMonth, n, raiz);
        }
    }
}