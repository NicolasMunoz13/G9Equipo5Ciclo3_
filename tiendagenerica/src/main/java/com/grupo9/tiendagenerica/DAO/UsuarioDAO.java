package com.grupo9.tiendagenerica.DAO;

import com.grupo9.tiendagenerica.DTO.UsuarioVO;
import java.sql.*;
import java.util.ArrayList;

//Clase para generar el acceso a la base de datos
public class UsuarioDAO {
	
	public void registrarUsuario(UsuarioVO user) {
		//Llamar y crear una instancia de la clase encargada de hacer la conexion
		Conexion conex = new Conexion();
		
		try {
			//Sentencia que se ejecutara en la base de datos
			Statement estatuto = conex.getConnection().createStatement();
			
			//String que contiene la sentencia insert a ejecutar
			String sentencia = "INSERT INTO usuarios VALUES(" 
					+ user.getCedula_usuario() + "," + "'"
					+ user.getEmail_usuario() + "'," + "'" 
					+ user.getNombre_usuario() + "'," + "'" 
					+ user.getPassword()+ "'," + "'" 
					+ user.getUsuario() + "'" 
					+ ");";
			
			//Ejecutar la sentencia de la base de datos
			estatuto.executeUpdate(sentencia);
			//Impresion en consola para verificacion
			System.out.println("Registrado " + sentencia);
			//Cerrar la sentencia y conexion
			estatuto.close();
			conex.desconectar();
			
		} catch (SQLException e) {
			// Si hay error en SQL mstrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} 
		catch (Exception e) {
			// Si hay cualquier otro error mostarlo
			System.out.println("No se pudo insertar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	
	//Permite consultar el usuario asociado al user enviado como parametro
	public ArrayList<UsuarioVO> consultarUsuario(String usuario){
		//Lista que contendra el o los usuarios obtenidos
		ArrayList<UsuarioVO> listausuarios = new ArrayList<UsuarioVO>();
		//Instancia de la conexion
		Conexion conex = new Conexion();
		
		try {
			//Preparar la sentenca en la base de datos
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios where usuario = ? ");
			//Se cambia el comodin ? por el dato que ha llegado en el parametro de la funcion
			consulta.setString(1, usuario);
			//Ejecutar la sentencia
			ResultSet res = consulta.executeQuery();
			//Crear un objeto basado en la clase entidad con los datos encontrados
			if (res.next()) {
				UsuarioVO Usuario = new UsuarioVO();
				Usuario.setCedula_usuario(Integer.parseInt(res.getString("cedula_usuario")));
				Usuario.setEmail_usuario(res.getString("email_usuario"));
				Usuario.setNombre_usuario(res.getString("nombre_usuario"));
				Usuario.setPassword(res.getString("password"));
				Usuario.setUsuario(res.getString("usuario"));
				
				listausuarios.add(Usuario);
			}
			//Cerrar resultado, sentencia y conexion
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch (SQLException e) {
			// Si hay erroe en sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} 
		catch (Exception e) {
			// Mostar cualquier otro error
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		return listausuarios;
	}
	
	//Permite consultar la lista de todos los usuarios
	public ArrayList<UsuarioVO> listaDeUsuarios(){
		//Lista que contendra el o los usuarios
		ArrayList<UsuarioVO> listausuarios = new ArrayList<UsuarioVO>();
		
		//Instancia de la conexion
		Conexion conex = new Conexion();
		
		try {
			//prepare la sentencia en la base de datos
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios");
			
			//ejecute la sentencia
			ResultSet res = consulta.executeQuery();
			
			//cree un objeto para cada encontrado en la base de datos basado en la clase entidad con los datos encontrados
			while (res.next()) {
				UsuarioVO Usuario = new UsuarioVO();
				Usuario.setCedula_usuario(Integer.parseInt(res.getString("cedula_usuario")));
				Usuario.setEmail_usuario(res.getString("email_usuario"));
				Usuario.setNombre_usuario(res.getString("nombre_usuario"));
				Usuario.setPassword(res.getString("password"));
				Usuario.setUsuario(res.getString("usuario"));

				listausuarios.add(Usuario);
			}
			
			//Cerrar resultado, sentencia y conexion
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch (SQLException e) {
			// Si hay erroe en sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todos los usuarios");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} 
		catch (Exception e) {
			// Mostar cualquier otro error
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todos los usuarios");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		
		return listausuarios;
	}
	

	//Permite la eliminacion de un usuario
	public void eliminarUsuario(Integer cedula_usuario){
		
		//Instancia de la conexion
		Conexion conex = new Conexion();
		
		try {
			//Sentencia inicializada
			Statement consulta = conex.getConnection().createStatement();
			
			//preparando sentencia a realizar
			String sentencia = "DELETE from usuarios where cedula_usuario=" + cedula_usuario + ";";
			
			//Impresion de verificacion
			System.out.println("Registrado " + sentencia);
			
			//Ejecutando la sentencia en la base de datos
			consulta.execute(sentencia);
			
			//Cerrando sentencia y conexion
			consulta.close();
			conex.desconectar();
			
		} catch (SQLException e) {
			// Si hay erroe en sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} 
		catch (Exception e) {
			// Mostar cualquier otro error
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	public void actualizarUsuario(UsuarioVO user) {
		
		//Instancia de conexion
		Conexion conex = new Conexion();
		
		try {
			//Inicializando la sentencia
			Statement estatuto = conex.getConnection().createStatement();
			
			//String con la sentencia a ejecutar
			String sentencia = "UPDATE usuarios "
					+ "SET email_usuario = '"+user.getEmail_usuario()+"',"
					+ "nombre_usuario = '"+user.getNombre_usuario()+"',"
					+ "password = '"+user.getPassword()+"',"
					+ "usuario = '"+user.getUsuario()+"' "
					+ "WHERE cedula_usuario = "+user.getCedula_usuario()+";";
			
			//ejecutando la sentencia
			estatuto.executeUpdate(sentencia);
			
			//Verificacion por consolta de la sentencia
			System.out.println("Registrado " + sentencia);
			
			//Cerrando sentencia y conexion
			estatuto.close();
			conex.desconectar();
			
		} catch (SQLException e) {
			// Si hay erroe en sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo actualizar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} 
		catch (Exception e) {
			// Mostar cualquier otro error
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo actualizar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	}

}
