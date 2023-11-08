import java.text.SimpleDateFormat;
import java.util.Date;

public class Alimentacio extends Producte {
    private Date dataCaducitat;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Alimentacio(String nom, double preu, String codiBarres, Date dataCaducitat) {
        super(nom, preu, codiBarres);
        this.dataCaducitat = dataCaducitat;
    }

    public double calcularPreu() {
        Date dataActual = new Date();
        long diesRestants = (dataCaducitat.getTime() - dataActual.getTime()) / (1000 * 60 * 60 * 24);
        return getPreu() - getPreu() * (1.0 / (diesRestants + 1)) + (getPreu() * 0.1);
    }
}