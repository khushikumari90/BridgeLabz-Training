package onlineVotingSystem;

public class OnlineVotingApp {

    public static void main(String[] args) {

        Election election = new Election();

        Voter v1 = new Voter(1, "Amit");
        Voter v2 = new Voter(2, "Ravi");

        Candidate c1 = new Candidate(101, "Candidate A");
        Candidate c2 = new Candidate(102, "Candidate B");

        election.registerVoter(v1);
        election.registerVoter(v2);

        election.addCandidate(c1);
        election.addCandidate(c2);

        try {
            election.castVote(v1, c1);
            election.castVote(v2, c2);
            election.castVote(v1, c2); // duplicate vote
        } catch (DuplicateVoteException e) {
            System.out.println("Error: " + e.getMessage());
        }

        election.declareResult();
    }
}

