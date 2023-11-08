import java.text.SimpleDateFormat;
import java.util.*;

public class Main {


    private static ArrayList<Producte> carroCompra = new ArrayList<>();
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static String nomSupermercat = "Frankmarket";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        int opcio;
        do {
            opcio = menu.mostrarMenu();

            switch (opcio) {
                case 1:
                    int subOpcio = menu.mostrarSubMenuProducte();
                    switch (subOpcio) {
                        case 1:
                            System.out.print("Nom de l'alimentació: ");
                            String nomAlimentacio = scanner.nextLine();
                            System.out.print("Preu: ");
                            double preuAlimentacio = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Codi de barres: ");
                            String codiBarresAlimentacio = scanner.nextLine();
                            System.out.print("Data de caducitat (dd/MM/yyyy): ");
                            try {
                                Date dataCaducitat = dateFormat.parse(scanner.nextLine());
                                Alimentacio alimentacio = new Alimentacio(nomAlimentacio, preuAlimentacio, codiBarresAlimentacio, dataCaducitat);
                                carroCompra.add(alimentacio);
                                System.out.println("Producte afegit al carro.");
                            } catch (Exception e) {
                                System.out.println("Error en el format de data.");
                            }
                            break;

                        case 2:
                            System.out.print("Nom del tèxtil: ");
                            String nomTextil = scanner.nextLine();
                            System.out.print("Preu: ");
                            double preuTextil = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Codi de barres: ");
                            String codiBarresTextil = scanner.nextLine();
                            System.out.print("Composició tèxtil: ");
                            String composicioTextil = scanner.nextLine();
                            Textil textil = new Textil(nomTextil, preuTextil, codiBarresTextil, composicioTextil);
                            carroCompra.add(textil);
                            System.out.println("Producte afegit al carro.");
                            break;

                        case 3:
                            System.out.print("Nom de l'electrònica: ");
                            String nomElectronica = scanner.nextLine();
                            System.out.print("Preu: ");
                            double preuElectronica = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Codi de barres: ");
                            String codiBarresElectronica = scanner.nextLine();
                            System.out.print("Dies de garantia: ");
                            int diesGarantia = scanner.nextInt();
                            scanner.nextLine();
                            Electronica electronica = new Electronica(nomElectronica, preuElectronica, codiBarresElectronica, diesGarantia);
                            carroCompra.add(electronica);
                            System.out.println("Producte afegit al carro.");
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Opció no vàlida");
                    }
                    break;
                case 2:
                    mostrarCarroCompra();
                    break;
                case 3:
                generarTiquetCompra(nomSupermercat);
                carroCompra.clear();
                break;
                case 0:
                    System.out.println("chao pescao");
                    break;
                default:
                    System.out.println("pon una opcion valida.");
            }
        } while (opcio != 0);
    }
    private static void generarTiquetCompra(String nomSupermercat) {
        if (carroCompra.isEmpty()) {
            System.out.println("el carro de la compra esta vacío.");
            return;
        }

        System.out.println("tiquet de Compra de " + nomSupermercat);
        System.out.println("data de la compra: " + dateFormat.format(new Date()));

        Map<String, Producte> productesUnics = new HashMap<>();
        for (Producte producte : carroCompra) {
            if (!productesUnics.containsKey(producte.getCodiBarres())) {
                productesUnics.put(producte.getCodiBarres(), producte);
            }
        }
        for (Producte producte : productesUnics.values()) {
            int quantitat = 0;
            for (Producte item : carroCompra) {
                if (item.getCodiBarres().equals(producte.getCodiBarres())) {
                    quantitat++;
                }
            }
            if (producte instanceof Alimentacio) {
                Alimentacio alimentacio = (Alimentacio) producte;
                System.out.println(producte.getNom() + " x" + quantitat + " - " + alimentacio.calcularPreu() + "€/unitat");
            } else if (producte instanceof Electronica) {
                Electronica electronica = (Electronica) producte;
                System.out.println(producte.getNom() + " x" + quantitat + " - " + electronica.calcularPreu() + "€/unitat");
            } else if (producte instanceof Textil) {
                System.out.println(producte.getNom() + " x" + quantitat + " - " + producte.getPreu() + "€/unitat");
            }
        }
        double total = calcularTotalCompra();
        System.out.println("Total a pagar: " + total + "€");
    }
    private static void mostrarCarroCompra() {
        if (carroCompra.isEmpty()) {
            System.out.println("el carro de la compra esta vacio.");
            return;
        }

        System.out.println("carro de la compra:");
        for (Producte producte : carroCompra) {
            System.out.println(producte.getNom());
        }
    }

    private static double calcularTotalCompra() {
        double total = 0.0;
        for (Producte producte : carroCompra) {
            if (producte instanceof Alimentacio) {
                Alimentacio alimentacio = (Alimentacio) producte;
                total += alimentacio.calcularPreu();
            } else if (producte instanceof Electronica) {
                Electronica electronica = (Electronica) producte;
                total += electronica.calcularPreu();
            } else if (producte instanceof Textil) {
                total += producte.getPreu();
            }
        }
        return total;
    }

}
