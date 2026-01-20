package scenario_based;
class ParcelNode {
    String stage;
    ParcelNode next;

    ParcelNode(String stage) {
        this.stage = stage;
        this.next = null;
    }
}

public class ParcelTracker {
    ParcelNode head;

    void addStage(String stage) {
        ParcelNode newNode = new ParcelNode(stage);
        if (head == null) {
            head = newNode;
            return;
        }
        ParcelNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    void addCheckpoint(String afterStage, String newStage) {
        ParcelNode temp = head;
        while (temp != null && !temp.stage.equals(afterStage))
            temp = temp.next;

        if (temp != null) {
            ParcelNode node = new ParcelNode(newStage);
            node.next = temp.next;
            temp.next = node;
        }
    }

    void trackParcel() {
        ParcelNode temp = head;
        if (temp == null) {
            System.out.println("Parcel is lost or not found");
            return;
        }
        while (temp != null) {
            System.out.print(temp.stage + " → ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        ParcelTracker parcel = new ParcelTracker();

        parcel.addStage("Packed");
        parcel.addStage("Shipped");
        parcel.addStage("In Transit");
        parcel.addStage("Delivered");

        parcel.addCheckpoint("Shipped", "Customs Check");

        parcel.trackParcel();
    }
}
