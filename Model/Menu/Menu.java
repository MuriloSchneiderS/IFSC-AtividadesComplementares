package Model.Menu;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private String titulo;
    private List<ItemMenu> itensDeMenu;
    static Scanner input = new Scanner(System.in);

    public Menu(String titulo, ItemMenu... itens) {
        this.titulo = titulo;
        this.itensDeMenu = Arrays.asList(itens);
    }

    public void exibir(){
        boolean continuar = true;
        do{
            System.out.println(titulo);
            for (ItemMenu item : itensDeMenu) {
                System.out.println(item.numero() + ") " + item.titulo());
            }
            continuar = Menu.escolha(this.itensDeMenu);
        }while(continuar);
    }
    private static boolean escolha(List<ItemMenu> itensDeMenu) {
        System.out.println("Escolha uma opção: ");
        try{
            int opcao = input.nextInt();
            for (ItemMenu item : itensDeMenu) {
                if (item.numero() == opcao) {
                    item.exibir();
                    return !(item instanceof OpcaoFinal);
                }
            }
            return true;
        }catch(Exception e) {
            System.out.println("Opção inválida. Tente novamente.");
            input.nextLine();
            return true;
        }
    }
}
