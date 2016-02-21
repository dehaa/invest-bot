package com.dehaa.invest.enpara.bot;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Locale;


import com.dehaa.invest.enpara.database.Crud;
import com.dehaa.invest.enpara.database.DataEntity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Created by sefa on 13.01.2016.
 */
public class Bot {

    /**
     *
     * @param text
     * @return
     */
    public static String removeTLString(String text) {

        if (text.length() > 0 && text.endsWith("TL")) {
            text = text.substring(0, text.length() - 3);
        }
        return text;
    }

    public static HashMap<String,Double> fiyatListe() throws IOException, ParseException {
        Document doc = Jsoup.connect("http://www.finansbank.enpara.com/doviz-kur-bilgileri/doviz-altin-kurlari.aspx").get();
        Elements fiyatListe = doc.select("#pnlContent span dl dd .dlCont span");
        if (fiyatListe == null) {
            System.out.println("null geldi");
            System.exit(0);
        }

        HashMap<String, Double> fiyatListeHash = new HashMap<String, Double>();
        fiyatListeHash.put("dolarAlis", Bot.money(Bot.removeTLString(fiyatListe.get(0).text())));
        fiyatListeHash.put("dolarSatis", Bot.money(Bot.removeTLString(fiyatListe.get(1).text())));
        fiyatListeHash.put("euroAlis", Bot.money(Bot.removeTLString(fiyatListe.get(2).text())));
        fiyatListeHash.put("euroSatis", Bot.money(Bot.removeTLString(fiyatListe.get(3).text())));
        fiyatListeHash.put("altinGramAlis", Bot.money(Bot.removeTLString(fiyatListe.get(4).text())));
        fiyatListeHash.put("altinGramSatis", Bot.money(Bot.removeTLString(fiyatListe.get(5).text())));
        fiyatListeHash.put("ceyrekAlis", Bot.money(Bot.removeTLString(fiyatListe.get(6).text())));
        fiyatListeHash.put("ceyrekSatis", Bot.money(Bot.removeTLString(fiyatListe.get(7).text())));

        DataEntity data = new DataEntity();
        data.setAltinGramAlis(fiyatListeHash.get("altinGramAlis"));
        data.setAltinGramSatis(fiyatListeHash.get("altinGramSatis"));
        data.setCeyrekAlis(fiyatListeHash.get("ceyrekAlis"));
        data.setCeyrekSatis(fiyatListeHash.get("ceyrekSatis"));
        data.setDolarAlis(fiyatListeHash.get("dolarAlis"));
        data.setDolarSatis(fiyatListeHash.get("dolarSatis"));
        data.setEuroAlis(fiyatListeHash.get("euroAlis"));
        data.setEuroSatis(fiyatListeHash.get("euroSatis"));
        data.setTime(new Timestamp(System.currentTimeMillis()));

        Crud crud = new Crud();
        crud.addData(data);

        return fiyatListeHash;
    }

    public static double money(String moneyText) throws ParseException {
        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
        Number number = format.parse(moneyText);
        return number.doubleValue();
    }

    public static void main(String[] args) throws IOException, ParseException {
        Bot.fiyatListe();
    }
}

