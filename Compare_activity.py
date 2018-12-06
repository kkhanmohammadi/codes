
# coding: utf-8

# In[16]:


import sys
sys.path.insert(0, 'D:/Ava/Empirical2018/hash-paper/ssdeep-ftw-master')
from ssftwpy3 import SSFTW
import csv
# Pass the ssdeep executable path to the class constructor.
ssdeep = SSFTW("D:\\Ava\\Empirical2018\\hash-paper\\ssdeep-2.14\\ssdeep.exe")

import os
from os import listdir
from os.path import isfile, join, isdir
import csv


csvpath='D:/Ava/Empirical2018/Adwares/adwaresOriginalRepackagedComparisons2.csv'
fi=open(csvpath, "a")
writer = csv.writer(fi, delimiter=',')
mylist=['Number','Original', 'Repackaged','malware type','type','original deleted','repackaged added','original manipulated','repackaged manipulated']
#writer.writerow(mylist)
#rootdir = 'D:\Ava\Empirical2018\Adwares\cauly\289_05D4CB4F3B47E00FB5CABA1CB34501E5A2D68B4CD500EAFCED7E3F48504351CE-java'
originaldir = 'D:/Ava/Empirical2018/Adwares/cauly/289_05D4CB4F3B47E00FB5CABA1CB34501E5A2D68B4CD500EAFCED7E3F48504351CE-java'
repackageddir = 'D:/Ava/Empirical2018/Adwares/cauly/289_E5478D0E73AE4574C80FBA10DEAD8970B7718E12E04D1BD2A3FE9E2D42B11FB2_r-java'
listpath='D:/Ava/Empirical2018/Adwares/flist_New_type_test.csv'
fil=open(listpath, "r")
reader = csv.reader(fil, delimiter=',')
for row in reader:
    print (', '.join(row))
    originaldir = row[0]
    repackageddir = row[1]
    print ("o:%s  r:%s\n" %(originaldir,repackageddir))
    on=0
    rn=0
    of=[]
    oh=[]
    rf=[]
    rh=[]
    for subdir, dirs, files in os.walk(originaldir):
        for file in files:
            print (os.path.join(subdir, file))
            hash1 = ssdeep.hash_from_file(os.path.join(subdir, file))
#             print ("Hash 1: %s\n" % (hash1))
#             oh.append(hash1)
#             of.append(os.path.join(subdir, file))
#             on=on+1
#     for subdir, dirs, files in os.walk(repackageddir):
#         for file in files:
#             print (os.path.join(subdir, file))
#             hash1 = ssdeep.hash_from_file(os.path.join(subdir, file))
#             print ("Hash 2: %s\n" % (hash1))
#             rh.append(hash1)
#             rf.append(os.path.join(subdir, file))
#             rn=rn+1
#     print ("on:%s\n" % (len(oh)))
#     print ("rn:%s\n" % (len(rh)))
    #str1 = ''.join(str(e) for e in oh)
    #print "mylist:%s\n" % (str1)


# In[10]:


import sys
sys.path.insert(0, 'D:/Ava/Empirical2018/hash-paper/ssdeep-ftw-master')
from ssftwpy3 import SSFTW

