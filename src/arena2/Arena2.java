package arena2;

import static arena2.Methods.battle;
import static arena2.Methods.check_total_winner_and_print;
import static arena2.Methods.check_winner_and_print;
import static arena2.Methods.random_from_three_numbers;

public class Arena2 {
    
    // Constructor
    public Arena2(){
        
    }
    
    public static void main(String[] args) {
        
        // Create Objects-Fighters
        Hunter hunter1 = new Hunter("Hun", 'M');
        Warlock warlock1 = new Warlock("War", 'F');
        Titan titan1 = new Titan("Tit", 'M');
        
        // Print Fighters
        hunter1.do_print_stats();
        warlock1.do_print_stats();
        titan1.do_print_stats();
        
        // Create Objects-Guns
        Xbow bow1 = new Xbow();
        Xstaff staff1 = new Xstaff();
        Xgun gun1 = new Xgun();
        
        // Print Weapons
        bow1.print_weapon_stats();
        staff1.print_weapon_stats();
        gun1.print_weapon_stats();
        
        // Fighters Attach Weapons
        hunter1.do_attach_weapon(bow1);
        warlock1.do_attach_weapon(staff1);
        titan1.do_attach_weapon(gun1);
        
        // Print Fighters
        hunter1.do_print_stats();
        warlock1.do_print_stats();
        titan1.do_print_stats();
        
        // Random number for random battle
        switch(random_from_three_numbers()) {
            case 0: {
                battle(hunter1, warlock1, bow1, staff1);
                check_winner_and_print(hunter1, warlock1);
                if (hunter1.get_life() > 0) {
                    hunter1.do_reset_stats();
                    bow1.initialize_weapon();
                    hunter1.do_attach_weapon(bow1);
                    battle(hunter1, titan1, bow1, gun1);
                    check_total_winner_and_print(hunter1, titan1);
                }
                else {
                    warlock1.do_reset_stats();
                    staff1.initialize_weapon();
                    warlock1.do_attach_weapon(staff1);
                    battle(warlock1, titan1, staff1, gun1);
                    check_total_winner_and_print(warlock1, titan1);
                }
                break;
            }
            case 1: {
                battle(hunter1, titan1, bow1, gun1);
                check_winner_and_print(hunter1, titan1);
                if (hunter1.get_life() > 0) {
                    hunter1.do_reset_stats();
                    bow1.initialize_weapon();
                    hunter1.do_attach_weapon(bow1);
                    battle(hunter1, warlock1, bow1, staff1);
                    check_total_winner_and_print(hunter1, warlock1);
                }
                else {
                    titan1.do_reset_stats();
                    gun1.initialize_weapon();
                    titan1.do_attach_weapon(gun1);
                    battle(warlock1, titan1, staff1, gun1);
                    check_total_winner_and_print(warlock1, titan1);
                }
                break;
            }
            default: {
                battle(warlock1, titan1, staff1, gun1);
                check_winner_and_print(warlock1, titan1);
                if (warlock1.get_life() > 0) {
                    warlock1.do_reset_stats();
                    staff1.initialize_weapon();
                    warlock1.do_attach_weapon(staff1);
                    battle(hunter1, warlock1, bow1, staff1);
                    check_total_winner_and_print(hunter1, warlock1);
                }
                else {
                    titan1.do_reset_stats();
                    gun1.initialize_weapon();
                    titan1.do_attach_weapon(gun1);
                    battle(hunter1, titan1, bow1, gun1);
                    check_total_winner_and_print(hunter1, titan1);
                }
                break;
            }    
        }
    }    
}
