from user import User


class Employee(User):
    ROLES = ["Veterinarian", "Guide", "Maintenance", "Administration"]

    def __init__(self, name, last_name, birth_date, hire_date, rfc, curp, salary, end_time, entry_time, role):
        super().__init__(name, last_name, birth_date, curp)
        self.hire_date = hire_date
        self.rfc = rfc
        self.salary = salary
        self.end_time = end_time
        self.entry_time = entry_time
        self.role = role

    def validate_role(self):
        return self.role in self.ROLES

    def get_hire_date(self):
        return self.hire_date

    def set_hire_date(self, hire_date):
        self.hire_date = hire_date

    def get_rfc(self):
        return self.rfc

    def set_rfc(self, rfc):
        self.rfc = rfc

    def get_salary(self):
        return self.salary

    def set_salary(self, salary):
        self.salary = salary

    def get_end_time(self):
        return self.end_time

    def set_end_time(self, end_time):
        self.end_time = end_time

    def get_entry_time(self):
        return self.entry_time

    def set_entry_time(self, entry_time):
        self.entry_time = entry_time

    def get_role(self):
        return self.role

    def set_role(self, value):
        self.role = value

    def get_info(self):
        print(" * Name:", self.name, self.last_name)
        print(" * Birth Date:", self.birth_date)
        print(" * CURP:", self.curp)
        print(" * RFC:", self.rfc)
        print(" * Salary:", self.salary)
        print(" * Schedule:")
        print("     * Start time:", self.entry_time)
        print("     * End time:", self.end_time)
        print(" * Hire date:", self.hire_date)
        print(" * Role:", self.role)
