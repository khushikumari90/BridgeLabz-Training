package restaurant_order_processing_system;
class Chef extends Thread {

    private String dish;
    private int totalTime; // in milliseconds

    public Chef(String name, String dish, int totalTime) {
        super(name); // sets thread name
        this.dish = dish;
        this.totalTime = totalTime;
    }

    @Override
    public void run() {
        System.out.println(getName() + " started preparing " + dish);

        int stepTime = totalTime / 4;

        try {
            for (int progress = 25; progress <= 100; progress += 25) {
                Thread.sleep(stepTime);
                System.out.println(
                    getName() + " preparing " + dish + ": " + progress + "% complete"
                );
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getName() + " finished preparing " + dish);
    }
}
