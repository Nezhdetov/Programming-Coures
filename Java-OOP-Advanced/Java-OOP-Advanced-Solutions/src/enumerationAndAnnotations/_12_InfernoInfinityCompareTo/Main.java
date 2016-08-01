package enumerationAndAnnotations._12_InfernoInfinityCompareTo;

import enumerationAndAnnotations._12_InfernoInfinityCompareTo.data.WeaponsRepository;
import enumerationAndAnnotations._12_InfernoInfinityCompareTo.enums.Gem;
import enumerationAndAnnotations._12_InfernoInfinityCompareTo.enums.WeaponType;
import enumerationAndAnnotations._12_InfernoInfinityCompareTo.interfaces.Repository;
import enumerationAndAnnotations._12_InfernoInfinityCompareTo.interfaces.Weapon;
import enumerationAndAnnotations._12_InfernoInfinityCompareTo.models.WeaponImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Repository weaponsRepository = new WeaponsRepository();
        while (true) {
            String line = reader.readLine();
            if (line.equals("END")) {
                break;
            }

            String[] commandTokens = line.split(";");
            executeCommand(weaponsRepository, commandTokens);
        }
    }

    private static void executeCommand(Repository weaponsRepository, String[] commandTokens) {
        switch (commandTokens[0]) {
            case "Create":
                WeaponType weaponType = WeaponType.valueOf(commandTokens[1]);
                String weaponName = commandTokens[2];
                Weapon weapon = new WeaponImpl(weaponName, weaponType);
                weaponsRepository.addWeapon(weapon);
                break;
            case "Add":
                String weaponToAddName = commandTokens[1];
                int socketIndex = Integer.parseInt(commandTokens[2]);
                Gem gemType = Gem.valueOf(commandTokens[3]);
                weaponsRepository.addGem(weaponToAddName, socketIndex, gemType);
                break;
            case "Remove":
                String weaponToRemoveName = commandTokens[1];
                int index = Integer.parseInt(commandTokens[2]);
                weaponsRepository.removeGem(weaponToRemoveName, index);
                break;
            case "Compare":
                String firstWeaponName = commandTokens[1];
                String secondWeaponName = commandTokens[2];
                weaponsRepository.compareWeapons(firstWeaponName, secondWeaponName);
                break;
            case "Print":
                String weaponToPrint = commandTokens[1];
                weaponsRepository.printWeapon(weaponToPrint);
                break;
        }
    }
}
