package br.com.springboot.airbnbanalyses.ordenationAlgorithms;

public class MergeSort {
    public static void mergeSortCrescent(Integer[] arrayPrice, Integer[] auxArray1, Integer[] arrayId, Integer[] auxArray2, Integer[] arrayHostId, Integer[] auxArray3, Integer[] arrayMinimumNights, Integer[] auxArray4,
                                         Integer[] arrayNumberOfReviews, Integer[] auxArray5,Integer[] arrayCalculatedHostListingsCount, Integer[] auxArray6,Integer[] arrayAvailability365, Integer[] auxArray7,String[] arrayName, String[] auxArray8, String[] arrayHostName, String[] auxArray9,
                                 String[] arrayNeighbourhoodGroup, String[] auxArray10,String[] arrayNeighbourhood, String[] auxArray11,String[] arrayRoomType, String[] auxArray12,String[] arrayLastReview, String[] auxArray13,
                                 Double[] arrayLatitude, Double[] auxArray14,Double[] arrayLongitude, Double[] auxArray15, Double[] arrayReviewsPerMonth, Double[] auxArray16,Integer ini, Integer fim) {
        if(ini<fim) {
            int meio= (ini+fim)/2;
            mergeSortCrescent(arrayPrice,auxArray1,arrayId,auxArray2,arrayHostId,auxArray3,arrayMinimumNights,auxArray4,arrayNumberOfReviews,auxArray5,arrayCalculatedHostListingsCount,auxArray6,
                    arrayAvailability365,auxArray7,arrayName,auxArray8,arrayHostName,auxArray9,arrayNeighbourhoodGroup,auxArray10,arrayNeighbourhood,auxArray11,arrayRoomType,auxArray12,
                    arrayLastReview,auxArray13,arrayLatitude,auxArray14,arrayLongitude,auxArray15, arrayReviewsPerMonth, auxArray16,ini,meio);
            mergeSortCrescent(arrayPrice,auxArray1,arrayId,auxArray2,arrayHostId,auxArray3,arrayMinimumNights,auxArray4,arrayNumberOfReviews,auxArray5,arrayCalculatedHostListingsCount,auxArray6,
                    arrayAvailability365,auxArray7,arrayName,auxArray8,arrayHostName,auxArray9,arrayNeighbourhoodGroup,auxArray10,arrayNeighbourhood,auxArray11,arrayRoomType,auxArray12,
                    arrayLastReview,auxArray13,arrayLatitude,auxArray14,arrayLongitude,auxArray15, arrayReviewsPerMonth, auxArray16,meio+1,fim);
            intercalar(arrayPrice,auxArray1,arrayId,auxArray2,arrayHostId,auxArray3,arrayMinimumNights,auxArray4,arrayNumberOfReviews,auxArray5,arrayCalculatedHostListingsCount,auxArray6,
                    arrayAvailability365,auxArray7,arrayName,auxArray8,arrayHostName,auxArray9,arrayNeighbourhoodGroup,auxArray10,arrayNeighbourhood,auxArray11,arrayRoomType,auxArray12,
                    arrayLastReview,auxArray13,arrayLatitude,auxArray14,arrayLongitude,auxArray15, arrayReviewsPerMonth, auxArray16,ini,meio,fim);

        }
    }

