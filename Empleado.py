from Persona import Persona

class Empleado(Persona):
    def __init__(self, nombre, cURP, fechaNacimiento, salario, rFC):
        super().__init__(nombre, cURP, fechaNacimiento)
        self.salario = salario
        self.RFC = rFC