import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Aplicacion {
    static void main() {
        Scanner sc= new Scanner(System.in);

        Cinema cinema= new Cinema("CinemaUQ", "nit123", "Armenia");
        Reporte reporte = new Reporte(cinema);

        int opcion;

        do {
            System.out.println("\n======CINEMAUQ======");
            System.out.println("1. Agregar Película.");
            System.out.println("2. Consultar Película.");
            System.out.println("3. Actualizar Película.");
            System.out.println("4. Deshabilitar Película.");

            System.out.println("------------------------------------------------");
            System.out.println("5. Agregar Sala.");
            System.out.println("6. Consultar Sala.");
            System.out.println("7. Actualizar Sala.");
            System.out.println("8. Deshabilitar Sala.");
            System.out.println("9. Agregar Asiento a una Sala.");
            System.out.println("10. Consultar Asiento.");

            System.out.println("------------------------------------------------");
            System.out.println("11. Agregar Cliente.");
            System.out.println("12. Consultar Cliente.");
            System.out.println("13. Actualizar Cliente.");

            System.out.println("------------------------------------------------");
            System.out.println("14. Programar Función.");
            System.out.println("15. Consultar Función.");
            System.out.println("16. Actualizar Función.");
            System.out.println("17. Cambiar Estado de una Función.");
            System.out.println("18. Consultar Funciones por Fecha.");

            System.out.println("------------------------------------------------");
            System.out.println("19. Registrar Venta.");
            System.out.println("20. Agregar Entrada a una Venta.");
            System.out.println("21. Consultar Venta.");
            System.out.println("22. Cancelar Venta.");

            System.out.println("------------------------------------------------");
            System.out.println("23. Consultar Disponibilidad de Asientos.");

            System.out.println("------------------------------------------------");
            System.out.println("24. Total de Entradas Vendidas.");
            System.out.println("25. Total de Ingresos.");
            System.out.println("26. Película Más Vendida.");
            System.out.println("27. Ocupación de una Función.");

            System.out.println("------------------------------------------------");
            System.out.println("28. Salir.");

            System.out.println("Seleccione una opción: ");
            opcion= sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("\n----- Agregar Película -----");
                    System.out.println("Código: ");
                    String codigo = sc.nextLine();

                    System.out.println("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.println("Género: ");
                    String genero = sc.nextLine();

                    System.out.println("Duración en minutos: ");
                    int duracion = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Seleccione la clasificación:");
                    System.out.println("1. TODOS");
                    System.out.println("2. MAYORES_7");
                    System.out.println("3. MAYORES_12");
                    System.out.println("4. MAYORES_15");
                    System.out.println("5. MAYORES_18");

                    int opcionClasificacion = sc.nextInt();
                    sc.nextLine();
                    Clasificacion clasificacion = null;

                    switch (opcionClasificacion) {
                        case 1:
                            clasificacion = Clasificacion.TODOS;
                            break;
                        case 2:
                            clasificacion = Clasificacion.MAYORES_7;
                            break;
                        case 3:
                            clasificacion = Clasificacion.MAYORES_12;
                            break;
                        case 4:
                            clasificacion = Clasificacion.MAYORES_15;
                            break;
                        case 5:
                            clasificacion = Clasificacion.MAYORES_18;
                            break;
                        default:
                            System.out.println("Clasificación inválida.");
                            break;
                    }
                    if (clasificacion != null) {
                        Pelicula pelicula = new Pelicula(codigo, nombre, genero, duracion, clasificacion, EstadoPelicula.DISPONIBLE);

                        boolean resultado = cinema.agregarPelicula(pelicula);

                        if (resultado) {
                            System.out.println("Película agregada correctamente.");
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n----- Consultar Película -----");
                    System.out.println("Ingrese el código de la película: ");
                    String codigoConsulta = sc.nextLine();

                    Pelicula peliculaEncontrada = cinema.consultarPelicula(codigoConsulta);

                    if (peliculaEncontrada != null) {
                        System.out.println(peliculaEncontrada.toString());
                    } else {
                        System.out.println("No se encontró una película con ese código.");
                    }
                    break;

                case 3:
                    System.out.println("\n----- Actualizar Pelicula -----");
                    System.out.println("Código de la película que desea actualizar:");
                    String codigoActualizar = sc.nextLine();

                    Pelicula peliculaActual = cinema.consultarPelicula(codigoActualizar);

                    if (peliculaActual != null) {

                        System.out.println("Nuevo nombre: ");
                        String nuevoNombre = sc.nextLine();

                        System.out.println("Nuevo género: ");
                        String nuevoGenero = sc.nextLine();

                        System.out.println("Nueva duración: ");
                        int nuevaDuracion = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Seleccione la nueva clasificación: ");
                        System.out.println("1. TODOS");
                        System.out.println("2. MAYORES_7");
                        System.out.println("3. MAYORES_12");
                        System.out.println("4. MAYORES_15");
                        System.out.println("5. MAYORES_18");

                        int opcionClasificacion2 = sc.nextInt();
                        sc.nextLine();

                        Clasificacion nuevaClasificacion = null;

                        switch (opcionClasificacion2) {
                            case 1:
                                nuevaClasificacion = Clasificacion.TODOS;
                                break;
                            case 2:
                                nuevaClasificacion = Clasificacion.MAYORES_7;
                                break;
                            case 3:
                                nuevaClasificacion = Clasificacion.MAYORES_12;
                                break;
                            case 4:
                                nuevaClasificacion = Clasificacion.MAYORES_15;
                                break;
                            case 5:
                                nuevaClasificacion = Clasificacion.MAYORES_18;
                                break;
                            default:
                                System.out.println("Clasificación inválida.");
                                break;
                        }
                        if (nuevaClasificacion != null) {

                            Pelicula peliculaActualizada = new Pelicula(codigoActualizar, nuevoNombre, nuevoGenero, nuevaDuracion, nuevaClasificacion, peliculaActual.getEstadoPelicula());

                            boolean resultado = cinema.actualizarPelicula(codigoActualizar, peliculaActualizada);

                            if (resultado) {
                                System.out.println("Película actualizada correctamente.");
                            }
                        }
                    } else {
                        System.out.println("No se encontró una película con ese código.");
                    }
                    break;

                case 4:
                    System.out.println("\n----- Deshabilitar Película -----");
                    System.out.println("Código de la película que desea deshabilitar: ");
                    String codigoDeshabilitar = sc.nextLine();

                    boolean deshabilitada = cinema.deshabilitarPelicula(codigoDeshabilitar);

                    if (deshabilitada == true) {
                        System.out.println("Película deshabilitada correctamente.");
                    } else {
                        System.out.println("No se encontró una película con ese código.");
                    }
                    break;

                case 5:
                    System.out.println("\n----- Agregar Sala -----");
                    System.out.println("Código: ");
                    String codigoSala = sc.nextLine();

                    System.out.println("Número de Sala: ");
                    int numeroSala = sc.nextInt();

                    System.out.println("Capacidad de Sala:");
                    int capacidadSala = sc.nextInt();
                    sc.nextLine();

                    Sala sala = new Sala(codigoSala, numeroSala, capacidadSala, EstadoSala.DISPONIBLE);

                    boolean resultadoSala = cinema.agregarSala(sala);

                    if (resultadoSala == true) {
                        System.out.println("Sala agregada correctamente.");
                    }
                    break;

                case 6:
                    System.out.println("\n----- Consultar Sala -----");
                    System.out.println("Código de la sala que desea consultar: ");
                    String codigoConsultaSala = sc.nextLine();

                    Sala salaEncontrada = cinema.consultarSala(codigoConsultaSala);

                    if (salaEncontrada != null) {
                        System.out.println(salaEncontrada.toString());
                    } else {
                        System.out.println("No se encontró una sala con ese código.");
                    }
                    break;

                case 7:
                    System.out.println("\n----- Actualizar Sala -----");
                    System.out.println("Código de la sala que desea actualizar: ");
                    String codigoActualizarSala = sc.nextLine();

                    Sala salaActual = cinema.consultarSala(codigoActualizarSala);

                    if (salaActual != null) {
                        System.out.println("Nuevo número de sala: ");
                        int nuevoNumeroSala = sc.nextInt();

                        System.out.println("Nueva capacidad de sala: ");
                        int nuevaCapacidadSala = sc.nextInt();
                        sc.nextLine();

                        Sala salaActualizada = new Sala(codigoActualizarSala, nuevoNumeroSala, nuevaCapacidadSala, salaActual.getEstadoSala());

                        boolean resultadoSala1 = cinema.actualizarSala(codigoActualizarSala, salaActualizada);

                        if (resultadoSala1 == true) {
                            System.out.println("Sala actualizada correctamente.");
                        }
                    } else {
                        System.out.println("No se encontró una sala con ese código.");
                    }
                    break;

                case 8:
                    System.out.println("\n----- Deshabilitar Sala -----");
                    System.out.println("Código de la sala que desea deshabilitar: ");
                    String codigoDeshabilitarSala = sc.nextLine();

                    boolean salaDeshabilitada = cinema.deshabilitarSala(codigoDeshabilitarSala);

                    if (salaDeshabilitada == true) {
                        System.out.println("Sala deshabilitada correctamente.");
                    } else {
                        System.out.println("No se encontró una sala con ese código.");
                    }
                    break;

                case 9:
                    System.out.println("\n----- Agregar Asiento a una Sala -----");
                    System.out.println("Código de la sala donde desea agregar el asiento: ");
                    String codigoSalaAsiento = sc.nextLine();

                    Sala salaAsiento = cinema.consultarSala(codigoSalaAsiento);

                    if (salaAsiento != null) {
                        System.out.println("Código del asiento: ");
                        String codigoAsiento = sc.nextLine();

                        System.out.println("Fila del asiento: ");
                        String filaAsiento = sc.nextLine();

                        System.out.println("Número del asiento: ");
                        int numeroAsiento = sc.nextInt();
                        sc.nextLine();

                        Asiento asiento = new Asiento(codigoAsiento, filaAsiento, numeroAsiento, EstadoAsiento.DISPONIBLE);

                        boolean asientoAgregado = salaAsiento.agregarAsiento(asiento);

                        if (asientoAgregado == true) {
                            System.out.println("Asiento agregado correctamente.");
                        } else {
                            System.out.println("No se pudo agregar el asiento. Verifique que no esté repetido.");
                        }

                    } else {
                        System.out.println("No se encontró una sala con ese código.");
                    }
                    break;

                case 10:
                    System.out.println("\n----- Consultar Asiento -----");
                    System.out.println("Código de la sala: ");
                    String codigoSalaConsultaAsiento = sc.nextLine();

                    Sala salaConsultaAsiento = cinema.consultarSala(codigoSalaConsultaAsiento);

                    if (salaConsultaAsiento != null) {
                        System.out.println("Código del asiento que desea consultar: ");
                        String codigoAsientoConsulta = sc.nextLine();

                        Asiento asientoEncontrado = salaConsultaAsiento.consultarAsiento(codigoAsientoConsulta);

                        if (asientoEncontrado != null) {
                            System.out.println(asientoEncontrado.toString());
                        } else {
                            System.out.println("No se encontró un asiento con ese código.");
                        }
                    } else {
                        System.out.println("No se encontró una sala con ese código.");
                    }
                    break;

                case 11:
                    System.out.println("\n----- Agregar Cliente -----");
                    System.out.println("Identificación del cliente: ");
                    String identificacionCliente = sc.nextLine();

                    System.out.println("Nombre: ");
                    String nombreCliente = sc.nextLine();

                    System.out.println("Seleccione el tipo de cliente:");
                    System.out.println("1. GENERAL");
                    System.out.println("2. ESTUDIANTE");
                    System.out.println("3. NIÑO");
                    System.out.println("4. ADULTO MAYOR");

                    int opcionTipoCliente = sc.nextInt();
                    sc.nextLine();

                    TipoCliente tipoCliente = null;

                    switch (opcionTipoCliente) {
                        case 1:
                            tipoCliente = TipoCliente.GENERAL;
                            break;
                        case 2:
                            tipoCliente = TipoCliente.ESTUDIANTE;
                            break;
                        case 3:
                            tipoCliente = TipoCliente.NIÑO;
                            break;
                        case 4:
                            tipoCliente = TipoCliente.ADU_MAYOR;
                            break;
                        default:
                            System.out.println("Tipo de cliente inválido.");
                            break;
                    }

                    if (tipoCliente != null) {
                        Cliente cliente = new Cliente(identificacionCliente, nombreCliente, tipoCliente);

                        boolean clienteAgregado = cinema.agregarCliente(cliente);

                        if (clienteAgregado == true) {
                            System.out.println("Cliente agregado correctamente.");
                        } else {
                            System.out.println("Ya existe un cliente con esa identificación.");
                        }
                    }
                    break;

                case 12:
                    System.out.println("\n----- Consultar Cliente -----");
                    System.out.println("Identificación del cliente que desea consultar: ");
                    String identificacionConsulta = sc.nextLine();

                    Cliente clienteEncontrado = cinema.consultarCliente(identificacionConsulta);

                    if (clienteEncontrado != null) {
                        System.out.println(clienteEncontrado.toString());
                    } else {
                        System.out.println("No se encontró un cliente con esa identificación.");
                    }
                    break;

                case 13:
                    System.out.println("\n----- Actualizar Cliente -----");
                    System.out.println("Identificación del cliente que desea actualizar: ");
                    String identificacionActualizar = sc.nextLine();

                    Cliente clienteActual = cinema.consultarCliente(identificacionActualizar);

                    if (clienteActual != null) {
                        System.out.println("Nuevo nombre: ");
                        String nuevoNombreCliente = sc.nextLine();

                        System.out.println("Seleccione el nuevo tipo de cliente:");
                        System.out.println("1. GENERAL");
                        System.out.println("2. ESTUDIANTE");
                        System.out.println("3. NIÑO");
                        System.out.println("4. ADULTO MAYOR");

                        int opcionNuevoTipo = sc.nextInt();
                        sc.nextLine();

                        TipoCliente nuevoTipoCliente = null;

                        switch (opcionNuevoTipo) {
                            case 1:
                                nuevoTipoCliente = TipoCliente.GENERAL;
                                break;
                            case 2:
                                nuevoTipoCliente = TipoCliente.ESTUDIANTE;
                                break;
                            case 3:
                                nuevoTipoCliente = TipoCliente.NIÑO;
                                break;
                            case 4:
                                nuevoTipoCliente = TipoCliente.ADU_MAYOR;
                                break;
                            default:
                                System.out.println("Tipo de cliente inválido.");
                                break;
                        }

                        if (nuevoTipoCliente != null) {
                            Cliente clienteActualizado = new Cliente(
                                    identificacionActualizar,
                                    nuevoNombreCliente,
                                    nuevoTipoCliente
                            );

                            boolean clienteActualizadoCorrectamente =
                                    cinema.actualizarCliente(identificacionActualizar, clienteActualizado);

                            if (clienteActualizadoCorrectamente == true) {
                                System.out.println("Cliente actualizado correctamente.");
                            }
                        }
                    } else {
                        System.out.println("No se encontró un cliente con esa identificación.");
                    }
                    break;

                case 14:
                    System.out.println("\n----- Programar Función -----");
                    System.out.println("Código de la función: ");
                    String codigoFuncion = sc.nextLine();

                    System.out.println("Código de la película: ");
                    String codigoPeliculaFuncion = sc.nextLine();

                    Pelicula peliculaFuncion = cinema.consultarPelicula(codigoPeliculaFuncion);

                    System.out.println("Código de la sala: ");
                    String codigoSalaFuncion = sc.nextLine();

                    Sala salaFuncion = cinema.consultarSala(codigoSalaFuncion);

                    if (peliculaFuncion != null && salaFuncion != null) {

                        System.out.println("Fecha de la función (AAAA-MM-DD): ");
                        LocalDate fechaFuncion = LocalDate.parse(sc.nextLine());

                        System.out.println("Hora de la función (HH:MM): ");
                        LocalTime horaFuncion = LocalTime.parse(sc.nextLine());

                        System.out.println("Valor Base de la función: ");
                        double valorBaseFuncion = sc.nextDouble();
                        sc.nextLine();

                        Funcion funcion = new Funcion(codigoFuncion, peliculaFuncion, salaFuncion, fechaFuncion, horaFuncion, valorBaseFuncion, EstadoFuncion.PROGRAMADA);

                        boolean funcionAgregada = cinema.agregarFuncion(funcion);

                        if (funcionAgregada == true) {
                            System.out.println("Función programada correctamente.");
                        }
                    } else {
                        if (peliculaFuncion == null) {
                            System.out.println("No se encontró la película.");
                        }

                        if (salaFuncion == null) {
                            System.out.println("No se encontró la sala.");
                        }
                    }
                    break;

                case 15:
                    System.out.println("\n----- Consultar Función -----");
                    System.out.println("Código de la función que desea consultar:");
                    String codigoConsultaFuncion = sc.nextLine();

                    Funcion funcionEncontrada = cinema.consultarFuncion(codigoConsultaFuncion);

                    if (funcionEncontrada != null) {
                        System.out.println(funcionEncontrada.toString());
                    } else {
                        System.out.println("No se encontró una función con ese código.");
                    }
                    break;

                case 16:
                    System.out.println("\n----- Actualizar Función -----");
                    System.out.println("Código de la función que desea actualizar: ");
                    String codigoActualizarFuncion = sc.nextLine();

                    Funcion funcionActual = cinema.consultarFuncion(codigoActualizarFuncion);

                    if (funcionActual != null) {

                        System.out.println("Nuevo código de la película: ");
                        String nuevoCodigoPelicula = sc.nextLine();

                        Pelicula nuevaPelicula = cinema.consultarPelicula(nuevoCodigoPelicula);

                        System.out.println("Nuevo código de la sala: ");
                        String nuevoCodigoSala = sc.nextLine();

                        Sala nuevaSala = cinema.consultarSala(nuevoCodigoSala);

                        if (nuevaPelicula != null && nuevaSala != null) {

                            System.out.println("Ingrese la nueva fecha (AAAA-MM-DD): ");
                            LocalDate nuevaFecha = LocalDate.parse(sc.nextLine());

                            System.out.println("Ingrese la nueva hora (HH:MM): ");
                            LocalTime nuevaHora = LocalTime.parse(sc.nextLine());

                            System.out.println("Ingrese el nuevo valor base: ");
                            double nuevoValorBase = sc.nextDouble();
                            sc.nextLine();

                            Funcion funcionActualizada = new Funcion(codigoActualizarFuncion, nuevaPelicula, nuevaSala, nuevaFecha, nuevaHora, nuevoValorBase, funcionActual.getEstadoFuncion());

                            boolean funcionActualizadaCorrectamente = cinema.actualizarFuncion(codigoActualizarFuncion, funcionActualizada);

                            if (funcionActualizadaCorrectamente == true) {
                                System.out.println("Función actualizada correctamente.");
                            } else {
                                System.out.println("No se pudo actualizar. Verifique que la nueva sala esté disponible.");
                            }

                        } else {
                            if (nuevaPelicula == null) {
                                System.out.println("No se encontró la película.");
                            }

                            if (nuevaSala == null) {
                                System.out.println("No se encontró la sala.");
                            }
                        }
                    } else {
                        System.out.println("No se encontró una función con ese código.");
                    }
                    break;

                case 17:
                    System.out.println("\n----- Cambiar Estado de una Función -----");
                    System.out.println("Código de la función: ");
                    String codigoCambiarEstado = sc.nextLine();

                    Funcion funcionCambiarEstado = cinema.consultarFuncion(codigoCambiarEstado);

                    if (funcionCambiarEstado != null) {
                        System.out.println("Seleccione el nuevo estado de la función: ");
                        System.out.println("1. PROGRAMADA");
                        System.out.println("2. FINALIZADA");
                        System.out.println("3. CANCELADA");

                        int opcionEstadoFuncion = sc.nextInt();
                        sc.nextLine();

                        EstadoFuncion nuevoEstadoFuncion = null;

                        switch (opcionEstadoFuncion) {
                            case 1:
                                nuevoEstadoFuncion = EstadoFuncion.PROGRAMADA;
                                break;
                            case 2:
                                nuevoEstadoFuncion = EstadoFuncion.FINALIZADA;
                                break;
                            case 3:
                                nuevoEstadoFuncion = EstadoFuncion.CANCELADA;
                                break;
                            default:
                                System.out.println("Opción de estado inválida.");
                                break;
                        }

                        if (nuevoEstadoFuncion != null) {
                            funcionCambiarEstado.setEstadoFuncion(nuevoEstadoFuncion);
                            System.out.println("Estado de la función actualizado correctamente.");
                        }
                    } else {
                        System.out.println("No se encontró una función con ese código.");
                    }
                    break;

                case 18:
                    System.out.println("\n----- Consultar Funciones por Fecha -----");
                    System.out.println("Fecha que desea consultar (AAAA-MM-DD): ");
                    LocalDate fechaConsulta = LocalDate.parse(sc.nextLine());

                    boolean funcionesEncontradas = false;

                    for (Funcion funcion : cinema.getListFunciones()) {
                        if (funcion.getFecha().equals(fechaConsulta)) {
                            System.out.println(funcion.toString());
                            funcionesEncontradas = true;
                        }
                    }
                    if (funcionesEncontradas == false) {
                        System.out.println("No hay funciones programadas para esa fecha.");
                    }
                    break;

                case 19:
                    System.out.println("\n----- Regirtrar Venta -----");
                    System.out.println("Código de la venta: ");
                    String codigoVenta = sc.nextLine();

                    System.out.println("Identificación del cliente: ");
                    String identificacionVenta = sc.nextLine();

                    Cliente clienteVenta = cinema.consultarCliente(identificacionVenta);

                    System.out.println("Código de la función: ");
                    String codigoFuncionVenta = sc.nextLine();

                    Funcion funcionVenta = cinema.consultarFuncion(codigoFuncionVenta);

                    if (clienteVenta != null && funcionVenta != null) {

                        System.out.println("Fecha de la venta (AAAA-MM-DD): ");
                        LocalDate fechaVenta = LocalDate.parse(sc.nextLine());

                        System.out.println("Hora de la venta (HH:MM): ");
                        LocalTime horaVenta = LocalTime.parse(sc.nextLine());

                        Venta venta = new Venta(codigoVenta, clienteVenta, funcionVenta, fechaVenta, horaVenta, 0, null, EstadoVenta.ACTIVA);

                        boolean ventaRegistrada = cinema.registrarVenta(codigoFuncionVenta, venta);

                        if (ventaRegistrada == true) {
                            System.out.println("Venta registrada correctamente.");
                        } else {
                            System.out.println("No se pudo registrar la venta.");
                        }
                    } else {
                        if (clienteVenta == null) {
                            System.out.println("No se encontró el cliente.");
                        }
                        if (funcionVenta == null) {
                            System.out.println("No se encontró la función.");
                        }
                    }
                    break;

                case 20:
                    System.out.println("\n----- Agregar Entrada a una Venta -----");
                    System.out.println("Código de la venta: ");
                    String codigoVentaDetalle = sc.nextLine();

                    Venta ventaDetalle = null;

                    for (Funcion funcion : cinema.getListFunciones()) {
                        for (Venta venta : funcion.getListVentas()) {
                            if (venta.getCodigo().equals(codigoVentaDetalle)) {
                                ventaDetalle = venta;
                                break;
                            }
                        }

                        if (ventaDetalle != null) {
                            break;
                        }
                    }

                    if (ventaDetalle == null) {
                        System.out.println("No existe una venta con ese código.");
                    } else {
                        if (ventaDetalle.getEstadoVenta() == EstadoVenta.CANCELADA) {
                            System.out.println("No se pueden agregar entradas a una venta cancelada.");
                        } else {
                            Sala salaDetalle = ventaDetalle.getFuncion().getSala();

                            System.out.println("Código del asiento: ");
                            String codigoAsientoDetalle = sc.nextLine();

                            Asiento asientoDetalle = salaDetalle.consultarAsiento(codigoAsientoDetalle);

                            if (asientoDetalle == null) {
                                System.out.println("No existe ese asiento en la sala de la función.");
                            } else {
                                Tarifa tarifa = null;

                                switch (ventaDetalle.getCliente().getTipoCliente()) {
                                    case GENERAL:
                                        tarifa = new TarifaGeneral();
                                        break;

                                    case ESTUDIANTE:
                                        tarifa = new TarifaEstu();
                                        break;

                                    case NIÑO:
                                        tarifa = new TarifaNino();
                                        break;

                                    case ADU_MAYOR:
                                        tarifa = new TarifaAduMayor();
                                        break;
                                }

                                if (tarifa != null) {
                                    double valorEntrada = ventaDetalle.getFuncion().getValorBase();
                                    double valorPagado = tarifa.calcularValor(valorEntrada);

                                    DetalleVenta detalleVenta = new DetalleVenta(asientoDetalle, tarifa, valorPagado);

                                    try {
                                        boolean detalleAgregado = ventaDetalle.agregarDetalle(detalleVenta);

                                        if (detalleAgregado == true) {
                                            System.out.println("Entrada agregada correctamente.");
                                            System.out.println("Valor de la entrada: " + valorPagado);
                                            System.out.println("Total de la venta: " + ventaDetalle.getValorTotal());
                                        } else {
                                            System.out.println("No se pudo agregar la entrada.");
                                        }

                                    } catch (AsientoOcupadoException e) {
                                        System.out.println(e.getMessage());

                                    } catch (SinAsientosDisponiblesException e) {
                                        System.out.println(e.getMessage());
                                    }

                                } else {
                                    System.out.println("No se pudo identificar la tarifa del cliente.");
                                }
                            }
                        }
                    }
                    break;

                case 21:
                    System.out.println("\n----- Consultar Venta -----");
                    System.out.println("Código de la venta: ");
                    String codigoConsultaVenta = sc.nextLine();

                    Venta ventaEncontrada = null;

                    for (Funcion funcion : cinema.getListFunciones()) {
                        for (Venta venta : funcion.getListVentas()) {
                            if (venta.getCodigo().equals(codigoConsultaVenta)) {
                                ventaEncontrada = venta;
                                break;
                            }
                        }

                        if (ventaEncontrada != null) {
                            break;
                        }
                    }

                    if (ventaEncontrada != null) {
                        System.out.println(ventaEncontrada.toString());

                        System.out.println("Entradas de la venta:");
                        for (DetalleVenta detalle : ventaEncontrada.getListDetalleVentas()) {
                            System.out.println(detalle.toString());
                        }

                    } else {
                        System.out.println("No se encontró una venta con ese código.");
                    }
                    break;

                case 22:
                    System.out.println("\n----- Cancelar Venta -----");
                    System.out.println("Código de la venta que desea cancelar: ");
                    String codigoCancelarVenta = sc.nextLine();

                    Venta ventaCancelar = null;

                    for (Funcion funcion : cinema.getListFunciones()) {
                        for (Venta venta : funcion.getListVentas()) {
                            if (venta.getCodigo().equals(codigoCancelarVenta)) {
                                ventaCancelar = venta;
                                break;
                            }
                        }

                        if (ventaCancelar != null) {
                            break;
                        }
                    }

                    if (ventaCancelar != null) {

                        if (ventaCancelar.getEstadoVenta() == EstadoVenta.ACTIVA) {

                            for (DetalleVenta detalle : ventaCancelar.getListDetalleVentas()) {
                                detalle.getAsiento().setEstadoAsiento(EstadoAsiento.DISPONIBLE);
                            }

                            ventaCancelar.setEstadoVenta(EstadoVenta.CANCELADA);
                            ventaCancelar.setValorTotal(0.0);

                            System.out.println("Venta cancelada correctamente.");
                            System.out.println("Los asientos quedaron disponibles nuevamente.");

                        } else {
                            System.out.println("Esta venta ya se encuentra cancelada.");
                        }

                    } else {
                        System.out.println("No se encontró una venta con ese código.");
                    }
                    break;

                case 23:
                    System.out.println("\n----- Consultar Disponibilidad de Asientos -----");
                    System.out.println("Código de la función:");
                    String codigoFuncionDisponibilidad = sc.nextLine();

                    Funcion funcionDisponibilidad = cinema.consultarFuncion(codigoFuncionDisponibilidad);

                    if (funcionDisponibilidad == null) {
                        System.out.println("No existe una función con ese código.");
                    } else {
                        System.out.println("Película: " + funcionDisponibilidad.getPelicula().getNombre());
                        System.out.println("Sala: " + funcionDisponibilidad.getSala().getNumero());
                        System.out.println("Fecha: " + funcionDisponibilidad.getFecha());
                        System.out.println("Hora: " + funcionDisponibilidad.getHora());

                        System.out.println(reporte.mostrarCupoFuncion(funcionDisponibilidad));
                    }
                    break;

                case 24:
                    System.out.println("\n----- Total de Entradas Vendidas -----");
                    int totalEntradas = reporte.generarEntradasVendidas();

                    System.out.println("El total de entradas vendidas es: " + totalEntradas);
                    break;

                case 25:
                    System.out.println("\n----- Total de Ingresos -----");
                    double totalIngresos = reporte.calcularTotalIngresos();

                    System.out.println("El total de ingresos es: $" + totalIngresos);
                    break;

                case 26:
                    System.out.println("\n----- Película más Vendida -----");
                    String peliculaMasVendida = reporte.mostrarPeliMasVendida();

                    if (peliculaMasVendida.equals("")) {
                        System.out.println("Todavía no hay entradas vendidas.");
                    } else {
                        System.out.println("La película más vendida es: " + peliculaMasVendida);
                    }
                    break;

                case 27:
                    System.out.println("\n----- Ocupación de una Función -----");
                    System.out.println("Ingrese la fecha (AAAA-MM-DD):");
                    LocalDate fechaConsulta2 = LocalDate.parse(sc.nextLine());

                    List<Funcion> funcionesFecha = reporte.mostrarFunPorFecha(fechaConsulta2);

                    if (funcionesFecha.isEmpty()) {
                        System.out.println("No hay funciones programadas para esa fecha.");
                    } else {
                        System.out.println("Funciones programadas para " + fechaConsulta2 + ":");

                        for (Funcion funcion : funcionesFecha) {
                            System.out.println("------------------------------");
                            System.out.println(funcion);
                        }
                    }
                    break;

                case 28:
                    System.out.println("Adiós....");
                    break;

                default:
                    System.out.println("Opción no válida.... Intente de nuevo.");
            }

        } while (opcion!= 0);
    }
}
