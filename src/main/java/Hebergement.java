public class Hebergement {
    private long id;
    private String dateClassement;
    private String datePublicationEtablissement;
    private String typologieEtablissement;
    private String classement;
    private String categorie;
    private String nomCommercial;
    private String adresse;
    private String codePostal;
    private String commune;
    private String tel;
    private String courrier;
    private String siteInternet;

    public Hebergement(String dateClassement, String datePublicationEtablissement, String typologieEtablissement, String classement, String categorie, String nomCommercial, String adresse, String codePostal, String commune, String tel, String courrier, String siteInternet) {
        this.dateClassement = dateClassement;
        this.datePublicationEtablissement = datePublicationEtablissement;
        this.typologieEtablissement = typologieEtablissement;
        this.classement = classement;
        this.categorie = categorie;
        this.nomCommercial = nomCommercial;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.commune = commune;
        this.tel = tel;
        this.courrier = courrier;
        this.siteInternet = siteInternet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDateClassement() {
        return dateClassement;
    }

    public void setDateClassement(String dateClassement) {
        this.dateClassement = dateClassement;
    }

    public String getDatePublicationEtablissement() {
        return datePublicationEtablissement;
    }

    public void setDatePublicationEtablissement(String datePublicationEtablissement) {
        this.datePublicationEtablissement = datePublicationEtablissement;
    }

    public String getTypologieEtablissement() {
        return typologieEtablissement;
    }

    public void setTypologieEtablissement(String typologieEtablissement) {
        this.typologieEtablissement = typologieEtablissement;
    }

    public String getClassement() {
        return classement;
    }

    public void setClassement(String classement) {
        this.classement = classement;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getNomCommercial() {
        return nomCommercial;
    }

    public void setNomCommercial(String nomCommercial) {
        this.nomCommercial = nomCommercial;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCourrier() {
        return courrier;
    }

    public void setCourrier(String courrier) {
        this.courrier = courrier;
    }

    public String getSiteInternet() {
        return siteInternet;
    }

    public void setSiteInternet(String siteInternet) {
        this.siteInternet = siteInternet;
    }
}
