import static java.lang.System.*;
import java.util.ArrayList;

public class Main {
    public static class Equipement {
        protected String name;
        protected Rarity rarity;
        protected int price;

        public enum Rarity {
            COMMON(1.0f),
            UNCOMMON(1.05f),
            RARE(1.1f),
            EPIC(1.15f),
            LEGENDARY(1.2f);
            private final float priceMultiplier;

            Rarity(float priceMultiplier) {
                this.priceMultiplier = priceMultiplier;
            }
            public float getPriceMultiplier() {
                return priceMultiplier;
            }
        }

        // Constructeur
        public Equipement(String name, Rarity rarity, int price) {
            this.name = name;
            this.rarity = rarity;
            this.price = price;
        }

        // Getters, Setters et méthode d'affichage
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Rarity getRarity() {
            return rarity;
        }

        public void setRarity(Rarity rarity) {
            this.rarity = rarity;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void displayEquipmentDetails() {
            System.out.println("Nom de l'équipement : " + name);
            System.out.println("Rareté de l'équipement : " + rarity);
            System.out.println("Prix de l'équipement : " + price);
        }
    }
    public static class Armor extends Equipement{
        private ArmorCategory category;
        private ArmorPiece  armorPiece;

        public enum ArmorCategory{
            LIGHT(0.92f),
            MEDIUM(1.05f),
            HEAVY(1.12f);
            private final float priceMultiplier;

            ArmorCategory(float priceMultiplier) {
                this.priceMultiplier = priceMultiplier;
            }
            public float getPriceMultiplier() {
                return priceMultiplier;
            }
        }
        public enum ArmorPiece {
            HELMET ( 0.98f),
            CHESTPLATE (1.12f),
            GAUNTLETS (0.95f),
            LEGGINGS (1.05f);
            private final float priceMultiplier;

            ArmorPiece(float priceMultiplier) {
                this.priceMultiplier = priceMultiplier;
            }
            public float getPriceMultiplier() {
                return priceMultiplier;
            }
        }
        public Armor(String name, Rarity rarity, int price, ArmorCategory category, ArmorPiece armorPiece){
            super(name,rarity,price);
            this.category=category;
            this.armorPiece=armorPiece;
        }

        public ArmorCategory getCategory() {
            return category;
        }
        public void setCategory(ArmorCategory category){
            this.category=category;
        }
        public ArmorPiece getArmorPiece(){
            return armorPiece;
        }
        public void setArmorPiece(ArmorPiece armorPiece){
            this.armorPiece=armorPiece;
        }
        public void displayEquipmentDetails() {
            super.displayEquipmentDetails();
            System.out.println("Catégorie de l'armure : " + category);
            System.out.println("Type d'armure : " + armorPiece);
        }
        public void updatePrice(){
            double multiplier = armorPiece.getPriceMultiplier();
            int basePrice = super.getPrice();
            int newPrice = (int)(basePrice*multiplier);
            super.setPrice(newPrice);
        }
        public String toString() {
            return "Armure: " + super.getName() + "\n" +
                    "Rareté: " + super.getRarity() + "\n" +
                    "Catégorie: " + category + "\n" +
                    "Type d'armure: " + armorPiece + "\n" +
                    "Prix: " + super.getPrice() + " pièces d'or";
        }

    }
    public static class Weapon extends Equipement{
        private WeaponCategory category;
        private WeaponType weaponType;

        public enum WeaponCategory{
            ONEHANDED(0.92f),
            TWOHANDED(1.15f);
            private final float priceMultiplier;

            WeaponCategory(float priceMultiplier) {
                this.priceMultiplier = priceMultiplier;
            }
            public float getPriceMultiplier() {
                return priceMultiplier;
            }
        }
        public enum WeaponType{
            SHORT(0.95),
            LONG(1.0),
            GREATSWORD(1.1),
            KATANA(1.05),
            BROADSWORD(1.0),
            AXE(1.02),
            HAMMER(1.05);
            private final double priceMultiplier;

            WeaponType(double priceMultiplier) {
                this.priceMultiplier = priceMultiplier;
            }

