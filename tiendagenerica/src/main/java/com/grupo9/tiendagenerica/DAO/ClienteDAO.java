package com.grupo9.tiendagenerica.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.grupo9.tiendagenerica.DTO.ClienteVO;

//Clase para generar el acceso a la base de datos
public class ClienteDAO {
	
	public void registrarCliente(ClienteVO user) {
		//Llamar y crear una instancia de la clase encargada de hacer la conexion
		Conexion conex = new Conexion();
		
		try {
			//Sentencia que se ejecutara en la base de datos
			Statement estatuto = conex.getConnection().createStatement();
			
			//String que contiene la sentencia insert a ejecutar
			String sentencia = "INSERT INTO clientes VALUES(" 
					+ user.getCedula_cliente() + "," + "'"
					+ user.getNombre_cliente() + "'," + "'" 
					+ user.getDireccion_cliente() + "'," + "'" 
					+ user.getTelefono_cliente()+ "'," + "'" 
					+ user.getEmail_cliente() + "'" 
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
			System.out.println("No se pudo insertar el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} 
		catch (Exception e) {
			// Si hay cualquier otro error mostarlo
			System.out.println("No se pudo insertar el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	
	//Permite consultar el usuario asociado al user enviado como parametro
	public ArrayList<ClienteVO> consultarCliente(Integer cedula){
		//Lista que contendra el o los usuarios obtenidos
		ArrayList<ClienteVO> listaclientes = new ArrayList<ClienteVO>();
		//Instancia de la conexion
		Conexion conex = new Conexion();
		
		try {
			//Preparar la sentenca en la base de datos
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes where cedula_cliente = ? ");
			//Se cambia el comodin ? por el dato que ha llegado en el parametro de la funcion
			consulta.setInt(1, cedula);
			//Ejecutar la sentencia
			ResultSet res = consulta.executeQuery();
			//Crear un objeto basado en la clase entidad con los datos encontrados
			if (res.next()) {
				ClienteVO Cliente = new ClienteVO();
				Cliente.setCedula_cliente(Integer.parseInt(res.getString("cedula_cliente")));
				Cliente.setNombre_cliente(res.getString("nombre_cliente"));
				Cliente.setDireccion_cliente(res.getString("direccion_cliente"));
				Cliente.setTelefono_cliente(res.getString("telefono_cliente"));
				Cliente.setEmail_cliente(res.getString("email_cliente"));
				
				listaclientes.add(Cliente);
			}
			//Cerrar resultado, sentencia y conexion
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch (SQLException e) {
			// Si hay erroe en sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} 
		catch (Exception e) {
			// Mostar cualquier otro error
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		return listaclientes;
	}
	
	//Permite consultar la lista de todos los clientes
	public ArrayList<ClienteVO> listaDeClientes(){
		//Lista que contendra el o los clientes
		ArrayList<ClienteVO> listaclientes = new ArrayList<ClienteVO>();
		
		//Instancia de la conexion
		Conexion conex = new Conexion();
		
		try {
			//prepare la sentencia en la base de datos
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes");
			
			//ejecute la sentencia
			ResultSet res = consulta.executeQuery();
			
			//cree un objeto para cada encontrado en la base de datos basado en la clase entidad con los datos encontrados
			while (res.next()) {
				ClienteVO Cliente = new ClienteVO();
				Cliente.setCedula_cliente(Integer.parseInt(res.getString("cedula_cliente")));
				Cliente.setNombre_cliente(res.getString("nombre_cliente"));
				Cliente.setDireccion_cliente(res.getString("direccion_cliente"));
				Cliente.setTelefono_cliente(res.getString("telefono_cliente"));
				Cliente.setEmail_cliente(res.getString("email_cliente"));
				
				listaclientes.add(Cliente);				
			}
			
			//Cerrar resultado, sentencia y conexion
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch (SQLException e) {
			// Si hay erroe en sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todos los clientes");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} 
		catch (Exception e) {
			// Mostar cualquier otro error
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todos los clientes");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		
		return listaclientes;
	}
	

	//Permite la eliminacion de un cliente
	public void eliminarCliente(Integer cedula_cliente){
		
		//Instancia de la conexion
		Conexion conex = new Conexion();
		
		try {
			//Sentencia inicializada
			Statement consulta = conex.getConnection().createStatement();
			
			//preparando sentencia a realizar
			String sentencia = "DELETE from clientes where cedula_cliente=" + cedula_cliente + ";";
			
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
			System.out.println("No se pudo eliminar el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} 
		catch (Exception e) {
			// Mostar cualquier otro error
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	public void actualizarCliente(ClienteVO user) {
		
		//Instancia de conexion
		Conexion conex = new Conexion();
		
		try {
			//Inicializando la sentencia
			Statement estatuto = conex.getConnection().createStatement();
			
			//String con la sentencia a ejecutar
			String sentencia = "UPDATE clientes "
					+ "SET nombre_cliente = '"+user.getNombre_cliente()+"',"
					+ "direccion_cliente = '"+user.getDireccion_cliente()+"',"
					+ "telefono_cliente = '"+user.getTelefono_cliente()+"',"
					+ "email_cliente = '"+user.getEmail_cliente()+"' "
					+ "WHERE cedula_cliente = "+user.getCedula_cliente()+";";
			
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
			System.out.println("No se pudo actualizar el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} 
		catch (Exception e) {
			// Mostar cualquier otro error
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo actualizar el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	}

}
