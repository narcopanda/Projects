import json

data = json.load(open("data.json"))

def translate(word):
    word = word.lower()
    if word in data:
        return data[word]
    else:
        return "The word was not found please check spelling"

word = input("Enter word: ")

print(translate(word))
