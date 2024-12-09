package com.project.Services;

import com.project.models.entitys.Cancha;
import com.project.models.entitys.Category;
import com.project.models.entitys.City;
import com.project.models.entitys.Country;
import com.project.models.entitys.Department;

import java.util.List;

public interface RestoServices {

    public Category saveCategory(Category category);

    public List<Category> getAllCategories();

    public void deleteCategorybyId(Long id);

    public Country saveCountry(Country country);

    public List<Country> getAllCountries();

    public void deleteCountry(Long id);

    public Department saveDepartment(Department department);

    public List<Department> getAllDepartment();

    public void deleteDepartment(Long id);

    public City saveCity(City city);

    public List<City> getAllCities();

    public void deleteCity(Long id);

    public Cancha saveCancha(Cancha cancha);

    public void deleteCancha(Long id);

    public Cancha editCancha(Cancha cancha);
    public Country editCountry(Country country);
    public Department editDepartment(Department department);
    public Category editCategory(Category category);
    public City editCity(City city);

    public List<Cancha> getAllCancha();

    public List<Department> getDepartmentsByCountry(Long id);

}