            public double getPriceMultiplier() {
                return priceMultiplier;
            }
        }
        public Weapon(String name, Rarity rarity, int price, WeaponCategory category, WeaponType weaponType){
            super(name,rarity,price);
            this.category=category;
            this.weaponType=weaponType;
        }

        public WeaponCategory getCategory() {
            return category;
        }
        public void setCategory(WeaponCategory category){
            this.category=category;
        }

        public WeaponType getWeaponType() {
            return weaponType;
        }
        public void setWeaponType(WeaponType weaponType){
            this.weaponType=weaponType;
        }

        public void displayEquipmentDetails() {
            super.displayEquipmentDetails();
            System.out.println("Catégorie de l'arme : " + category);
            System.out.println("Type d'arme : " + weaponType);
        }
        public void updatePrice() {
            double multiplier = weaponType.getPriceMultiplier();
            int basePrice = super.getPrice();
            int newPrice = (int) (basePrice * multiplier);
            super.setPrice(newPrice);
        }
        public String toString() {
            return "Arme: " + super.getName() + "\n" +
                    "Rareté: " + super.getRarity() + "\n" +
                    "Catégorie: " + category + "\n" +
                    "Type d'arme: " + weaponType + "\n" +
                    "Prix: " + super.getPrice() + " pièces d'or";
        }

    }

    public static class Merchant{
        private String name;
        private ArrayList<Equipement> inventory;
        private int money;

        public Merchant(String name, int money){
            if (money<0 || money >500){
                throw new IllegalArgumentException("L'argent du marchand doit être compris entre 0 et 500.");
                }
            this.name=name;
            this.inventory= new ArrayList<>();
            this.money=money;
        }

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name=name;
        }

        public ArrayList<Equipement> getInventory() {
            return inventory;
        }
        public void setInventory(ArrayList<Equipement> inventory){
            this.inventory=inventory;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            if (money<0||money>500){
                throw new IllegalArgumentException("L'argent du marchand doit être compris entre 0 et 500.");
            }
            this.money = money;
        }
        public void sellEquipement(Equipement equipement, double customerMultiplier){
            if (inventory.contains(equipement)){
                int sellingPrice= (int) (equipement.getPrice()*customerMultiplier);
                money+=sellingPrice;
                inventory.remove(equipement);
            }
        }
        public void addMoney(int amount){
            money+=amount;
        }
        public int getSaleBonus(int customerMultiplier){
            return (int)(money*(customerMultiplier-1));
        }
        public void addEquipementToInventory(Equipement equipement){
            inventory.add(equipement);
        }
        public void addEquipementToInventory(Equipement[] equipementArray){
            for (Equipement equipement : equipementArray){
                inventory.add(equipement);
            }
        }
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Marchand : ").append(name).append("\n");
            sb.append("Argent : ").append(money).append(" pièces d'or\n");
            sb.append("Inventaire :\n");
            for (Equipement equipment : inventory) {
                sb.append(equipment.toString()).append("\n");
            }
            return sb.toString();
        }
    }

    public static class Customer{
        private String name;
        private Equipement wantToBuy;
        private float multiplier;

        public Customer(String name, Equipement wantToBuy, float multiplier){
            this.name=name;
            this.wantToBuy=wantToBuy;
            this.multiplier=multiplier;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Equipement getWantToBuy() {
            return wantToBuy;
        }

        public void setWantToBuy(Equipement wantToBuy) {
            this.wantToBuy = wantToBuy;
        }

        public float getMultiplier() {
            return multiplier;
        }

        public void setMultiplier(float multiplier) {
            this.multiplier = multiplier;
        }
        public String toString() {
            return "Client : " + name + "\n" +
                    "Équipement souhaité : " + wantToBuy.getName() + "\n" +
                    "Bonus de vente : " + multiplier;
        }
    }


    public static void main(String[] args) {
        Equipement desiredEquipment = new Equipement("Épée légendaire", Equipement.Rarity.LEGENDARY, 1000);
        Customer customer = new Customer("Client A", desiredEquipment, 1.2f);
        System.out.println(customer.toString());
    }
}
