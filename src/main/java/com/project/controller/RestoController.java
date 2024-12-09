package com.project.controller;

import com.project.Services.RestoServicesImpl;
import com.project.models.dtos.CategoryDTO;
import com.project.models.entitys.Cancha;
import com.project.models.entitys.Category;
import com.project.models.entitys.City;
import com.project.models.entitys.Country;
import com.project.models.entitys.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/utils")
public class RestoController {

    @Autowired
    RestoServicesImpl restoServices;

    // 1. Save Methods
    @PostMapping("/create-category")
    public ResponseEntity<Category> saveCategory(@RequestBody CategoryDTO category) {
        Category categoryEntity = new Category(category);
        Category savedCategory = restoServices.saveCategory(categoryEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @PostMapping("/create-country")
    public ResponseEntity<Country> saveCountry(@RequestBody Country country) {
        Country savedCountry = restoServices.saveCountry(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCountry);
    }

    @PostMapping("/create-department")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
        Department savedDepartment = restoServices.saveDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartment);
    }

    @PostMapping("/create-city")
    public ResponseEntity<City> saveCity(@RequestBody City city) {
        City savedCity = restoServices.saveCity(city);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCity);
    }

    @PostMapping("/create-cancha")
    public ResponseEntity<Cancha> saveCancha(@RequestBody Cancha cancha) {
        Cancha canchaSaved = restoServices.saveCancha(cancha);
        return ResponseEntity.status(HttpStatus.CREATED).body(canchaSaved);
    }


    // 2. Get All Methods
    @GetMapping("/get-all-categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = restoServices.getAllCategories();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @GetMapping("/get-all-countries")
    public ResponseEntity<List<Country>> getAllCountries() {
        List<Country> countries = restoServices.getAllCountries();
        return ResponseEntity.status(HttpStatus.OK).body(countries);
    }

    @GetMapping("/get-all-departments")
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = restoServices.getAllDepartment();
        return ResponseEntity.status(HttpStatus.OK).body(departments);
    }

    @GetMapping("/get-all-departments-by-country/{id}")
    public ResponseEntity<List<Department>> getDepartmentsByCOuntryId(@PathVariable Long id) {
        List<Department> departments = restoServices.getDepartmentsByCountry(id);
        return ResponseEntity.status(HttpStatus.OK).body(departments);
    }

    @GetMapping("/get-all-cities")
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = restoServices.getAllCities();
        return ResponseEntity.status(HttpStatus.OK).body(cities);
    }

    @GetMapping("/get-all-canchas")
    public ResponseEntity<List<Cancha>> getAllCanchas() {
        List<Cancha> canchas = restoServices.getAllCancha();
        return ResponseEntity.status(HttpStatus.OK).body(canchas);
    }

    // 3. Delete Methods
    @DeleteMapping("/delete-category/{id}")
    public void deleteCategoryById(@PathVariable Long id) {
        restoServices.deleteCategorybyId(id);
    }

    @DeleteMapping("/delete-country/{id}")
    public void deleteCountryById(@PathVariable Long id) {
        restoServices.deleteCountry(id);
    }

    @DeleteMapping("/delete-department/{id}")
    public void deleteDepartmentById(@PathVariable Long id) {
        restoServices.deleteDepartment(id);
    }

    @DeleteMapping("/delete-city/{id}")
    public void deleteCityById(@PathVariable Long id) {
        restoServices.deleteCity(id);
    }

    @DeleteMapping("/delete-cancha/{id}")
    public void deleteCanchaById(@PathVariable Long id) {
        restoServices.deleteCancha(id);
    }

    @PutMapping("/create-category")
    public ResponseEntity<Category> editCategory(@RequestBody CategoryDTO category) {
        Category categoryEntity = new Category(category);
        Category savedCategory = restoServices.saveCategory(categoryEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @PutMapping("/edit-country/{id}")
    public ResponseEntity<Country> editCountry(@RequestBody Country country, @PathVariable Long id) {
        country.setId(id);
        Country savedCountry = restoServices.editCountry(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCountry);
    }

    @PutMapping("/edit-department/{id}")
    public ResponseEntity<Department> editDepartment(@RequestBody Department department, @PathVariable Long id) {
        department.setId(id);
        Department savedDepartment = restoServices.editDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartment);
    }

    @PutMapping("/edit-city/{id}")
    public ResponseEntity<City> editCity(@RequestBody City city, @PathVariable Long id) {
        city.setId(id);
        City savedCity = restoServices.editCity(city);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCity);
    }

    @PutMapping("/edit-cancha/{id}")
    public ResponseEntity<Cancha> editCancha(@RequestBody Cancha cancha, @PathVariable Long id) {
        cancha.setId(id);
        Cancha canchaSaved = restoServices.editCancha(cancha);
        return ResponseEntity.status(HttpStatus.CREATED).body(canchaSaved);
    }

    @PutMapping("/edit-category/{id}")
    public ResponseEntity<Category> editCategory(@RequestBody CategoryDTO category, @PathVariable Long id) {
        category.setId(id);
        Category categoryEntity = new Category(category);
        Category categorySaved = restoServices.editCategory(categoryEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(categorySaved);
    }
}
