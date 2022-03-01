package br.com.springboot.airbnbanalyses.ordenationAlgorithms;

public class SelectionSort {

    public static void selectionSortCrescent(Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights, Integer[] arrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvailability365, String[] arrayName,
                                  String[] arrayHostName, String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] arrayRoomType, String[] arrayLastReview, Double[] arrayLatitude, Double[] arrayLongitude, Double[] arrayReviewsPerMonth) {

        for (int j = 0; j < arrayPrice.length; j++) {
            int j_menor = j;
            for (int k = j + 1; k < arrayPrice.length; k++){
                if (arrayPrice[k] < arrayPrice[j_menor])
                    j_menor = k;
            }

            Integer key1 = arrayPrice[j];
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

            arrayPrice[j]=arrayPrice[j_menor];
            arrayId[j]=arrayId[j_menor];
            arrayHostId[j]=arrayHostId[j_menor];
            arrayMinimumNights[j]=arrayMinimumNights[j_menor];
            arrayNumberOfReviews[j]=arrayNumberOfReviews[j_menor];
            arrayCalculatedHostListingsCount[j]=arrayCalculatedHostListingsCount[j_menor];
            arrayAvailability365[j]=arrayAvailability365[j_menor];
            arrayName[j]=arrayName[j_menor];
            arrayHostName[j]=arrayHostName[j_menor];
            arrayNeighbourhoodGroup[j]=arrayNeighbourhoodGroup[j_menor];
            arrayNeighbourhood[j]=arrayNeighbourhood[j_menor];
            arrayRoomType[j]=arrayRoomType[j_menor];
            arrayLastReview[j]=arrayLastReview[j_menor];
            arrayLatitude[j]=arrayLatitude[j_menor];
            arrayLongitude[j]=arrayLongitude[j_menor];
            arrayReviewsPerMonth[j]=arrayReviewsPerMonth[j_menor];

            arrayPrice[j_menor]=key1;
            arrayId[j_menor]=key2;
            arrayHostId[j_menor]=key3;
            arrayMinimumNights[j_menor]=key4;
            arrayNumberOfReviews[j_menor]=key5;
            arrayCalculatedHostListingsCount[j_menor]=key6;
            arrayAvailability365[j_menor]=key7;
            arrayName[j_menor]=key8;
            arrayHostName[j_menor]=key9;
            arrayNeighbourhoodGroup[j_menor]=key10;
            arrayNeighbourhood[j_menor]=key11;
            arrayRoomType[j_menor]=key12;
            arrayLastReview[j_menor]=key13;
            arrayLatitude[j_menor]=key14;
            arrayLongitude[j_menor]=key15;
            arrayReviewsPerMonth[j_menor]=key16;

        }
    }

    public static void selectionSortDecrescent(Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights, Integer[] arrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvailability365, String[] arrayName,
                                         String[] arrayHostName, String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] arrayRoomType, String[] arrayLastReview, Double[] arrayLatitude, Double[] arrayLongitude, Double[] arrayReviewsPerMonth) {

        for (int j = 0; j < arrayPrice.length; j++) {
            int j_maior = j;
            for (int k = j + 1; k < arrayPrice.length; k++){
                if (arrayPrice[k] > arrayPrice[j_maior])
                    j_maior = k;
            }

            Integer key1 = arrayPrice[j];
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

            arrayPrice[j]=arrayPrice[j_maior];
            arrayId[j]=arrayId[j_maior];
            arrayHostId[j]=arrayHostId[j_maior];
            arrayMinimumNights[j]=arrayMinimumNights[j_maior];
            arrayNumberOfReviews[j]=arrayNumberOfReviews[j_maior];
            arrayCalculatedHostListingsCount[j]=arrayCalculatedHostListingsCount[j_maior];
            arrayAvailability365[j]=arrayAvailability365[j_maior];
            arrayName[j]=arrayName[j_maior];
            arrayHostName[j]=arrayHostName[j_maior];
            arrayNeighbourhoodGroup[j]=arrayNeighbourhoodGroup[j_maior];
            arrayNeighbourhood[j]=arrayNeighbourhood[j_maior];
            arrayRoomType[j]=arrayRoomType[j_maior];
            arrayLastReview[j]=arrayLastReview[j_maior];
            arrayLatitude[j]=arrayLatitude[j_maior];
            arrayLongitude[j]=arrayLongitude[j_maior];
            arrayReviewsPerMonth[j]=arrayReviewsPerMonth[j_maior];

            arrayPrice[j_maior]=key1;
            arrayId[j_maior]=key2;
            arrayHostId[j_maior]=key3;
            arrayMinimumNights[j_maior]=key4;
            arrayNumberOfReviews[j_maior]=key5;
            arrayCalculatedHostListingsCount[j_maior]=key6;
            arrayAvailability365[j_maior]=key7;
            arrayName[j_maior]=key8;
            arrayHostName[j_maior]=key9;
            arrayNeighbourhoodGroup[j_maior]=key10;
            arrayNeighbourhood[j_maior]=key11;
            arrayRoomType[j_maior]=key12;
            arrayLastReview[j_maior]=key13;
            arrayLatitude[j_maior]=key14;
            arrayLongitude[j_maior]=key15;
            arrayReviewsPerMonth[j_maior]=key16;

        }
    }

    public static void selectionSortCrescent_Names(String[] arrayName, Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights, Integer[] arrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvailability365 ,
                                       String[] arrayHostName, String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] arrayRoomType, String[] arrayLastReview, Double[] arrayLatitude, Double[] arrayLongitude){

        for (int j = 0; j < arrayName.length; j++) {
            int j_menor = j;
            for (int k = j + 1; k < arrayName.length; k++){
                if (arrayName[k].compareTo(arrayName[j_menor])<0)
                    j_menor = k;
            }

            String key1 = arrayName[j];
            int key2 = arrayPrice[j];
            int key3 = arrayId[j];
            int key4 = arrayHostId[j];
            int key5 = arrayMinimumNights[j];
            int key6 = arrayNumberOfReviews[j];
            int key7 = arrayCalculatedHostListingsCount[j];
            int key8 = arrayAvailability365[j];
            String key9 = arrayHostName[j];
            String key10 = arrayNeighbourhoodGroup[j];
            String key11 = arrayNeighbourhood[j];
            String key12 = arrayRoomType[j];
            String key13 = arrayLastReview[j];
            double key14 = arrayLatitude[j];
            double key15 = arrayLongitude[j];
//	            double key16 = arrayReviewsPerMonth[j];

            arrayName[j] = arrayName[j_menor];
            arrayPrice[j]=arrayPrice[j_menor];
            arrayId[j]=arrayId[j_menor];
            arrayHostId[j]=arrayHostId[j_menor];
            arrayMinimumNights[j]=arrayMinimumNights[j_menor];
            arrayNumberOfReviews[j]=arrayNumberOfReviews[j_menor];
            arrayCalculatedHostListingsCount[j]=arrayCalculatedHostListingsCount[j_menor];
            arrayAvailability365[j]=arrayAvailability365[j_menor];
            arrayHostName[j]=arrayHostName[j_menor];
            arrayNeighbourhoodGroup[j]=arrayNeighbourhoodGroup[j_menor];
            arrayNeighbourhood[j]=arrayNeighbourhood[j_menor];
            arrayRoomType[j]=arrayRoomType[j_menor];
            arrayLastReview[j]=arrayLastReview[j_menor];
            arrayLatitude[j]=arrayLatitude[j_menor];
            arrayLongitude[j]=arrayLongitude[j_menor];
//	            arrayReviewsPerMonth[j]=arrayReviewsPerMonth[j_menor];

            arrayName[j_menor]=key1;
            arrayPrice[j_menor]=key2;
            arrayId[j_menor]=key3;
            arrayHostId[j_menor]=key4;
            arrayMinimumNights[j_menor]=key5;
            arrayNumberOfReviews[j_menor]=key6;
            arrayCalculatedHostListingsCount[j_menor]=key7;
            arrayAvailability365[j_menor]=key8;
            arrayHostName[j_menor]=key9;
            arrayNeighbourhoodGroup[j_menor]=key10;
            arrayNeighbourhood[j_menor]=key11;
            arrayRoomType[j_menor]=key12;
            arrayLastReview[j_menor]=key13;
            arrayLatitude[j_menor]=key14;
            arrayLongitude[j_menor]=key15;
//	            arrayReviewsPerMonth[j_menor]=key16;

        }

    }

    public static void selectionSortDecrescent_Names(String[] arrayName, Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights, Integer[] arrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvailability365 ,
                                              String[] arrayHostName, String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] arrayRoomType, String[] arrayLastReview, Double[] arrayLatitude, Double[] arrayLongitude){

        for (int j = 0; j < arrayName.length; j++) {
            int j_maior = j;
            for (int k = j + 1; k < arrayName.length; k++){
                if (arrayName[k].compareTo(arrayName[j_maior])>0)
                    j_maior = k;
            }

            String key1 = arrayName[j];
            int key2 = arrayPrice[j];
            int key3 = arrayId[j];
            int key4 = arrayHostId[j];
            int key5 = arrayMinimumNights[j];
            int key6 = arrayNumberOfReviews[j];
            int key7 = arrayCalculatedHostListingsCount[j];
            int key8 = arrayAvailability365[j];
            String key9 = arrayHostName[j];
            String key10 = arrayNeighbourhoodGroup[j];
            String key11 = arrayNeighbourhood[j];
            String key12 = arrayRoomType[j];
            String key13 = arrayLastReview[j];
            double key14 = arrayLatitude[j];
            double key15 = arrayLongitude[j];
//	            double key16 = arrayReviewsPerMonth[j];

            arrayName[j] = arrayName[j_maior];
            arrayPrice[j]=arrayPrice[j_maior];
            arrayId[j]=arrayId[j_maior];
            arrayHostId[j]=arrayHostId[j_maior];
            arrayMinimumNights[j]=arrayMinimumNights[j_maior];
            arrayNumberOfReviews[j]=arrayNumberOfReviews[j_maior];
            arrayCalculatedHostListingsCount[j]=arrayCalculatedHostListingsCount[j_maior];
            arrayAvailability365[j]=arrayAvailability365[j_maior];
            arrayHostName[j]=arrayHostName[j_maior];
            arrayNeighbourhoodGroup[j]=arrayNeighbourhoodGroup[j_maior];
            arrayNeighbourhood[j]=arrayNeighbourhood[j_maior];
            arrayRoomType[j]=arrayRoomType[j_maior];
            arrayLastReview[j]=arrayLastReview[j_maior];
            arrayLatitude[j]=arrayLatitude[j_maior];
            arrayLongitude[j]=arrayLongitude[j_maior];
//	            arrayReviewsPerMonth[j]=arrayReviewsPerMonth[j_menor];

            arrayName[j_maior]=key1;
            arrayPrice[j_maior]=key2;
            arrayId[j_maior]=key3;
            arrayHostId[j_maior]=key4;
            arrayMinimumNights[j_maior]=key5;
            arrayNumberOfReviews[j_maior]=key6;
            arrayCalculatedHostListingsCount[j_maior]=key7;
            arrayAvailability365[j_maior]=key8;
            arrayHostName[j_maior]=key9;
            arrayNeighbourhoodGroup[j_maior]=key10;
            arrayNeighbourhood[j_maior]=key11;
            arrayRoomType[j_maior]=key12;
            arrayLastReview[j_maior]=key13;
            arrayLatitude[j_maior]=key14;
            arrayLongitude[j_maior]=key15;
//	            arrayReviewsPerMonth[j_menor]=key16;

        }
    }

    public static void selectionSortCrescent_LastReview(Integer[] arrayPrice, Integer[] arrayId, Integer[] arrayHostId, Integer[] arrayMinimumNights, Integer[] arrayNumberOfReviews, Integer[] arrayCalculatedHostListingsCount, Integer[] arrayAvailability365, String[] arrayName,
                                                        String[] arrayHostName, String[] arrayNeighbourhoodGroup, String[] arrayNeighbourhood, String[] arrayRoomType, String[] arrayLastReview, Double[] arrayLatitude, Double[] arrayLongitude, Double[] arrayReviewsPerMonth) {

        int[] arrayYears = new int[arrayLastReview.length];
        int[] arrayMonths = new int[arrayLastReview.length];
        int[] arrayDays = new int[arrayLastReview.length];


        for (int i = 0; i < arrayLastReview.length; i++) {
            String auxStr = arrayLastReview[i];
            String[] arrayAux = auxStr.split("/");

            int year, month, day;
            year = Integer.parseInt(arrayAux[2]);
            month = Integer.parseInt(arrayAux[1]);
            day = Integer.parseInt(arrayAux[0]);

            arrayYears[i] = year;
            arrayMonths[i] = month;
            arrayDays[i] = day;
        }

        for (int j = 0; j < arrayLastReview.length; j++) {
            System.out.println(arrayDays[j] + "/"  + arrayMonths[j] + "/" + arrayYears[j]);
        }
    }
}
