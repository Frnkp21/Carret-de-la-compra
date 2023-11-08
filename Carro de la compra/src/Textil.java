public class Textil extends Producte {
    String composicioTextil;

    public Textil(String nom, double preu, String codiBarres, String composicioTextil) {
        super(nom, preu, codiBarres);
        this.composicioTextil = composicioTextil;
    }
}
