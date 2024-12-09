package com.project.Services;

import com.project.models.entitys.Cancha;
import com.project.models.entitys.Category;
import com.project.models.entitys.City;
import com.project.models.entitys.Country;
import com.project.models.entitys.Department;
import com.project.repository.CanchasRepository;
import com.project.repository.CategoryRepository;
import com.project.repository.CityRepository;
import com.project.repository.CountryRepository;
import com.project.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestoServicesImpl implements RestoServices {

    private CategoryRepository categoryRepository;
    private CountryRepository countryRepository;
    private DepartmentRepository departmentRepository;
    private CanchasRepository canchasRepository;

    private CityRepository cityRepository;


    public RestoServicesImpl(CategoryRepository categoryRepository, CountryRepository countryRepository, DepartmentRepository departmentRepository,
                             CityRepository cityRepository, CanchasRepository canchasRepository) {
        this.categoryRepository = categoryRepository;
        this.countryRepository = countryRepository;
        this.departmentRepository = departmentRepository;
        this.cityRepository = cityRepository;
        this.canchasRepository = canchasRepository;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategorybyId(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public Cancha saveCancha(Cancha cancha) {
        return canchasRepository.save(cancha);
    }

    @Override
    public void deleteCancha(Long id) {
        canchasRepository.deleteById(id);
    }

    @Override
    public Cancha editCancha(Cancha cancha) {
        return canchasRepository.save(cancha);
    }

    @Override
    public Country editCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Department editDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Category editCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public City editCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<Cancha> getAllCancha() {
        return canchasRepository.findAll();
    }

    @Override
    public List<Department> getDepartmentsByCountry(Long id) {
        return departmentRepository.findByCountryId(id);
    }
}
