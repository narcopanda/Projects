import pyfiglet
from termcolor import colored

msg = input("give a input ")
color = input("what color ")

asscii = pyfiglet.figlet_format(msg)
colorAsscii = colored(asscii, color=color)

print(asscii)
print(colorAsscii)