    public static void intercalar(Integer[] arrayPrice, Integer[] auxArray1, Integer[] arrayId, Integer[] auxArray2, Integer[] arrayHostId, Integer[] auxArray3, Integer[] arrayMinimumNights, Integer[] auxArray4,
                                  Integer[] arrayNumberOfReviews, Integer[] auxArray5,Integer[] arrayCalculatedHostListingsCount, Integer[] auxArray6,Integer[] arrayAvailability365, Integer[] auxArray7,String[] arrayName, String[] auxArray8, String[] arrayHostName, String[] auxArray9,
                                  String[] arrayNeighbourhoodGroup, String[] auxArray10,String[] arrayNeighbourhood, String[] auxArray11,String[] arrayRoomType, String[] auxArray12,String[] arrayLastReview, String[] auxArray13,
                                  Double[] arrayLatitude, Double[] auxArray14,Double[] arrayLongitude, Double[] auxArray15, Double[] arrayReviewsPerMonth, Double[] auxArray16, Integer ini, Integer meio, Integer fim) {

        for(int k=ini;k<=fim;k++) {
            auxArray1[k]=arrayPrice[k];
            auxArray2[k]=arrayId[k];
            auxArray3[k]=arrayHostId[k];
            auxArray4[k]=arrayMinimumNights[k];
            auxArray5[k]=arrayNumberOfReviews[k];
            auxArray6[k]=arrayCalculatedHostListingsCount[k];
            auxArray7[k]=arrayAvailability365[k];
            auxArray8[k]=arrayName[k];
            auxArray9[k]=arrayHostName[k];
            auxArray10[k]=arrayNeighbourhoodGroup[k];
            auxArray11[k]=arrayNeighbourhood[k];
            auxArray12[k]=arrayRoomType[k];
            auxArray13[k]=arrayLastReview[k];
            auxArray14[k]=arrayLatitude[k];
            auxArray15[k]=arrayLongitude[k];
            auxArray16[k]=arrayReviewsPerMonth[k];
        }

        int i=ini;
        int j=meio+1;
        for(int k=ini;k<=fim;k++) {
            if(i>meio) {
                arrayPrice[k]=auxArray1[j];
                arrayId[k]=auxArray2[j];
                arrayHostId[k]=auxArray3[j];
                arrayMinimumNights[k]=auxArray4[j];
                arrayNumberOfReviews[k]=auxArray5[j];
                arrayCalculatedHostListingsCount[k]=auxArray6[j];
                arrayAvailability365[k]=auxArray7[j];
                arrayName[k]=auxArray8[j];
                arrayHostName[k]=auxArray9[j];
                arrayNeighbourhoodGroup[k]=auxArray10[j];
                arrayNeighbourhood[k]=auxArray11[j];
                arrayRoomType[k]=auxArray12[j];
                arrayLastReview[k]=auxArray13[j];
                arrayLatitude[k]=auxArray14[j];
                arrayLongitude[k]=auxArray15[j];
                auxArray16[k]=arrayReviewsPerMonth[k];
                j++;
            }
            else if(j>fim) {
                arrayPrice[k]= auxArray1[i];
                arrayId[k]=auxArray2[i];
                arrayHostId[k]=auxArray3[i];
                arrayMinimumNights[k]=auxArray4[i];
                arrayNumberOfReviews[k]=auxArray5[i];
                arrayCalculatedHostListingsCount[k]=auxArray6[i];
                arrayAvailability365[k]=auxArray7[i];
                arrayName[k]=auxArray8[i];
                arrayHostName[k]=auxArray9[i];
                arrayNeighbourhoodGroup[k]=auxArray10[i];
                arrayNeighbourhood[k]=auxArray11[i];
                arrayRoomType[k]=auxArray12[i];
                arrayLastReview[k]=auxArray13[i];
                arrayLatitude[k]=auxArray14[i];
                arrayLongitude[k]=auxArray15[i];
                auxArray16[k]=arrayReviewsPerMonth[k];
                i++;
            }
            else if(auxArray1[i]<auxArray1[j]) {
                arrayPrice[k]= auxArray1[i];
                arrayId[k]=auxArray2[i];
                arrayHostId[k]=auxArray3[i];
                arrayMinimumNights[k]=auxArray4[i];
                arrayNumberOfReviews[k]=auxArray5[i];
                arrayCalculatedHostListingsCount[k]=auxArray6[i];
                arrayAvailability365[k]=auxArray7[i];
                arrayName[k]=auxArray8[i];
                arrayHostName[k]=auxArray9[i];
                arrayNeighbourhoodGroup[k]=auxArray10[i];
                arrayNeighbourhood[k]=auxArray11[i];
                arrayRoomType[k]=auxArray12[i];
                arrayLastReview[k]=auxArray13[i];
                arrayLatitude[k]=auxArray14[i];
                arrayLongitude[k]=auxArray15[i];
                auxArray16[k]=arrayReviewsPerMonth[k];
                i++;
            }
            else {
                arrayPrice[k]= auxArray1[j];
                arrayId[k]=auxArray2[j];
                arrayHostId[k]=auxArray3[i];
                arrayMinimumNights[k]=auxArray4[j];
                arrayNumberOfReviews[k]=auxArray5[j];
                arrayCalculatedHostListingsCount[k]=auxArray6[j];
                arrayAvailability365[k]=auxArray7[j];
                arrayName[k]=auxArray8[j];
                arrayHostName[k]=auxArray9[j];
                arrayNeighbourhoodGroup[k]=auxArray10[j];
                arrayNeighbourhood[k]=auxArray11[j];
                arrayRoomType[k]=auxArray12[j];
                arrayLastReview[k]=auxArray13[j];
                arrayLatitude[k]=auxArray14[j];
                arrayLongitude[k]=auxArray15[j];
                auxArray16[k]=arrayReviewsPerMonth[k];
                j++;
            }
        }
    }

