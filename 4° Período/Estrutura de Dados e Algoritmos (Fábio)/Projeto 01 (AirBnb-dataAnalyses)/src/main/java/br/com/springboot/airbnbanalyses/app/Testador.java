package br.com.springboot.airbnbanalyses.app;


import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static java.text.DateFormat.FULL;

public class Testador {
    public static void main (String []args ) throws IOException, ParseException {
        String dataNotaFiscal = "2018-10-28";

        DateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatUS.parse(dataNotaFiscal);

        DateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");
        String dataConvertida = formatBR.format(date);

        System.out.println(dataConvertida);
    }
}
