package View.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private String titulo;
    private ArrayList<ItemMenu> itensDeMenu;
    static Scanner input = new Scanner(System.in);

    public Menu(String titulo, ArrayList<ItemMenu> itens) {
        this.titulo = titulo;
        this.itensDeMenu = itens;
    }

    public void exibir(){
        boolean continuar = true;
        do{
            System.out.println(titulo);
            for (ItemMenu item : itensDeMenu) {// Exibe o número e o título de cada item do menu
                System.out.println(item.numero() + ") " + item.titulo());
            }
            // Chama o método estático escolha para obter a opção do usuário
            continuar = Menu.escolha(this.itensDeMenu);
        }while(continuar);// Continua exibindo o menu até que uma opção de voltar seja selecionada
    }
    private static boolean escolha(List<ItemMenu> itensDeMenu) {
        System.out.println("Escolha uma opção: ");
        try{
            int opcao = input.nextInt();
            for (ItemMenu item : itensDeMenu) {
                if (item.numero() == opcao) {
                    item.exibir();// Chama o método exibir do item selecionado
                    // Verifica se o item é uma instância de OpcaoVoltar
                    return !(item instanceof OpcaoVoltar);
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
