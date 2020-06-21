package com.mtah.persistence.Service;

import com.mtah.model.Chef;
import com.mtah.persistence.Repository.ChefRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChefService extends EntityService<Chef, Long> {

    private final ChefRepository chefRepository;

    public ChefService(ChefRepository cr) {
        this.chefRepository = cr;
    }

    public Chef findById(Long id) {
        return chefRepository.findById(id).orElse(null);
    }

    public List<Chef> findAll() {
        return chefRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        chefRepository.deleteById(id);
    }

    @Override
    public Chef save(Chef chef) {
        return chefRepository.save(chef);
    }
}
