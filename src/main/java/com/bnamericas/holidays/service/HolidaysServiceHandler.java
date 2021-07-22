package com.bnamericas.holidays.service;

import com.bnamericas.holidays.model.Holidays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.bnamericas.holidays.repository.HolidaysRepository;

@Service
@Lazy
public class HolidaysServiceHandler implements HolidaysService {

    @Autowired
    HolidaysRepository repository;

    @Override
    public Holidays save(Holidays model) throws Exception {
        return repository.save(model);
    }

    @Override
    public Optional<Holidays> findById(Long id) {
        return Optional.ofNullable(repository.findById(id)
                .orElseGet(Holidays::new));
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public List<Holidays> findAll() {
        return repository.findAll();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Holidays model) {
        repository.delete(model);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