    public static void mergeSortCrescent_Names(String[] arrayName, String[] auxArrayName, Integer[] arrayPrice, Integer[] auxArrayPrice, Integer[] arrayId, Integer[] auxArrayId, Integer[] arrayHostId, Integer[] auxArrayHostId, Integer[] arrayMinimumNights, Integer[] auxArrayMinimumNights, Integer[] arrayNumberOfReviews, Integer[] auxArrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] auxArrayCalculatedHostListingsCount, Integer[] arrayAvailability365 , Integer[] auxArrayAvailability365 ,
                                       String[] arrayHostName, String[] auxArrayHostName, String[] arrayNeighbourhoodGroup, String[] auxArrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] auxArrayNeighbourhood, String[] arrayRoomType, String[] auxArrayRoomType, String[] arrayLastReview, String[] auxArrayLastReview, Double[] arrayLatitude, Double[] auxArrayLatitude, Double[] arrayLongitude, Double[] auxArrayLongitude, int ini, int fim) {
        if(ini<fim) {
            int meio= (ini+fim)/2;
            mergeSortCrescent_Names(arrayName, auxArrayName, arrayPrice, auxArrayPrice, arrayId, auxArrayId, arrayHostId, auxArrayHostId, arrayMinimumNights, auxArrayMinimumNights, arrayNumberOfReviews, auxArrayNumberOfReviews, arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount, arrayAvailability365, auxArrayAvailability365, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup, auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood, arrayRoomType, auxArrayRoomType, arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude, ini,meio);
            mergeSortCrescent_Names(arrayName, auxArrayName, arrayPrice, auxArrayPrice, arrayId, auxArrayId, arrayHostId, auxArrayHostId, arrayMinimumNights, auxArrayMinimumNights, arrayNumberOfReviews, auxArrayNumberOfReviews, arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount, arrayAvailability365, auxArrayAvailability365, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup, auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood, arrayRoomType, auxArrayRoomType, arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude,meio+1,fim);
            intercarlaStrings(arrayName, auxArrayName, arrayPrice, auxArrayPrice, arrayId, auxArrayId, arrayHostId, auxArrayHostId, arrayMinimumNights, auxArrayMinimumNights, arrayNumberOfReviews, auxArrayNumberOfReviews, arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount, arrayAvailability365, auxArrayAvailability365, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup, auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood, arrayRoomType, auxArrayRoomType, arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude,ini,meio,fim);

        }
    }
    public static void intercarlaStrings(String[] arrayName, String[] auxArrayName, Integer[] arrayPrice, Integer[] auxArrayPrice, Integer[] arrayId, Integer[] auxArrayId, Integer[] arrayHostId, Integer[] auxArrayHostId, Integer[] arrayMinimumNights, Integer[] auxArrayMinimumNights, Integer[] arrayNumberOfReviews, Integer[] auxArrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] auxArrayCalculatedHostListingsCount, Integer[] arrayAvailability365 , Integer[] auxArrayAvailability365 ,
                                         String[] arrayHostName, String[] auxArrayHostName, String[] arrayNeighbourhoodGroup, String[] auxArrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] auxArrayNeighbourhood, String[] arrayRoomType, String[] auxArrayRoomType, String[] arrayLastReview, String[] auxArrayLastReview, Double[] arrayLatitude, Double[] auxArrayLatitude, Double[] arrayLongitude, Double[] auxArrayLongitude, int ini, int meio, int fim) {

        for(int k=ini;k<=fim;k++) {
            auxArrayName[k]=arrayName[k];
            auxArrayPrice[k]=arrayPrice[k];
            auxArrayId[k]=arrayId[k];
            auxArrayHostId[k]=arrayHostId[k];
            auxArrayMinimumNights[k]=arrayMinimumNights[k];
            auxArrayNumberOfReviews[k]=arrayNumberOfReviews[k];
            auxArrayCalculatedHostListingsCount[k]=arrayCalculatedHostListingsCount[k];
            auxArrayAvailability365[k]=arrayAvailability365[k];
            auxArrayHostName[k]=arrayHostName[k];
            auxArrayNeighbourhoodGroup[k]=arrayNeighbourhoodGroup[k];
            auxArrayNeighbourhood[k]=arrayNeighbourhood[k];
            auxArrayRoomType[k]=arrayRoomType[k];
            auxArrayLastReview[k]=arrayLastReview[k];
            auxArrayLatitude[k]=arrayLatitude[k];
            auxArrayLongitude[k]=arrayLongitude[k];

        }

        int i=ini;
        int j=meio+1;
        for(int k=ini;k<=fim;k++) {
            if(i>meio) {

                arrayName[k]=auxArrayName[j];
                arrayPrice[k]=auxArrayId[j];
                arrayId[k]=auxArrayPrice[j];
                arrayHostId[k]=auxArrayHostId[j];
                arrayMinimumNights[k]=auxArrayMinimumNights[j];
                arrayNumberOfReviews[k]=auxArrayNumberOfReviews[j];
                arrayCalculatedHostListingsCount[k]=auxArrayCalculatedHostListingsCount[j];
                arrayAvailability365[k]=auxArrayAvailability365[j];
                arrayHostName[k]=auxArrayHostName[j];
                arrayNeighbourhoodGroup[k]=auxArrayNeighbourhoodGroup[j];
                arrayNeighbourhood[k]=auxArrayNeighbourhood[j];
                arrayRoomType[k]=auxArrayRoomType[j];
                arrayLastReview[k]=auxArrayLastReview[j];
                arrayLatitude[k]=auxArrayLatitude[j];
                arrayLongitude[k]=auxArrayLongitude[j];
                j++;
            }
            else if(j>fim) {
                arrayName[k]=auxArrayName[i];
                arrayPrice[k]=auxArrayId[i];
                arrayId[k]=auxArrayPrice[i];
                arrayHostId[k]=auxArrayHostId[i];
                arrayMinimumNights[k]=auxArrayMinimumNights[i];
                arrayNumberOfReviews[k]=auxArrayNumberOfReviews[i];
                arrayCalculatedHostListingsCount[k]=auxArrayCalculatedHostListingsCount[i];
                arrayAvailability365[k]=auxArrayAvailability365[i];
                arrayHostName[k]=auxArrayHostName[i];
                arrayNeighbourhoodGroup[k]=auxArrayNeighbourhoodGroup[i];
                arrayNeighbourhood[k]=auxArrayNeighbourhood[i];
                arrayRoomType[k]=auxArrayRoomType[i];
                arrayLastReview[k]=auxArrayLastReview[i];
                arrayLatitude[k]=auxArrayLatitude[i];
                arrayLongitude[k]=auxArrayLongitude[i];
                i++;
            }
            else if(auxArrayName[i].compareTo(auxArrayName[j])<0) {
                arrayName[k]=auxArrayName[i];
                arrayPrice[k]=auxArrayId[i];
                arrayId[k]=auxArrayPrice[i];
                arrayHostId[k]=auxArrayHostId[i];
                arrayMinimumNights[k]=auxArrayMinimumNights[i];
                arrayNumberOfReviews[k]=auxArrayNumberOfReviews[i];
                arrayCalculatedHostListingsCount[k]=auxArrayCalculatedHostListingsCount[i];
                arrayAvailability365[k]=auxArrayAvailability365[i];
                arrayHostName[k]=auxArrayHostName[i];
                arrayNeighbourhoodGroup[k]=auxArrayNeighbourhoodGroup[i];
                arrayNeighbourhood[k]=auxArrayNeighbourhood[i];
                arrayRoomType[k]=auxArrayRoomType[i];
                arrayLastReview[k]=auxArrayLastReview[i];
                arrayLatitude[k]=auxArrayLatitude[i];
                arrayLongitude[k]=auxArrayLongitude[i];
                i++;
            }
            else {
                arrayName[k]=auxArrayName[j];
                arrayPrice[k]=auxArrayId[j];
                arrayId[k]=auxArrayPrice[j];
                arrayHostId[k]=auxArrayHostId[j];
                arrayMinimumNights[k]=auxArrayMinimumNights[j];
                arrayNumberOfReviews[k]=auxArrayNumberOfReviews[j];
                arrayCalculatedHostListingsCount[k]=auxArrayCalculatedHostListingsCount[j];
                arrayAvailability365[k]=auxArrayAvailability365[j];
                arrayHostName[k]=auxArrayHostName[j];
                arrayNeighbourhoodGroup[k]=auxArrayNeighbourhoodGroup[j];
                arrayNeighbourhood[k]=auxArrayNeighbourhood[j];
                arrayRoomType[k]=auxArrayRoomType[j];
                arrayLastReview[k]=auxArrayLastReview[j];
                arrayLatitude[k]=auxArrayLatitude[j];
                arrayLongitude[k]=auxArrayLongitude[j];
                j++;
            }
        }
    }

    /*public static void mergeSortCrescent_Names(String[] arrayName, String[] auxArrayName, Integer[] arrayPrice, Integer[] auxArrayPrice, Integer[] arrayId, Integer[] auxArrayId, Integer[] arrayHostId, Integer[] auxArrayHostId, Integer[] arrayMinimumNights, Integer[] auxArrayMinimumNights, Integer[] arrayNumberOfReviews, Integer[] auxArrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] auxArrayCalculatedHostListingsCount, Integer[] arrayAvailability365 , Integer[] auxArrayAvailability365 ,
                                       String[] arrayHostName, String[] auxArrayHostName, String[] arrayNeighbourhoodGroup, String[] auxArrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] auxArrayNeighbourhood, String[] arrayRoomType, String[] auxArrayRoomType, String[] arrayLastReview, String[] auxArrayLastReview, Double[] arrayLatitude, Double[] auxArrayLatitude, Double[] arrayLongitude, Double[] auxArrayLongitude, Double[] arrayReviewsPerMonth, Double[] auxReviewsPerMonth, Integer ini, Integer fim) {
        if(ini<fim) {
            int meio= (ini+fim)/2;
            mergeSortCrescent_Names(arrayName, auxArrayName, arrayPrice, auxArrayPrice, arrayId, auxArrayId, arrayHostId, auxArrayHostId, arrayMinimumNights, auxArrayMinimumNights, arrayNumberOfReviews, auxArrayNumberOfReviews, arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount, arrayAvailability365, auxArrayAvailability365, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup, auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood, arrayRoomType, auxArrayRoomType, arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude, arrayReviewsPerMonth, auxReviewsPerMonth, ini,meio);
            mergeSortCrescent_Names(arrayName, auxArrayName, arrayPrice, auxArrayPrice, arrayId, auxArrayId, arrayHostId, auxArrayHostId, arrayMinimumNights, auxArrayMinimumNights, arrayNumberOfReviews, auxArrayNumberOfReviews, arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount, arrayAvailability365, auxArrayAvailability365, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup, auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood, arrayRoomType, auxArrayRoomType, arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude, arrayReviewsPerMonth,auxReviewsPerMonth,+1,fim);
            intercarlaNames(arrayName, auxArrayName, arrayPrice, auxArrayPrice, arrayId, auxArrayId, arrayHostId, auxArrayHostId, arrayMinimumNights, auxArrayMinimumNights, arrayNumberOfReviews, auxArrayNumberOfReviews, arrayCalculatedHostListingsCount, auxArrayCalculatedHostListingsCount, arrayAvailability365, auxArrayAvailability365, arrayHostName, auxArrayHostName, arrayNeighbourhoodGroup, auxArrayNeighbourhoodGroup, arrayNeighbourhood, auxArrayNeighbourhood, arrayRoomType, auxArrayRoomType, arrayLastReview, auxArrayLastReview, arrayLatitude, auxArrayLatitude, arrayLongitude, auxArrayLongitude, arrayReviewsPerMonth, auxReviewsPerMonth ,ini,meio,fim);

        }
    }
    public static void intercarlaNames(String[] arrayName, String[] auxArrayName, Integer[] arrayPrice, Integer[] auxArrayPrice, Integer[] arrayId, Integer[] auxArrayId, Integer[] arrayHostId, Integer[] auxArrayHostId, Integer[] arrayMinimumNights, Integer[] auxArrayMinimumNights, Integer[] arrayNumberOfReviews, Integer[] auxArrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] auxArrayCalculatedHostListingsCount, Integer[] arrayAvailability365 , Integer[] auxArrayAvailability365 ,
                                         String[] arrayHostName, String[] auxArrayHostName, String[] arrayNeighbourhoodGroup, String[] auxArrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] auxArrayNeighbourhood, String[] arrayRoomType, String[] auxArrayRoomType, String[] arrayLastReview, String[] auxArrayLastReview, Double[] arrayLatitude, Double[] auxArrayLatitude, Double[] arrayLongitude, Double[] auxArrayLongitude, Double[] arrayReviewsPerMonth, Double[] auxReviewsPerMonth,Integer ini, Integer meio, Integer fim) {

        for(int k=ini;k<=fim;k++) {
            auxArrayName[k]=arrayName[k];
            auxArrayPrice[k]=arrayPrice[k];
            auxArrayId[k]=arrayId[k];
            auxArrayHostId[k]=arrayHostId[k];
            auxArrayMinimumNights[k]=arrayMinimumNights[k];
            auxArrayNumberOfReviews[k]=arrayNumberOfReviews[k];
            auxArrayCalculatedHostListingsCount[k]=arrayCalculatedHostListingsCount[k];
            auxArrayAvailability365[k]=arrayAvailability365[k];
            auxArrayHostName[k]=arrayHostName[k];
            auxArrayNeighbourhoodGroup[k]=arrayNeighbourhoodGroup[k];
            auxArrayNeighbourhood[k]=arrayNeighbourhood[k];
            auxArrayRoomType[k]=arrayRoomType[k];
            auxArrayLastReview[k]=arrayLastReview[k];
            auxArrayLatitude[k]=arrayLatitude[k];
            auxArrayLongitude[k]=arrayLongitude[k];
            auxReviewsPerMonth[k]=arrayReviewsPerMonth[k];

        }

        int i=ini;
        int j=meio+1;
        for(int k=ini;k<=fim;k++) {
            if(i>meio) {

                arrayName[k]=auxArrayName[j];
                arrayPrice[k]=auxArrayId[j];
                arrayId[k]=auxArrayPrice[j];
                arrayHostId[k]=auxArrayHostId[j];
                arrayMinimumNights[k]=auxArrayMinimumNights[j];
                arrayNumberOfReviews[k]=auxArrayNumberOfReviews[j];
                arrayCalculatedHostListingsCount[k]=auxArrayCalculatedHostListingsCount[j];
                arrayAvailability365[k]=auxArrayAvailability365[j];
                arrayHostName[k]=auxArrayHostName[j];
                arrayNeighbourhoodGroup[k]=auxArrayNeighbourhoodGroup[j];
                arrayNeighbourhood[k]=auxArrayNeighbourhood[j];
                arrayRoomType[k]=auxArrayRoomType[j];
                arrayLastReview[k]=auxArrayLastReview[j];
                arrayLatitude[k]=auxArrayLatitude[j];
                arrayLongitude[k]=auxArrayLongitude[j];
                arrayReviewsPerMonth[k]=auxReviewsPerMonth[j];
                j++;
            }
            else if(j>fim) {
                arrayName[k]=auxArrayName[i];
                arrayPrice[k]=auxArrayId[i];
                arrayId[k]=auxArrayPrice[i];
                arrayHostId[k]=auxArrayHostId[i];
                arrayMinimumNights[k]=auxArrayMinimumNights[i];
                arrayNumberOfReviews[k]=auxArrayNumberOfReviews[i];
                arrayCalculatedHostListingsCount[k]=auxArrayCalculatedHostListingsCount[i];
                arrayAvailability365[k]=auxArrayAvailability365[i];
                arrayHostName[k]=auxArrayHostName[i];
                arrayNeighbourhoodGroup[k]=auxArrayNeighbourhoodGroup[i];
                arrayNeighbourhood[k]=auxArrayNeighbourhood[i];
                arrayRoomType[k]=auxArrayRoomType[i];
                arrayLastReview[k]=auxArrayLastReview[i];
                arrayLatitude[k]=auxArrayLatitude[i];
                arrayLongitude[k]=auxArrayLongitude[i];
                arrayReviewsPerMonth[k]=arrayReviewsPerMonth[i];
                i++;
            }
            else if(auxArrayName[i].compareTo(auxArrayName[j])<0) {
                arrayName[k]=auxArrayName[i];
                arrayPrice[k]=auxArrayId[i];
                arrayId[k]=auxArrayPrice[i];
                arrayHostId[k]=auxArrayHostId[i];
                arrayMinimumNights[k]=auxArrayMinimumNights[i];
                arrayNumberOfReviews[k]=auxArrayNumberOfReviews[i];
                arrayCalculatedHostListingsCount[k]=auxArrayCalculatedHostListingsCount[i];
                arrayAvailability365[k]=auxArrayAvailability365[i];
                arrayHostName[k]=auxArrayHostName[i];
                arrayNeighbourhoodGroup[k]=auxArrayNeighbourhoodGroup[i];
                arrayNeighbourhood[k]=auxArrayNeighbourhood[i];
                arrayRoomType[k]=auxArrayRoomType[i];
                arrayLastReview[k]=auxArrayLastReview[i];
                arrayLatitude[k]=auxArrayLatitude[i];
                arrayLongitude[k]=auxArrayLongitude[i];
                arrayReviewsPerMonth[k]=arrayReviewsPerMonth[i];
                i++;
            }
            else {
                arrayName[k]=auxArrayName[j];
                arrayPrice[k]=auxArrayId[j];
                arrayId[k]=auxArrayPrice[j];
                arrayHostId[k]=auxArrayHostId[j];
                arrayMinimumNights[k]=auxArrayMinimumNights[j];
                arrayNumberOfReviews[k]=auxArrayNumberOfReviews[j];
                arrayCalculatedHostListingsCount[k]=auxArrayCalculatedHostListingsCount[j];
                arrayAvailability365[k]=auxArrayAvailability365[j];
                arrayHostName[k]=auxArrayHostName[j];
                arrayNeighbourhoodGroup[k]=auxArrayNeighbourhoodGroup[j];
                arrayNeighbourhood[k]=auxArrayNeighbourhood[j];
                arrayRoomType[k]=auxArrayRoomType[j];
                arrayLastReview[k]=auxArrayLastReview[j];
                arrayLatitude[k]=auxArrayLatitude[j];
                arrayLongitude[k]=auxArrayLongitude[j];
                arrayReviewsPerMonth[k]=arrayReviewsPerMonth[j];
                j++;
            }
        }
    }*/
}
