###最小二乘法试验
import sys
import numpy as np
from scipy.optimize import leastsq


def least(arg2, arg3):
    Xi = np.array(list(map(int, arg2.split(","))))
    Yi = np.array(list(map(int, arg3.split(","))))
    p0 = [100, 2]
    Para = leastsq(error, p0, args=(Xi, Yi))
    k, b = Para[0]
    print(k,b)


def func(p, x):
    k, b = p
    return k * x + b


def error(p, x, y):
    return func(p, x) - y


least(sys.argv[1], sys.argv[2])
