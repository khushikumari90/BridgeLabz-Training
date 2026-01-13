package onlineVotingSystem;

public class Voter {
    private int voterId;
    private String name;
    private boolean hasVoted;

    public Voter(int voterId, String name) {
        this.voterId = voterId;
        this.name = name;
        this.hasVoted = false;
    }

    public int getVoterId() {
        return voterId;
    }

    public String hasVoted() {
        return hasVoted ? "Yes" : "No";
    }

    public boolean isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

    public String getName() {
        return name;
    }
}

