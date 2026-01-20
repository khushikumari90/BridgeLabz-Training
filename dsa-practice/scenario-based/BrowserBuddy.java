package scenario_based;
import java.util.Stack;

class HistoryNode {
    String url;
    HistoryNode prev, next;

    HistoryNode(String url) {
        this.url = url;
        this.prev = null;
        this.next = null;
    }
}

class BrowserTab {
    private HistoryNode current;

    public void visit(String url) {
        HistoryNode newNode = new HistoryNode(url);

        if (current != null) {
            current.next = newNode;
            newNode.prev = current;
        }
        current = newNode;
        System.out.println("Visited: " + url);
    }

    public void back() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Back to: " + current.url);
        } else {
            System.out.println("No previous page");
        }
    }

    public void forward() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Forward to: " + current.url);
        } else {
            System.out.println("No forward page");
        }
    }

    public String getCurrentPage() {
        return current != null ? current.url : null;
    }
}

public class BrowserBuddy {
    static Stack<String> closedTabs = new Stack<>();

    public static void main(String[] args) {

        BrowserTab tab = new BrowserTab();

        tab.visit("google.com");
        tab.visit("github.com");
        tab.visit("stackoverflow.com");

        tab.back();
        tab.back();
        tab.forward();

        closeTab(tab);
        restoreTab();
    }

    static void closeTab(BrowserTab tab) {
        String page = tab.getCurrentPage();
        if (page != null) {
            closedTabs.push(page);
            System.out.println("Tab closed: " + page);
        }
    }

    static void restoreTab() {
        if (!closedTabs.isEmpty()) {
            System.out.println("Restored tab: " + closedTabs.pop());
        } else {
            System.out.println("No closed tabs to restore");
        }
    }
}
