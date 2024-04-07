class Maintenance:

    next_id = 0

    def __init__(self, employee_in_charge, animal_id, process_performed, process_date, observations=""):
        self.id = Maintenance.next_id
        Maintenance.next_id += 1
        self.employee_in_charge = employee_in_charge
        self.animal_id = animal_id
        self.process_performed = process_performed
        self.process_date = process_date
        self.observations = observations

    def get_employee_in_charge(self):
        return self.employee_in_charge

    def set_employee_in_charge(self, employee_in_charge):
        self.employee_in_charge = employee_in_charge

    def get_employee_names(self):
        return self.employee_in_charge.get_full_name()

    def get_animal_id(self):
        return self.animal_id

    def set_animal(self, animal_id):
        self.animal_id = animal_id

    def get_id(self):
        return self.id

    def get_process_performed(self):
        return self.process_performed

    def set_process_performed(self, process_performed):
        self.process_performed = process_performed

    def get_process_date(self):
        return self.process_date

    def set_process_date(self, process_date):
        self.process_date = process_date

    def get_observations(self):
        return self.observations

    def set_observations(self, observations):
        self.observations = observations

    def print_observation_list(self):
        print("CURRENT OBSERVATIONS:")
        for i, observation in enumerate(self.observations, start=1):
            formatted_observation = observation.strip().capitalize()
            print(f"   * Observation #{i}: {formatted_observation}")
    
    def print_info(self):

        print("MAINTENANCE RECORD INFO:")
        print("   * Record ID:", self.id)
        print("   * Employee in charge:", self.get_employee_names())
        print("   * Animal treated ID:", self.animal_id)
        print("   * Process performed:", self.get_process_performed())
        print("   * Process date:", self.get_process_date())
        self.print_observation_list()
