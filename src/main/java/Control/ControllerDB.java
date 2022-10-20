package Control;

import com.sun.source.tree.ReturnTree;

import javax.imageio.stream.IIOByteBuffer;
import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class ControllerDB {

    public Connection test_conexion;
    String driver = "com.mysql.cj.jdbc.Driver";
    String user = "root";
    String password = "ingesoft2003";
    String url = "jdbc:mysql://localhost:3306/mudafacil_db?serverTimezone=UTC";

    public ControllerDB() throws SQLException {
    }

    public Connection getConnection() {
        try {
            Class.forName(driver);
            test_conexion = DriverManager.getConnection(url, user, password);
            if (test_conexion != null) {
                System.out.println("Conexion realizada con exito");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return test_conexion;
    }

    public boolean validarusuario(String Nombre, String Contra) throws SQLException, ClassNotFoundException {
        Boolean Existe = false;
        try {
            Class.forName(driver);
            test_conexion = DriverManager.getConnection(url, user, password);
            if (test_conexion != null) {
                System.out.println("Conexion realizada con exito");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Statement statement = test_conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT nombre_usuario, contra FROM USUARIO");
        while (rs.next()) {
            String var1 = rs.getString(1);
            String var2 = rs.getString(2);
            if (Objects.equals(var1, Nombre) && Objects.equals(var2, Contra) && !Existe) {
                Existe = true;
            }
        }
        return Existe;
    }


    // BUSCAR EL TIPO DE CUENTA DE UN USUARIO
    public String BuscarTCuenta(String NombU, String Contrase) throws SQLException, ClassNotFoundException {
        String Cuenta = null;

        try {
            Class.forName(driver);
            test_conexion = DriverManager.getConnection(url, user, password);
            if (test_conexion != null) {
                System.out.println("Conexion realizada con exito");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Statement statement = test_conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT nombre_usuario, contra, tipo_cuenta FROM USUARIO");
        while(rs.next()){
            String var1 = rs.getString(1 );
            String var2 = rs.getString(2);
            String var3 = rs.getString(3);
            if (Objects.equals(var1, NombU) && Objects.equals(var2, Contrase)) {
                Cuenta = var3;
            }
        }

        return Cuenta;
    }


    // VALIDAR QUE LAS ID NO SE REPITAN EN LA CREACION DE UNA CUENTA
    public boolean validarRegistroCedula (int cedula) throws SQLException {
        boolean bandera = false;
        int Ced;

        try {
            Class.forName(driver);
            test_conexion = DriverManager.getConnection(url, user, password);
            if (test_conexion != null) {
                System.out.println("Conexion realizada con exito");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Statement statement = test_conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT id FROM USUARIO");

        while(rs.next()){
            String var1 = rs.getString(1);
            Ced = Integer.parseInt(var1);

            if(cedula == Ced){
                bandera = true;
            }
        }
        return bandera;
    }

    // SUBIR UNA NUEVA CUENTA A LA BASE DE DATOS
    public void agregarusuario (String Nomb, int Id, String Contra, String NombU, String Cell, String FechaN, String TCuenta) throws SQLException, ClassNotFoundException {

        try {
            Class.forName(driver);
            test_conexion = DriverManager.getConnection(url, user, password);
            if (test_conexion != null) {
                System.out.println("Conexion realizada con exito SUBIR DATOS");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        PreparedStatement Datos = test_conexion.prepareStatement("insert into USUARIO values (?,?,?,?,?,?,?)");

        Datos.setString(1,Nomb);
        Datos.setString(2, String.valueOf(Id));
        Datos.setString(3,Contra);
        Datos.setString(4,NombU);
        Datos.setString(5,Cell);
        Datos.setString(6,FechaN);
        Datos.setString(7,TCuenta);
        Datos.executeUpdate();

    }

    public String BuscarIDUsuario (String NombU, String Contrase) throws SQLException, ClassNotFoundException {
        String id = null;

        try {
            Class.forName(driver);
            test_conexion = DriverManager.getConnection(url, user, password);
            if (test_conexion != null) {
                System.out.println("Conexion realizada con exito");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Statement statement = test_conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT nombre_usuario, contra, id FROM USUARIO");
        while(rs.next()){
            String var1 = rs.getString(1 );
            String var2 = rs.getString(2);
            String var3 = rs.getString(3);
            if (Objects.equals(var1, NombU) && Objects.equals(var2, Contrase)) {
                id = var3;
            }
        }
        return id;
    }

    public void agregarMudanza (int id, int Persona, String DPartida, String DLlegada, String Fecha, String Hora) throws SQLException, ClassNotFoundException {

        String Identificador = String.valueOf(id);
        String Perso = String.valueOf(Persona);
        int x = 0;

        System.out.println(Identificador + " / " + Perso);

        try {
            Class.forName(driver);
            test_conexion = DriverManager.getConnection(url, user, password);
            if (test_conexion != null) {
                System.out.println("Conexion realizada con exito SUBIR DATOS");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        PreparedStatement Datos = test_conexion.prepareStatement("insert into MUDANZA values (?,?,?,?,?,?,?,?,?,?)");

        Datos.setString(1,Identificador);
        Datos.setString(2, Perso);
        Datos.setString(3, String.valueOf(x));
        Datos.setString(4, String.valueOf(x));
        Datos.setString(5, String.valueOf(x));
        Datos.setString(6,DPartida);
        Datos.setString(7,DLlegada);
        Datos.setString(8,Fecha);
        Datos.setString(9,Hora);
        Datos.setString(10, String.valueOf(x));
        Datos.executeUpdate();
    }

        public void agregarArticuloMudanza(String nombreArticulo, int largo, int ancho, int alto, int peso, int ID) throws SQLException {

            System.out.println("Datos: "+ nombreArticulo + largo + ancho + alto + peso + ID);

            try {
                Class.forName(driver);
                test_conexion = DriverManager.getConnection(url, user, password);
                if (test_conexion != null) {
                    System.out.println("Conexion realizada con exito SUBIR DATOS");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            PreparedStatement Datos = test_conexion.prepareStatement("insert into ARTICULOSMUDANZA values (?,?,?,?,?,?)");

            Datos.setString(1,nombreArticulo);
            Datos.setString(2, String.valueOf(largo));
            Datos.setString(3, String.valueOf(ancho));
            Datos.setString(4, String.valueOf(alto));
            Datos.setString(5, String.valueOf(peso));
            Datos.setString(6, String.valueOf(ID));
            Datos.executeUpdate();

    }

}