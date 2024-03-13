package com.decry.fanzo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import com.decry.fanzo.Repository.ComitenteRepository;
import com.decry.fanzo.Repository.MercadoRepository;




@SpringBootApplication
@ComponentScan(basePackages = "com.decry.fanzo")
public class DecryptoApplication implements CommandLineRunner{

	
	@Autowired
	ComitenteRepository comitenteRepository;	
	@Autowired
	MercadoRepository mercadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DecryptoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//La usaria para cargar los paises si no fueran enum
		

//		Comitente comitente1 = new Comitente();
//		comitente1.setNombre("ComitenteAB");
//
//		Comitente comitente2 = new Comitente();
//		comitente2.setNombre("ComitenteCD");
//		
//		comitenteRepository.save(comitente1);
//		comitenteRepository.save(comitente2);
//		
//		
//		Mercado mer1 = new Mercado();
//		mer1.setCodigo("101");
//		mer1.setDescripcion("Mercado101");
//		
//		Mercado mer2 = new Mercado();
//		mer2.setCodigo("202");
//		mer2.setDescripcion("Mercado202");
//
//		
//		
//		List<Comitente> comitentesM1 = new ArrayList<>();
//		comitentesM1.add(comitente1);
//		comitentesM1.add(comitente2);
//		
//		mer1.setComitentes(comitentesM1);
//		
//		List<Comitente> comitentesM2 = new ArrayList<>();
//		comitentesM2.add(comitente1);
//		comitentesM2.add(comitente2);
//		
//		mer2.setComitentes(comitentesM2);
//		
//		//Guardo
//		
//
//		mercadoRepository.save(mer1);
//		mercadoRepository.save(mer2);
		
	}

}
