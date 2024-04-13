class Persona:
    def __init__(self, nombre, cURP, fechaNacimiento):
        self.nombre = nombre
        self.CURP = cURP
        self.fechaNacimiento = fechaNacimiento

    def getNombre(self):
        return self.nombre