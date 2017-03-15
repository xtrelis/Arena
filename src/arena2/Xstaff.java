package arena2;

import java.util.Random;

public class Xstaff implements auto_staff {
    
    // Properties --------------------------------------------------------------
    private final String name;
    private double weapon_power;
    
    // Constructor -------------------------------------------------------------
    public Xstaff() {
        name = "Xstaff";
        Random rnd = new Random();
        weapon_power = (double)(rnd.nextInt(10) + 5) / 100;
    }
    
    // Getters -----------------------------------------------------------------
    public String get_name() {
        return name;
    }
    
    public double get_weapon_power() {
        return weapon_power;
    }
    
    // Methods -----------------------------------------------------------------
    @Override
    public void initialize_weapon() {       
        Random rnd = new Random();
        weapon_power = (double)(rnd.nextInt(10) + 5) / 100; 
    }
    
    @Override
    public void print_weapon_stats() {
        System.out.println("--- Weapon Statistics ---");
        System.out.println("Name:         " + get_name());
        System.out.println("Attack Power: " + get_weapon_power());
        System.out.println("-------------------------\n");
    }
    
    @Override
    public void extra_auto_staff_init() {
        
    }
}
