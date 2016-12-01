package bandas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bandas.logica.Artista;

/**
 *
 */
public class ArtistaDAOSQL implements ArtistaDAO {
	
    private static final String CONSULTA_ARTISTA_POR_NOME = 
            "select * from bandas.Artista where NomeArtista like ?";
    
    private static final String INSERIR_ARTISTA = 
            "insert into bandas.Artista (NomeArtista, Cidade) values (?,?)";
    
    private Connection conexaoBanco;
    
    public int salvar(Artista artista) {
    	conexaoBanco = ConnectionFactory.getConnection();
        try {
            PreparedStatement sentencaSQL = conexaoBanco.
                prepareStatement(INSERIR_ARTISTA);
            sentencaSQL.setString(1, artista.getNomeArtista());
            sentencaSQL.setString(2, artista.getCidade());
            int retorno = sentencaSQL.executeUpdate();
            sentencaSQL.close();
            conexaoBanco.close();
            return retorno;
        } catch (SQLException ex) {
            System.out.println("Falha ao salvar artista em banco de dados.");
            return 0;
        }
    }
    
    public Artista consultaPorNome(String nomeArtista) {
    	conexaoBanco = ConnectionFactory.getConnection();
    	try {
    		PreparedStatement sentencaSQL = 
    				conexaoBanco.prepareStatement(CONSULTA_ARTISTA_POR_NOME);
    		sentencaSQL.setString(1, nomeArtista);
    		ResultSet resultado = sentencaSQL.executeQuery();
    		Artista artista = null;
    		if (resultado.next()){
    			artista = new Artista();
    			artista.setNomeArtista(resultado.getString("NomeArtista"));
    			artista.setCidade(resultado.getString("Cidade"));
    		}
    		sentencaSQL.close();
    		conexaoBanco.close();
    		return artista;
    	} catch (SQLException ex) {
    		System.out.println("Falha ao consultar artista em banco de dados.");
    		ex.printStackTrace();
    		return null;
    	}        
    }     
}
