class ParkingSystem {
    private int[] spaces = new int[3];

    public ParkingSystem(int big, int medium, int small) {
        this.spaces[0] = big;
        this.spaces[1] = medium;
        this.spaces[2] = small;
    }
    
    public boolean addCar(int carType) {
        if (this.spaces[carType - 1] == 0) {
            return false;
        }
        this.spaces[carType - 1]--;
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */