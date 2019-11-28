package br.univille.main;

import br.univille.ecommerce.Cliente;
import br.univille.ecommerce.Ofertas;
import br.univille.youtube.Notificador;
import br.univille.youtube.Usuario;

public class Main {
	public static void main(String[] args) {
		Ofertas ofertas = new Ofertas();

		Cliente c1 = new Cliente("João");
		Cliente c2 = new Cliente("Maria");
		
		ofertas.attach(c1);
		ofertas.attach(c2);
		
		ofertas.novaOferta("Banana", 1.0);
		
		ofertas.detach(c1);

		ofertas.novaOferta("Hot pocket", 10.5);
		
		Notificador notificadorYoutube = new Notificador();

		Usuario u1 = new Usuario("João do Youtube");
		
		notificadorYoutube.attach(u1);
		notificadorYoutube.videoNovo("Pisei na amoeba e olha no que deu", 10);
	}
}
