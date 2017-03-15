package arena2;

import java.util.Random;

public class Titan extends Hero {
    
    // Properties --------------------------------------------------------------
    private int limit_for_special_attack;
    
    // Constructor -------------------------------------------------------------
    public Titan(String name, char sex) {        
        super(name, sex);
        super.set_class_name("Titan");
        super.set_life(1200);
        super.set_attack_power(super.get_life() * 0.1);
        if (sex == 'M') {
            super.set_attack_power(super.get_attack_power() + (super.get_attack_power() * 0.05));
        }
        super.set_defence_power(super.get_life() * 0.05);
        super.set_agility(0.1);
        if (sex == 'F') {
            super.set_agility(super.get_agility() + 0.1);
        }
        limit_for_special_attack = 25;
    }
    
    // Setters -----------------------------------------------------------------
    public void set_has_a_weapon() {
        has_a_weapon = true;
    }
    
    // Getters -----------------------------------------------------------------
    public int get_limit_for_special_attack() {
        return limit_for_special_attack;
    }
    
    // Methods -----------------------------------------------------------------
    @Override
    public double do_normal_attack() {
        double normal_attack;        
        normal_attack = get_attack_power() + (get_attack_power() * get_agility());        
        return normal_attack;  
    }
    
    @Override
    public double do_defence() {
        return 0;
    }
    
    // Overload
    public double do_defence(double normal_attack) {        
        normal_attack -= get_defence_power();
        set_life(get_life() - normal_attack);
        if (get_life() < 0) {
            set_life(0);
        }
        set_ready_for_special_attack(1);
        return normal_attack;
    }

    @Override
    public double do_special_attack() {
        return 0;
    }
    
    public void do_special_attack(Hero opponent) {    
        Random rnd = new Random();
        int number = rnd.nextInt(100) + 1;
        System.out.println( "Possibility for Crush Attack 50%. Random number is: " + number + "\n");
        if (number >= 1 && number <= 50) {
            opponent.set_life(0);
        }
    }
    
    @Override
    public void do_reset_stats() {
        set_life(1200);
        set_attack_power(get_life() * 0.1);
        if (get_sex() == 'M') {
            set_attack_power(get_attack_power() + (get_attack_power() * 0.05));
        }
        set_defence_power(get_life() * 0.05);
        set_ready_for_special_attack(0);
    }
    
    @Override
    public void do_print_stats() {
        System.out.println("----------- Fighter Statistics -----------");
        System.out.println("Class:                              " + get_class_name());
        System.out.println("Name:                               " + get_name());
        System.out.println("Sex:                                " + get_sex());
        System.out.printf("Life (0 / 1200):                    %.2f\n" , get_life());
        System.out.printf("Attack Power:                       %.2f\n" , get_attack_power());
        System.out.printf("Defence Power:                      %.2f\n" , get_defence_power());
        System.out.println("Agility:                            " + get_agility());
        System.out.println("Ready for Special Attack (0 / 25):  " + get_ready_for_special_attack());
        System.out.println("------------------------------------------\n");
    }
    
    @Override
    protected boolean isReadyForSpecialAttack(int limit) {
        boolean flag = false;
        if (get_ready_for_special_attack() >= limit) {
            flag = true;
            set_ready_for_special_attack(0);
        }
        return flag;
    }
    
    public void do_attach_weapon(Xgun gun) {
        set_attack_power(get_attack_power() + gun.get_weapon_power());
        set_has_a_weapon();
    }
}
