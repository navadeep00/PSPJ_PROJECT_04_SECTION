import java.util.Scanner;

class Election {

    String name1, name2, name3;
    int votes1, votes2, votes3;
    int invalidVotes;

    Election(String name1, String name2, String name3) {
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.votes1 = 0;
        this.votes2 = 0;
        this.votes3 = 0;
        this.invalidVotes = 0;
    }

    void showMenu() {
        System.out.println("\n--- Ballot Menu ---");
        System.out.println("1. Vote for " + this.name1);
        System.out.println("2. Vote for " + this.name2);
        System.out.println("3. Vote for " + this.name3);
        System.out.println("4. End Voting & Show Results");
        System.out.print("Enter your choice (1-4): ");
    }

    void castVote(int choice) {
        if (choice == 1) {
            this.votes1++;
            System.out.println("Vote recorded for " + this.name1 + ".");
        } else if (choice == 2) {
            this.votes2++;
            System.out.println("Vote recorded for " + this.name2 + ".");
        } else if (choice == 3) {
            this.votes3++;
            System.out.println("Vote recorded for " + this.name3 + ".");
        } else if (choice == 4) {
            System.out.println("Voting closed. Generating tally...");
        } else {
            this.invalidVotes++;
            System.out.println("Invalid option! Counted as an invalid vote.");
        }
    }

    int getValidVotes() {
        return this.votes1 + this.votes2 + this.votes3;
    }

    int getTotalVotes() {
        return this.getValidVotes() + this.invalidVotes;
    }

    void declareWinner() {
        if (this.getValidVotes() == 0) {
            System.out.println("No valid votes casted");
        } else if (this.votes1 > this.votes2 && this.votes1 > this.votes3) {
            System.out.println("Winner is " + this.name1);
        } else if (this.votes2 > this.votes1 && this.votes2 > this.votes3) {
            System.out.println("Winner is " + this.name2);
        } else if (this.votes3 > this.votes1 && this.votes3 > this.votes2) {
            System.out.println("Winner is " + this.name3);
        } else {
            System.out.println("Result: tie");
        }
    }

    void showResults() {
        System.out.println("\n=============================");
        System.out.println("       ELECTION RESULTS      ");
        System.out.println("=============================");
        System.out.println("Total Votes Cast : " + this.getTotalVotes());
        System.out.println(this.name1 + ": " + this.votes1 + " votes");
        System.out.println(this.name2 + ": " + this.votes2 + " votes");
        System.out.println(this.name3 + ": " + this.votes3 + " votes");
        System.out.println("Invalid Votes: " + this.invalidVotes + " votes");
        System.out.println("=============================");
        this.declareWinner();
    }
}

public class ElectionTallySystem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Election election = new Election("Ganesh", "Navadeep", "Revanth");
        int choice;

        System.out.println("=== Student Council Election Voting System ===");

        do {
            election.showMenu();
            choice = sc.nextInt();
            election.castVote(choice);
        } while (choice != 4);

        election.showResults();
        sc.close();
    }
}