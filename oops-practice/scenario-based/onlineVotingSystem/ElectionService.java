package onlineVotingSystem;

public interface ElectionService {
    void castVote(Voter voter, Candidate candidate)
            throws DuplicateVoteException;

    void declareResult();
}

