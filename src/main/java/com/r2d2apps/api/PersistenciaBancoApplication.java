package com.r2d2apps.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.r2d2apps.api.entities.Empresa;
import com.r2d2apps.api.reporitories.EmpresaRepository;

@SpringBootApplication
public class PersistenciaBancoApplication {
	
	@Autowired
	private EmpresaRepository empresaRepository;

	public static void main(String[] args) {
		SpringApplication.run(PersistenciaBancoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("R2D2 Apps Solutions");
			empresa.setCnpj("1234");
			
			Empresa empresa2 = new Empresa();
			empresa2.setRazaoSocial("Fulando de tal");
			empresa2.setCnpj("222");
			
			
			this.empresaRepository.save(empresa);
			this.empresaRepository.save(empresa2);
			
			this.empresaRepository
			    .findAll()
			    .forEach(System.out::println);
			
			System.out.println("Total de empresas: "+this.empresaRepository.count());
			
			System.out.println("Procurando empresa pelo Id: " +this.empresaRepository.findOne(1L));
			System.out.println("Procurando empresa pelo Cnpj: " +this.empresaRepository.findByCnpj("1234"));
			
			this.empresaRepository.delete(2L);
			
			System.out.println("Total de empresas: "+this.empresaRepository.count());
			this.empresaRepository
				.findAll()
				.forEach(System.out::println);
			
		};
	}
	
	
}


  
  