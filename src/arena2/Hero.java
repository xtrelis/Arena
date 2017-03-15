package arena2;

public abstract class Hero {
    
    // Properties
    private String class_name;
    private String name;
    private char sex;
    private double life;
    private double attack_power;
    private double defence_power;
    private double agility;    
    private int ready_for_special_attack;
    private final int step = 1;
    protected boolean has_a_weapon = false;
    
    // Constructor
    protected Hero(String name, char sex) {        
        this.name = name;
        this.sex = sex;
        ready_for_special_attack = 0;
    }
    
    // Abstract methods
    protected abstract double do_normal_attack();
    protected abstract double do_defence();   
    protected abstract double do_special_attack();
    protected abstract void do_reset_stats();
    protected abstract void do_print_stats();
    
    // Setters
    protected void set_class_name(String class_name) {
        this.class_name = class_name;
    }
    
    protected void set_name(String name) {
        this.name = name;
    }
    
    protected void set_sex(char sex) {
        this.sex = sex;
    }
    
    protected void set_life(double life) {
        this.life = life;
    }
    
    protected void set_attack_power(double attack_power) {
        this.attack_power = attack_power;
    }
    
    protected void set_defence_power(double defence_power) {
        this.defence_power = defence_power;
    }
    
    protected void set_agility(double agility) {
        this.agility = agility;
    }
    
    protected void set_ready_for_special_attack(int step) {
        if (step == 0) {
            ready_for_special_attack = 0;
        }
        else {
            ready_for_special_attack += step;
        }
    }
    
    // Getters
    protected String get_class_name() {
        return class_name;
    }
    
    protected String get_name(){
        return name;
    }
    
    protected char get_sex() {
        return sex;
    }
    
    protected double get_life() {
        return life;
    }
    
    protected double get_attack_power() {
        return attack_power;
    }
    
    protected double get_defence_power() {
        return defence_power;
    }
    
    protected double get_agility() {
        return agility;
    }
    
    protected int get_ready_for_special_attack() {
        return ready_for_special_attack;
    }
        
    // Methods
    protected boolean isReadyForSpecialAttack(int limit) {
        boolean flag = false;
        if (get_ready_for_special_attack() >= limit) {
            flag = true;
            set_ready_for_special_attack(0);
        }
        else {
            set_ready_for_special_attack(this.step);
        }
        return flag;
    }
}
