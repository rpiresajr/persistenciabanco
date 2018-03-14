package com.r2d2apps.api.reporitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.r2d2apps.api.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	Empresa findByCnpj(String cnpj);
	
}
