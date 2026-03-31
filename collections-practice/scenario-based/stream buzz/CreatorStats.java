package stream_buzz;
import java.util.ArrayList;
import java.util.List;

public class CreatorStats {

    private String creatorName;
    private double[] weeklyLikes;

    public static List<CreatorStats> EngagementBoard = new ArrayList<>();

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public double[] getWeeklyLikes() {
        return weeklyLikes;
    }

    public void setWeeklyLikes(double[] weeklyLikes) {
        this.weeklyLikes = weeklyLikes;
    }
}
