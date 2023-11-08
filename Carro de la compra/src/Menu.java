import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║              Menu           ║");
        System.out.println("╠═════════════════════════════╣");
        System.out.println("║1. Introduir producte        ║");
        System.out.println("║2. Mostrar carro de la compra║");
        System.out.println("║3. Passar per caixa          ║");
        System.out.println("║0. Sortir                    ║");
        System.out.println("╠═════════════════════════════╣");
        System.out.print("Escull una opció: ");
        return scanner.nextInt();
    }

    public int mostrarSubMenuProducte() {
        System.out.println("╔═══════════════════════════════════╗");
        System.out.println("║Quin tipus de producte vols afegir?║");
        System.out.println("╠═══════════════════════════════════╣");
        System.out.println("║1. Alimentació                     ║");
        System.out.println("║2. Tèxtil                          ║");
        System.out.println("║3. Electrònica                     ║");
        System.out.println("║0. Tornar                          ║");
        System.out.println("╠═══════════════════════════════════╣");
        System.out.print("Escull una opcio: ");
        return scanner.nextInt();
    }
}
