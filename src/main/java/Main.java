import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println("Connection to server sucessfully");
        //set the data in redis string
        long valeur1 = System.currentTimeMillis();
        jedis.set("tutorial-name", "Redis tutorial");
        long valeur2 = System.currentTimeMillis();
        System.out.println("Temps d'execution : " + (valeur2 - valeur1) + "ms");
        // Get the stored data and print it
        System.out.println("Server is running: " + jedis.ping());
        System.out.println("Stored string in redis:: " + jedis.get("tutorial-name"));

        jedis.del("tutorial-name");
        System.out.println("Stored string in redis:: " + jedis.get("tutorial-name"));
    }


    public void recupererValeur() {
        String csvFile = "/home/david/Documents/test-hebergements.csv";
        String line = "";
        String cvsSplitBy = ",";
        int cpt = 0;
        List<String> listPhrase = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator
                cpt++;
                String[] ligne = line.split(cvsSplitBy);
                String DATE_DE_CLASSEMENT = ligne[0];
                String DATE_DE_PUBLICATION_ETABLISSEMENT = ligne[1];
                String TYPOLOGIE_ETABLISSEMENT = ligne[2];
                String CLASSEMENT = ligne[3];
                String CATEGORIE = ligne[4];
                String NOM_COMMERCIAL = ligne[5].replaceAll(" ", "-");
                String ADRESSE = ligne[6].replaceAll(" ", "-");
                String CODE_POSTAL = ligne[7];
                String COMMUNE = ligne[8];
                String TELEPHONE = ligne[9];
                String COURRIEL = ligne[10];
                String SITE_INTERNET = ligne[11];
                String phraseFinal = "eval curl -i -X POST http://localhost:8098/riak/heb -H \"Content-Type:application/json\" -d \"{" +
                        "\"" + "DATE_DE_CLASSEMENT" + "\"" + ":" + "\"" + DATE_DE_CLASSEMENT + "\"," +
                        "\"" + "DATE_DE_PUBLICATION_ETABLISSEMENT" + "\"" + ":" + "\"" + DATE_DE_PUBLICATION_ETABLISSEMENT + "\"," +
                        "\"" + "TYPOLOGIE_ETABLISSEMENT" + "\"" + ":" + "\"" + TYPOLOGIE_ETABLISSEMENT + "\"," +
                        "\"" + "CLASSEMENT" + "\"" + ":" + "\"" + CLASSEMENT + "\"," +
                        "\"" + "CATEGORIE" + "\"" + ":" + "\"" + CATEGORIE + "\"," +
                        "\"" + "NOM_COMMERCIAL" + "\"" + ":" + "\"" + NOM_COMMERCIAL + "\"," +
                        "\"" + "ADRESSE" + "\"" + ":" + "\"" + ADRESSE + "\"," +
                        "\"" + "CODE_POSTAL" + "\"" + ":" + "\"" + CODE_POSTAL + "\"," +
                        "\"" + "COMMUNE" + "\"" + ":" + "\"" + COMMUNE + "\"," +
                        "\"" + "TELEPHONE" + "\"" + ":" + "\"" + TELEPHONE + "\"," +
                        "\"" + "COURRIEL" + "\"" + ":" + "\"" + COURRIEL + "\"" +
                        //	"\"" + "SITE_INTERNET" + "\""  + ":" + "\"" +SITE_INTERNET+ "\","+
                        "}\"";
                listPhrase.add(phraseFinal);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String string : listPhrase) {

        }

    }

}
