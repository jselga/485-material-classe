/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicisfitxers;

/**
 *
 * @author jordi
 */
public class Exercici2ModelGestio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SheikahSlateAlt slate1 = new SheikahSlateAlt();

        slate1.addMonster(new Monster(119, "Electric Lizalfos", "These quick-witted, lizard-like monsters can be found all over Hyrule. The can emit strong electrical currents from their bodies, so don't get too close. Their horns are brimming with electricity, which will discharge and arc to nearby areas if struck by an arrow. They tend to live in desert climates."));
        slate1.addMonster(new Monster(103, "Bokoblin", "This common species is a nuisance all over Hyrule. Some have unified in the time following the Great Calamity and have formed factions of bandits. While not very clever, they are at least intelligent enough to hunt beasts and grill their meat for food. Though they're typically ferocious carnivores, they actually enjoy fruit as well."));
        slate1.addMonster(new Monster(147, "Hinox", "The largest monster to make its home in Hyrule, the Hinox lives primarily in forested areas. A keen awareness of your surroundings is paramount when facing one, as Hinox are known for tearing entire trees from the ground and using them as weapons. A deft hand can steal weapons off the necklaces they wear."));
        if (slate1.saveMonsters()) {
            System.out.println("Monsters Successfully saved");
        }

        SheikahSlate slate2 = new SheikahSlate();

        if (slate2.loadMonsters()) {
            System.out.println("Monsters Successfully loaded");
        }

        slate2.showMonsters();

    }

}
