from random import random

def flip():
    r = random()
    if r > 0.5:
        return "Heads"
    else:
        return "Taild"
print(flip())
