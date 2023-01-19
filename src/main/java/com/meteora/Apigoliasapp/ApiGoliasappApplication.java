package com.meteora.Apigoliasapp;

import com.meteora.Apigoliasapp.Entities.Empresa;
import com.meteora.Apigoliasapp.Entities.Estagiario;
import com.meteora.Apigoliasapp.Repositories.EmpresaRepository;
import com.meteora.Apigoliasapp.Repositories.EstagiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class ApiGoliasappApplication {
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private EstagiarioRepository estagiarioRepository;
	@Bean
	public CommandLineRunner init(){
		return args -> {
			Empresa empresa1 = new Empresa();
			empresa1.setNome("meteora");

			Estagiario estagiario1 = new Estagiario("gabriel");
			estagiario1.setEmpresa(empresa1);

			empresaRepository.save(empresa1);


			estagiarioRepository.save(estagiario1);

			Empresa empresa = empresaRepository.findEmpresaFetchEstagiarios(empresa1.getId());
			System.out.println(estagiario1);

		};
	}









	public static void main(String[] args)
{
		SpringApplication.run(ApiGoliasappApplication.class, args);
	}
}
