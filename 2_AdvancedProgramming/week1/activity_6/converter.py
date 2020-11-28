# converter.py
import sys

def check_range(value, spec_range):
  if value < spec_range[0] or value > spec_range[1]:
    print(f'ERROR: value must between ({spec_range[0]}, {spec_range[1]})')
    sys.exit()        

def length_fi2m():
  '''feet (') and inches ('') to meters (m)'''
  i = float(input("Enter length in feet:")) 
  check_range(i, [0, float('inf')])
  meters = i*0.3048 
  print("Your length in metres is: " + str(metres) + " metres")

def length_m2fi():
  '''meters (m) to feet (') and inches ('')'''
  i = float(input("Enter length in meters:")) 
  check_range(i, [0, float('inf')])
  feet = int(i / .3048)
  inches = (i / .3048 - feet) % 1 * 12
  print(f"Your length in feet is: {feet} feets and {inchese} inches" )

def mass_p2kg():
  '''pounds (lbs) to kilograms (kg)'''
  i = float(input("Enter mass in pounds:")) 
  check_range(i, [0, float('inf')])
  kilograms = i / 2.2
  print(f"Your mass is: {kilograms} kg")

def mass_kg2p():
  '''kilograms (kg) to pounds (lbs)'''
  i = float(input("Enter mass in kg:")) 
  check_range(i, [0, float('inf')])
  pounds = i * 2.2
  print(f"Your mass in is: {pounds} pounds")

def temp_k2c():
  '''Kelvin (K) to Celsius (oC)'''
  i = float(input("Enter temperature in kelvin:")) 
  check_range(i, [0, float('inf')])
  temp = i - 273
  print(f"Your temperature is: {temp} oC")

def temp_c2k():
  '''Celsius (oC) to Kelvin (K) '''
  i = float(input("Enter temperature in Celsius:")) 
  check_range(i, [-273,float('inf')])
  temp = i + 273
  print(f"Your temperature is: {temp} Kelvin")

def time_hm2s():
  '''hours (h) and minutes(m) to seconds (s)'''
  i = float(input("Enter time in hours:")) 
  check_range(i, [0, float('inf')])
  time = i * 3600
  print(f"Your time is: {time} seconds" )

def time_s2hm():
  '''seconds (s) to hours (h) and minutes(m)'''
  i = float(input("Enter time in seconds:")) 
  check_range(i, [0, float('inf')])
  time = i / 3600
  print(f"Your time is: {time} hours"  )
