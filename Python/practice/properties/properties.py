class Human:
    def __init__(self, first, last, age):
        self._first = first
        self._last = last
        self._age = age

    @property
    def first(self):
        return self._first

    @first.setter
    def first(self, value):
        self._first = value

    @property
    def last(self):
        return self._last

    @last.setter
    def last(self, value):
        self._last = value

    @property
    def age(self):
        return self._age

    @age.setter
    def age(self, value):
        if value >= 0:
            self._age = value
        else:
            raise ValueError("age can't be neg")

jane = Human("jane", "smith", 30)
print(jane.first)
print(jane.age)
