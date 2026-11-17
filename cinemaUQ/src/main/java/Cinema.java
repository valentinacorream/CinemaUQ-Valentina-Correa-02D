import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private String nombre;
    private String nit;
    private String direccion;
    private List<Pelicula> listPeliculas;
    private List<Sala> listSalas;
    private List<Cliente> listClientes;
    private List<Funcion> listFunciones;

    public Cinema(String nombre, String nit, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;

        listPeliculas= new ArrayList<>();
        listSalas= new ArrayList<>();
        listClientes= new ArrayList<>();
        listFunciones= new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Pelicula> getListPeliculas() {
        return listPeliculas;
    }

    public void setListPeliculas(List<Pelicula> listPeliculas) {
        this.listPeliculas = listPeliculas;
    }

    public List<Sala> getListSalas() {
        return listSalas;
    }

    public void setListSalas(List<Sala> listSalas) {
        this.listSalas = listSalas;
    }

    public List<Cliente> getListClientes() {
        return listClientes;
    }

    public void setListClientes(List<Cliente> listClientes) {
        this.listClientes = listClientes;
    }

    public List<Funcion> getListFunciones() {
        return listFunciones;
    }

    public void setListFunciones(List<Funcion> listFunciones) {
        this.listFunciones = listFunciones;
    }

    @Override
    public String toString() {
        return "Cinema: " +
                "nombre: " + nombre +
                ", NIT: " + nit +
                ", dirección: " + direccion;
    }

    //--Pelicula--
    // Verificar película
    public boolean verificarPeliculas(String codigo) {
        boolean existe = false;
        for (Pelicula pelicula : listPeliculas) {
            if (pelicula.getCodigo().equals(codigo)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    // Agregar película
    public boolean agregarPelicula(Pelicula pelicula) {
        boolean agregado = false;
        boolean existe = verificarPeliculas(pelicula.getCodigo());

        if (existe == true) {
            throw new PeliculaDuplicadaException(
                    "Ya existe una película con ese código"
            );
        }else {
            listPeliculas.add(pelicula);
            agregado = true;
        }
        return agregado;
    }

    //Consultar pelicula
    public Pelicula consultarPelicula(String codigo) {
        Pelicula encontrada = null;
        for (Pelicula pelicula : listPeliculas) {
            if (pelicula.getCodigo().equals(codigo)) {
                encontrada = pelicula;
                break;
            }
        }
        return encontrada;
    }

    // Actualizar película
    public boolean actualizarPelicula(String codigo, Pelicula peliculaActualizada) {
        boolean estaActualizada = false;
        for (Pelicula pelicula : listPeliculas) {
            if (pelicula.getCodigo().equals(codigo)) {
                pelicula.setNombre(peliculaActualizada.getNombre());
                pelicula.setGenero(peliculaActualizada.getGenero());
                pelicula.setDuracion(peliculaActualizada.getDuracion());
                pelicula.setClasificacion(peliculaActualizada.getClasificacion());

                estaActualizada = true;
                break;
            }
        }
        return estaActualizada;
    }

    //Deshabilitar pelicula
    public boolean deshabilitarPelicula(String codigo) {
        boolean deshabilitada = false;
        for (Pelicula pelicula : listPeliculas) {
            if (pelicula.getCodigo().equals(codigo)) {
                pelicula.setEstadoPelicula(EstadoPelicula.NO_DISPONIBLE);
                deshabilitada = true;
                break;
            }
        }
        return deshabilitada;
    }

    //--Sala--
    //Verificar sala
    public boolean verificarSalas(String codigo) {
        boolean existe = false;
        for (Sala sala : listSalas) {
            if (sala.getCodigo().equals(codigo)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    // Agregar sala
    public boolean agregarSala(Sala sala) {
        boolean agregado = false;
        boolean existe = verificarSalas(sala.getCodigo());

        if (existe == true) {
            throw new SalaDuplicadaException(
                    "Ya existe una sala con ese código"
            );
        }else {
            listSalas.add(sala);
            agregado = true;
        }
        return agregado;
    }

    //Consultar Sala
    public Sala consultarSala(String codigo) {
        Sala encontrada = null;
        for (Sala sala : listSalas) {
            if (sala.getCodigo().equals(codigo)) {
                encontrada = sala;
                break;
            }
        }
        return encontrada;
    }

    //Actualizar sala
    public boolean actualizarSala(String codigo, Sala salaActualizada) {
        boolean estaActualizada = false;
        for (Sala sala : listSalas) {
            if (sala.getCodigo().equals(codigo)) {
                sala.setNumero(salaActualizada.getNumero());
                sala.setCapacidad(salaActualizada.getCapacidad());

                estaActualizada = true;
                break;
            }
        }
        return estaActualizada;
    }

    //Deshabilitar sala
    public boolean deshabilitarSala(String codigo) {
        boolean deshabilitada = false;
        for (Sala sala : listSalas) {
            if (sala.getCodigo().equals(codigo)) {
                sala.setEstadoSala(EstadoSala.FUERA_SERVICIO);
                deshabilitada = true;
                break;
            }
        }
        return deshabilitada;
    }

    //--Clientes--
    //Verificar Cliente
    public boolean verificarClientes(String identificacion) {
        boolean existe = false;

        for (Cliente cliente : listClientes) {
            if (cliente.getIdentificacion().equals(identificacion)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    // Agregar cliente
    public boolean agregarCliente(Cliente cliente) {
        boolean agregado = false;
        boolean existe = verificarClientes(cliente.getIdentificacion());

        if (existe == false) {
            listClientes.add(cliente);
            agregado = true;
        }
        return agregado;
    }

    //Consultar Clientes
    public Cliente consultarCliente(String identificacion) {
        Cliente encontrado = null;
        for (Cliente cliente : listClientes) {
            if (cliente.getIdentificacion().equals(identificacion)) {
                encontrado = cliente;
                break;
            }
        }
        return encontrado;
    }

    //Actualizar cliente
    public boolean actualizarCliente(String identificacion, Cliente clienteActualizado) {
        boolean estaActualizado = false;
        for (Cliente cliente : listClientes) {
            if (cliente.getIdentificacion().equals(identificacion)) {
                cliente.setNombre(clienteActualizado.getNombre());
                cliente.setTipoCliente(clienteActualizado.getTipoCliente());

                estaActualizado = true;
                break;
            }
        }
        return estaActualizado;
    }

    //--Funcion--
    //Verificar Funcion
    public boolean verificarFunciones(String codigo) {
        boolean existe = false;

        for (Funcion funcion : listFunciones) {
            if (funcion.getCodigo().equals(codigo)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    // Agregar función
    public boolean agregarFuncion(Funcion funcion) {
        boolean agregado = false;
        boolean existe = verificarFunciones(funcion.getCodigo());

        if (existe == false) {
            if (funcion.getSala().getEstadoSala() == EstadoSala.FUERA_SERVICIO) {
                throw new SalaNoDisponibleException(
                        "No se puede programar una función en una sala fuera de servicio"
                );
            }else {
                listFunciones.add(funcion);
                agregado = true;
            }
        }
        return agregado;
    }

    //Consultar funcion
    public Funcion consultarFuncion(String codigo) {
        Funcion encontrada = null;

        for (Funcion funcion : listFunciones) {
            if (funcion.getCodigo().equals(codigo)) {
                encontrada = funcion;
                break;
            }
        }
        return encontrada;
    }

    //Actualizar funcion
    public boolean actualizarFuncion(String codigo, Funcion funcionActualizada) {
        boolean estaActualizada = false;
        for (Funcion funcion : listFunciones) {
            if (funcion.getCodigo().equals(codigo)) {
                if (funcionActualizada.getSala().getEstadoSala() == EstadoSala.DISPONIBLE) {
                    funcion.setPelicula(funcionActualizada.getPelicula());
                    funcion.setSala(funcionActualizada.getSala());
                    funcion.setFecha(funcionActualizada.getFecha());
                    funcion.setHora(funcionActualizada.getHora());
                    funcion.setValorBase(funcionActualizada.getValorBase());

                    estaActualizada = true;
                    break;
                }
            }
        }
        return estaActualizada;
    }

    // Registrar venta
    public boolean registrarVenta(String codigoFuncion, Venta venta) {
        boolean registrada = false;
        Funcion funcion = consultarFuncion(codigoFuncion);
        if (funcion == null) {
            throw new FuncionNoEncontradaException(
                    "No existe una función con ese código"
            );
        } else {
            registrada = funcion.agregarVenta(venta);
        }
        return registrada;
    }
}
