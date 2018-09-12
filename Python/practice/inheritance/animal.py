class Animal:
    cool = True

    def makeSound(self, sound):
        print(f"this animal says {sound}")

class Cat(Animal):
    pass

blue = Cat()
blue.makeSound("MEOW")
print(blue.cool)
print(blue.makeSound)
