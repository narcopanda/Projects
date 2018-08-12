import json
from difflib import get_close_matches

data = json.load(open("data.json"))

def translate(word):
    word = word.lower()
    if word in data:
        return data[word]

    elif word.title() in data:
        return word.title() in data

    elif word.upper() in data:
        return data[word.upper()]

    elif len ( get_close_matches(word, data.keys())) > 0:
        yesOrNo = input( "Did you mean %s instead? Enter y if yes or n if no." %
    get_close_matches(word, data.keys())[0])
        
        if yesOrNo == "y":
            return data[get_close_matches(word, data.keys())[0]]
        elif yesOrNo == "n":
            return "The word does not exist."
        else:
            return "Invalid command"
        
    else:
        return "The word was not found please check spelling"

word = input("Enter word: ")


output = translate(word)

if type(output) == list:
    for item in output:
        print(item)
else:
    print(output)
