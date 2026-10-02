import java.util.Scanner;

public class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            health -= amount;
            if (health < 0) {
                health = 0;
            }
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            health += amount;
            if (health > maxHealth) {
                health = maxHealth;
            }
        }
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxHealth = sc.nextInt();
        Character c = new Character(maxHealth);
        int damage1 = sc.nextInt();
        c.takeDamage(damage1);
        System.out.println(c.getHealth());
        int healAmount = sc.nextInt();
        c.heal(healAmount);
        System.out.println(c.getHealth());
        int damage2 = sc.nextInt();
        c.takeDamage(damage2);
        System.out.println(c.getHealth());
        sc.close();
    }
}