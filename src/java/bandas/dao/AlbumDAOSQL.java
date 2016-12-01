/*
 * AlbumDAOSQL.java
 *
 * Created on 4 de Novembro de 2008, 11:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package bandas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bandas.logica.Album;

/**
 *
 */
public class AlbumDAOSQL implements AlbumDAO {
       
    private static final String CONSULTA_ALBUM_POR_TITULO = 
    		"SELECT * FROM bandas.Album WHERE Titulo like ?";
    
    private static final String CONSULTA_ALBUM_POR_ARTISTA =
            "SELECT Titulo, Preco FROM bandas.Album WHERE NomeArtista like ?";
   
    private static final String CONSULTA_ALBUM_POR_CAPA =
            "SELECT Titulo, Preco FROM bandas.Album WHERE capa like ?";
    
    private static final String INSERIR_ALBUM = 
    		"INSERT INTO bandas.Album(Titulo, Capa, Preco, NomeArtista) VALUES(?,?,?,?)";
    
    private Connection conexaoBanco;
    
    public int salvar(Album album) {
    	conexaoBanco = ConnectionFactory.getConnection();
        try{
            PreparedStatement sentencaSQL = 
                    conexaoBanco.prepareStatement(INSERIR_ALBUM);
            sentencaSQL.setString(1, album.getTitulo());
            sentencaSQL.setString(2, album.getCapa());
            sentencaSQL.setFloat(3, album.getPreco());
            sentencaSQL.setString(4,album.getNomeArtista());
            int retorno = sentencaSQL.executeUpdate();
            sentencaSQL.close();
            conexaoBanco.close();
            return retorno;
        } catch (SQLException ex) {
            System.out.println("Falha ao salvar album em banco de dados.");
            return 0;
        } 
    }
    
    public Album consultaPorTitulo(String titulo) {
    	conexaoBanco = ConnectionFactory.getConnection();
    	try {
            PreparedStatement sentencaSQL = 
               conexaoBanco.prepareStatement(CONSULTA_ALBUM_POR_TITULO);
            sentencaSQL.setString(1, titulo);
            ResultSet resultado = sentencaSQL.executeQuery();
            Album album = null;
            if (resultado.next()){
                album = new Album();
                album.setTitulo(resultado.getString("Titulo"));
                album.setCapa(resultado.getString("Capa"));
                album.setPreco(resultado.getFloat("Preco"));
                album.setNomeArtista(resultado.getString("NomeArtista"));
            }
            sentencaSQL.close();
            conexaoBanco.close();
            return album;
        } catch (SQLException ex) {
            System.out.println("Falha ao consultar album em banco de dados.");
            return null;
        }
    }
    
    public ArrayList<Album> consultaPorArtista(String nomeArtista) {
    	conexaoBanco = ConnectionFactory.getConnection();
    	ArrayList<Album> albuns = new ArrayList<Album>();
    	try {
    		PreparedStatement sentencaSQL = 
    				conexaoBanco.prepareStatement(CONSULTA_ALBUM_POR_ARTISTA);
    		sentencaSQL.setString(1, nomeArtista);
    		ResultSet resultado = sentencaSQL.executeQuery();
    		while(resultado.next()){
    			Album album = new Album();
    			album.setTitulo(resultado.getString("Titulo"));
    			//livro.setEditora(resultado.getString("Editora"));
    			album.setPreco(resultado.getFloat("Preco"));
    			albuns.add(album);
    		}
            sentencaSQL.close();
            conexaoBanco.close();
    		return albuns;
    	} catch (SQLException ex) {
    		System.out.println("Falha ao consultar album em banco de dados.");
    		return albuns;
    	}
    }  
}
