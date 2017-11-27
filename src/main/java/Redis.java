import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class Redis {

	private Jedis jedis = new Jedis("localhost", 6379);
	private List<Hebergement> listHebergements;

	public Redis(List<Hebergement> listHebergements) {
		this.listHebergements = listHebergements;
	}
	


	public long calculTempsExecutionSet(Hebergement hebergement) {

		long id = jedis.incr("Id");

		Map<String, String> hash = new HashMap<String, String>();
		hash.put("DATE_DE_CLASSEMENT", hebergement.getDateClassement());
		hash.put("DATE_DE_PUBLICATION_ETABLISSEMENT", hebergement.getDatePublicationEtablissement());
		hash.put("TYPOLOGIE_ETABLISSEMENT", hebergement.getTypologieEtablissement());
		hash.put("CLASSEMENT", hebergement.getClassement());
		hash.put("CATEGORIE", hebergement.getCategorie());
		hash.put("NOM_COMMERCIAL", hebergement.getNomCommercial());
		hash.put("ADRESSE", hebergement.getAdresse());
		hash.put("CODE_POSTAL", hebergement.getCodePostal());
		hash.put("COMMUNE", hebergement.getCommune());
		hash.put("TELEPHONE", hebergement.getTel());
		hash.put("COURRIEL", hebergement.getCourrier());

		long valeur1 = System.currentTimeMillis();
		jedis.hmset(String.valueOf(id), hash);
		long valeur2 = System.currentTimeMillis();
		return (valeur2 - valeur1);
	}

	public long calculTempsExecutionGet(long id) {
		long valeur1 = System.currentTimeMillis();
		List<String> items = jedis.hmget("Id"+id, "DATE_DE_CLASSEMENT", "DATE_DE_PUBLICATION_ETABLISSEMENT",
				"TYPOLOGIE_ETABLISSEMENT", "CLASSEMENT", "CATEGORIE", "NOM_COMMERCIAL", "ADRESSE", "CODE_POSTAL", "COMMUNE",
				"TELEPHONE", "COURRIEL");
		long valeur2 = System.currentTimeMillis();
		
		return (valeur2 - valeur1);
	}

	public long calculTempsExecutionDelete(long id) {
		long valeur1 = System.currentTimeMillis();
		jedis.del("Id"+id);
		long valeur2 = System.currentTimeMillis();
		return (valeur2 - valeur1);
	}
	
	public long moyenneTempsGet(int nbElement){
		long tempsCumulé = 0;
		for (int i = 1; i <= nbElement; i++) {
			tempsCumulé += calculTempsExecutionGet(i);
		}
		return tempsCumulé/nbElement;
	}
	public long moyenneTempsSet(int nbElement){
		long tempsCumulé = 0;
		for (int i = 0; i < nbElement; i++) {
			tempsCumulé += calculTempsExecutionSet(listHebergements.get(i));
		}
		return tempsCumulé/nbElement;
	}
	public long moyenneTempsDelete(int nbElement){
		long tempsCumulé = 0;
		for (int i = 1; i <= nbElement; i++) {
			tempsCumulé += calculTempsExecutionDelete(i);
		}
		return tempsCumulé/nbElement;
	}

}
