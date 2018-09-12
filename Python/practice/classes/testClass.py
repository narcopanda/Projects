
class User:
    def __init__(self, first, last, age):
        self.first = first
        self.last = last
        self.age = age

user1 = User("Joe", "smith", 60)
print(user1.first, user1.last, user1.age)
user2 = User("abe", "linn", 40)
print(user2.first, user2.last, user2.age)
