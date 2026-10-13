package com.iesdoctorbalmis.spring;

import com.iesdoctorbalmis.spring.model.Cliente;
import com.iesdoctorbalmis.spring.model.TipoCliente;
import com.iesdoctorbalmis.spring.repository.ClienteRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner testRepositorio(ClienteRepositorio clienteRepositorio) {
		return args -> {
			System.out.println("=== Prueba ClienteRepositorio ===");

			// Crear y guardar un cliente
			Cliente cliente1 = new Cliente();
			cliente1.setCodigoCliente("CLI-001");
			cliente1.setNombre("Acme Corporation");
			cliente1.setEmail("info@acme.com");
			cliente1.setTipoCliente(TipoCliente.PROSPECTO);
			cliente1.setFechaAlta(LocalDate.now());

			Cliente guardado = clienteRepositorio.guardar(cliente1);
			System.out.println("- Cliente guardado con ID: " + guardado.getId());

			// Buscar todos los clientes
			System.out.println("- Total de clientes: " + clienteRepositorio.contar());

			// Buscar por ID
			Cliente encontrado = clienteRepositorio.buscarPorId(1L);
			System.out.println("- Cliente encontrado: " + encontrado.getNombre());

			// Cambiar a activo
			encontrado.setTipoCliente(TipoCliente.ACTIVO);
			clienteRepositorio.actualizar(encontrado);
			System.out.println("- Cliente actualizado a: " + encontrado.getTipoCliente());

			// Listar por tipo
			System.out.println("- Clientes ACTIVOS: " + clienteRepositorio.buscarPorTipo(TipoCliente.ACTIVO).size());
		};
	}
}