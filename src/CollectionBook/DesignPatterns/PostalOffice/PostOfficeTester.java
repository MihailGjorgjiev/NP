package CollectionBook.DesignPatterns.PostalOffice;

import java.util.Scanner;

public class PostOfficeTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = Integer.parseInt(scanner.nextLine());
        if (test == 1) {
            // Group Package printing
            System.out.println(" ====== Packages ====== ");
            PostOffice office = new PostOffice(" Poshta ", " Skopje ");
            try {
                office.addPackage(new InternationalPackage(" John_Doe ",
                        " Main_St_123 ", 111, 4, " America "));
            } catch (InvalidPackageException e) {
                System.out.println(e.getMessage());
            }
            GroupPackage groupPackage =
                    new GroupPackage(" John_Done ", " Main_St_123 ", 232);
            groupPackage.addPackage(
                    new LocalPackage(" Jon_Snow ", " The_Wall ", 432, 5,
                            true));
            try {
                office.addPackage(groupPackage);
            } catch (InvalidPackageException e) {
                System.out.println(e.getMessage());
            }
            office.printPackages(System.out);
        }
        if (test == 2) {
            // Nested Group Package printing
            System.out.println(" ====== Packages ====== ");
            PostOffice office = new PostOffice(" Poshta ", " Skopje ");
            try {
                office.addPackage(
                        new InternationalPackage(" Richard_Hendricks ",
                                " Noble_Pathway ", 325, 4, " Africa "));
            } catch (InvalidPackageException e) {
                System.out.println(e.getMessage());
            }
            try {
                office.addPackage(new LocalPackage(" Jalisa_Acheson ",
                        " Emerald_Harbour ", 600, 14, false));
            } catch (InvalidPackageException e) {
                System.out.println(e.getMessage());
            }

            GroupPackage groupPackage =
                    new GroupPackage(" Meagan_Schuette ", " Westeros ",
                            232);
            groupPackage.addPackage(
                    new LocalPackage(" Meagan_Schuette ", " Westeros ",
                            432, 5, true));
            groupPackage.addPackage(
                    new InternationalPackage(" Sansa_Stark ",
                            " Westeros ", 332, 3, " Asia "));

            GroupPackage nestedGroupPackage =
                    new GroupPackage(" Marline_Bohling ",
                            " Crystal_Hills ", 284);
            nestedGroupPackage.addPackage(
                    new InternationalPackage(" Edie_Bramblett ",
                            " Lazy_Treasure ", 382, 7, " Europe "));
            nestedGroupPackage.addPackage(
                    new InternationalPackage(" Cassaundra_Huff ",
                            " Sleepy_Farms ", 696, 1, " Asia "));
            nestedGroupPackage.addPackage(
                    new InternationalPackage(" German_Sabbagh ",
                            " Tawny_Heath ", 963, 12, " Africa "));

            groupPackage.addPackage(nestedGroupPackage);
            try {
                office.addPackage(groupPackage);
            } catch (InvalidPackageException e) {
                System.out.println(e.getMessage());
            }
            try {
                office.addPackage(
                        new LocalPackage(" Clemmie_Reves ", " Little_Cloud ",
                                217, 5, true));
            } catch (InvalidPackageException e) {
                System.out.println(e.getMessage());
            }
            office.printPackages(System.out);
        }
        if (test == 3) {
            // Most expensive Group Package
            System.out.println(" ====== Packages ====== ");
            PostOffice office = new PostOffice(" Poshta ", " Skopje ");
            try {
                office.addPackage(new InternationalPackage(" Dohn_Joe ",
                        " Main_St_321 ", 444, 4, " Europe "));
            } catch (InvalidPackageException e) {
                System.out.println(e.getMessage());
            }
            GroupPackage groupPackage =
                    new GroupPackage(" John_Jon ", " First_St_123 ", 232);
            groupPackage.addPackage(
                    new LocalPackage(" Jon_Snow ", " Westeros ", 432, 5,
                            true));
            groupPackage.addPackage(
                    new InternationalPackage(" Sansa_Stark ",
                            " Westeros ", 332, 3, " Asia "));
            try {
                office.addPackage(groupPackage);
            } catch (InvalidPackageException e) {
                System.out.println(e.getMessage());
            }
            try {
                office.addPackage(
                        new LocalPackage(" Littlefinger ", " The_Eyrie ", 987,
                                7, false));
            } catch (InvalidPackageException e) {
                System.out.println(e.getMessage());
            }
            office.printPackages(System.out);
            System.out.println();
            System.out.println(" ====== MostExpensive ====== ");
            System.out.println(office.mostExpensive());
        }
        if (test == 4) {
            // Most expensive International Package
            System.out.println(" ====== Packages ====== ");
            PostOffice office = new PostOffice(" Poshta ", " Skopje ");
            try {
                office.addPackage(new InternationalPackage(" Dohn_Joe ",
                        " Main_St_321 ", 444, 15, " Europe "));
            } catch (InvalidPackageException e) {
                System.out.println(e.getMessage());
            }
            GroupPackage groupPackage =
                    new GroupPackage(" John_Jon ", " First_St_123 ", 232);
            groupPackage.addPackage(
                    new LocalPackage(" Jon_Snow ", " Westeros ", 432, 5,
                            true));
            groupPackage.addPackage(
                    new InternationalPackage(" Sansa_Stark ",
                            " Westeros ", 332, 3, " Asia "));
            try {
                office.addPackage(groupPackage);
            } catch (InvalidPackageException e) {
                System.out.println(e.getMessage());
            }
            try {
                office.addPackage(
                        new LocalPackage(" Littlefinger ", " The_Eyrie ", 987,
                                7, false));
            } catch (InvalidPackageException e) {
                System.out.println(e.getMessage());
            }
            office.printPackages(System.out);
            System.out.println();
            System.out.println(" ====== MostExpensive ====== ");
            System.out.println(office.mostExpensive());
        }
        scanner.close();
    }
}