package onlineVotingSystem;

public class Candidate {
    private int candidateId;
    private String name;
    private int voteCount;

    public Candidate(int candidateId, String name) {
        this.candidateId = candidateId;
        this.name = name;
        this.voteCount = 0;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public String getName() {
        return name;
    }

    public void addVote() {
        voteCount++;
    }

    public int getVoteCount() {
        return voteCount;
    }
}
