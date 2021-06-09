package apiConfig;

public interface Endpoints {
      String APIURL = "https://api.allegro.pl";
      String SALE = "/sale";
      String CATEGORIES = "/sale/categories";
      String TAG = SALE+"/offer-tags";
      String BLACKLIST = "/sale/blacklisted-users";
      String CONTACTS = SALE+"/offer-contacts";
      String SINGLE_CONTACT = CONTACTS+"/{id}";
      String ALLEGRO_BASE = "https://allegro.pl";
      String PARAMETERS = "/parameters";
      String ACCOUNT = "/account";
      String ADDITIONAL_EMAIL = ACCOUNT+"/additional-emails";
      String SELLERS_OFFERS = SALE + "/offers";
}
