from random import shuffle

class Card:

    def __init__(self, value, suit):
        self.value = value
        self.suit = suit

    def __repr__(self):
        return f"{self.value} of {self.suit}"


class Deck:
    
    #dunder method/ constructor
    def __init__(self):
        suits = ["Hearts", "Diamonds", "Clubs", "Spades"]
        values = ['A','2','3','4','5','6','7','8','9','10','J','Q','K']
        self.cards = [Card(value, suit) for suit in suits for value in values]

    #dunder method/ tostring
    def __repr__(self):
        return f"Deck of {self.count()} cards"
    
    def __iter__(self):
        return iter(self.cards)

    def reset(self):
        suits = ['Hearts', 'Diamonds', 'Clubs', 'Spades']
        values = ['A', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K']
        self.cards = [Card(suit, value) for suit in suits for value in values]
        return self

    def count(self):
        return len(self.cards)
    
    #private method
    def _deal(self, num):
        count = self.count()
        actNum = min([count, num])
        if count == 0:
            raise ValueError ( "All cards have been dealt" )
        cards = self.cards[-actNum:]
        self.cards = self.cards[:-actNum]
        return cards

    def dealCard(self):
        return self._deal(1)[0]
    
    def dealHand(self, handSize):
        return self._deal(handSize)

    def shuffle(self):
        if self.count() < 52:
            raise ValueError("deck is not full")
        shuffle(self.cards)
        return self

d = Deck()
d.shuffle()

for card in d:
    print(card)

#card = d.dealCard()
#print(card)
#hand = d.dealHand(50)
#card2 = d.dealCard()
#print(card2)
#print(d.cards)

