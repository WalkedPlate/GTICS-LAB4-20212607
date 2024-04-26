package com.example.gticslab420212607.controller;

import com.example.gticslab420212607.entity.Employees;
import com.example.gticslab420212607.entity.Regions;
import com.example.gticslab420212607.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class EmpleadoController {


    final EmployeesRepository employeesRepository;
    final CountriesRepository countriesRepository;

    final DepartmentsRepository departmentsRepository;
    final JobHistoryRepository jobHistoryRepository;

    final JobsRepository jobsRepository;
    final LocationsRepository locationsRepository;
    final RegionsRepository regionsRepository;

    public EmpleadoController(EmployeesRepository employeesRepository, CountriesRepository countriesRepository,
                              DepartmentsRepository departmentsRepository, JobsRepository jobsRepository,
                              JobHistoryRepository jobHistoryRepository, LocationsRepository locationsRepository,
                              RegionsRepository regionsRepository){
        this.employeesRepository = employeesRepository;
        this.countriesRepository = countriesRepository;
        this.departmentsRepository = departmentsRepository;
        this.jobsRepository = jobsRepository;
        this.jobHistoryRepository = jobHistoryRepository;
        this.locationsRepository = locationsRepository;
        this.regionsRepository = regionsRepository;
    }



    @GetMapping(value ={"","/"})
    public String home(){

        return "home";
    }

    @GetMapping(value ={"/empleados"})
    public String lista(Model model){

        List<Employees> listaEmpleados = employeesRepository.findAll();

        model.addAttribute("listaEmpleados",listaEmpleados);

        return "Empleados/list";
    }

    @GetMapping("/empleados/borrar")
    public String borrar(@RequestParam("idEmployee") Integer id){
        Optional<Employees> opt =employeesRepository.findById(id);
        if(opt.isPresent()){
            employeesRepository.deleteById(id);
        }
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/editar")
    public String editar(Model model,
                         @RequestParam("idEmployee") Integer id){
        Optional<Employees> prov = employeesRepository.findById(id);
        if(prov.isPresent()){
            Employees employees = prov.get();

            return "Empleados/edit";
        }
        return "redirect:/empleados";
    }

    @GetMapping(value="/sede/nuevo")
    public String nuevo(){
        return "Empleados/nuevo";
    }


    @PostMapping(value = "sede/guardar")
    public String guardarEmpleado(Employees employees){
        employeesRepository.save(employees);
        return "redirect:/empleados";
    }

}
