package onlineVotingSystem;

import java.util.ArrayList;
import java.util.List;

public class Election implements ElectionService {

    private List<Voter> voters = new ArrayList<>();
    private List<Candidate> candidates = new ArrayList<>();
    private List<Vote> votes = new ArrayList<>();

    // CRUD: Register Voter
    public void registerVoter(Voter voter) {
        voters.add(voter);
        System.out.println("Voter registered: " + voter.getName());
    }

    // CRUD: Add Candidate
    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
        System.out.println("Candidate added: " + candidate.getName());
    }

    @Override
    public void castVote(Voter voter, Candidate candidate)
            throws DuplicateVoteException {

        if (voter.isHasVoted()) {
            throw new DuplicateVoteException("Voter has already voted!");
        }

        Vote vote = new Vote(voter, candidate);
        votes.add(vote);
        candidate.addVote();
        voter.setHasVoted(true);

        System.out.println("Vote cast successfully for " + candidate.getName());
    }

    @Override
    public void declareResult() {
        System.out.println("\n Election Results:");
        for (Candidate c : candidates) {
            System.out.println(c.getName() + " : " + c.getVoteCount() + " votes");
        }
    }
}
