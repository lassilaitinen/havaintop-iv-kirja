/**
 * 
 */
package paivakirja;

/**
 * Päiväkirja-luokka
 *|------------------------------------------------------------------------|
 *| Luokan nimi:   Päiväkirja                          | Avustajat:        |
 *|-------------------------------------------------------------------------
 *| Vastuualueet:                                      |                   | 
 *|                                                    | - Havainnot       | 
 *| - Huolehtii Havainto - ja Laji -luokkien välisestä | - Lajit           |
 *|   yhteistyöstä                                     | - Havainto        |
 *| - välittää em. luokkien tietoja jos niitä          | - Laji            | 
 *|   pyydetään                                        |                   |
 *| - lukee ja kirjoittaa päiväkirjan tiedostoon       |                   | 
 *|   avustajien avulla                                |                   |
 *|                                                    |                   | 
 *|-------------------------------------------------------------------------
 * @author lassi
 * @version 27.2.2022
 *
 */
public class Paivakirja {
    private final Havainnot havainnot = new Havainnot();
    
    
    /**
     * Palauttaa havaintojen lukumäärän
     * @return havaintojen lukumäärä
     */
    public int getLukumaara() {
        return havainnot.getLkm();
    }
    
    
    /**
     * Havainnon lisääminen
     * @param havainto Havainto joka lisätään
     * @throws TilaException Virheilmoitus jos ei voida lisätä
     */
    public void lisaa(Havainto havainto) throws TilaException {
        havainnot.lisaa(havainto);
    }
    
    
    /**
     * Palauttaa i:n havainnon
     * @param i Monesko havainto halutaan
     * @return Halutun havainnon viite
     * @throws IndexOutOfBoundsException Virheilmoitus jos i ei kelpaa
     */
    public Havainto annaHavainto(int i) throws IndexOutOfBoundsException {
        return havainnot.anna(i);
    }
    
    
    /**
     * Lukee havainnot tiedostosta
     * @param tiedosto Tiedosto
     * @throws TilaException Virheilmoitus jos ei onnistu
     */
    public void lueTiedosto(String tiedosto) throws TilaException {
        havainnot.lueTiedosto(tiedosto);
    }
    
    
    /**
     * Tallentaa havainnot tiedostoon
     * @throws TilaException Virheilmoitus jos tallennus ei onnistu
     */
    public void tallenna() throws TilaException {
        havainnot.tallenna();
    }
    
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Paivakirja paivakirja = new Paivakirja();

        Havainto hirvi = new Havainto();
        Havainto kauris = new Havainto();
            
        hirvi.rekisterointi();
        kauris.rekisterointi();
        hirvi.vastaa();
        kauris.vastaa();
            
        try {   
            paivakirja.lisaa(hirvi);
            paivakirja.lisaa(kauris);

            System.out.println("TESTATAAN OHJELMAA:");

            for (int i = 0; i < paivakirja.getLukumaara(); i++) {
                Havainto havainto = paivakirja.annaHavainto(i);
                System.out.println("Havainnon id: " + i);
                havainto.tulosta(System.out);
            }

        } catch (TilaException viesti) {
            System.out.println(viesti.getMessage());
        }
    
    }

}
