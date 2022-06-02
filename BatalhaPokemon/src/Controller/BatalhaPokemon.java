package Controller;

import Models.Pokemon;
import java.util.Scanner;

public class BatalhaPokemon {

    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in);
        
        Pokemon pokemon = new Pokemon();
        
        String nome;
        String opcao;
        boolean desejaContinuar = false;
        boolean flag = true;
        int rodada;
        
        System.out.println("Olá. Seja bem vindo à batalha pokemon!");
       
        while(true){    
            
            Pokemon pokemonInimigo = new Pokemon("Mewtwo",150,10,40);
            
            System.out.print("\nQual seu nome? ");
            nome = leitor.next();

            desceConsole();
            
            do{
                
                System.out.println("1 - Bulbasaur");
                System.out.println("2 - Squirtle");
                System.out.println("3 - Charmander");
                System.out.print(nome + ", escolha o pokemon desejado: ");
                opcao = leitor.next();
                desceConsole();

                switch(opcao){
                    case "1":
                        setarAtributosPokemon(pokemon, "Bulbasaur", 150,30,20);
                        System.out.println(pokemon);
                        desejaContinuar = desejaContinuar(leitor);
                        break;
                    case "2":
                        setarAtributosPokemon(pokemon, "Squirtle", 100,20,30);
                        System.out.println(pokemon);
                        desejaContinuar = desejaContinuar(leitor);
                        break;
                    case "3":
                        setarAtributosPokemon(pokemon, "Charmander", 80, 10, 75);
                        System.out.println(pokemon);
                        desejaContinuar = desejaContinuar(leitor);
                        break;
                    default:
                        System.out.println("\nOpção inválida. Tente novamente.");
                        break;
                }

            }while(!desejaContinuar);

            desceConsole();
            System.out.println("Pokemon inimigo: ");
            System.out.println(pokemonInimigo);
            System.out.println("");

            while(flag){
                System.out.println("1 - Começar batalha");
                System.out.println("2 - Desistir");
                System.out.print("Escolha a opção desejada: ");
                opcao = leitor.next();
                
                flag = verificaOpcao(opcao);
            }
            flag = true;

            if(opcao.equals("2")){
                desceConsole();
                System.out.println("Você desistiu da batalha, logo perdeu por W.O");
                break;
            }
            
            desceConsole();
            System.out.println("Prepare-se, a batalha irá iniciar!");
            
            rodada = 1;
            while(true){

                System.out.println("Sua vida: " + pokemon.getVida());
                System.out.println("Vida de Mewtwo: " + pokemonInimigo.getVida());
                System.out.println("");
                
                while(flag){
                    System.out.println("1 - Atacar");
                    System.out.println("2 - Curar");
                    System.out.print("Escolha a opção desejada: ");
                    opcao = leitor.next();
                    
                    flag = verificaOpcao(opcao);
                }
                flag = true;
                System.out.println("");
                
                if ( opcao.equals("1") ){
                    pokemonInimigo.setVida(pokemonInimigo.getVida() - pokemon.getAtaque());
                    System.out.println("Mewtwo atacado com sucesso!");
                } else {
                    pokemon.setVida(pokemon.getVida() + pokemon.getCura());
                    System.out.println(pokemon.getNome() + " curado com sucesso!");
                    System.out.println("Sua vida: " + pokemon.getVida());
                }
                
                System.out.println("");
                
                if ( pokemonInimigo.getVida() > 0 ){
                    pokemon.setVida(pokemon.getVida() - pokemonInimigo.getAtaque());
                    System.out.println("Você foi atacado por Mewtwo!");
                    System.out.println("");
                } else {
                    System.out.println("Você é o grande vencedor da batalha contra Mewtwo!");
                    break;
                }
                
                if ( pokemon.getVida() <= 0 ){
                    System.out.println("Infelizmente, você perdeu esta batalha! Talvez na próxima você ganhe.");
                    break;
                }
                
                rodada++;
            }
            
            System.out.println("Número de rodadas: " + rodada);
            System.out.println("");
            desejaContinuar = desejaContinuar(leitor);
            
            if (!desejaContinuar){
                break;
            }
        }
        
        System.out.println("\nObrigado por utilizar meu sistema!");
        
    }
    
    public static void desceConsole(){
        for(int i=0; i<100; i++){
            System.out.println("");
        }
    }
    
    public static void setarAtributosPokemon(Pokemon pokemon, String nome, int vida, int cura, int ataque){
        pokemon.setNome(nome);
        pokemon.setVida(vida);
        pokemon.setCura(cura);
        pokemon.setAtaque(ataque);
    }
 
    public static boolean desejaContinuar(Scanner leitor){
        String opcao = "";
        boolean flag = true;
        
        while(flag){
            System.out.print("\nDeseja continuar? 1 - sim | 2 - não : ");
            opcao = leitor.next();
            
            if ( opcao.equals("1") || opcao.equals("2") ){
                flag = false;
            } else {
                System.out.println("\nOpção inválida. Tente novamente.");
            }
        }
        
        desceConsole();
        return opcao.equals("1") ? true : false;
    }
    
    public static boolean verificaOpcao(String opcao){
        if( opcao.equals("1") || opcao.equals("2") ){
            return false;
        } else {
            System.out.println("\nOpção inválida. Tente novamente.");
            return true;
        }
    }
    
}
