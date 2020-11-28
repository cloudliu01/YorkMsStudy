import converter
import inspect
from collections import OrderedDict

def get_func_map():
  d = OrderedDict()
  a = inspect.getmembers(converter, inspect.isfunction)
  for e in a:
    d[e[0]] = e[1]
  return d

def main():
  d = get_func_map()
  msg = f'Please type in your choice:\n'

  for func_name in list(d):
    if d[func_name].__doc__:
      i = list(d).index(func_name)
      msg += (f'{i} {d[func_name].__doc__}:\n')
  choice = int(input(msg))
  msg += '\n'
  func_name = list(d)[choice]
  d[func_name]()
  
main()
