from datetime import datetime


class User:
    def __init__(self, name, last_name, birth_date, curp):
        self.name = name
        self.last_name = last_name
        self.birth_date = birth_date
        self.curp = curp

    def get_name(self):
        return self.name

    def set_name(self, name):
        self.name = name

    def get_last_name(self):
        return self.last_name

    def set_last_name(self, last_name):
        self.last_name = last_name

    def set_names(self, name, last_name):
        self.name = name
        self.last_name = last_name

    def get_birth_date(self):
        return self.birth_date

    def set_birth_date(self, birth_date):
        self.birth_date = birth_date

    def get_curp(self):
        return self.curp

    def set_curp(self, curp):
        self.curp = curp

    def get_full_name(self):
        return f"{self.name} {self.last_name}"

    def age(self):
        today = datetime.now()
        age = today.year - self.birth_date.year - (
                    (today.month, today.day) < (self.birth_date.month, self.birth_date.day))
        return age
