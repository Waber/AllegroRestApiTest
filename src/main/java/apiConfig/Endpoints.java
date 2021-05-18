package apiConfig;

public interface Endpoints {
      String APIURL = "https://api.allegro.pl";
      String SALE = "/sale";
      String CATEGORIES = "/sale/categories";
      String TAG = SALE+"/offer-tags";
      String BLACKLIST = "/sale/blacklisted-users";
      String CONTACTS = SALE+"/offer-contacts";
      String ALLEGRO_BASE = "https://allegro.pl";
      String PARAMETERS = "/parameters";
      String ACCOUNT = "/account";
      String ADDITIONAL_EMAIL = ACCOUNT+"/additional-emails";
}
