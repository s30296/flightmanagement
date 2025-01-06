package com.example.service.services;

import com.example.model.models.City;
import com.example.model.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    // Tworzy miasto.
    public City createCity(City city) {
        return cityRepository.save(city);
    }

    // Wyswietla liste wszystkich miast.
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    // Wyswietla miasto po id.
    public City getCityById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono miasta z id: " + id));
    }
}
