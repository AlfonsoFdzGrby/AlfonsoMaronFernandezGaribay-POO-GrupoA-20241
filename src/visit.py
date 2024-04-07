class Visit:
    next_id = 0

    def __init__(self, guide_name, guide_last_name, visitors, visit_date, num_children=0, num_adults=0, total_cost=0.0):
        self.id = Visit.next_id
        Visit.next_id += 1
        self.guide_name = guide_name
        self.guide_last_name = guide_last_name
        self.visitors = visitors
        self.num_children = num_children
        self.num_adults = num_adults
        self.visit_date = visit_date
        self.total_cost = total_cost

    def get_id(self):
        return self.id

    def get_guide_name(self):
        return self.guide_name

    def get_guide_last_name(self):
        return self.guide_last_name

    def get_visitors(self):
        return self.visitors

    def set_visitors(self, visitors):
        self.visitors = visitors

    def get_total_cost(self):
        return self.total_cost

    def set_total_cost(self, total_cost):
        self.total_cost = total_cost

    def get_visit_date(self):
        return self.visit_date

    def set_visit_date(self, visit_date):
        self.visit_date = visit_date

    def get_num_children(self):
        return self.num_children

    def set_num_children(self, num_children):
        self.num_children = num_children

    def get_num_adults(self):
        return self.num_adults

    def set_num_adults(self, num_adults):
        self.num_adults = num_adults

    def calculate_total_visits(self):
        for visitor in self.visitors:
            visitor.increase_visits()  # Increment the visit count here

    def calculate_total_cost(self):
        self.num_children = 0
        self.num_adults = 0
        self.total_cost = 0.0

        for visitor in self.visitors:
            age = (self.visit_date - visitor.birth_date).days // 365
            ticket_price = 50 if age < 18 else 100

            if visitor.num_visits % 5 == 0:
                ticket_price *= 0.8  # Apply 20% discount

            self.total_cost += ticket_price

            if age < 18:
                self.num_children += 1
            else:
                self.num_adults += 1

    def get_visit_info(self):
        print(f"   * ID: {self.id}")
        print(f"   * Guide in charge: {self.guide_name} {self.guide_last_name}")
        print(f"   * Visit Date: {self.visit_date.strftime('%d/%m/%Y')}")
        print("   * Visitors:")
        for visitor in self.visitors:
            age = (self.visit_date - visitor.birth_date).days // 365
            print(f"      - {visitor.get_full_name()}, Age: {age}")
        print("   * Tickets:")
        print("     * Children ($50 MXN):")
        print("       * Number of children:", self.num_children)
        print("     * Adults ($100 MXN):")
        print("       * Number of adults:", self.num_adults)
        print(f"   * Total Cost: ${self.total_cost}")
