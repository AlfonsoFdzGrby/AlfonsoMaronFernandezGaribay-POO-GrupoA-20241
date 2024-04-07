class Animal:

    next_id = 0

    def __init__(self, animal_type, birth_date, arrival_date, weight, diseases=[], feeding_frequency="", feeding_type="", is_vaccinated=False):
        self.id = Animal.next_id
        Animal.next_id += 1
        self.animal_type = animal_type
        self.birth_date = birth_date
        self.arrival_date = arrival_date
        self.weight = weight
        self.diseases = diseases
        self.feeding_frequency = feeding_frequency
        self.feeding_type = feeding_type
        self.is_vaccinated = is_vaccinated

    def get_id(self):
        return self.id

    def get_animal_type(self):
        return self.animal_type

    def set_animal_type(self, animal_type):
        self.animal_type = animal_type

    def get_birth_date(self):
        return self.birth_date

    def set_birth_date(self, birth_date):
        self.birth_date = birth_date

    def get_arrival_date(self):
        return self.arrival_date

    def set_arrival_date(self, arrival_date):
        self.arrival_date = arrival_date

    def get_weight(self):
        return self.weight

    def set_weight(self, weight):
        self.weight = weight

    def get_diseases(self):
        return self.diseases

    def set_diseases(self, diseases):
        self.diseases = diseases

    def get_feeding_frequency(self):
        return self.feeding_frequency

    def set_feeding_frequency(self, feeding_frequency):
        self.feeding_frequency = feeding_frequency

    def get_feeding_type(self):
        return self.feeding_type

    def set_feeding_type(self, feeding_type):
        self.feeding_type = feeding_type

    def is_vaccinated(self):
        return self.is_vaccinated

    def set_vaccinated(self, vaccinated):
        self.is_vaccinated = vaccinated

    def set_vaccine_status(self, status):
        self.is_vaccinated = status

    def get_info(self):
        print(" * ID:", self.id)
        print(" * Animal:", self.animal_type)
        print(" * Birth Date:", self.birth_date.strftime('%d/%m/%Y'))
        print(" * Arrival Date:", self.arrival_date.strftime('%d/%m/%Y'))
        print(" * Weight:", self.weight)

        if self.diseases:
            # Clean up any spaces and capitalize
            cleaned_diseases = [disease.strip().capitalize() for disease in self.diseases]
            print(" * Diseases:")
            for disease in cleaned_diseases:  # Iterate over cleaned_diseases
                print("    *", disease)
        else:
            print(" * Diseases: ")

        print(" * Feeding Frequency:", self.feeding_frequency)
        print(" * Feeding Type:", self.feeding_type)
        print(" * Vaccinated:", "Yes" if self.is_vaccinated else "No")
