package com.group_31;

import java.util.*;
import java.util.stream.Collectors;

public class BlackJack {
    static Boolean endOrNot = false;
    static Map<Player,Integer>choices = new HashMap<>();
    static List<Player> players = new ArrayList<>();
    static Map<Player,Integer>scores = new HashMap<>();
    static List<Player>eliminatedPlayers = new ArrayList<>();

    static void complete(){
       long stick = choices.values().stream().filter(x -> x == 2).count() ;
       if (stick == players.size()){
           Optional<Player>winner = players.stream().max((o1, o2) ->{
               if(o1.getValue()> o2.getValue())
                   return 1;
               if (o1.getValue()< o2.getValue())
                   return  -1;
               return 0;
           });
           if(winner.isPresent()){
               System.out.println(winner.get().name + " won");

               endOrNot=true;
               return;
           }

       }
       Optional<Player>winner = players.stream().filter(x -> x.getValue() ==21).findFirst();
        if(winner.isPresent()){
            System.out.println(winner.get().name + " won");

            endOrNot=true;
            return;
        }

        eliminatedPlayers.addAll(players.stream().filter(x -> x.getValue() >21).collect(Collectors.toList()));
    }




    public static void main(String[] args) {
        int number= args.length>0? Integer.parseInt( args[0]):3;

        if(number<2 || number >6) {
            System.out.println(" Okay");

            return;
        }
        for (int i = 0; i <number;i++){
            players.add(new Player("Player " + (i+1)));
        }
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        System.out.println(playingDeck.size());
        playingDeck.shuffle();
        System.out.println(playingDeck.size());
        int totalCardValue = 0;
        for (Player player : players) {
            player.hand.add(playingDeck.deal());
            player.hand.add(playingDeck.deal());
            System.out.println(player.name + "'s hand = " + player.hand + " cards total = " + player.getValue());

        }
        System.out.println();
         while(!endOrNot){
             int playersInARound = players.size();
             for (int i = 0;i<players.size();i++) {
                 Player player = players.get(i);
                 totalCardValue = player.hand.stream().map(Card::getValue).reduce(0, Integer::sum);
                 if (totalCardValue < 17) {

                     player.hand.add(playingDeck.deal());
                     choices.put(player,1);

                 }
                 else{
                     choices.put(player,2);

                 }
                 System.out.println(player.name + "'s hand = " + player.hand + " cards total = " + player.getValue());
                 scores.put(player,player.getValue());
                 if (i == players.size()-1){
                     complete();

                 }

             }
             System.out.println();
             players.removeAll(eliminatedPlayers);
             for(Player player : eliminatedPlayers){
                 scores.remove(player);
                 choices.remove(player);

             }
             if(players.size()==1){
                 System.out.println(players.get(0).name);
                 endOrNot = true;
             }
             if(players.size()==0){
                 System.out.println("No winners");
                 endOrNot= true;
             }
         }


    }

}

