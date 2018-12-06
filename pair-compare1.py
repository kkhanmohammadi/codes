from ssftw import SSFTW
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
listpath='D:/Ava/Empirical2018/Adwares/flist_New_type1.csv'
fil=open(listpath, "r")
reader = csv.reader(fil, delimiter=',')
for row in reader:
    print ', '.join(row)
    originaldir = row[0]
    repackageddir = row[1]
    print "o:%s  r:%s\n" %(originaldir,repackageddir)
    on=0
    rn=0
    of=[]
    oh=[]
    rf=[]
    rh=[]
    for subdir, dirs, files in os.walk(originaldir):
        for file in files:
            print os.path.join(subdir, file)
            hash1 = ssdeep.hash_from_file(os.path.join(subdir, file))
            print "Hash 1: %s\n" % (hash1)
            oh.append(hash1)
            of.append(os.path.join(subdir, file))
            on=on+1
    for subdir, dirs, files in os.walk(repackageddir):
        for file in files:
            print os.path.join(subdir, file)
            hash1 = ssdeep.hash_from_file(os.path.join(subdir, file))
            print "Hash 2: %s\n" % (hash1)
            rh.append(hash1)
            rf.append(os.path.join(subdir, file))
            rn=rn+1
    print "on:%s\n" % (len(oh))
    print "rn:%s\n" % (len(rh))
    #str1 = ''.join(str(e) for e in oh)
    #print "mylist:%s\n" % (str1)

    originalDeleted=""
    originalManipulated=""
    repackagedAdded=""
    repackagedManipulated=""

    for i in range(len(oh)):
        ratio=0
        index=0
        lengthRH=len(rh)
        for j in range(lengthRH):
            r=ssdeep.compare(oh[i], rh[j])
            if(r!=None and r>ratio):
                ratio=int(r)
                index=j
        print "on:%s %s %s\n" % (i,index, ratio)
        if(ratio>=98):
            #the two file is identical
            #_oh.pop(i)
            #_of.pop(i)
            print "identrical:%s %s %s %s %s\n" % (rf[index],of[i],rh[index],oh[i],ratio)
            rh.pop(index)
            rf.pop(index)
        if(ratio<98 and ratio>=70):
            #two file are changed
            originalManipulated=originalManipulated+of[i]+"|"
            repackagedManipulated=repackagedManipulated+rf[index]+"|"
            #_oh.pop(i)
            #_of.pop(i)
            print "Manipulated:%s\n" % (rf[index])
            rh.pop(index)
            rf.pop(index)# write in changed original and repackaged column
        if(ratio<70):
            #the file is deleted from original
            originalDeleted=originalDeleted+of[i]+"|"
            print "Manipulated:%s\n" % (of[i])
       # there are added files left in array are added in repackaged
            # write in repackaged files added
    if(len(rf)!=0):
        for s in rf:
            repackagedAdded=repackagedAdded+s+"|"
            print "added:%s\n" % (s)


    print "originalDeleted:%s\n" % (originalDeleted)
    print "repackagedAdded:%s\n" % (repackagedAdded)
    print "originalManipulated:%s\n" % (originalManipulated)
    print "repackagedManipulated:%s\n" % (repackagedManipulated)

    typeFolder=originaldir[29:-69]
    tf=typeFolder.split("/")
    mylist=[tf[1][:-1],originaldir[-69:-5], repackageddir[-71:-7],tf[0],'adware',originalDeleted,repackagedAdded,originalManipulated,repackagedManipulated]
    str1 = ''.join(str(e) for e in mylist)
    print "mylist:%s\n" % (str1)
    writer.writerow(mylist)
    fi.flush()
fi.close()
#.pop()   
# read the two csv file
'''
csvpathR='D:\\Ava\\Empirical2018\\androguardRepackaged.csv'
fiR=open(csvpathR, "rb")
txtpathW='D:\\Ava\\Empirical2018\\repackagedActivityHash.txt'
fiW=open(txtpathW, "w")

reader = csv.reader(fiR, delimiter=',')
reader.next()
#writer = csv.writer(fiW, delimiter=',')
fiW.write('ssdeep,1.1--blocksize:hash:hash,filename\n')
for row in reader:
    activity= row[7]  
    print row[0]
    print '\n'
    hash1 = ssdeep.hash(activity)
    fiW.write('%s,\"%s\"\n' % (hash1,row[0]))
fiW.close()
fiR.close()
'''

'''writer = csv.writer(fi, delimiter=',')
mylist=['filepath','package name', 'Adlibraries']
writer.writerow(line)'''
# compute hash for the activity rows
# compare the two by each other


