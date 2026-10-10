/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_algoritmos;

import java.util.Scanner;

/**
 *
 * @author migue
 */
public class proyecto {
     public static void VentasYfacturas() {

        Scanner teclado = new Scanner(System.in);

        int opcion;
        int CantidadProductos;
        //variables de caja
        int ventasRealizadas = 0;
        int productosVendidos = 0;
        double totalVendido = 0;
        int ventasEfectivo = 0;
        int ventasTarjeta = 0;
        int ventasTransferencia = 0;
        //variables de estadisticas
        double ventaMayor = 0;
        double ventaMenor = 0;

        do {

            System.out.println("\n====================================");
            System.out.println("     SISTEMA DE VENTAS Y FACTURACION");
            System.out.println("====================================");
            System.out.println("1. Registrar una venta");
            System.out.println("------------------------------------");
            System.out.println("2. Consultar caja");
            System.out.println("------------------------------------");
            System.out.println("3. Mostrar estadisticas");
            System.out.println("------------------------------------");
            System.out.println("4. Salir");
            System.out.println("====================================");
            System.out.print("Seleccione una opcion: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("==============================");
                    System.out.println("        REGISTRAR VENTAS");
                    System.out.println("==============================");
                    //validar el numero de productos
                    do{
                    System.out.println("cuantos productos tiene su venta?");
                    CantidadProductos = teclado.nextInt();
                    if(CantidadProductos <= 0){
                       System.out.println("==========================ERROR========================");
                        System.out.println("la cantidad de productos tiene que ser mayor que cero");
                       System.out.println("==========================ERROR========================");
                    }
                    } while(CantidadProductos <= 0);
                    double subtotal = 0;
                   
                int CantidadTotalVendida = 0;
                for (int i = 1; i <= CantidadProductos; i++) {
                    System.out.println("producto "+ i);
                    System.out.println("codigo: ");
                    int codigo;
                    codigo = teclado.nextInt();
                    System.out.println("nombre: ");
                    String nombre;
                    nombre = teclado.next();
                //validar el precio
                    
                    double precio;
                    do{
                    System.out.println("precio: ");
                    precio = teclado.nextDouble();
                    if(precio <= 0){
                        System.out.println("==================ERROR==================");
                          System.out.println("el precio tiene que ser mayor que cero");
                        System.out.println("==================ERROR==================");
                    }
                    }while (precio <= 0);
                    //cantidad
                    int cantidad;
                    do{
                        System.out.println("cantidad: ");
                        cantidad = teclado.nextInt();
                        if (cantidad <= 0) {
                            System.out.println("==================ERROR==================");
                            System.out.println("la cantidad tiene que ser mayor que cero");
                            System.out.println("==================ERROR==================");
                        }   
                    }while(cantidad <= 0);
                    //sumarcantidadvendidas
                    CantidadTotalVendida = CantidadTotalVendida + cantidad;
                    //calcular el subtotal de la venta
                    double SubtotalProducto = cantidad * precio;
                    subtotal = subtotal + SubtotalProducto;
                    //mostrar el valor de la venta
                    System.out.println("el subtotal del producto es: Q "+ SubtotalProducto);
                }
                    
                    
                    //calcular el descuento de la venta
                    double porcentajedescuento;
                    double descuento;
                    if(subtotal < 200){
                    porcentajedescuento = 0;
                    } 
                    else if(subtotal <500){
                    porcentajedescuento = 0.05;}
                    else if(subtotal < 1000){
                    porcentajedescuento =0.08;
                    }
                    else {
                        porcentajedescuento = 0.10;
                    }
                    descuento = subtotal * porcentajedescuento;
                    double MontoConDescuento = subtotal - descuento;
                    
                    //calcular el iva y el total de la venta
                    double iva = MontoConDescuento*0.12;
                    double total = MontoConDescuento + iva;
                    
                    //forma de pago
                    int formapago = 0;
                    while (formapago < 1 || formapago > 3) {
                    System.out.println("===============================");
                    System.out.println("   INGRESE SU FORMA DE PAGO");
                    System.out.println("===============================");
                    System.out.println("           1.efectivo");
                    System.out.println("--------------------------------");
                    System.out.println("           2.Tarjeta");
                    System.out.println("--------------------------------");
                    System.out.println("           3.Transeferncia");
                    System.out.println("--------------------------------");
                    System.out.println("           elija una opcion: ");
                    formapago = teclado.nextInt(); 
                    }
                    
                    
                    double efectivoRecibido = 0;
                    double cambio = 0;
                    
                    switch(formapago){
                        case 1: 
                            //validar efectivo alcanze
                            do{
                                System.out.println("efectivo recibido:  Q ");
                                efectivoRecibido = teclado.nextDouble();
                                if(efectivoRecibido < total){
                                System.out.println("==================ERROR=====================");
                                    System.out.println("      efectivo insuficiente");
                                    System.out.println("   debe de ingresar al menos Q"+ total);
                                System.out.println("==================ERROR====================");
                                }
                            }while(efectivoRecibido < total);
                            
                            cambio = efectivoRecibido - total;
                            
                            break;
                            
                        case 2:
                         System.out.println("===================================");
                            System.out.println("pago con tarjeta seleccionado");
                         System.out.println("===================================");
                            break;
                        
                        case 3:
                         System.out.println("=======================================");
                            System.out.println("pago por transeferncia seleccionado");
                         System.out.println("=======================================");
                            
                           break;
                        default:
                      System.out.println("=======================================");
                            System.out.println("forma de pago invalida");
                      System.out.println("=======================================");
                            
                    }
                    System.out.println("\n====================================");
                    System.out.println("          RESUMEN DE VENTA");
                    System.out.println("====================================");

                    System.out.println("cantidad de productos ingresados: "+ CantidadProductos);
                    System.out.println("-------------------------------------");
                    System.out.println("cantidad de productos vendidos: "+CantidadTotalVendida);
                    System.out.println("-------------------------------------");
                    System.out.println("subtotal: Q"+ subtotal);
                    System.out.println("-------------------------------------");
                    System.out.println("descuento: Q"+ descuento);
                    System.out.println("-------------------------------------");
                    System.out.println("IVA: Q"+ iva);
                    System.out.println("-------------------------------------");
                    System.out.println("total: Q"+ total);
                    System.out.println("-------------------------------------");
                    
                    if (formapago==1) {
                        System.out.println("forma de pago: efectivo");
                        System.out.println("efectivo recibido: Q"+efectivoRecibido);
                        System.out.println("cambio: Q"+ cambio);
                    }
                    else if(formapago==2){
                        System.out.println("forma de pago: tarjeta");
                    }
                    else if(formapago==3){
                        System.out.println("forma de pago: transferencia");
                    }
                    //estadisticas
                    if(ventasRealizadas == 0){
                    ventaMayor = total;
                    ventaMenor = total;
                    }
                    else if(total > ventaMayor){
                    
                    ventaMayor = total;
                    }
                    else if(total<ventaMenor){
                    ventaMenor = total;
                    }
                    //actualizacion de caja
                    ventasRealizadas = ventasRealizadas + 1;
                    productosVendidos = productosVendidos + CantidadTotalVendida;
                    totalVendido= totalVendido + total;
                    if(formapago==1){
                    ventasEfectivo = ventasEfectivo+1;
                    }
                    else if (formapago==2){
                    ventasTarjeta = ventasTarjeta+1;
                    }
                    else if(formapago==3){
                    ventasTransferencia = ventasTransferencia+1;
                    }
                    break;

                case 2:
                    System.out.println("====================================");
                    System.out.println("           CONSULTAR CAJA");
                    System.out.println("====================================");
                    
                    System.out.println("Ventas realizadas: " + ventasRealizadas);
                    System.out.println("------------------------------------");

                    System.out.println("Productos vendidos: " + productosVendidos);
                    System.out.println("------------------------------------");

                    System.out.println("Total vendido: Q" + totalVendido);
                    System.out.println("------------------------------------");

                    System.out.println("Ventas en efectivo: " + ventasEfectivo);
                    System.out.println("------------------------------------");

                    System.out.println("Ventas con tarjeta: " + ventasTarjeta);
                    System.out.println("------------------------------------");

                    System.out.println("Ventas por transferencia: " + ventasTransferencia);
                    System.out.println("------------------------------------");
                    break;

                case 3:
                    System.out.println("====================================");
                    System.out.println("          ESTADISTICAS");
                    System.out.println("====================================");
                    if(ventasRealizadas==0){
                        System.out.println("============================");
                        System.out.println("no existen ventas realizadas");
                        System.out.println("=============================");
                    }
                    else{
                        System.out.println("total de ventas: "+ ventasRealizadas);
                        System.out.println("unidades vendidas: "+productosVendidos);
                        System.out.println("Dinero vendido"+ totalVendido);
                        System.out.println("promedio de venta: "+(totalVendido / ventasRealizadas));
                        
                    
                    }
                    break;

                case 4:
                    System.out.println("\nSaliendo del sistema...");
                    break;

                default:
                    System.out.println("\nOpción inválida. Intente nuevamente.");
            }

        } while (opcion != 4);

       
    }
}



   
