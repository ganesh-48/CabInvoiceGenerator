package com.cabinvoiceservice;

import java.util.ArrayList;
import java.util.HashMap;

public class RideRepository {
    private HashMap<String, ArrayList<Ride>> rideRepositoryMap;

    public RideRepository() {
        this.rideRepositoryMap = new HashMap<String, ArrayList<Ride>>();
    }

    public void addRidetoUser(String Userid, Ride ride) {
        if (rideRepositoryMap.containsKey(Userid)) {
            ArrayList<Ride> rides = rideRepositoryMap.get(Userid);
            rides.add(ride);
            rideRepositoryMap.put(Userid, rides);

        } else {
            ArrayList<Ride> rides = new ArrayList<Ride>();
            rides.add(ride);
            rideRepositoryMap.put(Userid, rides);
        }

    }

    public ArrayList<Ride> getRides(String Userid) {
        if (rideRepositoryMap.containsKey(Userid)) {

            return rideRepositoryMap.get(Userid);
        } else {
            return null;
        }
    }
}
