import random

randNum = random.randint(1,10)

check = input()

while True:
    print("guess the num between 1 and 10")

    if int(check) == randNum:
        print("you win do you want to play again y/n")
        play = input()
        if play == "n":
            break
        else:
            randNum = random.randint(1,10)
    elif int(check) > randNum:
        print("to high")
        print("guess the num between 1 and 10")
        check = input()
    elif int(check) < randNum:
        print("to low")
        print("guess the num between 1 and 10")
        check = input()
