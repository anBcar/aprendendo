package br.com.ana.projeto_integrador.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ana.projeto_integrador.modelo.Manga;
import br.com.ana.projeto_integrador.modelo.Usuario;

public class MangaDAO {
	
	public static List<Manga> listar(Usuario usuario) throws Exception{
		String sql = "SELECT * FROM manga WHERE usuario = ?";
		
		List<Manga> list = new ArrayList<Manga>();
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ps.setInt(1, (int) usuario.getId());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Manga manga = new Manga();
				manga.setId(rs.getInt("mangaid"));
				manga.setNome(rs.getString("nome"));
				manga.setAtor(rs.getString("ator"));
				manga.setTipo(rs.getString("tipo"));
				manga.setVolume(rs.getString("volume"));
				manga.setNota(rs.getString("nota"));
				manga.setUsuario(rs.getInt("usuario"));
				
				list.add(manga);
			}
			
			return list;
		}
		
	}
}
