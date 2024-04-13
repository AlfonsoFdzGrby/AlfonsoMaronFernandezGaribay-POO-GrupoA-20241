from Tienda import Tienda
from Cliente import Cliente
from Limpieza import Limpieza

import getpass

class Sistema:
    def __init__(self):
        self.contraseña = "Psw/8."
        self.tienda = Tienda()

    def ejecutarPrograma(self):
        self.printHeader("BIENVENIDO")
        while True:
            intento = input("Por favor ingrese la contraseña: ")
            if intento == self.contraseña:
                print("¡Contraseña correcta!")
                input("Presione enter para continuar...")
                self.ejecutarSistema()
                break
            else:
                print("Contraseña incorrecta")

    def ejecutarSistema(self):
        self.tienda.addCliente(Cliente("Jorge", "CURP", "25/03/03", 123456789))
        self.tienda.addProducto(Limpieza("Lysol", 1534, 15.32, "25/03/23", 15, "Lysol"))
        opc = 0

        while opc < 11:
            self.printHeader("SISTEMA")
            print("Seleccione una opción:")
            print("1. Registrar producto")
            print("2. Registrar cliente")
            print("3. Mostrar productos")
            print("4. Mostrar clientes")
            print("5. Eliminar producto")
            print("6. Eliminar cliente")
            print("7. Añadir a Stock")
            print("8. Eliminar del Stock")
            print("9. Realizar una compra")
            print("10. Ver compras")
            print("11. Salir")
            opc = int(input(">> "))

            if opc == 1:
                self.tienda.registrarProducto()
            elif opc == 2:
                self.tienda.registrarCliente()
            elif opc == 3:
                self.tienda.mostrarProductos()
            elif opc == 4:
                self.tienda.mostrarClientes()
            elif opc == 5:
                self.tienda.eliminarProducto()
            elif opc == 6:
                self.tienda.eliminarCliente()
            elif opc == 7:
                self.tienda.añadirStock()
            elif opc == 8:
                self.tienda.quitarStock()
            elif opc == 9:
                self.tienda.realizarCompra()
            elif opc == 10:
                self.tienda.verCompras()

    def printHeader(self, header):
        print("===================================================")
        print(header)
        print("===================================================")