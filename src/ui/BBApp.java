package ui;

import java.util.Arrays;
import java.util.Scanner;
import linkedlist2.Friend;
import linkedlist2.Link;
import linkedlist2.LinkedList;
import utility.Validator;

/**
 * A black book rating app.
 *
 * @author 55jphillip
 */
public class BBApp {

    LinkedList list;

    public BBApp() {
        this.list = new LinkedList();
        list.push(new Friend("Bob", 0));
        list.push(new Friend("Kim", 1));
        list.push(new Friend("Pam", 4));
        list.push(new Friend("Tony", 2));
        list.push(new Friend("Robert", 7));
        list.push(new Friend("Sim", 4));
        list.push(new Friend("Carl", 3));
        list.push(new Friend("Jasper", 0));
        start();
    }

    private void start() {
        Scanner sc = new Scanner(System.in);
        String choice;
        while (true) {
            menu();
            String regex = "^quit|add|remove|list|name|reverse|rating$";
            choice = Validator.getLine(sc, "Enter your choice: ", regex);
            if (choice.equalsIgnoreCase("quit")) {
                break;
            } else if (choice.equalsIgnoreCase("add")) {
                String name = Validator.getLine(sc, "Enter friend's name: ");
                int rating = Validator.getInt(sc, "Enter rating: ");
                list.push(new Friend(name, rating));
            } 
            else if(choice.equalsIgnoreCase("remove")){
                int index = Validator.getInt(sc, "Enter index to remove: ");
                list.delete(index);
            }
            else if (choice.equalsIgnoreCase("list")) {
                System.out.println(list);
            }
            else if (choice.equalsIgnoreCase("name")) {
                Friend[] fa = list.toArray();
                Arrays.sort(fa, (Friend a , Friend b) -> (a.getName().compareTo(b.getName())));
                for(Friend f : fa){
                    System.out.println(f);
                }
            }
            else if (choice.equalsIgnoreCase("reverse")) {
                Friend[] fa = list.toArray();
                Arrays.sort(fa, (Friend a , Friend b) -> (b.getName().compareTo(a.getName())));
                for(Friend f : fa){
                    System.out.println(f);
                }
            }
            else if (choice.equalsIgnoreCase("rating")) {
                Friend[] fa = list.toArray();
                Arrays.sort(fa, (Friend a , Friend b) -> (Integer.compare(b.getRating(), a.getRating())));
                for(Friend f : fa){
                    System.out.println(f);
                }
            }
        }
    }

    public void menu() {
        System.out.println("\nJohn's Black Book");
        System.out.println("Add - add a new friend");
        System.out.println("Remove - remove a friend");
        System.out.println("List - display list of friends");
        System.out.println("Name - display list of friends ordered by name");
        System.out.println("Reverse - display list of friends ordered by name descending");
        System.out.println("Rating - display list of friends ordered by rating");
        System.out.println("Search - search for a friend");
        System.out.println("Range - display friends in a range of ratings");
        System.out.println("Quit");
    }

    public static void main(String[] args) {
        BBApp app = new BBApp();
    }
}
