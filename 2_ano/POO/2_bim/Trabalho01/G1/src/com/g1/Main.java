package com.g1;

import java.util.Date;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Categoria categoria1 = new Categoria("Policia");
		Categoria categoria2 = new Categoria("Esportes");
		Autor autor1 = new Autor("João", "joao@globo.com", "joao123", Plano.Pro, Estado.SC, 1);

		Autor autor2 = new Autor("Radio Globo", "globo@globo.com", "globo123", Plano.Pro, Estado.SP, 2000);
		autor2.setSenha("novaSenha");

		Lista lista = new Lista();

		Noticia noticia1 = new Noticia("Baleia baleia Baleia", "Morte trágica em SC", new Date(),
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam quis turpis est. Pellentesque in lorem id est sollicitudin ultricies interdum",
				autor1, categoria1);
		Noticia noticia2 = new Noticia("Seleção atropela Honduras e faz maior goleada da era Tite",
				"Gabriel Jesus(2 gols), Coutinho e estreante David Neres foram os destaques.", new Date(),
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam quis turpis est. Pellentesque in lorem id est sollicitudin ultricies interdum",
				autor2, categoria2);

		lista.adicionarNoticia(noticia1);
		lista.adicionarNoticia(noticia2);

		autor1.novaPublicacao();
		autor2.novaPublicacao();

		lista.removerNoticia(noticia1);

		List<Noticia> listaFiltrada = lista.buscar("esporte");
		
		// Mostra a primeira noticia do filtro
		listaFiltrada.get(0).visualizarNoticiaCompleta();

		Usuario usuario = new Usuario("Sergio", "sergio@gmail.com", "sergio123", Plano.Free, Estado.SC);
		usuario.realizarLogin("sergio@gmail.com", "Sergio123");
		if (usuario.getIsLogado() != true)
			usuario.realizarLogin("sergio@gmail.com", "sergio123");

		String infoUsuario = usuario.obterInformacoes();
		System.out.println(infoUsuario);
	}
}
