class Solution {
    private class Car {
        int pos;
        int speed;

        Car(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];

        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b.pos, a.pos));

        Deque<Double> lane = new ArrayDeque<>();

        for (int j = 0; j < position.length; j++) {
            double time = (double) (target - cars[j].pos)/cars[j].speed;
            
            if (lane.isEmpty() || time > lane.peek()) {
                lane.push(time);
            }
        }

        return lane.size();
    }
}
