package org.api.couriermanager.service.asset.implementation;


import org.api.couriermanager.entity.asset.Vehicle;
import org.api.couriermanager.entity.security.User;
import org.api.couriermanager.repository.asset.IVehicleRepository;
import org.api.couriermanager.service.asset.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    IVehicleRepository vehicleRepository;

    @Override
    public Vehicle create(Vehicle x) {
        return this.vehicleRepository.save(x);
    }

    @Override
    public Vehicle read(String ID) {
        return this.vehicleRepository.findById(ID).orElseGet(null);
    }

    public List<Vehicle> readAll(){
        return this.vehicleRepository.findAll();
    }

    @Override
    public Vehicle update(Vehicle x, String ID) {

        if(this.vehicleRepository.existsById(x.getVehicleID())){

            return this.vehicleRepository.save(x);
        }
        return null;
    }

    @Override
    public boolean delete(String ID) {

        this.vehicleRepository.deleteById(ID);
        if (this.vehicleRepository.existsById(ID))
            return false;
        else
            return true;
    }
}
