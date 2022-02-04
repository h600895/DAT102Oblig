import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;

public interface FilmarkivADT {
    /**

     * Hente en film med gitt nr fra arkivet
     *
     * @param nr nummer på film som skal hentes.
     * @return film med gitt nr. Om nr ikke finnes, returneres null.
     */

    Film finnFilm(int nr);

    /**
     * Legger til en ny film
     * @param nyFilm
     */
    void leggTilFilm(Film nyFilm);

    /**
     * Sletter en fil med gitt nr
     * @param filmnr på film som skal slettes
     * @return true dersom filen blir slettet, false ellers
     */
    boolean slettFilm(int filmnr);

    /**
     * Søker og henter Filmer med en gitt delstreng i tittelen.
     * @param delstreng som må være med i tittel.
     * @return tabell med filmer som har delstreng i tittel
     */
    Film[] soekTittel (String delstreng);

    /**
     * Finner antall filmer med gitt sjanger
     * @param sjanger
     * @return antall filmer av gitt sjanger.
     */
    int antall(Sjanger sjanger);

    /**
     * @return antall filmer i arkivet
     */
    int antall();
}