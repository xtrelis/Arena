package arena2;

import java.io.IOException;
import java.util.Random;

public class Methods {
    
    // Methods
    public static void press_any_key() {         
        System.out.println("Press a key for next turn...\n");
        try
        {
            System.in.read();
        }  
        catch(IOException e)
        {
        }  
    }
    
    public static int random_from_two_numbers() {
        Random rnd = new Random();
        int random = rnd.nextInt(2);
        return random;        
    }
    
    public static int random_from_three_numbers() {
        Random rnd = new Random();
        int random = rnd.nextInt(3);
        return random;        
    }
    
    // Text for normal attacks
    public static void print_attack(Hero h1, Hero h2) {        
        System.out.println("TURN " + h1.get_name() + " attacks like a falcon, " + h2.get_name() + 
            " with power " + h1.get_attack_power() + " units.\n");
    }
    
    // Text for defences
    public static void print_defence(Hero h1, Hero h2) {        
        System.out.println(h1.get_name() + " defends self like a lion, with defence " 
            + h1.get_defence_power() + " units, getting a total hit of power " + h2.get_attack_power() +
            " - " + h1.get_defence_power() + " = " + (h2.get_attack_power() - h1.get_defence_power()) +
            " units.\n");
    }
    
    // Text for special attacks
    public static void print_special_attack(Hero h1) {        
        System.out.println(h1.get_name() + " attacks with the " + h1.get_class_name() + "'s special attack.\n");
    }
    
    // When fighter looses
    public static void print_death(Hero h1) {        
        System.out.println(h1.get_name() + " D E F E A T E D  ! ! !\n");
    }
    
    // When fighter wins
    public static void print_winner(Hero h1) {        
        System.out.println(h1.get_name() + " W I N S  T H E  G A M E  ! ! !\n");
    }
    
    // Check who fighter win and who fighter loose and print
    public static Hero check_winner_and_print(Hero h1, Hero h2) {        
        Hero winner;        
        if (h1.get_life() > 0) {
                print_death(h2);
                print_winner(h1);
                winner = h1;
            }
            else {
                print_death(h1);
                print_winner(h2);
                winner = h2;
            }        
        return winner;
    }
    
    // Check who fighter is the total winner 
    public static Hero check_total_winner_and_print(Hero h1, Hero h2) {        
        Hero winner;        
        if (h1.get_life() > 0) {
                System.out.println(h1.get_name() + " I S  T H E  T O T A L  W I N N E R  ! ! !\n");
                winner = h1;
            }
            else {
                System.out.println(h2.get_name() + " I S  T H E  T O T A L  W I N N E R  ! ! !\n");
                winner = h2;
            }        
        return winner;
    }
    
    public static void print_battle_stats(Hunter h, Warlock w, Xbow b, Xstaff s) {
        h.do_print_stats();
        w.do_print_stats();
        b.print_weapon_stats();
        s.print_weapon_stats();
    }
    
    public static void print_battle_stats(Hunter h, Titan t, Xbow b, Xgun g) {
        h.do_print_stats();
        t.do_print_stats();
        b.print_weapon_stats();
        g.print_weapon_stats();
    }
    
    public static void print_battle_stats(Warlock w, Titan t, Xstaff s, Xgun g) {
        w.do_print_stats();
        t.do_print_stats();
        s.print_weapon_stats();
        g.print_weapon_stats();
    }
    
    public static void battle(Hunter h, Warlock w, Xbow b, Xstaff s) {
        int battle_turn = random_from_two_numbers();
        while (h.get_life() > 0 && w.get_life() > 0) {
            if (battle_turn == 0) {
                print_attack(h, w);
                print_defence(w, h);
                w.do_defence(h.do_normal_attack());
                if (h.isReadyForSpecialAttack(h.get_limit_for_special_attack())) {
                    h.do_special_attack(w);
                }
                print_battle_stats(h, w, b, s);
                battle_turn = 1;
                press_any_key();                
            }
            else {
                if (w.get_life() > 0) {
                    print_attack(w, h);
                    print_defence(h, w);
                    h.do_defence(w.do_normal_attack());
                    if (w.isReadyForSpecialAttack(w.get_limit_for_special_attack())) {
                        w.do_special_attack(w);
                    }
                    print_battle_stats(h, w, b, s);
                    battle_turn = 0;
                    
                    press_any_key();
                }
            }
        }
    }
    
    public static void battle(Hunter h, Titan t, Xbow b, Xgun g) {
        int battle_turn = random_from_two_numbers();
        while (h.get_life() > 0 && t.get_life() > 0) {
            if (battle_turn == 0) {
                print_attack(h, t);
                print_defence(t, h);
                t.do_defence(h.do_normal_attack());
                if (h.isReadyForSpecialAttack(h.get_limit_for_special_attack())) {
                    h.do_special_attack(t);
                }
                print_battle_stats(h, t, b, g);
                battle_turn = 1;
                press_any_key();                
            }
            else {
                if (t.get_life() > 0) {
                    print_attack(t, h);
                    print_defence(h, t);
                    h.do_defence(t.do_normal_attack());
                    if (t.isReadyForSpecialAttack(t.get_limit_for_special_attack())) {
                        t.do_special_attack(t);
                    }
                    print_battle_stats(h, t, b, g);
                    battle_turn = 0;
                    
                    press_any_key();
                }
            }
        }
    }
    
    public static void battle(Warlock w, Titan t, Xstaff s, Xgun g) {
        int battle_turn = random_from_two_numbers();
        while (w.get_life() > 0 && t.get_life() > 0) {
            if (battle_turn == 0) {
                print_attack(w, t);
                print_defence(t, w);
                t.do_defence(w.do_normal_attack());
                if (w.isReadyForSpecialAttack(w.get_limit_for_special_attack())) {
                    w.do_special_attack(t);
                }
                print_battle_stats(w, t, s, g);
                battle_turn = 1;
                press_any_key();                
            }
            else {
                if (t.get_life() > 0) {
                    print_attack(t, w);
                    print_defence(w, t);
                    w.do_defence(t.do_normal_attack());
                    if (t.isReadyForSpecialAttack(t.get_limit_for_special_attack())) {
                        t.do_special_attack(t);
                    }
                    print_battle_stats(w, t, s, g);
                    battle_turn = 0;
                    
                    press_any_key();
                }
            }
        }
    }
    
}
