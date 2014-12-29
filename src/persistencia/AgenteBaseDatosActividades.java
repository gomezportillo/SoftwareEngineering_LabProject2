package persistencia;

import java.sql.*;
import java.util.Vector;

public class AgenteBaseDatosActividades {
	//instancia del agente
	protected static AgenteBaseDatosActividades mInstancia=null;
	//Conexion con la base de datos
	protected static Connection mBD;
	//Identificador ODBC de la base de datos
	private static String url="jdbc:odbc:BDActividades"; /**A esto habrá que ponerle el nombre de la base de datos que hemso definido (antes era P1_Login)**/
	//Driven para conectar con bases de datos Microsoft Access 
	private static String driver="sun.jdbc.odbc.JdbcOdbcDriver";



	//Constructor privado, para obligar a crear un agente con Agente a = Agente.getAgente();
	private AgenteBaseDatosActividades()throws Exception {
		conectar();

	}

	//Implementacion del patron singleton Este patron de diseño permite implementar clases de las cuales
	//solo existir una instancia: http://es.wikipedia.org/wiki/Singleton
	public static AgenteBaseDatosActividades getAgente() throws Exception{
		if (mInstancia==null){
			mInstancia=new AgenteBaseDatosActividades();
		}
		return mInstancia;
	}

	//Metodo para realizar la conexion a la base de datos 
	private void conectar() throws Exception {
		Class.forName(driver);
		mBD=DriverManager.getConnection(url);
	}


	//Metodo para desconectar de la base de datos
	public void desconectar() throws Exception{
		mBD.close();
	}

	//Metodo para realizar una insercion en la base de datos
	public int insert(String SQL) throws SQLException, Exception{
		conectar();
		PreparedStatement stmt = mBD.prepareStatement(SQL); // SQL = "INSERT INTO Usuario VALUES ('Antonio', 'Asecas')"
		int res=stmt.executeUpdate();
		stmt.close();
		desconectar();
		return res;
	}

	//Metodo para realizar una eliminacion en la base de datos. Nunca se usa
	public int delete(String SQL) throws SQLException,Exception{
		conectar();
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res=stmt.executeUpdate();
		stmt.close();
		desconectar();
		return res;
	}

	//Metodo para realizar una eliminacion en la base de datos
	public int update(String SQL) throws SQLException,Exception{
		conectar();
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res=stmt.executeUpdate();
		stmt.close();
		desconectar();
		return res;
	}


	public Vector<Object> select(String SQL) throws SQLException,Exception{
		conectar();
		/**Metodo para realizar una busqueda o seleccion de informacion enla base de datos
		 *El mtodo select devuelve un vector de vectores, donde cada uno de los vectores
		 *que contiene el vector principal representa los registros que se recuperan de la base de datos.
		 */	

		//Definimos primero el vector que vamos a usar para almacenar todos los valores y después el vector que va a ayudarle a ello
		Vector<Object> vector_final = new Vector<Object>();
		
		//Creamos la consulta
		PreparedStatement sentencia = mBD.prepareStatement(SQL); 
		ResultSet respuesta = sentencia.executeQuery(); // antes estaba "SELECT * FROM Usuario"
		
		while(respuesta.next()){ //mientras haya más entradas
			Vector<Object> vector_tmp = new Vector<Object>();
			String id = respuesta.getString("codigo");
			String entrenador = respuesta.getString("Entrenador"); //selecciona el campo del login y lo guarda en una string
			String miembro = respuesta.getString("Miembro"); //selecciona el campo de la contraseña y lo guarda en una string
			String maquina = respuesta.getString("Maquina");
			String hora= respuesta.getString("Hora");
			
			//metemos el nombre y la contraseña en el vector pequeño
			vector_tmp.add(id);
			vector_tmp.add(entrenador);
			vector_tmp.add(miembro);
			vector_tmp.add(maquina);
			vector_tmp.add(hora);
			
			//metemos el vector que acabamos de definir en el vector grande, que devolveremos al final
			vector_final.add(vector_tmp);
		}
		respuesta.close();
		sentencia.close();
		desconectar();
		
		return vector_final;
	}




}
